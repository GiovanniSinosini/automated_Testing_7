package com.github.giovannisinosini.automated_Testing_7.servicos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.github.giovannisinosini.automated_Testing_7.exceptions.NaoPodeDividirPorZeroException;

public class CalculadoraTest {
	
	private Calculadora calc;
	
	@Before
	public void setup() {
		calc = new Calculadora();
	}

	@Test
	public void somarDoisValores() {
		// cenario
		int a = 7;
		int b = 7;

		// acao
		int resultado = calc.somar(a, b);

		// verificacao
		Assert.assertEquals(14, resultado);
	}

	@Test
	public void subtrairDoisValores() {
		// cenario
		int a = 7;
		int b = 7;

		// acao
		int resultado = calc.subtrair(a, b);

		// varificacao
		Assert.assertEquals(0, resultado);

	}

	@Test
	public void dividirDoisValores() throws NaoPodeDividirPorZeroException {
		//cenario
		int a = 7;
		int b = 7;
		
		//acao
		int resultado = calc.dividir(a,b);
		
		//verificacao
		Assert.assertEquals(1, resultado);
}
	
	@Test(expected=NaoPodeDividirPorZeroException.class)
	public void lancarExcecaoDividirZero() throws NaoPodeDividirPorZeroException {
		// cenario
		int a = 10;
		int b = 0;

		// acao
		int resultado = calc.dividir(a, b);

		// verificacao
		Assert.assertEquals(1, resultado);
	}
}
