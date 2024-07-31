package com.amaan;

import java.util.Arrays;

public class Inventory {
    private int length;
    private Product[] products;
    private static int i = 0;

    public Inventory(int length) {
        this.length = length;
        products = new Product[this.length];
    }

    public void addProduct(Product product) {
        products[i] = product;
        i++;
    }

    public Product LinearSearchProduct(int id) {
        return SearchAlgorithms.linearSearch(this.products, id);
    }

    public Product BinarySearchProduct(int id) {
        //Sorting the products array
        int n = this.products.length;
        boolean swapped = false;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (products[j].getProductId() > products[j].getProductId()) {
                    Product temp = products[j];
                    products[j] = products[j + 1];
                    products[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false) {
                break;
            }
        }
        return SearchAlgorithms.binarySearch(this.products, id);
    }

}
