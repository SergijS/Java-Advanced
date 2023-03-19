package org.example.CRUD;

import org.example.Connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateRow {
    public void updateRow() {
        String updateRow = "UPDATE TheBestAirport SET serial_number = '1234', " +
                "model = 'Airbus A321-231', passengers = 240, plane_owners = 'Ukraine Airlines'" +
                "WHERE serial_number = '1178'";
        try (Connection connection = DriverManager.getConnection(Connections.url, Connections.user, Connections.password)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(updateRow);

            System.out.println("the table update was successful");

        } catch (SQLException e) {
            System.out.println("Error by create table: " + e.getMessage());
        }

    }
}