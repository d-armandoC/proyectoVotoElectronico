/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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

/**
 *
 * @author Diego Cale Pillco
 */
@Entity
@Table(name = "designacion")
@NamedQueries({
    @NamedQuery(name = "Designacion.findAll", query = "SELECT d FROM Designacion d")
    , @NamedQuery(name = "Designacion.findByIdDesignacion", query = "SELECT d FROM Designacion d WHERE d.idDesignacion = :idDesignacion")
    , @NamedQuery(name = "Designacion.findByNombre", query = "SELECT d FROM Designacion d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "Designacion.findByDescripcion", query = "SELECT d FROM Designacion d WHERE d.descripcion = :descripcion")})
public class Designacion implements Serializable {
    
    // verificando los cambios.....

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_designacion")
    private Integer idDesignacion;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "idDesignacion")
    private List<MiembroLista> miembroListaList;

    public Designacion() {
    }

    public Designacion(Integer idDesignacion) {
        this.idDesignacion = idDesignacion;
    }
    
    public Designacion(String desing) {
        this.nombre=desing;
    }
   

    public Integer getIdDesignacion() {
        return idDesignacion;
    }

    public void setIdDesignacion(Integer idDesignacion) {
        this.idDesignacion = idDesignacion;
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

    public List<MiembroLista> getMiembroListaList() {
        return miembroListaList;
    }

    public void setMiembroListaList(List<MiembroLista> miembroListaList) {
        this.miembroListaList = miembroListaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDesignacion != null ? idDesignacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Designacion)) {
            return false;
        }
        Designacion other = (Designacion) object;
        if ((this.idDesignacion == null && other.idDesignacion != null) || (this.idDesignacion != null && !this.idDesignacion.equals(other.idDesignacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Designacion[ idDesignacion=" + idDesignacion + " ]";
    }
    
}
