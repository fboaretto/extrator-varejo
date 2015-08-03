package com.projetandoo.extrator.service;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Map;

import org.apache.log4j.Logger;

import com.projetandoo.extrator.clienteWS.ProdutoCadastroType;
import com.projetandoo.extrator.clienteWS.Produtos;
import com.projetandoo.extrator.clienteWS.Produtos_Service;

public class ConsumidorProdutos 
{
	private static final Logger LOGGER = Logger.getLogger(ConsumidorProdutos.class);

	public static void main(String[] args) throws IOException 
	{
		String arquivoCargaProdutos = 
				".../CW000200_ANTERIOR.SPL";

		String arquivoCargaPrecos = 
				".../sp001148_ANTERIOR.txt";

		//Primeiro Arquivo
		LeitorArquivoProdutos leitorProdutos = new LeitorArquivoProdutos();
		Map<String, ProdutoCadastroType> mapaProdutos = leitorProdutos.leArquivo(arquivoCargaProdutos);


		//Segundo Arquivo
		LeitorArquivoPrecos leitorPrecos = new LeitorArquivoPrecos(mapaProdutos);
		Map<String, ProdutoCadastroType> mapaProdutosAtualizados = leitorPrecos.leArquivo(arquivoCargaPrecos);

		LOGGER.debug("\n\nTOTAL :::::: " + mapaProdutosAtualizados.size());


		Authenticator.setDefault(new Authenticator() 
		{
			@Override
			protected PasswordAuthentication getPasswordAuthentication() 
			{
				return new PasswordAuthentication(
						"marcelos...",
						"123...".toCharArray());
			}
		});


		Produtos_Service servico = new Produtos_Service();
		Produtos produtos = servico.getProdutosSOAP();

		for (Map.Entry<String, ProdutoCadastroType> produto : mapaProdutosAtualizados.entrySet()) 
		{
			try {
				produtos.salvar(produto.getValue());

				LOGGER.debug("Produto: " + produto.getValue().getNome() + " - "
						+ produto.getValue().getCodigoInterno() + " enviado com sucesso");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
