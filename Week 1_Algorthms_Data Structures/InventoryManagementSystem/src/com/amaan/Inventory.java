package com.amaan;

import java.util.HashMap;

public class Inventory {
    private HashMap<Integer, Product> productHashMap = new HashMap<>();

    public void addProduct(Product product) {
        productHashMap.put(product.getProductId(), product);
    }

    public Product getProduct(int id) {
        return productHashMap.get(id);
    }

    public void updateProduct(Product product) {
        if (productHashMap.containsKey(product.getProductId())) {
            productHashMap.put(product.getProductId(), product);
        }
    }

    public void deleteProduct(int id) {
        productHashMap.remove(id);
    }
}
