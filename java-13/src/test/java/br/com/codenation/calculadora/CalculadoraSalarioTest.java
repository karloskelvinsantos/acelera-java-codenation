package br.com.codenation.calculadora;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculadoraSalarioTest {

	@Test
	public void salarioLiquidoIsNotNull() {
		assertEquals(1380, new CalculadoraSalario().calcularSalarioLiquido(1500));
	}

}