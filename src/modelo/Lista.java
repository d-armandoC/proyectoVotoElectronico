/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Diego Cale Pillco
 */
@Entity
@Table(name = "lista")
@NamedQueries({
    @NamedQuery(name = "Lista.findAll", query = "SELECT l FROM Lista l")
    , @NamedQuery(name = "Lista.findByIdLista", query = "SELECT l FROM Lista l WHERE l.idLista = :idLista")
    , @NamedQuery(name = "Lista.findByTipoLista", query = "SELECT l FROM Lista l WHERE l.tipoLista = :tipoLista")
    , @NamedQuery(name = "Lista.findByNombreLista", query = "SELECT l FROM Lista l WHERE l.nombreLista = :nombreLista")
    , @NamedQuery(name = "Lista.findByPeriodo", query = "SELECT l FROM Lista l WHERE l.periodo = :periodo")
    , @NamedQuery(name = "Lista.findByPropuesta", query = "SELECT l FROM Lista l WHERE l.propuesta = :propuesta")
    , @NamedQuery(name = "Lista.findByFechaHoraRegistro", query = "SELECT l FROM Lista l WHERE l.fechaHoraRegistro = :fechaHoraRegistro")})
public class Lista implements Serializable {

    @OneToMany(mappedBy = "idLista")
    private List<Voto> votoList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_lista")
    private Integer idLista;
    @Column(name = "tipoLista")
    private String tipoLista;
    @Column(name = "nombre_lista")
    private String nombreLista;
    @Column(name = "periodo")
    private String periodo;
    @Column(name = "propuesta")
    private String propuesta;
    @Column(name = "fecha_hora_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraRegistro;

    public Lista() {
    }

    public Lista(Integer idLista) {
        this.idLista = idLista;
    }

    public Integer getIdLista() {
        return idLista;
    }

    public void setIdLista(Integer idLista) {
        this.idLista = idLista;
    }

    public String getTipoLista() {
        return tipoLista;
    }

    public void setTipoLista(String tipoLista) {
        this.tipoLista = tipoLista;
    }

    public String getNombreLista() {
        return nombreLista;
    }

    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getPropuesta() {
        return propuesta;
    }

    public void setPropuesta(String propuesta) {
        this.propuesta = propuesta;
    }

    public Date getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public void setFechaHoraRegistro(Date fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLista != null ? idLista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lista)) {
            return false;
        }
        Lista other = (Lista) object;
        if ((this.idLista == null && other.idLista != null) || (this.idLista != null && !this.idLista.equals(other.idLista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Lista[ idLista=" + idLista + " ]";
    }

    public List<Voto> getVotoList() {
        return votoList;
    }

    public void setVotoList(List<Voto> votoList) {
        this.votoList = votoList;
    }
    
}
