package br.com.codenation.paymentmethods;

public class CashPaymentMethod implements PriceStrategy {

    protected final double DISCOUNT = 0.9;

    @Override
    public Double calculate(Double price) {
        return price * DISCOUNT;
    }
}
