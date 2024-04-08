/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "opcion_adicional", catalog = "concesionario", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OpcionAdicional.findAll", query = "SELECT o FROM OpcionAdicional o"),
    @NamedQuery(name = "OpcionAdicional.findByIDOpcion", query = "SELECT o FROM OpcionAdicional o WHERE o.iDOpcion = :iDOpcion"),
    @NamedQuery(name = "OpcionAdicional.findByNombre", query = "SELECT o FROM OpcionAdicional o WHERE o.nombre = :nombre"),
    @NamedQuery(name = "OpcionAdicional.findByPrecio", query = "SELECT o FROM OpcionAdicional o WHERE o.precio = :precio")})
public class OpcionAdicional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Opcion", nullable = false)
    private Integer iDOpcion;
    @Size(max = 255)
    @Column(name = "Nombre", length = 255)
    private String nombre;
    @Lob
    @Size(max = 65535)
    @Column(name = "Descripcion", length = 65535)
    private String descripcion;
    @Column(name = "Precio")
    private Integer precio;
    @JoinColumn(name = "ID_Vehiculo", referencedColumnName = "ID_Vehiculo")
    @ManyToOne
    private Vehiculo iDVehiculo;

    public OpcionAdicional() {
    }

    public OpcionAdicional(Integer iDOpcion) {
        this.iDOpcion = iDOpcion;
    }

    public Integer getIDOpcion() {
        return iDOpcion;
    }

    public void setIDOpcion(Integer iDOpcion) {
        this.iDOpcion = iDOpcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Vehiculo getIDVehiculo() {
        return iDVehiculo;
    }

    public void setIDVehiculo(Vehiculo iDVehiculo) {
        this.iDVehiculo = iDVehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDOpcion != null ? iDOpcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpcionAdicional)) {
            return false;
        }
        OpcionAdicional other = (OpcionAdicional) object;
        if ((this.iDOpcion == null && other.iDOpcion != null) || (this.iDOpcion != null && !this.iDOpcion.equals(other.iDOpcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.entities.OpcionAdicional[ iDOpcion=" + iDOpcion + " ]";
    }
    
}
