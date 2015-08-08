package com.projetandoo.extrator.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.projetandoo.extrator.clienteWS.EstoqueType;
import com.projetandoo.extrator.clienteWS.FornecedorType;
import com.projetandoo.extrator.clienteWS.GondolaType;
import com.projetandoo.extrator.clienteWS.LojaType;
import com.projetandoo.extrator.clienteWS.ObjectFactory;
import com.projetandoo.extrator.clienteWS.ProdutoCadastroType;

public class LeitorArquivoProdutos 
{
	private static final String PREFIX_MARKAO        	= "MARKAO COSMETICOS";
	private static final String PREFIX_FINAL_ARQUIVO    = "-----";
	private static final String PREFIX_PRODUTO_INVALIDO = " SALDO DE BALANCO";

	private static final BigDecimal UM_BIG_DECIMAL       = new BigDecimal(1);
	private static final String 	COD_BARRA_DEFAULT    = "1111111111111";
	private static final long 		COD_EXTERNO_PRODUTOS = 0;

	private static final Logger LOGGER = Logger.getLogger(LeitorArquivoProdutos.class);

	private Map<String, ProdutoCadastroType> produtos = new HashMap<String, ProdutoCadastroType>();

	private ObjectFactory factory = new ObjectFactory();

	private LojaType loja = factory.createLojaType();

	public Map<String, ProdutoCadastroType> leArquivo(String arquivo) throws IOException 
	{
		BufferedReader buffReader = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo), "IBM850"));

		String linha = buffReader.readLine();

		//Ignorando header inicial e capturando a loja:
		for (int i = 1; i <= 8; i++) 
		{
			if (i == 4) 
			{
				//Long idLoja = Long.parseLong(linha.substring(10, 13).trim());
				//String nomeLoja = linha.substring(14, 34).trim();
				loja.setId((long) 1);
				loja.setCodigoInterno((long) 1);
			}
			linha = buffReader.readLine();
		}

		while (linha != null) 
		{
			//headers
			if (linha.contains(PREFIX_MARKAO)) 
			{
				for (int i = 1; i <= 8; i++) 
				{
					linha = buffReader.readLine();
				}
			}

			if (linha.startsWith(PREFIX_PRODUTO_INVALIDO)) 
			{
				//logging.debug("SALDO DE BALANCO ...próx linha");
				linha = buffReader.readLine();
				continue;
			}			

			//footer
			if (linha.startsWith(PREFIX_FINAL_ARQUIVO)) 
			{
				buffReader.close();
				return produtos;
			}

			String[] items = StringUtils.split(linha, "|");
			String nome = items[0].trim();
			String codigo = items[1].trim();

			String estoqueDisponivel = items[2].substring(0, 6).trim();
			String codBarra = items[7].trim();
			String nomeFornecedor = items[8].trim();

			LOGGER.debug(nome + "\t" + codigo + "\t[" + estoqueDisponivel
					+ "]\t[" + codBarra + "]\t" + nomeFornecedor + "\t"
					+ loja.getId());

			ProdutoCadastroType produto = capturaValoresProduto(nome, codigo,
					estoqueDisponivel, codBarra, nomeFornecedor);

			produtos.put(codigo, produto);
			linha = buffReader.readLine();
		}

		buffReader.close();

		return produtos;
	}


	private ProdutoCadastroType capturaValoresProduto(String nome, String codigo, String estoqueDisponivel, 
			String codBarra, String nomeFornecedor) 
	{
		ProdutoCadastroType produto = factory.createProdutoCadastroType();

		produto.setLoja(loja);
		produto.setNome(nome);

		/**
		 * Setando os preços/custos de todos os produtos do primeiro arquivo com UM.
		 * No segundo arquivo, aqueles que possuem algum valor, serão atualizados.
		 * Aqueles que não foram, permaneceram com UM ao invés de NULL.
		 */
		produto.setPreco(UM_BIG_DECIMAL);
		produto.setCusto(UM_BIG_DECIMAL);

		produto.setPeso(UM_BIG_DECIMAL);

		EstoqueType estoque = factory.createEstoqueType();

		if (estoqueDisponivel.isEmpty()) 
			estoque.setDisponivel(new BigDecimal(0));
		else 
			estoque.setDisponivel(new BigDecimal(estoqueDisponivel));

		estoque.setMaximo(UM_BIG_DECIMAL);
		estoque.setMinimo(UM_BIG_DECIMAL);
		estoque.setRessuprimento(UM_BIG_DECIMAL);

		produto.setEstoque(estoque);

		GondolaType gondola = factory.createGondolaType();
		gondola.setDisponivel(UM_BIG_DECIMAL);
		gondola.setMaximo(UM_BIG_DECIMAL);
		gondola.setMinimo(UM_BIG_DECIMAL);
		gondola.setReposicao(UM_BIG_DECIMAL);

		produto.setGondola(gondola);

		if (codBarra.isEmpty())
			produto.setCodigoBarra(COD_BARRA_DEFAULT);
		else
			produto.setCodigoBarra(codBarra);

		produto.setCodigoInterno(Long.parseLong(codigo));

		produto.setCodigoExterno(COD_EXTERNO_PRODUTOS);

		FornecedorType fornecedor = factory.createFornecedorType();
		fornecedor.setId((long) 1);
		fornecedor.setNome(nomeFornecedor);

		produto.setFornecedor(fornecedor);

		produto.setId(1);

		return produto;
	}

}
