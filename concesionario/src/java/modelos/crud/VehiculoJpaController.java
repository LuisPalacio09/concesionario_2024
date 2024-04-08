/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.crud;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import models.entities.OpcionAdicional;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;
import modelos.crud.exceptions.NonexistentEntityException;
import modelos.crud.exceptions.RollbackFailureException;
import models.entities.Vehiculo;

/**
 *
 * @author USUARIO
 */
public class VehiculoJpaController implements Serializable {

    public VehiculoJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    
       public VehiculoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
       
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Vehiculo vehiculo) throws RollbackFailureException, Exception {
        if (vehiculo.getOpcionAdicionalList() == null) {
            vehiculo.setOpcionAdicionalList(new ArrayList<OpcionAdicional>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            List<OpcionAdicional> attachedOpcionAdicionalList = new ArrayList<OpcionAdicional>();
            for (OpcionAdicional opcionAdicionalListOpcionAdicionalToAttach : vehiculo.getOpcionAdicionalList()) {
                opcionAdicionalListOpcionAdicionalToAttach = em.getReference(opcionAdicionalListOpcionAdicionalToAttach.getClass(), opcionAdicionalListOpcionAdicionalToAttach.getIDOpcion());
                attachedOpcionAdicionalList.add(opcionAdicionalListOpcionAdicionalToAttach);
            }
            vehiculo.setOpcionAdicionalList(attachedOpcionAdicionalList);
            em.persist(vehiculo);
            for (OpcionAdicional opcionAdicionalListOpcionAdicional : vehiculo.getOpcionAdicionalList()) {
                Vehiculo oldIDVehiculoOfOpcionAdicionalListOpcionAdicional = opcionAdicionalListOpcionAdicional.getIDVehiculo();
                opcionAdicionalListOpcionAdicional.setIDVehiculo(vehiculo);
                opcionAdicionalListOpcionAdicional = em.merge(opcionAdicionalListOpcionAdicional);
                if (oldIDVehiculoOfOpcionAdicionalListOpcionAdicional != null) {
                    oldIDVehiculoOfOpcionAdicionalListOpcionAdicional.getOpcionAdicionalList().remove(opcionAdicionalListOpcionAdicional);
                    oldIDVehiculoOfOpcionAdicionalListOpcionAdicional = em.merge(oldIDVehiculoOfOpcionAdicionalListOpcionAdicional);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Vehiculo vehiculo) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Vehiculo persistentVehiculo = em.find(Vehiculo.class, vehiculo.getIDVehiculo());
            List<OpcionAdicional> opcionAdicionalListOld = persistentVehiculo.getOpcionAdicionalList();
            List<OpcionAdicional> opcionAdicionalListNew = vehiculo.getOpcionAdicionalList();
            List<OpcionAdicional> attachedOpcionAdicionalListNew = new ArrayList<OpcionAdicional>();
            for (OpcionAdicional opcionAdicionalListNewOpcionAdicionalToAttach : opcionAdicionalListNew) {
                opcionAdicionalListNewOpcionAdicionalToAttach = em.getReference(opcionAdicionalListNewOpcionAdicionalToAttach.getClass(), opcionAdicionalListNewOpcionAdicionalToAttach.getIDOpcion());
                attachedOpcionAdicionalListNew.add(opcionAdicionalListNewOpcionAdicionalToAttach);
            }
            opcionAdicionalListNew = attachedOpcionAdicionalListNew;
            vehiculo.setOpcionAdicionalList(opcionAdicionalListNew);
            vehiculo = em.merge(vehiculo);
            for (OpcionAdicional opcionAdicionalListOldOpcionAdicional : opcionAdicionalListOld) {
                if (!opcionAdicionalListNew.contains(opcionAdicionalListOldOpcionAdicional)) {
                    opcionAdicionalListOldOpcionAdicional.setIDVehiculo(null);
                    opcionAdicionalListOldOpcionAdicional = em.merge(opcionAdicionalListOldOpcionAdicional);
                }
            }
            for (OpcionAdicional opcionAdicionalListNewOpcionAdicional : opcionAdicionalListNew) {
                if (!opcionAdicionalListOld.contains(opcionAdicionalListNewOpcionAdicional)) {
                    Vehiculo oldIDVehiculoOfOpcionAdicionalListNewOpcionAdicional = opcionAdicionalListNewOpcionAdicional.getIDVehiculo();
                    opcionAdicionalListNewOpcionAdicional.setIDVehiculo(vehiculo);
                    opcionAdicionalListNewOpcionAdicional = em.merge(opcionAdicionalListNewOpcionAdicional);
                    if (oldIDVehiculoOfOpcionAdicionalListNewOpcionAdicional != null && !oldIDVehiculoOfOpcionAdicionalListNewOpcionAdicional.equals(vehiculo)) {
                        oldIDVehiculoOfOpcionAdicionalListNewOpcionAdicional.getOpcionAdicionalList().remove(opcionAdicionalListNewOpcionAdicional);
                        oldIDVehiculoOfOpcionAdicionalListNewOpcionAdicional = em.merge(oldIDVehiculoOfOpcionAdicionalListNewOpcionAdicional);
                    }
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = vehiculo.getIDVehiculo();
                if (findVehiculo(id) == null) {
                    throw new NonexistentEntityException("The vehiculo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Vehiculo vehiculo;
            try {
                vehiculo = em.getReference(Vehiculo.class, id);
                vehiculo.getIDVehiculo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vehiculo with id " + id + " no longer exists.", enfe);
            }
            List<OpcionAdicional> opcionAdicionalList = vehiculo.getOpcionAdicionalList();
            for (OpcionAdicional opcionAdicionalListOpcionAdicional : opcionAdicionalList) {
                opcionAdicionalListOpcionAdicional.setIDVehiculo(null);
                opcionAdicionalListOpcionAdicional = em.merge(opcionAdicionalListOpcionAdicional);
            }
            em.remove(vehiculo);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Vehiculo> findVehiculoEntities() {
        return findVehiculoEntities(true, -1, -1);
    }

    public List<Vehiculo> findVehiculoEntities(int maxResults, int firstResult) {
        return findVehiculoEntities(false, maxResults, firstResult);
    }

    private List<Vehiculo> findVehiculoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Vehiculo.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Vehiculo findVehiculo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Vehiculo.class, id);
        } finally {
            em.close();
        }
    }

    public int getVehiculoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Vehiculo> rt = cq.from(Vehiculo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
