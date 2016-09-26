package br.com.art4dev.iples.impostometropessoal.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Constante implements Serializable {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1678927219803427533L;
	
	@Id
	private Long	          id;
	
	private String	          nome;
	private String	          valor;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getValor() {
		return valor;
	}
	
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return String.format("Constante [id=%s, nome=%s, valor=%s]", id, nome, valor);
	}
	
}
