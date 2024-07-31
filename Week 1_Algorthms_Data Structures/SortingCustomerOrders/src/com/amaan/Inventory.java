package com.amaan;

public class Inventory {
    private int length;
    private Order[] orders;
    private static int i = 0;

    public Inventory(int length) {
        this.length = length;
        orders = new Order[this.length];
    }

    public void addOrder(Order order) {
        orders[i] = order;
        i++;
    }

    public void bubbleSortOrders() {
        BubbleSort.sortOrdersByTotalPrice(orders);
    }

    public void quickSortOrders() {
        QuickSort.sortOrdersByTotalPrice(orders, 0, this.length - 1);
    }

    public void displayOrders() {
        for (Order order : orders) {
            System.out.println(order);
        }
    }

}
