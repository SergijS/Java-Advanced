package org.example.service;

import org.example.exceptions.ProductCodeExceptions;
import org.example.entity.Product;
import org.example.repository.ShopRepository;

import java.util.HashMap;
import java.util.Map;

public class ProductStoreService {
    private ShopRepository shopRepository;
    private Product product;

    public ProductStoreService() {
        shopRepository = new ShopRepository();
    }

    public double calculateCost(Product product, int count) {
        if (product.getPromotionalQuantity() > 0 && count >= product.getPromotionalQuantity()) {
            int specialCount = count / product.getPromotionalQuantity();
            int regularCount = count % product.getPromotionalQuantity();
            return specialCount * product.getPromotionalPrice() + regularCount * product.getPrice();
        } else {
            return count * product.getPrice();
        }
    }

    public double calculateTotalCost(String basket) {
        Map<Character, Integer> productCount = new HashMap<Character, Integer>();
        for (char code : basket.toCharArray()) {
            Product product = shopRepository.getProduct(code);
            if (product == null) {
                throw new ProductCodeExceptions("The code " + code + " does not exist, enter one of the following in upper case (ABCD)!");
            }
            if (!productCount.containsKey(code)) {
                productCount.put(code, 1);
            } else {
                productCount.put(code, productCount.get(code) + 1);
            }
        }

        double totalCost = 0.0;
        for (char code : productCount.keySet()) {
            int count = productCount.get(code);
            Product product = shopRepository.getProduct(code);
            totalCost += calculateCost(product, count);
        }
        return totalCost;
    }
}