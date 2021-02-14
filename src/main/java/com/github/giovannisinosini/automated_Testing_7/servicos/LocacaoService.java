package com.github.giovannisinosini.automated_Testing_7.servicos;

import static com.github.giovannisinosini.automated_Testing_7.utils.DataUtils.adicionarDias;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.github.giovannisinosini.automated_Testing_7.entidades.Filme;
import com.github.giovannisinosini.automated_Testing_7.entidades.Locacao;
import com.github.giovannisinosini.automated_Testing_7.entidades.Usuario;
import com.github.giovannisinosini.automated_Testing_7.utils.DataUtils;

public class LocacaoService {
	
	public Locacao alugarFilme(Usuario usuario, Filme filme) {
		Locacao locacao = new Locacao();
		locacao.setFilme(filme);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		locacao.setValor(filme.getPrecoLocacao());

		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		locacao.setDataRetorno(dataEntrega);
		
		//Salvando a locacao...	
		//TODO adicionar metodo para salvar
		
		return locacao;
	}
	
	@Test
	public void test() {
		//cenário
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