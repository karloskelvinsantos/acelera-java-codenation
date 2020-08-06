package br.com.codenation.paymentmethods;

public enum PaymentMethod {

    CASH(price -> new CashPaymentMethod().calculate(price)),
    DEBIT_CARD(price -> new DebitCardPaymentMethod().calculate(price)),
    CREDIT_CARD(price -> new CreditCardPaymentMethod().calculate(price)),
    TRANSFER(price -> new TransferPaymentMethod().calculate(price));

    private final PriceStrategy priceStrategy;

    PaymentMethod(PriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }

    public PriceStrategy getPaymentStrategy() {
        return priceStrategy;
    }
}