package com.gugawag.primeirojsf.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_MENSAGEM")
public class Mensagem implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer codigo;
	private String texto;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEnvio;

	@ManyToOne(cascade=CascadeType.ALL)
	private Usuario enviador;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Usuario receptor;
	
	public Mensagem() {
		this(null);
	}
	
	public Mensagem(String texto) {
		this(texto, null, null);
	}
	
	public Mensagem(String texto, Usuario enviador, Usuario receptor) {
		this.texto = texto;
		this.setEnviador(enviador);
		this.setReceptor(receptor);
		if (enviador != null){
			enviador.enviarMensagem(this);
		}
		if (receptor != null){
			receptor.receberMensagem(this);
		}
		this.dataEnvio = new Date();
	}


	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String toString(){
		return "Codigo: " + codigo + " texto: " + texto;
	}

	public Date getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public Usuario getEnviador() {
		return enviador;
	}

	public void setEnviador(Usuario enviador) {
		this.enviador = enviador;
	}

	public Usuario getReceptor() {
		return receptor;
	}

	public void setReceptor(Usuario receptor) {
		this.receptor = receptor;
	}
}
