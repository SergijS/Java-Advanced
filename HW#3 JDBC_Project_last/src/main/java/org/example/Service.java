package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.CRUD.CreateTable;
import org.example.CRUD.DeleteRow;
import org.example.CRUD.InsertData;

import java.sql.SQLException;

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
        CreateTable createTable = new CreateTable();
        createTable.createTable();
    }

    public void insertData() {
        InsertData insertData = new InsertData();
        insertData.insertData();
    }

    public void deleteRow() {
        DeleteRow deleteRow = new DeleteRow();
        deleteRow.deleteRow();
    }
}