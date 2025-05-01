package org.example;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Ledger {
    static Scanner myScanner = new Scanner(System.in);
    static ArrayList<Transaction> ledgerList = TransactionFileManager.ledgerList;

    public static void homeScreen() throws IOException {
        String userInput;

        do {
            System.out.println("Welcome to Founder's Credit Union! Please select an option below" +
                    "\nD) Deposit" +
                    "\nP) Make a payment" +
                    "\nL) Ledger" +
                    "\nX) Exit");

            userInput = myScanner.nextLine().trim().toUpperCase();

            switch (userInput) {
                case "D":
                    addDeposit();
                    break;
                case "P":
                    makePayment();
                    break;
                case "L":
                    displayLedger();
                    break;
                case "X":
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        } while (true);
    }

    public static void addDeposit() throws IOException {
        System.out.println("Enter the description of the transaction:");
        String description = myScanner.nextLine().trim();
        System.out.println("Enter the vendor:");
        String vendor = myScanner.nextLine().trim();
        System.out.println("Enter the amount:");
        double amount = myScanner.nextDouble();
        myScanner.nextLine();

        Transaction newTransaction = new Transaction(LocalDate.now(), LocalTime.now(), description, vendor, amount);
        ledgerList.add(newTransaction);
        TransactionFileManager.writeFile();
        System.out.println("Deposit added successfully!");
    }

    public static void makePayment() throws IOException {
        System.out.println("Enter the description of the transaction:");
        String description = myScanner.nextLine().trim();
        System.out.println("Enter the vendor:");
        String vendor = myScanner.nextLine().trim();
        System.out.println("Enter the amount:");
        double amount = myScanner.nextDouble();
        myScanner.nextLine();

        Transaction newTransaction = new Transaction(LocalDate.now(), LocalTime.now(), description, vendor, -amount);
        ledgerList.add(newTransaction);
        TransactionFileManager.writeFile();
        System.out.println("Payment added successfully!");
    }

    public static void displayLedger() throws IOException {
        String userInput;

        do {
            System.out.println("These are your options:" +
                    "\nA) All entries" +
                    "\nD) View deposits" +
                    "\nP) View payments" +
                    "\nH) Home");

            userInput = myScanner.nextLine().trim().toUpperCase();

            switch (userInput) {
                case "A":
                    displayAll(sortLedgerByDate(ledgerList));
                    break;
                case "D":
                    displayDeposits(sortLedgerByDate(ledgerList));
                    break;
                case "P":
                    displayPayments(sortLedgerByDate(ledgerList));
                    break;
                case "H":
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        } while (!userInput.equals("H"));
    }

