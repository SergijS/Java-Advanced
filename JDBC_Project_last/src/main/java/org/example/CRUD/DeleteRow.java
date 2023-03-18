package org.example.CRUD;

import org.example.Connections;

import java.sql.*;

public class DeleteRow {

    public void deleteRow(){
        String deleteRow = "DELETE FROM TheBestAirport WHERE serial_number = '466';";
        try (Connection connection = DriverManager.getConnection(Connections.url, Connections.user, Connections.password)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(deleteRow);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM TheBestAirport");

            while(resultSet.next()) {
                String serial_number = resultSet.getString("serial_number");
                String model = resultSet.getString("model");
                String passengers = resultSet.getString("passengers");
                String plane_owners = resultSet.getString("plane_owners");
                System.out.println("serial_number: " + serial_number + ", model: " + model +
                        ", passengers: " + passengers + ", plane_owners: " + plane_owners);

            }
        } catch (SQLException e) {
            System.out.println("Error by create table: " + e.getMessage());
        }
    }
}
