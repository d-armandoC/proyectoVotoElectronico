/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Diego Cale Pillco
 */
@Entity
@Table(name = "miembro_lista")
@NamedQueries({
    @NamedQuery(name = "MiembroLista.findAll", query = "SELECT m FROM MiembroLista m")
    , @NamedQuery(name = "MiembroLista.findByIdMiembroLista", query = "SELECT m FROM MiembroLista m WHERE m.idMiembroLista = :idMiembroLista")
    , @NamedQuery(name = "MiembroLista.findByFechaHoraRegistro", query = "SELECT m FROM MiembroLista m WHERE m.fechaHoraRegistro = :fechaHoraRegistro")})
public class MiembroLista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_miembro_lista")
    private Integer idMiembroLista;
    @Column(name = "fecha_hora_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraRegistro;
    @JoinColumn(name = "id_designacion", referencedColumnName = "id_designacion")
    @ManyToOne
    private Designacion idDesignacion;
    @JoinColumn(name = "id_lista", referencedColumnName = "id_lista")
    @ManyToOne
    private Lista idLista;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne
    private Persona idPersona;

    public MiembroLista() {
    }

    public MiembroLista(Integer idMiembroLista) {
        this.idMiembroLista = idMiembroLista;
    }

    public Integer getIdMiembroLista() {
        return idMiembroLista;
    }

    public void setIdMiembroLista(Integer idMiembroLista) {
        this.idMiembroLista = idMiembroLista;
    }

    public Date getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public void setFechaHoraRegistro(Date fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    public Designacion getIdDesignacion() {
        return idDesignacion;
    }

    public void setIdDesignacion(Designacion idDesignacion) {
        this.idDesignacion = idDesignacion;
    }

    public Lista getIdLista() {
        return idLista;
    }

    public void setIdLista(Lista idLista) {
        this.idLista = idLista;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMiembroLista != null ? idMiembroLista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MiembroLista)) {
            return false;
        }
        MiembroLista other = (MiembroLista) object;
        if ((this.idMiembroLista == null && other.idMiembroLista != null) || (this.idMiembroLista != null && !this.idMiembroLista.equals(other.idMiembroLista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.MiembroLista[ idMiembroLista=" + idMiembroLista + " ]";
    }
    
}
