package br.com.codenation;

import br.com.codenation.paymentmethods.PaymentMethod;

public class BillingProcessor {

    public Double calculate(Order order) {
        return order.getPaymentMethod().getPaymentStrategy().calculate(order.getPrice());
    }
}