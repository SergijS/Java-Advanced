package org.example;

import java.sql.*;

public class AllPassengers {
    public void allPassengers() {

        int totalPassengers = 0;
        try (Connection connection = DriverManager.getConnection(Connections.url, Connections.user, Connections.password)) {
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