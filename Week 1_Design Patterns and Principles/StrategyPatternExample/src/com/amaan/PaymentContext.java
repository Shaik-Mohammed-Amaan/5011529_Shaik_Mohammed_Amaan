package com.amaan;

public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePaymentStrategy(double amount) {
        paymentStrategy.pay(amount);
    }
}
