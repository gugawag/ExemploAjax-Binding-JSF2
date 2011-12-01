package com.gugawag.primeirojsf.service;

import java.util.List;
import java.util.StringTokenizer;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.gugawag.primeirojsf.manager.MensagemManager;
import com.gugawag.primeirojsf.manager.UsuarioManager;
import com.gugawag.primeirojsf.modelo.Mensagem;
import com.gugawag.primeirojsf.modelo.Usuario;

@Stateless
public class MensagemService {
	
	@EJB
	private UsuarioManager usuarioManager;
	
	@EJB 
	private MensagemManager mensagemManager;

	public void enviarMensagem(Usuario enviador, String textoMensagem) {
		enviador = usuarioManager.getUsuarioPorLogin(enviador.getLogin());
		Usuario receptor = getUsuarioReceptorDaMensagem(textoMensagem);
		Mensagem mensagem = new Mensagem(textoMensagem, enviador, receptor);
	}

	/**
	 * Retorna o usu‡rio que vai receber a mensagem (@login)
	 * @param textoMensagem
	 * @return
	 */
	private Usuario getUsuarioReceptorDaMensagem(String textoMensagem) {
		StringTokenizer tokenizer = new StringTokenizer(textoMensagem, " ");
		while (tokenizer.hasMoreTokens()){
			String token = tokenizer.nextToken();
			if (token.contains("@")){
				String login = token.substring(1, token.length());
				return usuarioManager.getUsuarioPorLogin(login);
			}
		}
		return null;
	}

	public List<Mensagem> getMensagens() {
		return mensagemManager.getMensagens();
	}

}
