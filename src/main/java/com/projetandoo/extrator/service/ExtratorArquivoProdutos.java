package com.projetandoo.extrator.service;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.projetandoo.extrator.clienteWS.EstoqueType;
import com.projetandoo.extrator.clienteWS.LojaType;
import com.projetandoo.extrator.clienteWS.ObjectFactory;
import com.projetandoo.extrator.clienteWS.ProdutoType;
import com.projetandoo.extrator.clienteWS.Produtos;
import com.projetandoo.extrator.clienteWS.Produtos_Service;
import com.projetandoo.extrator.model.Produto;

public class ExtratorArquivoProdutos {

	private static final Logger logging = Logger.getLogger(ExtratorArquivoProdutos.class);

	public static void main(String[] args) throws IOException {

		String arquivoCargaProdutoFornecedores = //args[0];
				"/home/fboaretto/Documentos/Projetandoo/arquivosExtracao/relatoriodeprodutoscadastradoseestoque/CW000200.SPL";

		String arquivoCargaPrecos = //args[1];
				"/home/fboaretto/Documentos/Projetandoo/arquivosExtracao/relatoriodeprodutoscadastradoseestoque/sp001148.txt";

		//Primeiro Arquivo
		LeitorArquivoProdutos leitorProdutos = new LeitorArquivoProdutos();
		Map<String, Produto> mapaProdutos = leitorProdutos.leArquivo(arquivoCargaProdutoFornecedores);

		logging.debug("\n\n\nTOTAL :::::: " + mapaProdutos.size() + "\n");
		logging.debug("===== IMPRIMINDO MIX([chave]:valor) =====\n");
		for (Map.Entry<String, Produto> mapaProduto : mapaProdutos.entrySet()) {
			logging.debug("[" + mapaProduto.getKey() + "]: "+ mapaProduto.getValue() + "\n");
		}

		//Segundo Arquivo
		LeitorArquivoPrecos leitorPrecos = new LeitorArquivoPrecos(mapaProdutos);
		List<Produto> listaProdutos = leitorPrecos.leArquivo(arquivoCargaPrecos);

		logging.debug("\n\nTOTAL :::::: " + listaProdutos.size());
		logging.debug("IMPRIMINDO " + listaProdutos.size()
				+ " PRODUTOS ATUALIZADOS DOS " + mapaProdutos.size()
				+ " VINDOS DO PRIMEIRO ARQUIVO:\n");

		ObjectFactory factory = new ObjectFactory();

		List<ProdutoType> listaProdutosTypes = new ArrayList<ProdutoType>();


		for (Produto produto : listaProdutos) {

			logging.debug("PRODUTO ARQUIVO: " + produto);

			ProdutoType produtoType = factory.createProdutoType();
			produtoType.setCodigoInterno(produto.getCodigo());
			produtoType.setNome(produto.getNome());
			produtoType.setCodigoBarra(produto.getCodigoBarra());

			EstoqueType estoqueType = factory.createEstoqueType();
			estoqueType.setDisponivel(produto.getEstoque().getDisponivel());
			produtoType.setEstoque(estoqueType);

			LojaType lojaType = factory.createLojaType();
			lojaType.setId(produto.getLoja().getId());
			produtoType.setLoja(lojaType);

			produtoType.setCusto(produto.getValorCusto());
			produtoType.setPreco(produto.getValorVenda());

			listaProdutosTypes.add(produtoType);
			logging.debug("PRODUTO_TYPE de código: " + produtoType.getCodigoInterno() + " foi inserido.");
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

		for (ProdutoType produtoType : listaProdutosTypes) {

			produtos.salvar(produtoType);
		}			

	}

}
