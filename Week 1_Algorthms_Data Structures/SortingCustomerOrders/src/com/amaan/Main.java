package com.amaan;

public class Main {

    public static void main(String[] args) {
        Order order1 = new Order(101, "Ram", 2000);
        Order order2 = new Order(102, "Rajesh", 1000);
        Order order3 = new Order(104, "Suresh", 1500);
        Order order4 = new Order(105, "Raj", 4000);
        Order order5 = new Order(103, "Reshma", 3000);

        Inventory inventory = new Inventory(5);
        inventory.addOrder(order1);
        inventory.addOrder(order2);
        inventory.addOrder(order3);
        inventory.addOrder(order4);
        inventory.addOrder(order5);

        System.out.println("Bubble Sort");
        inventory.bubbleSortOrders();

        inventory.displayOrders();

        System.out.println("Quick Sort");
        inventory.quickSortOrders();

        inventory.displayOrders();

    }
}
