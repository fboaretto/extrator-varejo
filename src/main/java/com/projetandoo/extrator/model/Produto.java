package com.projetandoo.extrator.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Produto implements Serializable{

	private static final long serialVersionUID = 2234476414421868736L;

	private String nome;

	private long codigo;

	private Estoque estoque;

	private String codigoBarra;

	private BigDecimal valorCusto;

	private BigDecimal valorVenda;

	private Fornecedor fornecedor;

	private Loja loja;


	@Override
	public String toString() 
	{
		return getNome() + "||" + getCodigo() + "||"
				+ getEstoque().getDisponivel() + "||" + getCodigoBarra() + "||"
				+ getFornecedor().getNome() + "||" + getValorCusto() + "||"
				+ getValorVenda() + "||" + getLoja().getNome();
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigo ^ (codigo >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValorCusto() {
		return valorCusto;
	}

	public void setValorCusto(BigDecimal valorCusto) {
		this.valorCusto = valorCusto;
	}

	public BigDecimal getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

}
