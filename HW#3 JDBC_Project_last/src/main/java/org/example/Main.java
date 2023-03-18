package org.example;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        AllPassengers allPassengers = new AllPassengers();

        service.createTable();
        service.insertData();
        service.deleteRow();

        allPassengers.allPassengers();
    }
}