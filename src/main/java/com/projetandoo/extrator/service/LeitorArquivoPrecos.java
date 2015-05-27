package com.projetandoo.extrator.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.projetandoo.extrator.model.Produto;

public class LeitorArquivoPrecos {

	private static final String PREFIX_MARKAO 			= "MARKAO COSMETICOS";
	private static final String PREFIX_PRODUTO_INVALIDO = "SALDO DE BALANCO";

	private Map<String, Produto> produtosMapaEntrada = new HashMap<String, Produto>();

	private List<Produto> produtosListaSaida = new ArrayList<Produto>();
	
	private static final Logger logging = Logger.getLogger(LeitorArquivoPrecos.class);
	
	public LeitorArquivoPrecos(Map<String, Produto> produtosMapEntrada) {
		this.produtosMapaEntrada = produtosMapEntrada;
	}

	public List<Produto> leArquivo(String arquivo) throws IOException {
		
		FileWriter fWriter = 
				new FileWriter("/home/fboaretto/Documentos/Projetandoo/arquivosExtracao/relatoriodeprodutoscadastradoseestoque/lista_produtos_FINAL.txt");
		PrintWriter pWriter = new PrintWriter(new BufferedWriter(fWriter));
		
		BufferedReader buffReader = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo), "IBM850"));

		String linha = buffReader.readLine();
		
		//Ignorando header inicial
		for (int i = 1; i <= 10; i++) {
			linha = buffReader.readLine();
		}

		while (linha != null) {

			if (linha.contains(PREFIX_MARKAO)) {
				for (int i = 1; i <= 4; i++) {
					linha = buffReader.readLine();
				}
			}
			if (linha.startsWith(PREFIX_PRODUTO_INVALIDO)) {
				//logging.debug("SALDO DE BALANCO ...próx linha");
				linha = buffReader.readLine();
				continue;
			}

			String codigo = linha.substring(43, 50).trim();

			String volume = linha.substring(64, 70).trim();

			String valorVendaVolume = linha.substring(89, 98);
			valorVendaVolume = formataValor(valorVendaVolume);

			String valorCustoUnidade = linha.substring(116, 124);
			valorCustoUnidade = formataValor(valorCustoUnidade);

			logging.debug(codigo + "\t[" + volume + "]\t" + valorVendaVolume + "\t" + valorCustoUnidade + "\t");
			
			Produto produto = produtosMapaEntrada.get(codigo);

			atualizaValoresProduto(produto, volume, valorVendaVolume, valorCustoUnidade);
			
			produtosListaSaida.add(produto);
			pWriter.println(produto);
			
			linha = buffReader.readLine();
		}

		pWriter.println("\nTOTAL: " + produtosListaSaida.size());
		
		buffReader.close();
		pWriter.close();

		return produtosListaSaida;
	}


	public void atualizaValoresProduto(Produto produto, String volume, String valorVendaVolume, String valorCustoUnidade) {

		int volumeInt = Integer.parseInt(volume);

		BigDecimal valorVendaVolumeBD = new BigDecimal(valorVendaVolume);
		BigDecimal valorVendaUnidade = valorVendaVolumeBD.divide(new BigDecimal(volumeInt));
		
		produto.setValorVenda(valorVendaUnidade);
		produto.setValorCusto(new BigDecimal(valorCustoUnidade));
	}


	public String formataValor(String valor) {

		String valorFormatado = valor.trim();

		if (valorFormatado.startsWith(","))
			valorFormatado = "0".concat(valorFormatado);

		return valorFormatado.replace(",", ".");
	}


	public List<Produto> getProdutos() {
		return produtosListaSaida;
	}

}
