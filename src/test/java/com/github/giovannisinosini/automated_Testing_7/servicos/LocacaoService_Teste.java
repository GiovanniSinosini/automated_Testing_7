package com.github.giovannisinosini.automated_Testing_7.servicos;


import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.github.giovannisinosini.automated_Testing_7.entidades.Filme;
import com.github.giovannisinosini.automated_Testing_7.entidades.Locacao;
import com.github.giovannisinosini.automated_Testing_7.entidades.Usuario;
import com.github.giovannisinosini.automated_Testing_7.utils.DataUtils;

public class LocacaoService_Teste {
	@Test
	public void test() {
		// cenario
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 1", 2, 5.0);

		// acao
		Locacao locacao = service.alugarFilme(usuario, filme);

		// verificacao/validacao
		Assert.assertTrue(locacao.getValor() == 5.0);
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));

	}
}
