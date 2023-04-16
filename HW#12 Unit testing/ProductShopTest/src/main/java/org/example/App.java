package org.example;

import org.example.service.ProductStoreService;

import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        ProductStoreService store = new ProductStoreService();

        System.out.println("Enter a list of products (For example, ABCDABA): ");
        Scanner scanner = new Scanner(System.in);
        String basket = scanner.nextLine();
        double totalCost = store.calculateTotalCost(basket);
        System.out.println("The cost of the basket is: " + totalCost + "$");
    }
}