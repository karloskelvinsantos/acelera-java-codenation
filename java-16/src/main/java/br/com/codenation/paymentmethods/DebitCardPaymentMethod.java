package br.com.codenation.paymentmethods;

public class DebitCardPaymentMethod implements PriceStrategy {

    protected final double DISCOUNT = 0.95;

    @Override
    public Double calculate(Double price) {
        return price * DISCOUNT;
    }
}
