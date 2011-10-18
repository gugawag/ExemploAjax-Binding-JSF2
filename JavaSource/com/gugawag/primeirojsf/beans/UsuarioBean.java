package com.gugawag.primeirojsf.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlSelectOneMenu;

@ManagedBean
@SessionScoped
public class UsuarioBean {
	private String login;
	private String senha;
	private String captcha;
	private boolean loginsucesso;
	private List<String> nomes;
	private HtmlInputText loginHtml;
	private String nome;
	private HtmlSelectOneMenu menu;
	private String senhaRedigitada;
	private String textoSenhas;
	private List<String> cidades;
	private List<String> ufs;
	private Map<String, List<String>> mapaUFs;
	private String ufEscolhida;
	private String cidadeEscolhida;

	public UsuarioBean() {
		super();
		mapaUFs = new HashMap<String, List<String>>();

		ufs = new ArrayList<String>();
		ufs.add("PB");
		ufs.add("PE");
		ufs.add("RN");

		List<String> cidadesPB = new ArrayList<String>();
		cidadesPB.add("Jo‹o Pessoa");
		cidadesPB.add("Campina Grande");
		cidadesPB.add("Patos");

		List<String> cidadesPE = new ArrayList<String>();
		cidadesPE.add("Recife");
		cidadesPE.add("Penedo");
		cidadesPE.add("Ferreiros");

		mapaUFs.put("PB", cidadesPB);
		mapaUFs.put("PE", cidadesPE);
	}

	
	public String getCidadeEscolhida() {
		return cidadeEscolhida;
	}


	public void setCidadeEscolhida(String cidadeEscolhida) {
		this.cidadeEscolhida = cidadeEscolhida;
	}


	public List<String> getCidades() {
		return cidades;
	}

	public void setCidades(List<String> cidades) {
		this.cidades = cidades;
	}

	public String getUfEscolhida() {
		return ufEscolhida;
	}

	public void setUfEscolhida(String ufEscolhida) {
		this.ufEscolhida = ufEscolhida;
	}

	public List<String> getUfs() {
		return ufs;
	}

	public void setUfs(List<String> ufs) {
		this.ufs = ufs;
	}

	public HtmlSelectOneMenu getMenu() {
		return menu;
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

	public void setMenu(HtmlSelectOneMenu menu) {
		this.menu = menu;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public HtmlInputText getLoginHtml() {
		return loginHtml;
	}

	public void setLoginHtml(HtmlInputText loginHtml) {
		this.loginHtml = loginHtml;
	}

	public List<String> getNomes() {
		menu.setValue("Nome 2");
		return nomes;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean getLoginsucesso() {
		return loginsucesso;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public String logar() {
		if (login.equals(senha)) {
			this.loginsucesso = true;
			return "loginlegal";
		}
		this.loginsucesso = false;
		loginHtml.setStyle("background:red");
		return null;
	}
	
	public void checarSenhas(){
		if (senha.equals(senhaRedigitada)){
			textoSenhas = "Senhas conferem!";
		} else{
			textoSenhas = "Senhas n‹o conferem!";
		}
	}
	
	public void mudarUf(){
		cidades = mapaUFs.get(ufEscolhida);
	}


}
