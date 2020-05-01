package br.com.codenation.calculadora;


public class CalculadoraSalario {
	public static final double SALARIO_MINIMO = 1039.00;


	public long calcularSalarioLiquido(double salarioBase) {
		if (salarioBase <= SALARIO_MINIMO) {
			return Math.round(0.0);
		} else {
			double descontoINSS = descontoINSS(salarioBase);
			double salarioBruto = salarioBase - descontoINSS;
			double descontoIRPF = descontoIRPF(salarioBruto);

			double salarioLiquido = salarioBruto - descontoIRPF;

			return Math.round(salarioLiquido);
		}

	}

	private double descontoINSS(double salarioBase) {
		if (salarioBase <= 1500) {
			return salarioBase * 0.08;
		} else if (salarioBase > 1500  && salarioBase <= 4000) {
			return salarioBase * 0.09;
		} else {
			return salarioBase * 0.11;
		}
	}

	private double descontoIRPF(double salarioBruto) {
		if (salarioBruto <= 3000) {
			return 0;
		} else if (salarioBruto > 3000 && salarioBruto <= 6000) {
			return salarioBruto * 0.075;
		} else {
			return salarioBruto * 0.15;
		}
	}

}