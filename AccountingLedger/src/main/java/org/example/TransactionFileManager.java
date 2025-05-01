package org.example;

import java.time.format.DateTimeFormatter;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class TransactionFileManager {
    public static ArrayList<Transaction> ledgerList = new ArrayList<>();

    // Reads transactions from the file
    public static void readFile() throws IOException {
        ledgerList.clear();
        String input;

        FileReader fileReader = new FileReader("src/main/resources/transactions.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // Skip the header row
        bufferedReader.readLine();

        while ((input = bufferedReader.readLine()) != null) {
            String[] transactionReader = input.split("\\|");
            if (transactionReader.length == 5) {
                try {
                    LocalDate date = LocalDate.parse(transactionReader[0]);
                    LocalTime time = LocalTime.parse(transactionReader[1]);
                    String description = transactionReader[2];
                    String vendor = transactionReader[3];
                    double amount = Double.parseDouble(transactionReader[4]);

                    Transaction transaction = new Transaction(date, time, description, vendor, amount);
                    ledgerList.add(transaction);
                } catch (Exception e) {
                    System.err.println("Error parsing transaction: " + input);
                }
            }
        }
        bufferedReader.close();
    }

    // Writes transactions to the file
    public static void writeFile() throws IOException {
        FileWriter fileWriter = new FileWriter("src/main/resources/transactions.csv");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        // Define a formatter for HH:mm
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        for (Transaction transaction : ledgerList) {
            String line = String.format("%s|%s|%s|%s|%.2f",
                    transaction.getDate(),
                    transaction.getTime().format(timeFormatter), // Format time as HH:mm
                    transaction.getDescription(),
                    transaction.getVendor(),
                    transaction.getAmount());
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
}
