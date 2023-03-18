package org.example.CRUD;

import org.example.Connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public void createTable() {

        String createTable = "CREATE TABLE TheBestAirport (serial_number VARCHAR(20) PRIMARY KEY,\n" +
                "                model VARCHAR(50),\n" +
                "                passengers INTEGER,\n" +
                "                plane_owners VARCHAR(50));";

        try (Connection connection = DriverManager.getConnection(Connections.url, Connections.user, Connections.password)){
            Statement statement = connection.createStatement();
            statement.executeUpdate(createTable);

            System.out.println("Таблицю успішно створено");

            } catch (SQLException e) {
            System.out.println("Error by create table: " + e.getMessage());
        }
    }
}


