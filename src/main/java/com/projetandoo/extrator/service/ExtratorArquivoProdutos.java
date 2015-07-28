package com.projetandoo.extrator.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.projetandoo.extrator.clienteWS.DepartamentoType;
import com.projetandoo.extrator.clienteWS.EstoqueType;
import com.projetandoo.extrator.clienteWS.GondolaType;
import com.projetandoo.extrator.clienteWS.LojaType;
import com.projetandoo.extrator.clienteWS.ObjectFactory;
import com.projetandoo.extrator.clienteWS.ProdutoCadastroType;
import com.projetandoo.extrator.clienteWS.Produtos;
import com.projetandoo.extrator.clienteWS.Produtos_Service;
import com.projetandoo.extrator.model.Produto;

public class ExtratorArquivoProdutos 
{

	private static final int        COD_EXTERNO_PRODUTOS = 000000;
	private static final BigDecimal ZERO_BIG_DECIMAL     = new BigDecimal(0);
	private static final Logger     LOGGER               = Logger.getLogger(ExtratorArquivoProdutos.class);

	public static void main(String[] args) throws IOException 
	{

		String arquivoCargaProdutoFornecedores = "";

		String arquivoCargaPrecos = "";

		//Primeiro Arquivo
		LeitorArquivoProdutos leitorProdutos = new LeitorArquivoProdutos();
		Map<String, Produto> mapaProdutos = leitorProdutos.leArquivo(arquivoCargaProdutoFornecedores);

		LOGGER.debug("\n\n\nTOTAL :::::: " + mapaProdutos.size() + "\n");
		LOGGER.debug("===== IMPRIMINDO MIX([chave]:valor) =====\n");
		
		for (Map.Entry<String, Produto> mapaProduto : mapaProdutos.entrySet()) 
		{
			LOGGER.debug("[" + mapaProduto.getKey() + "]: "+ mapaProduto.getValue() + "\n");
		}

		//Segundo Arquivo
		LeitorArquivoPrecos leitorPrecos = new LeitorArquivoPrecos(mapaProdutos);
		List<Produto> listaProdutos = leitorPrecos.leArquivo(arquivoCargaPrecos);

		LOGGER.debug("\n\nTOTAL :::::: " + listaProdutos.size());
		LOGGER.debug("IMPRIMINDO " + listaProdutos.size()
				+ " PRODUTOS ATUALIZADOS DOS " + mapaProdutos.size()
				+ " VINDOS DO PRIMEIRO ARQUIVO:\n");

		ObjectFactory factory = new ObjectFactory();
		
		LojaType lojaType = factory.createLojaType();
		
		DepartamentoType departamentoType = factory.createDepartamentoType();

		List<ProdutoCadastroType> listaProdutosTypes = new ArrayList<ProdutoCadastroType>();


		for(Produto produto : listaProdutos) 
		{
			LOGGER.debug("PRODUTO ARQUIVO: " + produto);

			ProdutoCadastroType produtoCadType = factory.createProdutoCadastroType();

			produtoCadType.setPeso(ZERO_BIG_DECIMAL);
			produtoCadType.setCodigoExterno(COD_EXTERNO_PRODUTOS);
			
			//QUAL ID???
			produtoCadType.setId(1);

			produtoCadType.setNome(produto.getNome());
			produtoCadType.setCodigoInterno(produto.getCodigo());
			produtoCadType.setCodigoBarra(produto.getCodigoBarra());

			EstoqueType estoqueType = factory.createEstoqueType();
			estoqueType.setDisponivel(produto.getEstoque().getDisponivel());
			estoqueType.setMaximo(ZERO_BIG_DECIMAL);
			estoqueType.setMinimo(ZERO_BIG_DECIMAL);
			estoqueType.setRessuprimento(ZERO_BIG_DECIMAL);
			produtoCadType.setEstoque(estoqueType);

			GondolaType gondolaType = factory.createGondolaType();
			gondolaType.setDisponivel(ZERO_BIG_DECIMAL);
			gondolaType.setMaximo(ZERO_BIG_DECIMAL);
			gondolaType.setMinimo(ZERO_BIG_DECIMAL);
			gondolaType.setReposicao(ZERO_BIG_DECIMAL);
			produtoCadType.setGondola(gondolaType);

			//Loja
			lojaType.setId(produto.getLoja().getId());
			produtoCadType.setLoja(lojaType);

			//Departamento
			departamentoType.setId(Long.valueOf(0));
			departamentoType.setNome("Departamento1");
			produtoCadType.setDepartamanento(departamentoType);

			produtoCadType.setCusto(produto.getValorCusto());
			produtoCadType.setPreco(produto.getValorVenda());

			listaProdutosTypes.add(produtoCadType);
			LOGGER.debug("PRODUTO_TYPE de código: " + produtoCadType.getCodigoInterno() + " foi inserido.");
		}


		Authenticator.setDefault(new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(
						"marcelosrodrigues@globo.com",
						"12345678".toCharArray());
			}
		});

		Produtos_Service servico = new Produtos_Service();
		Produtos produtos = servico.getProdutosSOAP();

		for (ProdutoCadastroType produtoCadastroType : listaProdutosTypes) {

			produtos.salvar(produtoCadastroType);
		}			

	}

}
