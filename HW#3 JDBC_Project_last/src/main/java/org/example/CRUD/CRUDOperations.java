package org.example.CRUD;

import org.example.ConnectionsToDB;

import java.sql.*;

public class CRUDOperations {
    public void createTable() {

        String createTable = "CREATE TABLE TheBestAirport (serial_number VARCHAR(20) PRIMARY KEY,\n" +
                "                model VARCHAR(50),\n" +
                "                passengers INTEGER,\n" +
                "                plane_owners VARCHAR(50));";

        try (Connection connection = DriverManager.getConnection(ConnectionsToDB.url, ConnectionsToDB.user, ConnectionsToDB.password)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(createTable);

            System.out.println("The table was successfully created");

        } catch (SQLException e) {
            System.out.println("Error by create table: " + e.getMessage());
        }
    }

    public void insertData() {

        String insertData = "INSERT INTO 'TheBestAirport'\n" +
                "            VALUES ('AT3-003', 'AT-3 R100', 210, 'Jetstar'),\n" +
                "            ('1178', 'ATR 72-212A (600 version)', 850, 'Air France KLM'),\n" +
                "            ('3260', 'Airbus 319-115', 1120, 'Jetstar'),\n" +
                "            ('2462', 'Airbus A321-231', 1300, 'American Airlines'),\n" +
                "            ('466', 'Airbus A320-212', 1250, 'Air France KLM'),\n" +
                "            ('139', 'Alouette-M III', 30, 'Jetstar'),\n" +
                "            ('306911207', 'AУС-N-7', 5, 'American Airlines');";
        try (Connection connection = DriverManager.getConnection(ConnectionsToDB.url, ConnectionsToDB.user, ConnectionsToDB.password)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(insertData);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM TheBestAirport");

            while (resultSet.next()) {
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

    public void updateRow() {
        String updateRow = "UPDATE TheBestAirport SET serial_number = '1234', " +
                "model = 'Airbus A321-231', passengers = 240, plane_owners = 'Ukraine Airlines'" +
                "WHERE serial_number = '1178'";
        try (Connection connection = DriverManager.getConnection(ConnectionsToDB.url, ConnectionsToDB.user, ConnectionsToDB.password)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(updateRow);

            System.out.println("the table update was successful");

        } catch (SQLException e) {
            System.out.println("Error by create table: " + e.getMessage());
        }

    }

    public void deleteRow() {
        String deleteRow = "DELETE FROM TheBestAirport WHERE serial_number = '466';";


        try (Connection connection = DriverManager.getConnection(ConnectionsToDB.url, ConnectionsToDB.user, ConnectionsToDB.password)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(deleteRow);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM TheBestAirport");

            while (resultSet.next()) {
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