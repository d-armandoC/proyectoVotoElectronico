/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.exceptions.NonexistentEntityException;
import controlador.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Persona;
import modelo.Voto;

/**
 *
 * @author Diego Cale Pillco
 */
public class VotoJpaController implements Serializable {

    public VotoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Voto voto) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Persona idPersona = voto.getIdPersona();
            if (idPersona != null) {
                idPersona = em.getReference(idPersona.getClass(), idPersona.getIdPersona());
                voto.setIdPersona(idPersona);
            }
            em.persist(voto);
            if (idPersona != null) {
                idPersona.getVotoList().add(voto);
                idPersona = em.merge(idPersona);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVoto(voto.getIdVoto()) != null) {
                throw new PreexistingEntityException("Voto " + voto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Voto voto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Voto persistentVoto = em.find(Voto.class, voto.getIdVoto());
            Persona idPersonaOld = persistentVoto.getIdPersona();
            Persona idPersonaNew = voto.getIdPersona();
            if (idPersonaNew != null) {
                idPersonaNew = em.getReference(idPersonaNew.getClass(), idPersonaNew.getIdPersona());
                voto.setIdPersona(idPersonaNew);
            }
            voto = em.merge(voto);
            if (idPersonaOld != null && !idPersonaOld.equals(idPersonaNew)) {
                idPersonaOld.getVotoList().remove(voto);
                idPersonaOld = em.merge(idPersonaOld);
            }
            if (idPersonaNew != null && !idPersonaNew.equals(idPersonaOld)) {
                idPersonaNew.getVotoList().add(voto);
                idPersonaNew = em.merge(idPersonaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = voto.getIdVoto();
                if (findVoto(id) == null) {
                    throw new NonexistentEntityException("The voto with id " + id + " no longer exists.");
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
            Voto voto;
            try {
                voto = em.getReference(Voto.class, id);
                voto.getIdVoto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The voto with id " + id + " no longer exists.", enfe);
            }
            Persona idPersona = voto.getIdPersona();
            if (idPersona != null) {
                idPersona.getVotoList().remove(voto);
                idPersona = em.merge(idPersona);
            }
            em.remove(voto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Voto> findVotoEntities() {
        return findVotoEntities(true, -1, -1);
    }

    public List<Voto> findVotoEntities(int maxResults, int firstResult) {
        return findVotoEntities(false, maxResults, firstResult);
    }

    private List<Voto> findVotoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Voto.class));
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

    public Voto findVoto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Voto.class, id);
        } finally {
            em.close();
        }
    }

    public int getVotoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Voto> rt = cq.from(Voto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
