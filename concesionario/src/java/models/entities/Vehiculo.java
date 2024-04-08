/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "vehiculo", catalog = "concesionario", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v"),
    @NamedQuery(name = "Vehiculo.findByIDVehiculo", query = "SELECT v FROM Vehiculo v WHERE v.iDVehiculo = :iDVehiculo"),
    @NamedQuery(name = "Vehiculo.findByMarca", query = "SELECT v FROM Vehiculo v WHERE v.marca = :marca"),
    @NamedQuery(name = "Vehiculo.findByModelo", query = "SELECT v FROM Vehiculo v WHERE v.modelo = :modelo"),
    @NamedQuery(name = "Vehiculo.findByCilindrada", query = "SELECT v FROM Vehiculo v WHERE v.cilindrada = :cilindrada"),
    @NamedQuery(name = "Vehiculo.findByPrecio", query = "SELECT v FROM Vehiculo v WHERE v.precio = :precio")})
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Vehiculo", nullable = false)
    private Integer iDVehiculo;
    @Size(max = 255)
    @Column(name = "Marca", length = 255)
    private String marca;
    @Size(max = 255)
    @Column(name = "Modelo", length = 255)
    private String modelo;
    @Column(name = "Cilindrada")
    private Integer cilindrada;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Precio")
    private Float precio;
    @OneToMany(mappedBy = "iDVehiculo")
    private List<OpcionAdicional> opcionAdicionalList;

    public Vehiculo() {
    }

    public Vehiculo(Integer iDVehiculo) {
        this.iDVehiculo = iDVehiculo;
    }

    public Integer getIDVehiculo() {
        return iDVehiculo;
    }

    public void setIDVehiculo(Integer iDVehiculo) {
        this.iDVehiculo = iDVehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(Integer cilindrada) {
        this.cilindrada = cilindrada;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    @XmlTransient
    public List<OpcionAdicional> getOpcionAdicionalList() {
        return opcionAdicionalList;
    }

    public void setOpcionAdicionalList(List<OpcionAdicional> opcionAdicionalList) {
        this.opcionAdicionalList = opcionAdicionalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDVehiculo != null ? iDVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.iDVehiculo == null && other.iDVehiculo != null) || (this.iDVehiculo != null && !this.iDVehiculo.equals(other.iDVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.entities.Vehiculo[ iDVehiculo=" + iDVehiculo + " ]";
    }
    
}
