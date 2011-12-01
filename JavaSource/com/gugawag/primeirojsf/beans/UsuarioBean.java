package com.gugawag.primeirojsf.beans;

import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import com.gugawag.primeirojsf.modelo.Mensagem;
import com.gugawag.primeirojsf.modelo.UF;
import com.gugawag.primeirojsf.modelo.Usuario;
import com.gugawag.primeirojsf.modelo.UsuarioJahExistenteException;
import com.gugawag.primeirojsf.service.UsuarioService;

@ManagedBean
@SessionScoped
public class UsuarioBean {

	private Usuario usuario;
	private boolean loginsucesso;
	private String senhaRedigitada;
	private String textoSenhas;
	private DataModel<Usuario> dmUsuarios;
	private List<String> cidades;
	private String styleMensagemSenha;

	@EJB 
	private UsuarioService usuarioService;

	public UsuarioBean() {
		super();
		usuario = new Usuario();
	}

	//MŽtodos action
	
	public void mudarUf(){
		cidades = new UF().getUfsCidades().get(usuario.getUf());
	}

	public void cadastrar() {
		usuario.setCodigo(null);
		try {
			usuarioService.acrescentaAtualizaUsuario(usuario);
		} catch (UsuarioJahExistenteException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usu‡rio j‡ cadastrado!"));
			return;
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usu‡rio cadastrado com sucesso!"));
	}

	public String logar() {
		Usuario usuarioALogar = usuarioService.getUsuarioPorLogin(usuario.getLogin());
		if (usuarioALogar == null){
			//TODO pegar essa mensagem do arquivo de properties
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usu‡rio inexistente e/ou senha inv‡lida!"));
			return null;
		}
		try {
			usuarioService.acrescentaAtualizaUsuario(usuarioALogar);
		} catch (UsuarioJahExistenteException e) {
			e.printStackTrace();
			return null;
		}
		this.usuario = usuarioALogar;
		return "loginlegal";
	}
	
	public String deslogar(){
		usuario = new Usuario();
		return "inicio";
	}
	
	public void checarSenhas() {
		if (usuario.getSenha().equals(senhaRedigitada)) {
			textoSenhas = "Senhas conferem!";
			styleMensagemSenha = "color:blue";
		} else {
			textoSenhas = "Senhas n‹o conferem!";
			styleMensagemSenha = "color:red";
		}
	}
	
	//Gets e Sets
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTextoSenhas() {
		return textoSenhas;
	}

	public void setTextoSenhas(String textoSenhas) {
		this.textoSenhas = textoSenhas;
	}

	public String getSenhaRedigitada() {
		return senhaRedigitada;
	}

	public void setSenhaRedigitada(String senhaRedigitada) {
		this.senhaRedigitada = senhaRedigitada;
	}

	public boolean getLoginsucesso() {
		return loginsucesso;
	}
	
	public DataModel<Usuario> getUsuarios(){
		this.dmUsuarios = new ListDataModel<Usuario>(usuarioService.getUsuarios());
		return dmUsuarios;
	}
	
	public DataModel<Usuario> getUsuariosLogados(){
		this.dmUsuarios = new ListDataModel<Usuario>(usuarioService.getUsuariosLogados());
		return dmUsuarios;
	}
	
	//TODO refatorar essa parte de UFs. Usar enums?
	public Set<String> getUfs(){
		return new UF().getUfsCidades().keySet(); 
	}
	
	public List<String> getCidades(){
		return cidades; 
	}
	
	public String getStyleMensagemSenha() {
		return styleMensagemSenha;
	}

	public void setStyleMensagemSenha(String styleMensagemSenha) {
		this.styleMensagemSenha = styleMensagemSenha;
	}
	
	public List<Mensagem> getMensagensRecebidas(){
		usuario = usuarioService.getUsuarioPorLogin(usuario.getLogin());
		return usuario.getMensagensRecebidas();
	}


	
}
