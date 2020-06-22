package br.com.codenation.calculadora;

public class ImpostoINSS implements Imposto{
    @Override
    public double calcular(double salario) {
        if (salario <= 1500) {
            return salario * 0.08;
        }

        if (salario > 1500  && salario <= 4000) {
            return salario * 0.09;
        }

        return salario * 0.11;
    }
}
