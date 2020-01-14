/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Designacion;
import modelo.MiembroLista;
import modelo.Persona;

/**
 *
 * @author Diego Cale Pillco
 */
public class MiembroListaJpaController implements Serializable {

    public MiembroListaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MiembroLista miembroLista) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Designacion idDesignacion = miembroLista.getIdDesignacion();
            if (idDesignacion != null) {
                idDesignacion = em.getReference(idDesignacion.getClass(), idDesignacion.getIdDesignacion());
                miembroLista.setIdDesignacion(idDesignacion);
            }
            Persona idPersona = miembroLista.getIdPersona();
            if (idPersona != null) {
                idPersona = em.getReference(idPersona.getClass(), idPersona.getIdPersona());
                miembroLista.setIdPersona(idPersona);
            }
            em.persist(miembroLista);
            if (idDesignacion != null) {
                idDesignacion.getMiembroListaList().add(miembroLista);
                idDesignacion = em.merge(idDesignacion);
            }
            if (idPersona != null) {
                idPersona.getMiembroListaList().add(miembroLista);
                idPersona = em.merge(idPersona);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MiembroLista miembroLista) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            MiembroLista persistentMiembroLista = em.find(MiembroLista.class, miembroLista.getIdMiembroLista());
            Designacion idDesignacionOld = persistentMiembroLista.getIdDesignacion();
            Designacion idDesignacionNew = miembroLista.getIdDesignacion();
            Persona idPersonaOld = persistentMiembroLista.getIdPersona();
            Persona idPersonaNew = miembroLista.getIdPersona();
            if (idDesignacionNew != null) {
                idDesignacionNew = em.getReference(idDesignacionNew.getClass(), idDesignacionNew.getIdDesignacion());
                miembroLista.setIdDesignacion(idDesignacionNew);
            }
            if (idPersonaNew != null) {
                idPersonaNew = em.getReference(idPersonaNew.getClass(), idPersonaNew.getIdPersona());
                miembroLista.setIdPersona(idPersonaNew);
            }
            miembroLista = em.merge(miembroLista);
            if (idDesignacionOld != null && !idDesignacionOld.equals(idDesignacionNew)) {
                idDesignacionOld.getMiembroListaList().remove(miembroLista);
                idDesignacionOld = em.merge(idDesignacionOld);
            }
            if (idDesignacionNew != null && !idDesignacionNew.equals(idDesignacionOld)) {
                idDesignacionNew.getMiembroListaList().add(miembroLista);
                idDesignacionNew = em.merge(idDesignacionNew);
            }
            if (idPersonaOld != null && !idPersonaOld.equals(idPersonaNew)) {
                idPersonaOld.getMiembroListaList().remove(miembroLista);
                idPersonaOld = em.merge(idPersonaOld);
            }
            if (idPersonaNew != null && !idPersonaNew.equals(idPersonaOld)) {
                idPersonaNew.getMiembroListaList().add(miembroLista);
                idPersonaNew = em.merge(idPersonaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = miembroLista.getIdMiembroLista();
                if (findMiembroLista(id) == null) {
                    throw new NonexistentEntityException("The miembroLista with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            MiembroLista miembroLista;
            try {
                miembroLista = em.getReference(MiembroLista.class, id);
                miembroLista.getIdMiembroLista();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The miembroLista with id " + id + " no longer exists.", enfe);
            }
            Designacion idDesignacion = miembroLista.getIdDesignacion();
            if (idDesignacion != null) {
                idDesignacion.getMiembroListaList().remove(miembroLista);
                idDesignacion = em.merge(idDesignacion);
            }
            Persona idPersona = miembroLista.getIdPersona();
            if (idPersona != null) {
                idPersona.getMiembroListaList().remove(miembroLista);
                idPersona = em.merge(idPersona);
            }
            em.remove(miembroLista);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MiembroLista> findMiembroListaEntities() {
        return findMiembroListaEntities(true, -1, -1);
    }

    public List<MiembroLista> findMiembroListaEntities(int maxResults, int firstResult) {
        return findMiembroListaEntities(false, maxResults, firstResult);
    }

    private List<MiembroLista> findMiembroListaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MiembroLista.class));
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

    public MiembroLista findMiembroLista(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MiembroLista.class, id);
        } finally {
            em.close();
        }
    }

    public int getMiembroListaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MiembroLista> rt = cq.from(MiembroLista.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
