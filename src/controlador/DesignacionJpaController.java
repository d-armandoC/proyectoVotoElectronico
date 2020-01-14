/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.MiembroLista;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Designacion;

/**
 *
 * @author Diego Cale Pillco
 */
public class DesignacionJpaController implements Serializable {

    public DesignacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Designacion designacion) {
        if (designacion.getMiembroListaList() == null) {
            designacion.setMiembroListaList(new ArrayList<MiembroLista>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<MiembroLista> attachedMiembroListaList = new ArrayList<MiembroLista>();
            for (MiembroLista miembroListaListMiembroListaToAttach : designacion.getMiembroListaList()) {
                miembroListaListMiembroListaToAttach = em.getReference(miembroListaListMiembroListaToAttach.getClass(), miembroListaListMiembroListaToAttach.getIdMiembroLista());
                attachedMiembroListaList.add(miembroListaListMiembroListaToAttach);
            }
            designacion.setMiembroListaList(attachedMiembroListaList);
            em.persist(designacion);
            for (MiembroLista miembroListaListMiembroLista : designacion.getMiembroListaList()) {
                Designacion oldIdDesignacionOfMiembroListaListMiembroLista = miembroListaListMiembroLista.getIdDesignacion();
                miembroListaListMiembroLista.setIdDesignacion(designacion);
                miembroListaListMiembroLista = em.merge(miembroListaListMiembroLista);
                if (oldIdDesignacionOfMiembroListaListMiembroLista != null) {
                    oldIdDesignacionOfMiembroListaListMiembroLista.getMiembroListaList().remove(miembroListaListMiembroLista);
                    oldIdDesignacionOfMiembroListaListMiembroLista = em.merge(oldIdDesignacionOfMiembroListaListMiembroLista);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Designacion designacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Designacion persistentDesignacion = em.find(Designacion.class, designacion.getIdDesignacion());
            List<MiembroLista> miembroListaListOld = persistentDesignacion.getMiembroListaList();
            List<MiembroLista> miembroListaListNew = designacion.getMiembroListaList();
            List<MiembroLista> attachedMiembroListaListNew = new ArrayList<MiembroLista>();
            for (MiembroLista miembroListaListNewMiembroListaToAttach : miembroListaListNew) {
                miembroListaListNewMiembroListaToAttach = em.getReference(miembroListaListNewMiembroListaToAttach.getClass(), miembroListaListNewMiembroListaToAttach.getIdMiembroLista());
                attachedMiembroListaListNew.add(miembroListaListNewMiembroListaToAttach);
            }
            miembroListaListNew = attachedMiembroListaListNew;
            designacion.setMiembroListaList(miembroListaListNew);
            designacion = em.merge(designacion);
            for (MiembroLista miembroListaListOldMiembroLista : miembroListaListOld) {
                if (!miembroListaListNew.contains(miembroListaListOldMiembroLista)) {
                    miembroListaListOldMiembroLista.setIdDesignacion(null);
                    miembroListaListOldMiembroLista = em.merge(miembroListaListOldMiembroLista);
                }
            }
            for (MiembroLista miembroListaListNewMiembroLista : miembroListaListNew) {
                if (!miembroListaListOld.contains(miembroListaListNewMiembroLista)) {
                    Designacion oldIdDesignacionOfMiembroListaListNewMiembroLista = miembroListaListNewMiembroLista.getIdDesignacion();
                    miembroListaListNewMiembroLista.setIdDesignacion(designacion);
                    miembroListaListNewMiembroLista = em.merge(miembroListaListNewMiembroLista);
                    if (oldIdDesignacionOfMiembroListaListNewMiembroLista != null && !oldIdDesignacionOfMiembroListaListNewMiembroLista.equals(designacion)) {
                        oldIdDesignacionOfMiembroListaListNewMiembroLista.getMiembroListaList().remove(miembroListaListNewMiembroLista);
                        oldIdDesignacionOfMiembroListaListNewMiembroLista = em.merge(oldIdDesignacionOfMiembroListaListNewMiembroLista);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = designacion.getIdDesignacion();
                if (findDesignacion(id) == null) {
                    throw new NonexistentEntityException("The designacion with id " + id + " no longer exists.");
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
            Designacion designacion;
            try {
                designacion = em.getReference(Designacion.class, id);
                designacion.getIdDesignacion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The designacion with id " + id + " no longer exists.", enfe);
            }
            List<MiembroLista> miembroListaList = designacion.getMiembroListaList();
            for (MiembroLista miembroListaListMiembroLista : miembroListaList) {
                miembroListaListMiembroLista.setIdDesignacion(null);
                miembroListaListMiembroLista = em.merge(miembroListaListMiembroLista);
            }
            em.remove(designacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Designacion> findDesignacionEntities() {
        return findDesignacionEntities(true, -1, -1);
    }

    public List<Designacion> findDesignacionEntities(int maxResults, int firstResult) {
        return findDesignacionEntities(false, maxResults, firstResult);
    }

    private List<Designacion> findDesignacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Designacion.class));
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

    public Designacion findDesignacion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Designacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getDesignacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Designacion> rt = cq.from(Designacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
