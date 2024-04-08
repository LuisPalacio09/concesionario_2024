/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.crud;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;
import modelos.crud.exceptions.NonexistentEntityException;
import modelos.crud.exceptions.RollbackFailureException;
import models.entities.OpcionAdicional;
import models.entities.Vehiculo;

/**
 *
 * @author USUARIO
 */
public class OpcionAdicionalJpaController implements Serializable {

    public OpcionAdicionalJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(OpcionAdicional opcionAdicional) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Vehiculo IDVehiculo = opcionAdicional.getIDVehiculo();
            if (IDVehiculo != null) {
                IDVehiculo = em.getReference(IDVehiculo.getClass(), IDVehiculo.getIDVehiculo());
                opcionAdicional.setIDVehiculo(IDVehiculo);
            }
            em.persist(opcionAdicional);
            if (IDVehiculo != null) {
                IDVehiculo.getOpcionAdicionalList().add(opcionAdicional);
                IDVehiculo = em.merge(IDVehiculo);
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

    public void edit(OpcionAdicional opcionAdicional) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            OpcionAdicional persistentOpcionAdicional = em.find(OpcionAdicional.class, opcionAdicional.getIDOpcion());
            Vehiculo IDVehiculoOld = persistentOpcionAdicional.getIDVehiculo();
            Vehiculo IDVehiculoNew = opcionAdicional.getIDVehiculo();
            if (IDVehiculoNew != null) {
                IDVehiculoNew = em.getReference(IDVehiculoNew.getClass(), IDVehiculoNew.getIDVehiculo());
                opcionAdicional.setIDVehiculo(IDVehiculoNew);
            }
            opcionAdicional = em.merge(opcionAdicional);
            if (IDVehiculoOld != null && !IDVehiculoOld.equals(IDVehiculoNew)) {
                IDVehiculoOld.getOpcionAdicionalList().remove(opcionAdicional);
                IDVehiculoOld = em.merge(IDVehiculoOld);
            }
            if (IDVehiculoNew != null && !IDVehiculoNew.equals(IDVehiculoOld)) {
                IDVehiculoNew.getOpcionAdicionalList().add(opcionAdicional);
                IDVehiculoNew = em.merge(IDVehiculoNew);
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
                Integer id = opcionAdicional.getIDOpcion();
                if (findOpcionAdicional(id) == null) {
                    throw new NonexistentEntityException("The opcionAdicional with id " + id + " no longer exists.");
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
            OpcionAdicional opcionAdicional;
            try {
                opcionAdicional = em.getReference(OpcionAdicional.class, id);
                opcionAdicional.getIDOpcion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The opcionAdicional with id " + id + " no longer exists.", enfe);
            }
            Vehiculo IDVehiculo = opcionAdicional.getIDVehiculo();
            if (IDVehiculo != null) {
                IDVehiculo.getOpcionAdicionalList().remove(opcionAdicional);
                IDVehiculo = em.merge(IDVehiculo);
            }
            em.remove(opcionAdicional);
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

    public List<OpcionAdicional> findOpcionAdicionalEntities() {
        return findOpcionAdicionalEntities(true, -1, -1);
    }

    public List<OpcionAdicional> findOpcionAdicionalEntities(int maxResults, int firstResult) {
        return findOpcionAdicionalEntities(false, maxResults, firstResult);
    }

    private List<OpcionAdicional> findOpcionAdicionalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(OpcionAdicional.class));
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

    public OpcionAdicional findOpcionAdicional(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(OpcionAdicional.class, id);
        } finally {
            em.close();
        }
    }

    public int getOpcionAdicionalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<OpcionAdicional> rt = cq.from(OpcionAdicional.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
