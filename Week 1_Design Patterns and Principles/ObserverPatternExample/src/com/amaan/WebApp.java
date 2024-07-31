package com.amaan;

public class WebApp implements Observer {
    public void update(String stockName, double stockPrice) {
        System.out.println("Web Application received update - " + stockName + ": Rs." + stockPrice);
    }
}
