package com.github.giovannisinosini.automated_Testing_7.servicos;

import static com.github.giovannisinosini.automated_Testing_7.utils.DataUtils.isMesmaData;
import static com.github.giovannisinosini.automated_Testing_7.utils.DataUtils.obterDataComDiferencaDias;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import java.util.Date;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import com.github.giovannisinosini.automated_Testing_7.entidades.Filme;
import com.github.giovannisinosini.automated_Testing_7.entidades.Locacao;
import com.github.giovannisinosini.automated_Testing_7.entidades.Usuario;
import com.github.giovannisinosini.automated_Testing_7.exceptions.FilmeSemEstoqueException;

import junit.framework.Assert;

public class LocacaoService_Teste {

	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void test() throws Exception {
		// cenario
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 1", 2, 5.0);

		// acao
		Locacao locacao;
		locacao = service.alugarFilme(usuario, filme);

		// verificacao/validacao
		error.checkThat(locacao.getValor(), is(equalTo(5.0)));
		error.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
		error.checkThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(true));
	}

	@Test(expected = FilmeSemEstoqueException.class)
	public void testLocacao_filmeSemEstoque() throws Exception {
		// cenario
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 1", 0, 5.0);

		// acao
		service.alugarFilme(usuario, filme);
	}
	
	//robust shape
	@Test
	public void testLocacao_filmeSemEstoque2() {
		// cenario
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 1", 2, 5.0);

		// acao
		try {
			service.alugarFilme(usuario, filme);
			Assert.fail("Deveria ter lancado uma excecao");
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), is("Filme sem estoque"));
		}
	}
	
	@Test
	public void testLocacao_filmeSemEstoque_3() throws Exception {
		// cenario
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 1", 2, 5.0);

		exception.expect(Exception.class);
		exception.expectMessage("Filme sem estoque");
		// acao
		service.alugarFilme(usuario, filme);

	}
}
