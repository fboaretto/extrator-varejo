package com.projetandoo.extrator.model;

import java.io.Serializable;

public class Loja implements Serializable{

	private static final long serialVersionUID = 3069590353340391832L;

	private Long id;

	private String nome;


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

}
