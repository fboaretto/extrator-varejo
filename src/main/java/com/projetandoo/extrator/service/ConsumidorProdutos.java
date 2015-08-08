package com.projetandoo.extrator.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Map;

import org.apache.log4j.Logger;

import com.projetandoo.extrator.clienteWS.ProdutoCadastroType;
import com.projetandoo.extrator.clienteWS.ProdutoResponseType;
import com.projetandoo.extrator.clienteWS.Produtos;
import com.projetandoo.extrator.clienteWS.Produtos_Service;
import com.projetandoo.extrator.clienteWS.StatusType;

public class ConsumidorProdutos 
{
	private static final Logger LOGGER = Logger.getLogger(ConsumidorProdutos.class);

	public static void main(String[] args) throws IOException 
	{
		String arquivoCargaProdutos = 
				".../CW000200.SPL";

		String arquivoCargaPrecos = 
				".../sp001148.txt";

		String arquivoControle = 
				".../produtos_enviados.txt";

		//Primeiro Arquivo
		LeitorArquivoProdutos leitorProdutos = new LeitorArquivoProdutos();
		Map<String, ProdutoCadastroType> mapaProdutos = leitorProdutos.leArquivo(arquivoCargaProdutos);

		//Segundo Arquivo
		LeitorArquivoPrecos leitorPrecos = new LeitorArquivoPrecos(mapaProdutos);
		Map<String, ProdutoCadastroType> mapaProdutosAtualizados = leitorPrecos.leArquivo(arquivoCargaPrecos);

		//Arquivo Controle
		BufferedReader buffReader = new BufferedReader(new InputStreamReader(new FileInputStream(arquivoControle)));
		String linhaCodigo = buffReader.readLine();

		LOGGER.debug("\n\nTOTAL ANTES:::::: " + mapaProdutosAtualizados.size());
		while (linhaCodigo != null) 
		{
			if (mapaProdutosAtualizados.containsKey(linhaCodigo))
			{
				mapaProdutosAtualizados.remove(linhaCodigo);
			}
			linhaCodigo = buffReader.readLine();
		}
		
		buffReader.close();
		
		LOGGER.debug("\n\n..E DEPOIS!!!:::::: " + mapaProdutosAtualizados.size());


		Authenticator.setDefault(new Authenticator() 
		{
			@Override
			protected PasswordAuthentication getPasswordAuthentication() 
			{
				return new PasswordAuthentication(
						"...",
						"...".toCharArray());
			}
		});


		Produtos_Service servico = new Produtos_Service();
		Produtos produtos = servico.getProdutosSOAP();

		FileWriter arquivoControleAAtualizar = new FileWriter(arquivoControle, true);
		PrintWriter pWriter = new PrintWriter(arquivoControleAAtualizar);

		for (Map.Entry<String, ProdutoCadastroType> produto : mapaProdutosAtualizados.entrySet()) 
		{
			try 
			{
				ProdutoResponseType produtoResponse = produtos.salvar(produto.getValue());

				LOGGER.debug("[" + produtoResponse.getDataProcessamento() + "] : " 
						+ produtoResponse.getProduto().getCodigoInterno() + ", STATUS: " + produtoResponse.getServiceStatus());
				
				if(produtoResponse.getServiceStatus().equals(StatusType.SUCESSO))
				{
					pWriter.println(produto.getKey());
					pWriter.flush();
				}
				
			} catch (Exception e) {
				pWriter.close();
				e.printStackTrace();
			}
		}

		pWriter.close();
	}

}
