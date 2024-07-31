package com.amaan;

public class CreditCardPayment implements PaymentStrategy {

    public void pay(double amount) {
        System.out.println("Payment of Rs."+amount+" is done through Credit card");
    }
}
