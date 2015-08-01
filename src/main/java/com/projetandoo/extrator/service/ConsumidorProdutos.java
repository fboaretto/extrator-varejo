package com.projetandoo.extrator.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.projetandoo.extrator.clienteWS.EstoqueType;
import com.projetandoo.extrator.clienteWS.FornecedorType;
import com.projetandoo.extrator.clienteWS.LojaType;
import com.projetandoo.extrator.clienteWS.ObjectFactory;
import com.projetandoo.extrator.clienteWS.ProdutoCadastroType;
import com.projetandoo.extrator.clienteWS.Produtos;
import com.projetandoo.extrator.clienteWS.Produtos_Service;

public class ConsumidorProdutos 
{
	private static final Logger LOGGER = Logger.getLogger(ConsumidorProdutos.class);

	public static void main(String[] args) throws IOException 
	{
		/*String arquivoCargaProdutos = 
				"/home/fboaretto/Documentos/Projetandoo/arquivosExtracao/relatoriodeprodutoscadastradoseestoque/CW000200_ANTERIOR.SPL";

		String arquivoCargaPrecos = 
				"/home/fboaretto/Documentos/Projetandoo/arquivosExtracao/relatoriodeprodutoscadastradoseestoque/sp001148_ANTERIOR.txt";

		//Primeiro Arquivo
		LeitorArquivoProdutos leitorProdutos = new LeitorArquivoProdutos();
		Map<String, ProdutoCadastroType> mapaProdutos = leitorProdutos.leArquivo(arquivoCargaProdutos);

		LOGGER.debug("\n\n\nTOTAL :::::: " + mapaProdutos.size() + "\n");
		LOGGER.debug("===== IMPRIMINDO MIX([chave]:valor) =====\n");

		for (Map.Entry<String, ProdutoCadastroType> mapaProduto : mapaProdutos.entrySet()) 
		{
			LOGGER.debug("[" + mapaProduto.getKey() + "]: "+ mapaProduto.getValue() + "\n");
		}

		//Segundo Arquivo
		LeitorArquivoPrecos leitorPrecos = new LeitorArquivoPrecos(mapaProdutos);
		List<ProdutoCadastroType> listaProdutos = leitorPrecos.leArquivo(arquivoCargaPrecos);

		LOGGER.debug("\n\nTOTAL :::::: " + listaProdutos.size());
		LOGGER.debug("IMPRIMINDO " + listaProdutos.size()
				+ " PRODUTOS ATUALIZADOS DOS " + mapaProdutos.size()
				+ " VINDOS DO PRIMEIRO ARQUIVO:\n");*/
		
		
		ObjectFactory factory = new ObjectFactory();
		ProdutoCadastroType produto = factory.createProdutoCadastroType();

		produto.setNome("produtoEclipse");
		produto.setCodigoInterno(Long.parseLong("111222"));
		produto.setCodigoExterno(000000);
		produto.setPeso(new BigDecimal(1));
		
		LojaType loja = factory.createLojaType();
		loja.setCodigoInterno(Long.parseLong("1"));
		loja.setId(Long.parseLong("1"));
		produto.setLoja(loja);

		EstoqueType estoque = factory.createEstoqueType();
		estoque.setDisponivel(new BigDecimal("15"));
		BigDecimal ZERO_BIG_DECIMAL  = new BigDecimal(0);

		estoque.setMaximo(ZERO_BIG_DECIMAL);
		estoque.setMinimo(ZERO_BIG_DECIMAL);
		estoque.setRessuprimento(ZERO_BIG_DECIMAL);

		produto.setEstoque(estoque);
		
		produto.setCodigoBarra("7896009186666");

		FornecedorType fornecedor = factory.createFornecedorType();
		fornecedor.setNome("FornecedorEclipse");

		produto.setFornecedor(fornecedor);
		
		produto.setCusto(new BigDecimal("2.20"));
		produto.setPreco(new BigDecimal("4.20"));
		
		LOGGER.debug(produto.toString());

		Authenticator.setDefault(new Authenticator() 
		{
			@Override
			protected PasswordAuthentication getPasswordAuthentication() 
			{
				return new PasswordAuthentication(
						"marcelosrodrigues@globo.com",
						"12345678".toCharArray());
			}
		});

		Produtos_Service servico = new Produtos_Service();
		Produtos produtos = servico.getProdutosSOAP();

		produtos.salvar(produto);
		
		//for (ProdutoCadastroType produtoCadastroType : listaProdutos) 
		//	produtos.salvar(produtoCadastroType);

	}

}
