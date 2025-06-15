package org.example;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LeaseContractDataModel {
    private Connection connection;
    private Scanner scanner;

    public LeaseContractDataModel(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }
    public void addLease(){
        String query = "{CALL addLease(?,?,?,?,?,?)}";
        try {
            System.out.println("What is your name?");
            String name = scanner.next();
            System.out.println();

            System.out.println("What is the start Date?");
            String startDate = scanner.next();
            System.out.println();

            System.out.println("What is the end date?");
            String endDate = scanner.next();
            System.out.println();
            double monthlyPayment;

            System.out.println("What is the VIN?");
            String vin = scanner.next();
            System.out.println();

            System.out.println("What is the dealershipID");
            int dealerID = scanner.nextInt();
            System.out.println();

            String query2 = "{CALL getPriceFromVehicles(?)}";
            CallableStatement stmt2 = connection.prepareCall(query2);
            stmt2.setString(1,vin);
            stmt2.execute();

            double carTotalPrice = 0;
            ResultSet resultSet2 = stmt2.getResultSet();
            if (resultSet2.next()){
                carTotalPrice = resultSet2.getDouble("Price");
            }
            //lease fee is totalPrice * 0.07;
            double residualPrice = carTotalPrice / 2;

            double moneyFactor = 4/2400;


            double depreciationFee = (carTotalPrice - residualPrice) / 36;


            double financeFee = (carTotalPrice + residualPrice) * moneyFactor;


            monthlyPayment = depreciationFee + financeFee;
            System.out.printf("Monthly payment is $%.2f", monthlyPayment);


            CallableStatement stmt = connection.prepareCall(query);

            stmt.setString(1, name);
            stmt.setString(2, startDate);
            stmt.setString(3, endDate);
            stmt.setDouble(4,monthlyPayment);
            stmt.setString(5,vin);
            stmt.setInt(6,dealerID);


            ResultSet resultSet = stmt.executeQuery();
            System.out.println("Vehicle Leased.");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

