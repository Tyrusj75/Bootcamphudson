package org.example;

import java.io.*;


public class DealershipFileManager {


    public DealershipFileManager() {
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/inventory.csv"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/inventory.csv",true));
        }
        catch(Exception e){
            e.printStackTrace();

        }


    }
    public void getDealerShip(Dealership dealership) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/inventory.csv"))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                Vehicle vehicle = readCSV(line);
                if (vehicle != null) {

                    dealership.inventory.add(vehicle);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public  Vehicle readCSV(String readVehicle) {
        String[] info = readVehicle.split("\\|");

        if (info.length != 8) {
            System.out.println("Incomplete Vehicle: " + readVehicle);
            return null;
        }

        int vin = Integer.parseInt(info[0]);
        int year = Integer.parseInt(info[1]);
        String make  = info[2];
        String model  = info[3];
        String vehicleType = info[4];
        String color = info[5];
        int odometer = Integer.parseInt(info[6]);
        double price = Double.parseDouble(info[7]);




        Vehicle vehicle = new Vehicle(vin,year,make,model,vehicleType,color,odometer,price);
        return vehicle;
    }
    public void saveDealership(){
    }
}

