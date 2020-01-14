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
import modelo.Persona;
import modelo.VotoNulo;

/**
 *
 * @author Diego Cale Pillco
 */
public class VotoNuloJpaController implements Serializable {

    public VotoNuloJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(VotoNulo votoNulo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Persona idPersona = votoNulo.getIdPersona();
            if (idPersona != null) {
                idPersona = em.getReference(idPersona.getClass(), idPersona.getIdPersona());
                votoNulo.setIdPersona(idPersona);
            }
            em.persist(votoNulo);
            if (idPersona != null) {
                idPersona.getVotoNuloList().add(votoNulo);
                idPersona = em.merge(idPersona);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(VotoNulo votoNulo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            VotoNulo persistentVotoNulo = em.find(VotoNulo.class, votoNulo.getIdVotoNulo());
            Persona idPersonaOld = persistentVotoNulo.getIdPersona();
            Persona idPersonaNew = votoNulo.getIdPersona();
            if (idPersonaNew != null) {
                idPersonaNew = em.getReference(idPersonaNew.getClass(), idPersonaNew.getIdPersona());
                votoNulo.setIdPersona(idPersonaNew);
            }
            votoNulo = em.merge(votoNulo);
            if (idPersonaOld != null && !idPersonaOld.equals(idPersonaNew)) {
                idPersonaOld.getVotoNuloList().remove(votoNulo);
                idPersonaOld = em.merge(idPersonaOld);
            }
            if (idPersonaNew != null && !idPersonaNew.equals(idPersonaOld)) {
                idPersonaNew.getVotoNuloList().add(votoNulo);
                idPersonaNew = em.merge(idPersonaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = votoNulo.getIdVotoNulo();
                if (findVotoNulo(id) == null) {
                    throw new NonexistentEntityException("The votoNulo with id " + id + " no longer exists.");
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
            VotoNulo votoNulo;
            try {
                votoNulo = em.getReference(VotoNulo.class, id);
                votoNulo.getIdVotoNulo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The votoNulo with id " + id + " no longer exists.", enfe);
            }
            Persona idPersona = votoNulo.getIdPersona();
            if (idPersona != null) {
                idPersona.getVotoNuloList().remove(votoNulo);
                idPersona = em.merge(idPersona);
            }
            em.remove(votoNulo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<VotoNulo> findVotoNuloEntities() {
        return findVotoNuloEntities(true, -1, -1);
    }

    public List<VotoNulo> findVotoNuloEntities(int maxResults, int firstResult) {
        return findVotoNuloEntities(false, maxResults, firstResult);
    }

    private List<VotoNulo> findVotoNuloEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VotoNulo.class));
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

    public VotoNulo findVotoNulo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(VotoNulo.class, id);
        } finally {
            em.close();
        }
    }

    public int getVotoNuloCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<VotoNulo> rt = cq.from(VotoNulo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
