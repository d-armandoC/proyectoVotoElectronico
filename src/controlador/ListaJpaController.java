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
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Lista;
import modelo.Usuario;

/**
 *
 * @author Diego Cale Pillco
 */
public class ListaJpaController implements Serializable {

    public ListaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Lista lista) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(lista);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Lista lista) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            lista = em.merge(lista);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = lista.getIdLista();
                if (findLista(id) == null) {
                    throw new NonexistentEntityException("The lista with id " + id + " no longer exists.");
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
            Lista lista;
            try {
                lista = em.getReference(Lista.class, id);
                lista.getIdLista();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The lista with id " + id + " no longer exists.", enfe);
            }
            em.remove(lista);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Lista> findListaEntities() {
        return findListaEntities(true, -1, -1);
    }

    public List<Lista> findListaEntities(int maxResults, int firstResult) {
        return findListaEntities(false, maxResults, firstResult);
    }

    private List<Lista> findListaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Lista.class));
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

    public Lista findLista(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Lista.class, id);
        } finally {
            em.close();
        }
    }

    public int getListaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Lista> rt = cq.from(Lista.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public Lista  getLista(String tipoLista){
        EntityManager em = getEntityManager();
        try {
             TypedQuery<Lista> query = em.createNamedQuery("Lista.findByTipoLista",Lista.class);
             query.setParameter("tipoLista", tipoLista);
             List<Lista> list = query.getResultList();
            return (list.size()>1)||(0==list.size())?null:list.get(0);
        } finally {
            em.close();
        }
    }
    
}
