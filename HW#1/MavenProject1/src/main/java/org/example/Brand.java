package org.example;

public enum Brand {
    TESLA, AUDI, BMW, TOYOTA, NISSAN;

    public static Brand randomCarGenerator() {
        return values()[(int) (Math.random() * values().length)];
    }
}