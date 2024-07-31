package com.amaan;

public class TestImage {
    public static void test() {
        Image img1 = new ProxyImage("flower.jpg");
        System.out.println("First call to display img1");
        img1.display();
        System.out.println("Second call to display img1");
        img1.display();
    }
}
