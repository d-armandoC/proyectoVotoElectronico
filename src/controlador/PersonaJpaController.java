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
import modelo.Voto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import modelo.Usuario;
import modelo.MiembroLista;
import modelo.Persona;
import modelo.VotoNulo;

/**
 *
 * @author Diego Cale Pillco
 */
public class PersonaJpaController implements Serializable {

    public PersonaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Persona persona) {
        if (persona.getVotoList() == null) {
            persona.setVotoList(new ArrayList<Voto>());
        }
        if (persona.getUsuarioList() == null) {
            persona.setUsuarioList(new ArrayList<Usuario>());
        }
        if (persona.getMiembroListaList() == null) {
            persona.setMiembroListaList(new ArrayList<MiembroLista>());
        }
        if (persona.getVotoNuloList() == null) {
            persona.setVotoNuloList(new ArrayList<VotoNulo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Voto> attachedVotoList = new ArrayList<Voto>();
            for (Voto votoListVotoToAttach : persona.getVotoList()) {
                votoListVotoToAttach = em.getReference(votoListVotoToAttach.getClass(), votoListVotoToAttach.getIdVoto());
                attachedVotoList.add(votoListVotoToAttach);
            }
            persona.setVotoList(attachedVotoList);
            List<Usuario> attachedUsuarioList = new ArrayList<Usuario>();
            for (Usuario usuarioListUsuarioToAttach : persona.getUsuarioList()) {
                usuarioListUsuarioToAttach = em.getReference(usuarioListUsuarioToAttach.getClass(), usuarioListUsuarioToAttach.getIdUsuario());
                attachedUsuarioList.add(usuarioListUsuarioToAttach);
            }
            persona.setUsuarioList(attachedUsuarioList);
            List<MiembroLista> attachedMiembroListaList = new ArrayList<MiembroLista>();
            for (MiembroLista miembroListaListMiembroListaToAttach : persona.getMiembroListaList()) {
                miembroListaListMiembroListaToAttach = em.getReference(miembroListaListMiembroListaToAttach.getClass(), miembroListaListMiembroListaToAttach.getIdMiembroLista());
                attachedMiembroListaList.add(miembroListaListMiembroListaToAttach);
            }
            persona.setMiembroListaList(attachedMiembroListaList);
            List<VotoNulo> attachedVotoNuloList = new ArrayList<VotoNulo>();
            for (VotoNulo votoNuloListVotoNuloToAttach : persona.getVotoNuloList()) {
                votoNuloListVotoNuloToAttach = em.getReference(votoNuloListVotoNuloToAttach.getClass(), votoNuloListVotoNuloToAttach.getIdVotoNulo());
                attachedVotoNuloList.add(votoNuloListVotoNuloToAttach);
            }
            persona.setVotoNuloList(attachedVotoNuloList);
            em.persist(persona);
            for (Voto votoListVoto : persona.getVotoList()) {
                Persona oldIdPersonaOfVotoListVoto = votoListVoto.getIdPersona();
                votoListVoto.setIdPersona(persona);
                votoListVoto = em.merge(votoListVoto);
                if (oldIdPersonaOfVotoListVoto != null) {
                    oldIdPersonaOfVotoListVoto.getVotoList().remove(votoListVoto);
                    oldIdPersonaOfVotoListVoto = em.merge(oldIdPersonaOfVotoListVoto);
                }
            }
            for (Usuario usuarioListUsuario : persona.getUsuarioList()) {
                Persona oldIdPersonaOfUsuarioListUsuario = usuarioListUsuario.getIdPersona();
                usuarioListUsuario.setIdPersona(persona);
                usuarioListUsuario = em.merge(usuarioListUsuario);
                if (oldIdPersonaOfUsuarioListUsuario != null) {
                    oldIdPersonaOfUsuarioListUsuario.getUsuarioList().remove(usuarioListUsuario);
                    oldIdPersonaOfUsuarioListUsuario = em.merge(oldIdPersonaOfUsuarioListUsuario);
                }
            }
            for (MiembroLista miembroListaListMiembroLista : persona.getMiembroListaList()) {
                Persona oldIdPersonaOfMiembroListaListMiembroLista = miembroListaListMiembroLista.getIdPersona();
                miembroListaListMiembroLista.setIdPersona(persona);
                miembroListaListMiembroLista = em.merge(miembroListaListMiembroLista);
                if (oldIdPersonaOfMiembroListaListMiembroLista != null) {
                    oldIdPersonaOfMiembroListaListMiembroLista.getMiembroListaList().remove(miembroListaListMiembroLista);
                    oldIdPersonaOfMiembroListaListMiembroLista = em.merge(oldIdPersonaOfMiembroListaListMiembroLista);
                }
            }
            for (VotoNulo votoNuloListVotoNulo : persona.getVotoNuloList()) {
                Persona oldIdPersonaOfVotoNuloListVotoNulo = votoNuloListVotoNulo.getIdPersona();
                votoNuloListVotoNulo.setIdPersona(persona);
                votoNuloListVotoNulo = em.merge(votoNuloListVotoNulo);
                if (oldIdPersonaOfVotoNuloListVotoNulo != null) {
                    oldIdPersonaOfVotoNuloListVotoNulo.getVotoNuloList().remove(votoNuloListVotoNulo);
                    oldIdPersonaOfVotoNuloListVotoNulo = em.merge(oldIdPersonaOfVotoNuloListVotoNulo);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Persona persona) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Persona persistentPersona = em.find(Persona.class, persona.getIdPersona());
            List<Voto> votoListOld = persistentPersona.getVotoList();
            List<Voto> votoListNew = persona.getVotoList();
            List<Usuario> usuarioListOld = persistentPersona.getUsuarioList();
            List<Usuario> usuarioListNew = persona.getUsuarioList();
            List<MiembroLista> miembroListaListOld = persistentPersona.getMiembroListaList();
            List<MiembroLista> miembroListaListNew = persona.getMiembroListaList();
            List<VotoNulo> votoNuloListOld = persistentPersona.getVotoNuloList();
            List<VotoNulo> votoNuloListNew = persona.getVotoNuloList();
            List<Voto> attachedVotoListNew = new ArrayList<Voto>();
            for (Voto votoListNewVotoToAttach : votoListNew) {
                votoListNewVotoToAttach = em.getReference(votoListNewVotoToAttach.getClass(), votoListNewVotoToAttach.getIdVoto());
                attachedVotoListNew.add(votoListNewVotoToAttach);
            }
            votoListNew = attachedVotoListNew;
            persona.setVotoList(votoListNew);
            List<Usuario> attachedUsuarioListNew = new ArrayList<Usuario>();
            for (Usuario usuarioListNewUsuarioToAttach : usuarioListNew) {
                usuarioListNewUsuarioToAttach = em.getReference(usuarioListNewUsuarioToAttach.getClass(), usuarioListNewUsuarioToAttach.getIdUsuario());
                attachedUsuarioListNew.add(usuarioListNewUsuarioToAttach);
            }
            usuarioListNew = attachedUsuarioListNew;
            persona.setUsuarioList(usuarioListNew);
            List<MiembroLista> attachedMiembroListaListNew = new ArrayList<MiembroLista>();
            for (MiembroLista miembroListaListNewMiembroListaToAttach : miembroListaListNew) {
                miembroListaListNewMiembroListaToAttach = em.getReference(miembroListaListNewMiembroListaToAttach.getClass(), miembroListaListNewMiembroListaToAttach.getIdMiembroLista());
                attachedMiembroListaListNew.add(miembroListaListNewMiembroListaToAttach);
            }
            miembroListaListNew = attachedMiembroListaListNew;
            persona.setMiembroListaList(miembroListaListNew);
            List<VotoNulo> attachedVotoNuloListNew = new ArrayList<VotoNulo>();
            for (VotoNulo votoNuloListNewVotoNuloToAttach : votoNuloListNew) {
                votoNuloListNewVotoNuloToAttach = em.getReference(votoNuloListNewVotoNuloToAttach.getClass(), votoNuloListNewVotoNuloToAttach.getIdVotoNulo());
                attachedVotoNuloListNew.add(votoNuloListNewVotoNuloToAttach);
            }
            votoNuloListNew = attachedVotoNuloListNew;
            persona.setVotoNuloList(votoNuloListNew);
            persona = em.merge(persona);
            for (Voto votoListOldVoto : votoListOld) {
                if (!votoListNew.contains(votoListOldVoto)) {
                    votoListOldVoto.setIdPersona(null);
                    votoListOldVoto = em.merge(votoListOldVoto);
                }
            }
            for (Voto votoListNewVoto : votoListNew) {
                if (!votoListOld.contains(votoListNewVoto)) {
                    Persona oldIdPersonaOfVotoListNewVoto = votoListNewVoto.getIdPersona();
                    votoListNewVoto.setIdPersona(persona);
                    votoListNewVoto = em.merge(votoListNewVoto);
                    if (oldIdPersonaOfVotoListNewVoto != null && !oldIdPersonaOfVotoListNewVoto.equals(persona)) {
                        oldIdPersonaOfVotoListNewVoto.getVotoList().remove(votoListNewVoto);
                        oldIdPersonaOfVotoListNewVoto = em.merge(oldIdPersonaOfVotoListNewVoto);
                    }
                }
            }
            for (Usuario usuarioListOldUsuario : usuarioListOld) {
                if (!usuarioListNew.contains(usuarioListOldUsuario)) {
                    usuarioListOldUsuario.setIdPersona(null);
                    usuarioListOldUsuario = em.merge(usuarioListOldUsuario);
                }
            }
            for (Usuario usuarioListNewUsuario : usuarioListNew) {
                if (!usuarioListOld.contains(usuarioListNewUsuario)) {
                    Persona oldIdPersonaOfUsuarioListNewUsuario = usuarioListNewUsuario.getIdPersona();
                    usuarioListNewUsuario.setIdPersona(persona);
                    usuarioListNewUsuario = em.merge(usuarioListNewUsuario);
                    if (oldIdPersonaOfUsuarioListNewUsuario != null && !oldIdPersonaOfUsuarioListNewUsuario.equals(persona)) {
                        oldIdPersonaOfUsuarioListNewUsuario.getUsuarioList().remove(usuarioListNewUsuario);
                        oldIdPersonaOfUsuarioListNewUsuario = em.merge(oldIdPersonaOfUsuarioListNewUsuario);
                    }
                }
            }
            for (MiembroLista miembroListaListOldMiembroLista : miembroListaListOld) {
                if (!miembroListaListNew.contains(miembroListaListOldMiembroLista)) {
                    miembroListaListOldMiembroLista.setIdPersona(null);
                    miembroListaListOldMiembroLista = em.merge(miembroListaListOldMiembroLista);
                }
            }
            for (MiembroLista miembroListaListNewMiembroLista : miembroListaListNew) {
                if (!miembroListaListOld.contains(miembroListaListNewMiembroLista)) {
                    Persona oldIdPersonaOfMiembroListaListNewMiembroLista = miembroListaListNewMiembroLista.getIdPersona();
                    miembroListaListNewMiembroLista.setIdPersona(persona);
                    miembroListaListNewMiembroLista = em.merge(miembroListaListNewMiembroLista);
                    if (oldIdPersonaOfMiembroListaListNewMiembroLista != null && !oldIdPersonaOfMiembroListaListNewMiembroLista.equals(persona)) {
                        oldIdPersonaOfMiembroListaListNewMiembroLista.getMiembroListaList().remove(miembroListaListNewMiembroLista);
                        oldIdPersonaOfMiembroListaListNewMiembroLista = em.merge(oldIdPersonaOfMiembroListaListNewMiembroLista);
                    }
                }
            }
            for (VotoNulo votoNuloListOldVotoNulo : votoNuloListOld) {
                if (!votoNuloListNew.contains(votoNuloListOldVotoNulo)) {
                    votoNuloListOldVotoNulo.setIdPersona(null);
                    votoNuloListOldVotoNulo = em.merge(votoNuloListOldVotoNulo);
                }
            }
            for (VotoNulo votoNuloListNewVotoNulo : votoNuloListNew) {
                if (!votoNuloListOld.contains(votoNuloListNewVotoNulo)) {
                    Persona oldIdPersonaOfVotoNuloListNewVotoNulo = votoNuloListNewVotoNulo.getIdPersona();
                    votoNuloListNewVotoNulo.setIdPersona(persona);
                    votoNuloListNewVotoNulo = em.merge(votoNuloListNewVotoNulo);
                    if (oldIdPersonaOfVotoNuloListNewVotoNulo != null && !oldIdPersonaOfVotoNuloListNewVotoNulo.equals(persona)) {
                        oldIdPersonaOfVotoNuloListNewVotoNulo.getVotoNuloList().remove(votoNuloListNewVotoNulo);
                        oldIdPersonaOfVotoNuloListNewVotoNulo = em.merge(oldIdPersonaOfVotoNuloListNewVotoNulo);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = persona.getIdPersona();
                if (findPersona(id) == null) {
                    throw new NonexistentEntityException("The persona with id " + id + " no longer exists.");
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
            Persona persona;
            try {
                persona = em.getReference(Persona.class, id);
                persona.getIdPersona();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The persona with id " + id + " no longer exists.", enfe);
            }
            List<Voto> votoList = persona.getVotoList();
            for (Voto votoListVoto : votoList) {
                votoListVoto.setIdPersona(null);
                votoListVoto = em.merge(votoListVoto);
            }
            List<Usuario> usuarioList = persona.getUsuarioList();
            for (Usuario usuarioListUsuario : usuarioList) {
                usuarioListUsuario.setIdPersona(null);
                usuarioListUsuario = em.merge(usuarioListUsuario);
            }
            List<MiembroLista> miembroListaList = persona.getMiembroListaList();
            for (MiembroLista miembroListaListMiembroLista : miembroListaList) {
                miembroListaListMiembroLista.setIdPersona(null);
                miembroListaListMiembroLista = em.merge(miembroListaListMiembroLista);
            }
            List<VotoNulo> votoNuloList = persona.getVotoNuloList();
            for (VotoNulo votoNuloListVotoNulo : votoNuloList) {
                votoNuloListVotoNulo.setIdPersona(null);
                votoNuloListVotoNulo = em.merge(votoNuloListVotoNulo);
            }
            em.remove(persona);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Persona> findPersonaEntities() {
        return findPersonaEntities(true, -1, -1);
    }

    public List<Persona> findPersonaEntities(int maxResults, int firstResult) {
        return findPersonaEntities(false, maxResults, firstResult);
    }

    private List<Persona> findPersonaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Persona.class));
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

    public Persona findPersona(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Persona.class, id);
        } finally {
            em.close();
        }
    }

    public int getPersonaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Persona> rt = cq.from(Persona.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    
        public Persona  buscarPersona(String cedula){
        EntityManager em = getEntityManager();
        try {
             TypedQuery<Persona> query = em.createNamedQuery("Persona.findByCedula",Persona.class);
             query.setParameter("cedula", cedula);
             List<Persona> list = query.getResultList();
            return (list.size()>1)||(0==list.size())?null:list.get(0);
        } finally {
            em.close();
        }
    }
    
}
