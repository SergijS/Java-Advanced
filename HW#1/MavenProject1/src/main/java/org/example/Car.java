package org.example;
import java.util.Random;

public class Car
{
    private Brand brand;
    private int price;
    private String owner;

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Car(Brand brand, int price, String owner) {
        this.brand = brand;
        this.price = price;
        this.owner = owner;
    }
    public static int randomCarPrice() {
        return new Random().nextInt(350000, 2100000);
    }
    @Override
    public String toString() {
        return "Car" +
                "brand=" + brand +
                ", price=" + price +
                ", owner='" + owner + '\n';
    }
}