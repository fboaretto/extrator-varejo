package com.projetandoo.extrator.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Estoque implements Serializable 
{

	private static final long serialVersionUID = -2673082177703373215L;

	private BigDecimal minimo;

	private BigDecimal disponivel;

	private BigDecimal maximo;

	private BigDecimal ressuprimento;


	public BigDecimal getMinimo() {
		return minimo;
	}

	public void setMinimo(BigDecimal minimo) {
		this.minimo = minimo;
	}

	public BigDecimal getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(BigDecimal disponivel) {
		this.disponivel = disponivel;
	}

	public BigDecimal getMaximo() {
		return maximo;
	}

	public void setMaximo(BigDecimal maximo) {
		this.maximo = maximo;
	}

	public BigDecimal getRessuprimento() {
		return ressuprimento;
	}

	public void setRessuprimento(BigDecimal ressuprimento) {
		this.ressuprimento = ressuprimento;
	}

	@Override
	public String toString() {
		return "Estoque [minimo=" + minimo + ", disponivel=" + disponivel
				+ ", maximo=" + maximo + ", ressuprimento=" + ressuprimento
				+ "]";
	}

}
