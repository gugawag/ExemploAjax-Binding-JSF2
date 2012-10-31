package com.gugawag.primeirojsf.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.gugawag.primeirojsf.manager.UsuarioManager;
import com.gugawag.primeirojsf.modelo.Usuario;
import com.gugawag.primeirojsf.modelo.UsuarioJahExistenteException;

@Stateless
public class UsuarioService {
	
	@EJB
	private UsuarioManager usuarioManager;

	public void acrescentaAtualizaUsuario(Usuario usuario) throws UsuarioJahExistenteException{
		Usuario usuarioAInserir = getUsuarioPorLogin(usuario.getLogin());
		if ((usuarioAInserir != null) && (usuario.getCodigo() == null)){
			throw new UsuarioJahExistenteException("O usu‡rio de login [" + usuarioAInserir.getLogin() +"]" +
					"j‡ est‡ cadastrado!");
		}
		usuarioManager.acrescentaAtualizaUsuario(usuario);
	}
	
	public List<Usuario> getUsuarios(){
		return usuarioManager.getUsuarios();
	}
	
	public Usuario getUsuarioPorLogin(String login){
		return usuarioManager.getUsuarioPorLogin(login);
	}
	
	public List<Usuario> getUsuariosLogados(){
		return usuarioManager.getUsuariosLogados();
	}

	public void remover(Usuario usuario) {
		usuarioManager.remover(usuario);
	}

}
