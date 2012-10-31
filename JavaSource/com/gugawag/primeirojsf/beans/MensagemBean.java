package com.gugawag.primeirojsf.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.gugawag.primeirojsf.modelo.Mensagem;
import com.gugawag.primeirojsf.modelo.Usuario;
import com.gugawag.primeirojsf.service.MensagemService;

@ManagedBean
@SessionScoped
public class MensagemBean {

	private String textoMensagem;
	
	@EJB 
	private MensagemService mensagemService;

	public MensagemBean() {
		super();
	}

	public String enviarMensagem(Usuario enviador){
		mensagemService.enviarMensagem(enviador, textoMensagem);
		return null;
	}
	
	public List<Mensagem> getMensagens(){
		return mensagemService.getMensagens();
	}

	public String getTextoMensagem() {
		return textoMensagem;
	}

	public void setTextoMensagem(String textoMensagem) {
		this.textoMensagem = textoMensagem;
	}
}
