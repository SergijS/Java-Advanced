package org.example.repository;

import org.example.entity.Product;

import java.util.HashMap;
import java.util.Map;

public class ShopRepository {
    private Map<Character, Product> products;

    public ShopRepository() {
        products = new HashMap<Character, Product>();
        products.put('A', new Product('A', 1.25, 3, 3.0));
        products.put('B', new Product('B', 4.25, 0, 0.0));
        products.put('C', new Product('C', 1.0, 6, 5.0));
        products.put('D', new Product('D', 0.75, 0, 0.0));

    }

    public Product getProduct(char code) {
        return products.get(code);
    }
}