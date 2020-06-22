package br.com.codenation.calculadora;


public class CalculadoraSalario {
	public static final double SALARIO_MINIMO = 1039.00;
	private final Imposto inss = new ImpostoINSS();
	private final Imposto irpf = new ImpostoIRPF();


	public long calcularSalarioLiquido(double salarioBase) {
		if (salarioBase <= SALARIO_MINIMO) {
			return 0L;
		}

		double descontoINSS = inss.calcular(salarioBase);
		double salarioBruto = salarioBase - descontoINSS;

		double descontoIRPF = irpf.calcular(salarioBruto);

		double salarioLiquido = salarioBruto - descontoIRPF;

		return Math.round(salarioLiquido);
	}

}