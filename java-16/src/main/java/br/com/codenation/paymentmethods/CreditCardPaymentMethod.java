package br.com.codenation.paymentmethods;

public class CreditCardPaymentMethod implements PriceStrategy {

    protected final double DISCOUNT = 0.98;

    @Override
    public Double calculate(Double price) {
        return price * DISCOUNT;
    }
}
