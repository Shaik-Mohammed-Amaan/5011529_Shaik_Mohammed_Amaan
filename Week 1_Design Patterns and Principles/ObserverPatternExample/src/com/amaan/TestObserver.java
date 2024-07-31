package com.amaan;

public class TestObserver {
    public static void test() {

        StockMarket stock = new StockMarket("ITC");
        Observer observer1 = new MobileApp();
        Observer observer2 = new WebApp();

        //register
        stock.register(observer1);
        stock.register(observer2);

        //change in stock price
        stock.setStockPrice(123.5);
        stock.setStockPrice(140.98);

        //deregister
        stock.deregister(observer2);

        //change in stock price
        stock.setStockPrice(120.5);
    }
}
