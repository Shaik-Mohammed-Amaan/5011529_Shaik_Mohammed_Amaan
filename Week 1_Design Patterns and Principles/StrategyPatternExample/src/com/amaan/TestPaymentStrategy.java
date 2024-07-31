package com.amaan;

public class TestPaymentStrategy {
    public static void test(){

        PaymentContext creditCard = new PaymentContext(new CreditCardPayment());
        creditCard.executePaymentStrategy(20000);

        PaymentContext payPal = new PaymentContext(new PayPalPayment());
        payPal.executePaymentStrategy(10000);
    }
}
