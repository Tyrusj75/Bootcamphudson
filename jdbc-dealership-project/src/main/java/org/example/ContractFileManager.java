package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class ContractFileManager {
    public ContractFileManager() {
    }

    public Vehicle readCSV(String readVehicle) {
        String[] info = readVehicle.split("\\|");

        if (info.length != 8) {
            System.out.println("Incomplete Vehicle: " + readVehicle);
            return null;
        }

        int vin = Integer.parseInt(info[0]);
        int year = Integer.parseInt(info[1]);
        String make = info[2];
        String model = info[3];
        String vehicleType = info[4];
        String color = info[5];
        int odometer = Integer.parseInt(info[6]);
        double price = Double.parseDouble(info[7]);


        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        return vehicle;
    }

    public static void writeSalesContract(SalesContract contract) {
        try {
            BufferedReader bufferedReader1 = new BufferedReader(new FileReader("src/main/resources/inventory.csv"));
            BufferedWriter bufferedWriter1 = new BufferedWriter(new FileWriter("src/main/resources/inventory.csv", true));

            BufferedReader bufferedReader2 = new BufferedReader(new FileReader("src/main/resources/contracts.csv"));
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter("src/main/resources/contracts.csv", true));
            bufferedWriter2.write(contract.contractType + "|" + contract.getDate() + "|" + contract.getCustomerName()+ "|" + contract.getCustomerEmail() + "|" + contract.vehicleSold + "|" + String.format("%.2f", contract.totalPrice) + "|" + String.format("%.2f", contract.salesTaxAmount) + "|" + String.format("%.2f", contract.recordingFee) + "|" + String.format("%.2f", contract.processingFee) + "|" + Boolean.toString(contract.isFinancing) + "|" + String.format("%.2f", contract.monthlyPayment) + "|" + String.format("%.2f", contract.endingTotal));
            bufferedWriter2.newLine();
            bufferedWriter2.close();
        } catch (Exception e) {
            e.printStackTrace();

        }


    }

    public static void writeLeaseContract(LeaseContract contract) {
        try{
            BufferedReader bufferedReader1 = new BufferedReader(new FileReader("src/main/resources/inventory.csv"));
            BufferedWriter bufferedWriter1 = new BufferedWriter(new FileWriter("src/main/resources/inventory.csv",true));

            BufferedReader bufferedReader2 = new BufferedReader(new FileReader("src/main/resources/contracts.csv"));
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter("src/main/resources/contracts.csv",true));
            bufferedWriter2.write(contract.contractType + "|" + contract.getDate()+ "|"  + contract.getCustomerName() + "|" + contract.getCustomerEmail() + "|" +contract.vehicleSold + "|" + String.format("%.2f",contract.totalPrice) + "|" + contract.leaseFee + "|" + String.format("%.2f",contract.monthlyPayment) + "|" +  String.format("%.2f", contract.endTotalPrice));
            bufferedWriter2.newLine();
            bufferedWriter2.close();
        }
        catch(Exception e){
            e.printStackTrace();

        }
    }
}

