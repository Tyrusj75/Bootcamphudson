package org.example;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SalesContractDataModel {
    private Connection connection;
    private Scanner scanner;

    public SalesContractDataModel(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }

    public void addSale() {

        String query = "{CALL addSale(?,?,?)}";
        try {
            System.out.println("What is your name?");
            String name = scanner.next();
            System.out.println();

            System.out.println("What is the dealer id? 1, 2 or 3.");
            int dealerID = scanner.nextInt();
            System.out.println();

            System.out.println("What is the VIN of the vehicle you want purchase?");
            String vin = scanner.next();
            System.out.println();

            CallableStatement stmt = connection.prepareCall(query);

            stmt.setString(1, name);
            stmt.setInt(2, dealerID);
            stmt.setString(3, vin);


            ResultSet resultSet = stmt.executeQuery();
            System.out.println("Vehicle purchased.");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

