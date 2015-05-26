package com.projetandoo.extrator.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.projetandoo.extrator.model.Produto;

public class LeitorArquivoProdutosFornecedores {

	private static final String PREFIX_MARKAO        	= "MARKAO COSMETICOS";
	private static final String PREFIX_FINAL_ARQUIVO    = "-----";
	private static final String PREFIX_PRODUTO_INVALIDO = " SALDO DE BALANCO";
	
	private Map<String, Produto> produtos = new HashMap<String, Produto>();
	
	private String nomeLoja = "";
	
	private static final Logger logging = Logger.getLogger(LeitorArquivoProdutosFornecedores.class);

	public Map<String, Produto> leArquivo(String arquivo) throws IOException {

		BufferedReader buffReader = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo), "IBM850"));

		String linha = buffReader.readLine();

		//Ignorando header inicial e capturando nome da loja
		for (int i = 1; i <= 8; i++) {
			if (i == 4) {
				nomeLoja = linha.substring(14, 34).trim();
			}
			linha = buffReader.readLine();
		}
		
		while (linha != null) {
			//headers
			if (linha.contains(PREFIX_MARKAO)) {
				for (int i = 1; i <= 8; i++) {
					linha = buffReader.readLine();
				}
			}
			if (linha.startsWith(PREFIX_PRODUTO_INVALIDO)) {
				//logging.debug("SALDO DE BALANCO ...próx linha");
				linha = buffReader.readLine();
				continue;
			}			
			//footer
			if (linha.startsWith(PREFIX_FINAL_ARQUIVO)) {
				buffReader.close();
				return produtos;
			}
			
			String[] items = StringUtils.split(linha, "|");
			String nome = items[0].trim();
			String codigo = items[1].trim();
			String estoque = items[2].substring(0, 6).trim();
			String codBarra = items[7].trim();
			String nomeFornecedor = items[8].trim();
			
			logging.debug(nome + "\t" + codigo + "\t[" + estoque + "]\t[" + codBarra + "]\t" + nomeFornecedor + "\t" + nomeLoja);

			Produto produto = atualizaValoresProduto(nome, codigo, estoque, codBarra, nomeFornecedor, nomeLoja);

			produtos.put(codigo, produto);
			linha = buffReader.readLine();
		}

		buffReader.close();
		return produtos;
	}


	public Produto atualizaValoresProduto(String nome, String codigo, String estoque, 
			String codBarra, String fornecedor, String nomeLoja) {

		Produto produto = new Produto(nomeLoja);

		produto.setNome(nome);
		produto.setCodigo(codigo);

		if (estoque.isEmpty())
			produto.setEstoque(Integer.valueOf(0));
		else
			produto.setEstoque(Integer.parseInt(estoque));

		if (codBarra.isEmpty())
			produto.setCodigoBarra(null);
		else
			produto.setCodigoBarra(codBarra);

		produto.setNomeFornecedor(fornecedor);

		return produto;
	}

	public Map<String, Produto> getProdutos() {
		return produtos;
	}

}
