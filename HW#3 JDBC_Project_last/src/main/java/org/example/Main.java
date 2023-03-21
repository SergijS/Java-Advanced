package org.example;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();

        service.createTable();
        service.insertData();
        service.updateRow();
        service.deleteRow();

        service.selectAllPassengers();
    }
}