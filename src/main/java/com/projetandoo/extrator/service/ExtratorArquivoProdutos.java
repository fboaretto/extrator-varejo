package com.projetandoo.extrator.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.projetandoo.extrator.model.Produto;

public class ExtratorArquivoProdutos {

	private static final Logger logging = Logger.getLogger(ExtratorArquivoProdutos.class);

	public static void main(String[] args) throws IOException {

		String arquivoCargaProdutoFornecedores = //args[0];
		"/home/fboaretto/Documentos/Projetandoo/arquivosExtracao/relatoriodeprodutoscadastradoseestoque/CW000200.SPL";

		String arquivoCargaPrecos = //args[1];
		"/home/fboaretto/Documentos/Projetandoo/arquivosExtracao/relatoriodeprodutoscadastradoseestoque/sp001148.txt";

		//Primeiro Arquivo
		LeitorArquivoProdutosFornecedores leitorProdutos = new LeitorArquivoProdutosFornecedores();
		Map<String, Produto> mapaProdutos = leitorProdutos.leArquivo(arquivoCargaProdutoFornecedores);

		logging.debug("\n\n\nTOTAL :::::: " + mapaProdutos.size() + "\n");
		logging.debug("===== IMPRIMINDO MIX([chave]:valor) =====\n");
		for (Map.Entry<String, Produto> mapaProduto : mapaProdutos.entrySet()) {
			logging.debug("[" + mapaProduto.getKey() + "]: "+ mapaProduto.getValue() + "\n");
		}

		//Segundo Arquivo
		LeitorArquivoProdutosPrecos leitorPrecos = new LeitorArquivoProdutosPrecos(mapaProdutos);
		List<Produto> listaProdutos = leitorPrecos.leArquivo(arquivoCargaPrecos);

		logging.debug("\n\nTOTAL :::::: " + listaProdutos.size());
		logging.debug("IMPRIMINDO " + listaProdutos.size()
				+ " PRODUTOS ATUALIZADOS DOS " + mapaProdutos.size()
				+ " VINDOS DO PRIMEIRO ARQUIVO:\n");
		for (Produto produto : listaProdutos) {
			logging.debug(produto);
		}

	}

}
