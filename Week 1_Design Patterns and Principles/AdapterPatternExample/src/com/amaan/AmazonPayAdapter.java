package com.amaan;

public class AmazonPayAdapter implements PaymentProcessor {
    private AmazonPay amazonPay;

    public AmazonPayAdapter(AmazonPay amazonPay) {
        this.amazonPay = amazonPay;
    }

    public void processPayment(double amount) {
        amazonPay.walletPayment(amount);
    }
}
