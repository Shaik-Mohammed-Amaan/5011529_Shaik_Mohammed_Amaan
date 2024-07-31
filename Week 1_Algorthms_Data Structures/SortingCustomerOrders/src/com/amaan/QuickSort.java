package com.amaan;

public class QuickSort {

    public static void sortOrdersByTotalPrice(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);

            sortOrdersByTotalPrice(orders, low, pi - 1);
            sortOrdersByTotalPrice(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        Order pivot = orders[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot.getTotalPrice()) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }
}
