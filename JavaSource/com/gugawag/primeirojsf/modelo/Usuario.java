package com.gugawag.primeirojsf.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_USUARIO_TWITTER")
public class Usuario implements Serializable, Comparable<Usuario>{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer codigo;
	private String nome;
	private String email;
	private String login;
	private String senha;
	private String uf;
	private String cidade;

	@OneToMany(mappedBy="enviador", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Mensagem> mensagensEnviadas;
	
	@OneToMany(mappedBy="receptor", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Mensagem> mensagensRecebidas;
	
	public Usuario() {
		this(null, null, null, null);
	}

	public Usuario(String nome, String email, String login, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.login = login;
		this.senha = senha;
		setMensagensEnviadas(new ArrayList<Mensagem>());
		setMensagensRecebidas(new ArrayList<Mensagem>());
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String toString() {
		return login;
	}

	@Override
	public int compareTo(Usuario outro) {
		return this.getLogin().compareTo(outro.getLogin());
	}

	public List<Mensagem> getMensagensEnviadas() {
		return mensagensEnviadas;
	}

	public void setMensagensEnviadas(List<Mensagem> mensagensEnviadas) {
		this.mensagensEnviadas = mensagensEnviadas;
	}

	public List<Mensagem> getMensagensRecebidas() {
		return mensagensRecebidas;
	}

	public void setMensagensRecebidas(List<Mensagem> mensagensRecebidas) {
		this.mensagensRecebidas = mensagensRecebidas;
	}
	
	public void receberMensagem(Mensagem mensagem){
		this.mensagensRecebidas.add(mensagem);
	}
	
	public void enviarMensagem(Mensagem mensagem){
		this.mensagensEnviadas.add(mensagem);
	}
	

}
