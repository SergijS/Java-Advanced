package org.example;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.CRUD.CRUDOperations;


@Data
@Getter
@Setter

public class Service {
    private String serial_number;
    private String model;
    private int passengers;
    private String plane_owners;


    public Service() {
        this.serial_number = serial_number;
        this.model = model;
        this.passengers = passengers;
        this.plane_owners = plane_owners;


    }

    public void createTable() {
        CRUDOperations createTable = new CRUDOperations();
        createTable.createTable();
    }

    public void insertData() {
        CRUDOperations insertData = new CRUDOperations();
        insertData.insertData();
    }

    public void updateRow() {
        CRUDOperations updateRow = new CRUDOperations();
        updateRow.updateRow();
    }

    public void deleteRow() {
        CRUDOperations deleteRow = new CRUDOperations();
        deleteRow.deleteRow();
    }

    public void selectAllPassengers() {
        SelectAllPassengers selectAllPassengers = new SelectAllPassengers();
        selectAllPassengers.selectallPassengers();
    }
}