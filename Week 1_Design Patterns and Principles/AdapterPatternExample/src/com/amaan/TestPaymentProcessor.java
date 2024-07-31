package com.amaan;

public class TestPaymentProcessor {
    public static void test(){

        PayPal payPalPayment = new PayPal();
        PaymentProcessor payPalProcess = new PayPalAdapter(payPalPayment);
        System.out.println("PayPal Gateway");
        payPalProcess.processPayment(2000);

        Paytm paytmPayment = new Paytm();
        PaymentProcessor paytmProcess = new PaytmAdapter(paytmPayment);
        System.out.println("Paytm Gateway");
        paytmProcess.processPayment(5000);

        AmazonPay amazonPayPayment = new AmazonPay();
        PaymentProcessor amazonPayProcess = new AmazonPayAdapter(amazonPayPayment);
        System.out.println("AmazonPay Gateway");
        amazonPayProcess.processPayment(10000);
    }
}
