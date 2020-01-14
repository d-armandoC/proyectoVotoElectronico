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
@Table(name = "voto_nulo")
@NamedQueries({
    @NamedQuery(name = "VotoNulo.findAll", query = "SELECT v FROM VotoNulo v")
    , @NamedQuery(name = "VotoNulo.findByIdVotoNulo", query = "SELECT v FROM VotoNulo v WHERE v.idVotoNulo = :idVotoNulo")
    , @NamedQuery(name = "VotoNulo.findByFechaHoraRegistro", query = "SELECT v FROM VotoNulo v WHERE v.fechaHoraRegistro = :fechaHoraRegistro")})
public class VotoNulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_voto_nulo")
    private Integer idVotoNulo;
    @Column(name = "fecha_hora_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraRegistro;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne
    private Persona idPersona;

    public VotoNulo() {
    }

    public VotoNulo(Integer idVotoNulo) {
        this.idVotoNulo = idVotoNulo;
    }

    public Integer getIdVotoNulo() {
        return idVotoNulo;
    }

    public void setIdVotoNulo(Integer idVotoNulo) {
        this.idVotoNulo = idVotoNulo;
    }

    public Date getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public void setFechaHoraRegistro(Date fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
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
        hash += (idVotoNulo != null ? idVotoNulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VotoNulo)) {
            return false;
        }
        VotoNulo other = (VotoNulo) object;
        if ((this.idVotoNulo == null && other.idVotoNulo != null) || (this.idVotoNulo != null && !this.idVotoNulo.equals(other.idVotoNulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.VotoNulo[ idVotoNulo=" + idVotoNulo + " ]";
    }
    
}
