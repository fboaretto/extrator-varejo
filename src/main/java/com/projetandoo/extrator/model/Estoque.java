package com.projetandoo.extrator.model;

import java.io.Serializable;

public class Estoque implements Serializable {

	private static final long serialVersionUID = 1L;

	private long minimo;

	private long disponivel;

	private long maximo;

	private long ressuprimento;

	private long reposicao;
	
	
	@Override
	public String toString() {
		return "Estoque [minimo=" + minimo + ", disponivel=" + disponivel
				+ ", maximo=" + maximo + ", ressuprimento=" + ressuprimento
				+ ", reposicao=" + reposicao + "]";
	}

	
	public long getMinimo() {
		return minimo;
	}

	public void setMinimo(long minimo) {
		this.minimo = minimo;
	}

	public long getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(long disponivel) {
		this.disponivel = disponivel;
	}

	public long getMaximo() {
		return maximo;
	}

	public void setMaximo(long maximo) {
		this.maximo = maximo;
	}

	public long getRessuprimento() {
		return ressuprimento;
	}

	public void setRessuprimento(long ressuprimento) {
		this.ressuprimento = ressuprimento;
	}

	public long getReposicao() {
		return reposicao;
	}

	public void setReposicao(long reposicao) {
		this.reposicao = reposicao;
	}
	
}
