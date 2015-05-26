package com.projetandoo.extrator.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;

	private String nome;

	private String codigo;

	private Integer estoque;

	private String codigoBarra;

	private BigDecimal valorCusto;

	private BigDecimal valorVenda;

	private String nomeFornecedor;
	
	private Loja loja;
	

	public Produto(String nomeLoja) {
		this.loja = new Loja(nomeLoja);
	}

	@Override
	public String toString() {
		return getId() + "||" + getNome() + "||" + getCodigo() + "||"
				+ getEstoque() + "||" + getCodigoBarra() + "||"
				+ getNomeFornecedor() + "||" + getValorCusto() + "||"
				+ getValorVenda() + "||" + getLoja().getNome();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public Produto(Long id) {
		this.id = id;
	}

	public Produto(Long id, String nomeProduto) {
		this.id = id;
		this.nome = nomeProduto;
	}

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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public String getNomeFornecedor() {
		return nomeFornecedor;
	}

	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

}
