package br.com.codenation.calculadora;

public class ImpostoIRPF implements Imposto{
    @Override
    public double calcular(double salario) {
        if (salario <= 3000) {
            return 0;
        }

        if (salario > 3000 && salario <= 6000) {
            return salario * 0.075;
        }

        return salario * 0.15;
    }
}
