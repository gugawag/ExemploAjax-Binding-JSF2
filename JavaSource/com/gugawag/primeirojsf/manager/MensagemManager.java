package com.gugawag.primeirojsf.manager;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.gugawag.primeirojsf.modelo.Mensagem;

@Stateless
public class MensagemManager implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Mensagem> getMensagens(){
		return em.createQuery("from Mensagem").getResultList();
	}

	public void acrescentaMensagem(Mensagem mensagem) {
		em.persist(mensagem);
	}
}
