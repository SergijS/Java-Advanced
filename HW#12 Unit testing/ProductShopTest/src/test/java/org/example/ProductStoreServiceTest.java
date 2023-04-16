package org.example;

import org.example.entity.Product;
import org.example.exceptions.ProductCodeExceptions;
import org.example.service.ProductStoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ProductStoreServiceTest {
    private ProductStoreService productStoreService;

    @BeforeEach
    public void setup() {
        productStoreService = new ProductStoreService();
    }

    @Test
    public void testCalculateCostWithoutPromotions() {
        Product product = new Product('A', 1.25, 0, 0.0);
        int count = 2;
        double cost = productStoreService.calculateCost(product, count);
        Assertions.assertEquals(2.5, cost);
    }

    @Test
    public void testCalculateCostWithPromotions() {
        Product product = new Product('A', 1.25, 3, 3.0);
        int count = 3;
        double cost = productStoreService.calculateCost(product, count);
        Assertions.assertEquals(3.0, cost);
    }

    @Test
    public void testCalculateTotalCost() {
        String basket = "ABCDABCD";
        double cost = productStoreService.calculateTotalCost(basket);
        Assertions.assertEquals(14.5, cost);
    }

    @Test
    public void testCalculateTotalCostWithWrongProductCode() {
        String basket = "ABCMCD";
        Assertions.assertThrows(ProductCodeExceptions.class, () -> {
            productStoreService.calculateTotalCost(basket);
        });
    }
}