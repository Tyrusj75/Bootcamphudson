package org.example;

import java.sql.*;
import java.util.Scanner;

public class DatabaseModel {
    private Connection connection;
    private Scanner scanner;

    public DatabaseModel(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;

    }
    public void addVehicle(){

        String query = "{CALL addVehicle(?,?,?,?,?,?,?,?)}";
        try {
            System.out.println("What is the VIN of the vehicle you want add?");
            String vin = scanner.next();
            System.out.println();

            System.out.println("What is the color of the vehicle?");
            String color = scanner.next();
            System.out.println();

            System.out.println("What is the make of the vehicle?");
            String make = scanner.next();
            System.out.println();

            int sold = 0;

            System.out.println("What is the price of the vehicle?");
            int price = scanner.nextInt();
            System.out.println();

            System.out.println("What is the year of the vehicle?");
            int year = scanner.nextInt();
            System.out.println();

            System.out.println("What is the mileage?");
            int mileage = scanner.nextInt();
            System.out.println();

            System.out.println("Is it a Sedan, SUV, or Truck?");
            String carType = scanner.next().trim();


            CallableStatement stmt = connection.prepareCall(query);

            stmt.setString(1,vin);
            stmt.setString(2,color);
            stmt.setString(3,make);
            stmt.setInt(4,sold);
            stmt.setInt(5,price);
            stmt.setInt(6,year);
            stmt.setInt(7,mileage);
            stmt.setString(8,carType);


            ResultSet resultSet = stmt.executeQuery();
            System.out.println("Vehicle added.");
            System.out.println("List of vehicles below.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void removeVehicle(){

        String query = "{CALL removeVehicle(?)}";
        try {
            System.out.println("What is the VIN of the vehicle you want remove?");
            String vin = scanner.next();
            System.out.println();

            CallableStatement stmt = connection.prepareCall(query);

            stmt.setString(1,vin);


            ResultSet resultSet = stmt.executeQuery();
            System.out.println("Vehicle removed.");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

