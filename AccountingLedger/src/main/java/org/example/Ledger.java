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

    public static ArrayList<Transaction> sortLedgerByDate(ArrayList<Transaction> ledgerList) {
        for (int i = 0; i < ledgerList.size() - 1; i++) {
            for (int j = 0; j < ledgerList.size() - i - 1; j++) {
                Transaction t1 = ledgerList.get(j);
                Transaction t2 = ledgerList.get(j + 1);

                if (t1.getDate().isBefore(t2.getDate()) ||
                        (t1.getDate().isEqual(t2.getDate()) && t1.getTime().isBefore(t2.getTime()))) {
                    ledgerList.set(j, t2);
                    ledgerList.set(j + 1, t1);
                }
            }
        }
        return ledgerList;
    }

    public static void displayAll(ArrayList<Transaction> ledgerList) {
        System.out.println("Displaying all transactions:");
        for (Transaction transaction : ledgerList) {
            System.out.printf("Date: %s | Time: %s | Description: %s | Vendor: %s | Amount: $%.2f%n",
                    transaction.getDate(), transaction.getTime(), transaction.getDescription(), transaction.getVendor(), transaction.getAmount());
        }
    }

    public static void displayDeposits(ArrayList<Transaction> ledgerList) {
        System.out.println("Displaying all deposits:");
        for (Transaction transaction : ledgerList) {
            if (transaction.getAmount() > 0) {
                System.out.printf("Date: %s | Time: %s | Description: %s | Vendor: %s | Amount: $%.2f%n",
                        transaction.getDate(), transaction.getTime(), transaction.getDescription(), transaction.getVendor(), transaction.getAmount());
            }
        }
    }

    public static void displayPayments(ArrayList<Transaction> ledgerList) {
        System.out.println("Displaying all payments:");
        for (Transaction transaction : ledgerList) {
            if (transaction.getAmount() < 0) {
                System.out.printf("Date: %s | Time: %s | Description: %s | Vendor: %s | Amount: $%.2f%n",
                        transaction.getDate(), transaction.getTime(), transaction.getDescription(), transaction.getVendor(), transaction.getAmount());
            }
        }
    }
}

