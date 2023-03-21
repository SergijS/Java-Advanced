package org.example;

import java.sql.*;

public class SelectAllPassengers {
    public void selectallPassengers() {

        int totalPassengers = 0;
        try (Connection connection = DriverManager.getConnection(ConnectionsToDB.url, ConnectionsToDB.user, ConnectionsToDB.password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT SUM(passengers) AS total_passengers FROM TheBestAirport");
            if (resultSet.next()) {
                totalPassengers = resultSet.getInt("total_passengers");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Total passengers: " + totalPassengers);
    }
}