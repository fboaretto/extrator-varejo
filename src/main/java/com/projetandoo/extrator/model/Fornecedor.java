package com.projetandoo.extrator.model;

import java.io.Serializable;

public class Fornecedor implements Serializable{

	private static final long serialVersionUID = 5010750325615569313L;

	private String nome;

	private Loja loja;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

}
