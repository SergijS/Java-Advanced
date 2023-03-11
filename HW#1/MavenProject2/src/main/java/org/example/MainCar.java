package org.example;
import java.util.Arrays;
import java.util.List;

public class MainCar
{
    public static void main( String[] args )
    {

        List<Car> cars = Arrays.asList(
                new Car(Brand.randomCarGenerator(), Car.randomCarPrice(), "SAM"),
                new Car(Brand.randomCarGenerator(), Car.randomCarPrice(), "Emma"),
                new Car(Brand.randomCarGenerator(), Car.randomCarPrice(), "Jonny")
        );
        System.out.println(cars);
    }
}