package com.amaan;

public class Paytm {

    public void makePayment(double amount){
        System.out.println("Processing payment of Rs."+amount+" through Paytm Gateway");
        System.out.println("You have received a cashback of Rs."+amount*0.25);
    }
}
