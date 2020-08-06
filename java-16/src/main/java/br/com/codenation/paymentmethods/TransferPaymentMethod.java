package br.com.codenation.paymentmethods;

public class TransferPaymentMethod implements PriceStrategy {

    protected final double DISCOUNT = 0.92;

    @Override
    public Double calculate(Double price) {
        return price * DISCOUNT;
    }
}
