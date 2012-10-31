package com.gugawag.primeirojsf.manager;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.gugawag.primeirojsf.modelo.Usuario;

@Stateless
public class UsuarioManager implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;
	
	public void acrescentaUsuario(Usuario usuario){
		em.persist(usuario);
	}

	public void acrescentaAtualizaUsuario(Usuario usuario){
		if (usuario.getCodigo() != null){
			em.merge(usuario);
		} else{
			em.persist(usuario);
		}
	}
	
	public Usuario getUsuarioPorCodigo(int codigo){
		return em.find(Usuario.class, codigo);
	}
	
	public List<Usuario> getUsuarios(){
		return (List<Usuario>)em.createQuery("from Usuario").getResultList();
	}
	
	public List<Usuario> getUsuariosLogados(){
		return (List<Usuario>)em.createQuery("from Usuario u where u.logado=true").getResultList();
	}
	
	public Usuario getUsuarioPorLogin(String login){
		List<Usuario> usuarios = (List<Usuario>)em.createQuery("from Usuario u where u.login=:login").setParameter("login", login).getResultList();
		if ((usuarios != null) && (usuarios.size()>0)){
			return usuarios.get(0);
		}
		return null;
	}

	public void remover(Usuario usuario) {
		usuario = em.merge(usuario);
		em.remove(usuario);
	}	
}
