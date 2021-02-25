package com.github.giovannisinosini.automated_Testing_7.servicos;

import static com.github.giovannisinosini.automated_Testing_7.utils.DataUtils.adicionarDias;

import java.util.Date;

import com.github.giovannisinosini.automated_Testing_7.entidades.Filme;
import com.github.giovannisinosini.automated_Testing_7.entidades.Locacao;
import com.github.giovannisinosini.automated_Testing_7.entidades.Usuario;
import com.github.giovannisinosini.automated_Testing_7.exceptions.FilmeSemEstoqueException;

public class LocacaoService {
	
	public Locacao alugarFilme(Usuario usuario, Filme filme) throws Exception {
		
		if(filme.getEstoque() == 0) {
			throw new FilmeSemEstoqueException();
		}
		
		
		Locacao locacao = new Locacao();
		locacao.setFilme(filme);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		locacao.setValor(filme.getPrecoLocacao());

		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		locacao.setDataRetorno(dataEntrega);
		
		
		
		return locacao;
	}
}