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
