package com.projetandoo.extrator.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.projetandoo.extrator.clienteWS.ProdutoCadastroType;

public class LeitorArquivoPrecos 
{
	private static final String PREFIX_MARKAO 			= "MARKAO COSMETICOS";
	private static final String PREFIX_PRODUTO_INVALIDO = "SALDO DE BALANCO";

	private static final Logger LOGGER = Logger.getLogger(LeitorArquivoPrecos.class);

	private Map<String, ProdutoCadastroType> produtosMapaEntrada = new HashMap<String, ProdutoCadastroType>();

	public LeitorArquivoPrecos(Map<String, ProdutoCadastroType> produtosMapEntrada) 
	{
		this.produtosMapaEntrada = produtosMapEntrada;
	}

	public Map<String, ProdutoCadastroType> leArquivo(String arquivo) throws IOException 
	{
		FileWriter listagemFinal = 
				new FileWriter("/home/fboaretto/Documentos/Projetandoo/arquivosExtracao/Produtos/lista_produtos_FINAL.txt");

		PrintWriter pWriter = new PrintWriter(new BufferedWriter(listagemFinal));

		BufferedReader buffReader = 
				new BufferedReader(new InputStreamReader(new FileInputStream(arquivo), "IBM850"));

		String linha = buffReader.readLine();

		//Ignorando header inicial
		for (int i = 1; i <= 10; i++) 
		{
			linha = buffReader.readLine();
		}

		int countAtualizados = 0;

		while (linha != null) 
		{
			if (linha.contains(PREFIX_MARKAO)) 
			{
				for (int i = 1; i <= 4; i++) {
					linha = buffReader.readLine();
				}
			}

			if (linha.startsWith(PREFIX_PRODUTO_INVALIDO)) 
			{
				linha = buffReader.readLine();
				continue;
			}

			String codigo = linha.substring(43, 50).trim();

			String volume = linha.substring(64, 70).trim();

			String valorVendaVolume = linha.substring(89, 98);
			valorVendaVolume = formataValor(valorVendaVolume);

			String valorCustoUnidade = linha.substring(116, 124);
			valorCustoUnidade = formataValor(valorCustoUnidade);

			//LOGGER.debug(codigo + "\t[" + volume + "]\t" + valorVendaVolume + "\t" + valorCustoUnidade + "\t");


			if (produtosMapaEntrada.containsKey(codigo)) 
			{
				ProdutoCadastroType produtoAtualizado = produtosMapaEntrada.remove(codigo);
				atualizaValoresProduto(produtoAtualizado, volume, valorVendaVolume, valorCustoUnidade);

				produtosMapaEntrada.put(codigo, produtoAtualizado);

				pWriter.println(produtoAtualizado);
				countAtualizados += 1;
			}

			linha = buffReader.readLine();
		}

		pWriter.println("\nATUALIZADOS.: " + countAtualizados + " produtos atualizados.");

		/*for (Map.Entry<String, ProdutoCadastroType> entry : produtosMapaEntrada.entrySet()) 
		{
			LOGGER.debug(entry.getValue());
		}*/

		buffReader.close();
		pWriter.close();

		return produtosMapaEntrada;
	}


	private void atualizaValoresProduto(ProdutoCadastroType produto,
			String volume, String valorVendaVolume, String valorCustoUnidade) 
	{
		int volumeInt = Integer.parseInt(volume);

		BigDecimal valorVendaVolumeBD = new BigDecimal(valorVendaVolume);
		BigDecimal valorVendaUnidade = valorVendaVolumeBD.divide(new BigDecimal(volumeInt));

		produto.setPreco(valorVendaUnidade);
		produto.setCusto(new BigDecimal(valorCustoUnidade));
	}


	private String formataValor(String valor) 
	{
		String valorFormatado = valor.trim();

		if (valorFormatado.startsWith(","))
			valorFormatado = "0".concat(valorFormatado);

		return valorFormatado.replace(",", ".");
	}

}
