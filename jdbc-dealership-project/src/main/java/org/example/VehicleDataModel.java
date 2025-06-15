package org.example;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class VehicleDataModel {
    private Connection connection;
    private Scanner scanner;

    public VehicleDataModel(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }

    public void getByPriceRange() {
        String query = "{CALL getByPriceRange(?)}";
        try {
            System.out.println("Enter the maximum amount to filter by");
            Double maxAmount = scanner.nextDouble();
            scanner.nextLine();

            CallableStatement stmt = connection.prepareCall(query);
            stmt.setDouble(1,maxAmount);

            ResultSet resultSet = stmt.executeQuery();
            System.out.println("These are the vehicles that are in that range");

            while (resultSet.next()) {
                System.out.printf("%d - %s - %s -%s\n",
                        resultSet.getInt("id"),
                        resultSet.getString("VIN"),
                        resultSet.getString("Color"),
                        resultSet.getString("Make"),
                        resultSet.getDouble("Price"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void getByMakeOrModel() {
        String query = "{CALL getByMakeOrModel(?)}";
        try {
            System.out.println("Enter the make or model you would like to search by");
            String makeOrModel = scanner.next();
            scanner.nextLine();

            CallableStatement stmt = connection.prepareCall(query);
            stmt.setString(1,makeOrModel);

            ResultSet resultSet = stmt.executeQuery();
            System.out.println("These are the vehicles that match your search.");

            while (resultSet.next()) {
                System.out.printf("%d - %s - %s -%s\n",
                        resultSet.getInt("id"),
                        resultSet.getString("VIN"),
                        resultSet.getString("Color"),
                        resultSet.getString("Make"),
                        resultSet.getDouble("Price"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void getByColor() {
        String query = "{CALL getByColor(?)}";
        try {
            System.out.println("Enter the color you would like to search by");
            String color = scanner.next();
            scanner.nextLine();

            CallableStatement stmt = connection.prepareCall(query);
            stmt.setString(1,color);

            ResultSet resultSet = stmt.executeQuery();
            System.out.println("These are the vehicles that match your search.");

            while (resultSet.next()) {
                System.out.printf("%d - %s - %s -%s\n",
                        resultSet.getInt("id"),
                        resultSet.getString("VIN"),
                        resultSet.getString("Color"),
                        resultSet.getString("Make"),
                        resultSet.getDouble("Price"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void getByYearRange() {
        String query = "{CALL getByYearRange(?,?)}";
        try {
            System.out.println("Enter the minimum year you would like to search by");
            int minYear = scanner.nextInt();

            System.out.println("Enter the maximum year you would like to search by");
            int maxYear = scanner.nextInt();
            scanner.nextLine();

            CallableStatement stmt = connection.prepareCall(query);
            stmt.setInt(1, minYear);
            stmt.setInt(2, maxYear);

            ResultSet resultSet = stmt.executeQuery();
            System.out.println("These are the vehicles that match your search.");

            while (resultSet.next()) {
                System.out.printf("%d - %s - %s -%s\n",
                        resultSet.getInt("id"),
                        resultSet.getString("VIN"),
                        resultSet.getString("Color"),
                        resultSet.getString("Make"),
                        resultSet.getDouble("Price"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getByMileageRange() {
        String query = "{CALL getByMileageRange(?,?)}";
        try {
            System.out.println("Enter the minimum mileage you would like to search by");
            int minMileage = scanner.nextInt();

            System.out.println("Enter the maximum mileage you would like to search by");
            int maxMileage = scanner.nextInt();
            scanner.nextLine();

            CallableStatement stmt = connection.prepareCall(query);
            stmt.setInt(1, minMileage);
            stmt.setInt(2, maxMileage);

            ResultSet resultSet = stmt.executeQuery();
            System.out.println("These are the vehicles that match your search.");

            while (resultSet.next()) {
                System.out.printf("%d - %s - %s -%s\n",
                        resultSet.getInt("id"),
                        resultSet.getString("VIN"),
                        resultSet.getString("Color"),
                        resultSet.getString("Make"),
                        resultSet.getDouble("Price"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getByCarType() {
        String query = "{CALL getByCarType(?)}";
        try {
            System.out.println("Enter the Car type you would like to search by");
            System.out.println("Options are SUV, Sedan and Truck");
            String carType = scanner.next();
            System.out.println();
            CallableStatement stmt = connection.prepareCall(query);
            stmt.setString(1, carType);


            ResultSet resultSet = stmt.executeQuery();
            System.out.println("These are the vehicles that match your search.");

            while (resultSet.next()) {
                System.out.printf("%d - %s - %s -%s\n",
                        resultSet.getInt("id"),
                        resultSet.getString("VIN"),
                        resultSet.getString("Color"),
                        resultSet.getString("Make"),
                        resultSet.getDouble("Price"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

