package org.example;
import lombok.*;
import java.util.*;

@Data
@AllArgsConstructor

public class Car {

    private Brand brand;
    private int price;
    private String owner;

    public static int randomCarPrice() {
        return new Random().nextInt(2500000);
    }
}