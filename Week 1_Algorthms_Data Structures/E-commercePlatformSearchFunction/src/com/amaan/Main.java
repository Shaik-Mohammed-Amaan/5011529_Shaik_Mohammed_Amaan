package com.amaan;

public class Main {

    public static void main(String[] args) {

        Inventory inventory = new Inventory(5);
        Product product1 = new Product(101, "Mobile Phone", "Mobile");
        Product product2 = new Product(105, "Laptop", "Laptop");
        Product product3 = new Product(107, "Tablet", "Tablet");
        Product product4 = new Product(104, "Shirt", "Clothes");
        Product product5 = new Product(102, "T-Shirt", "Clothes");

        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.addProduct(product3);
        inventory.addProduct(product4);
        inventory.addProduct(product5);

        System.out.println(inventory.LinearSearchProduct(102));
        System.out.println(inventory.BinarySearchProduct(107));
        System.out.println(inventory.LinearSearchProduct(108));
        System.out.println(inventory.BinarySearchProduct(109));
    }
}
