package com.amaan;

public class PaytmAdapter implements PaymentProcessor {
    private Paytm paytm;

    public PaytmAdapter(Paytm paytm) {
        this.paytm = paytm;
    }

    public void processPayment(double amount) {
        paytm.makePayment(amount);
    }
}
