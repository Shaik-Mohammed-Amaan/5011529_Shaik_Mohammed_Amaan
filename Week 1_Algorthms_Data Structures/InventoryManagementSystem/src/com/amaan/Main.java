package com.amaan;

public class Main {

    public static void main(String[] args) {
        Product product1 = new Product(101,"Mobile Phone",20,20000);
        Product product2 = new Product(102,"Laptop",15,50000);
        Product product3 = new Product(103,"Tablet",10,40000);
        Inventory inventory = new Inventory();

        //adding the products
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.addProduct(product3);

        //getting product by id
        System.out.println(inventory.getProduct(101));
        System.out.println(inventory.getProduct(102));

        //updating the price of product1
        product1.setPrice(30000);
        inventory.updateProduct(product1);
        System.out.println(inventory.getProduct(101));

        //deleting the product
        inventory.deleteProduct(102);
        System.out.println(inventory.getProduct(102));
    }
}
