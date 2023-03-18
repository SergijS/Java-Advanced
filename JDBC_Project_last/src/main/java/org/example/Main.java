package org.example;

import org.example.CRUD.CreateTable;
import org.example.CRUD.DeleteRow;
import org.example.CRUD.InsertData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        CreateTable createTable = new CreateTable();
        InsertData insertData = new InsertData();
        DeleteRow deleteRow = new DeleteRow();
        AllPassengers allPassengers = new AllPassengers();


        createTable.createTable();
        insertData.insertData();
        deleteRow.deleteRow();
        allPassengers.allPassengers();
    }
}