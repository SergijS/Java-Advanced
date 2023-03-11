package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
@Data
@AllArgsConstructor

public class Main {
    public static void main(String[] args) {

        List<Car> cars = Arrays.asList(
        new Car(Brand.randomCarGenerator(),Car.randomCarPrice(), "SAM"),
        new Car(Brand.randomCarGenerator(), Car.randomCarPrice(), "Emma"),
        new Car(Brand.randomCarGenerator(), Car.randomCarPrice(), "Jonny")
        );
        System.out.println(cars);
    }
}