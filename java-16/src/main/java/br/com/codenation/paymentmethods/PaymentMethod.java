package br.com.codenation.paymentmethods;

public enum PaymentMethod {

    CASH(price -> new CashPrice().calculate(price)),
    DEBIT_CARD(price -> new DebitCardPrice().calculate(price)),
    CREDIT_CARD(price -> new CreditCardPrice().calculate(price)),
    TRANSFER(price -> new TransferPrice().calculate(price));

    private PriceStrategy priceStrategy;

    PaymentMethod(PriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }

    public PriceStrategy getPaymentStrategy() {
        return priceStrategy;
    }
}