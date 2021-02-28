package com.github.giovannisinosini.automated_Testing_7.servicos;

import com.github.giovannisinosini.automated_Testing_7.exceptions.NaoPodeDividirPorZeroException;

public class Calculadora {

	public int somar(int a, int b) {
		return a + b;
	}

	public int subtrair(int a, int b) {
		return a - b;
	}

	public int dividir(int a, int b) throws NaoPodeDividirPorZeroException {
		if (b == 0 ) {
			throw new NaoPodeDividirPorZeroException();
		}
		return a / b;
	}
}
