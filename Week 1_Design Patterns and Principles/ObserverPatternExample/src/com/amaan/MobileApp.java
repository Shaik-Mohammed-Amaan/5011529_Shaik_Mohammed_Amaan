package com.amaan;

public class MobileApp implements Observer {

    public void update(String stockName,double stockPrice){
        System.out.println("Mobile Application received update - "+stockName+": Rs."+stockPrice);
    }
}
