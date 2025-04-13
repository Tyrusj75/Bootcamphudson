package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Tooka's Financial Calculators!");
        System.out.println("Please select a calculator:");
        System.out.println("1. Mortgage Calculator");
        System.out.println("2. Future Value Calculator");
        System.out.println("3. Present Value of Annuity");
        System.out.println("Enter your choice (1-3): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                runMortgageCalculator(scanner);
                break;
            case 2:
                runFutureValueCalculator(scanner);
                break;
            case 3:
                runAnnuityCalculator(scanner);
                break;
            default:
                System.out.println("Invalid choice. Please run the program again.");
        }
        scanner.close();
    }

    public static void runMortgageCalculator(Scanner scanner) {
        System.out.println("\n--- Mortgage Calculator ---");

        System.out.println("Enter the loan amount (principal): ");
        double principal = scanner.nextDouble();

        System.out.println("Enter the annual interest rate (e.g., 7.625): ");
        double annualRate = scanner.nextDouble() / 100;

        System.out.println("Enter the loan in terms of years: ");
        int years = scanner.nextInt();

        int n = years * 12; // total monthly payments
        double i = annualRate / 12; // monthly interest rate

        double monthlyPayment = principal * (i * Math.pow(1 + i, n)) / (Math.pow(1 + i, n) - 1);
        double totalInterest = (monthlyPayment * n) - principal;

        System.out.printf("Monthly Payment: $%.2f\n", monthlyPayment);
        System.out.printf("Total Interest Paid: $%.2f\n", totalInterest);
    }

    public static void runFutureValueCalculator(Scanner scanner) {
        System.out.println("\n--- Future Value Calculator ---");

        System.out.println("Enter the deposit amount: ");
        double principal = scanner.nextDouble();

        System.out.println("Enter the annual interest rate (e.g., 1.75): ");
        double annualRate = scanner.nextDouble() / 100;

        System.out.println("Enter the number of years:");
        int years = scanner.nextInt();

        double fv = principal * Math.pow(1 + (annualRate / 365), 365 * years);
        double interestEarned = fv - principal;

        System.out.printf("Future Value of Annuity Calculator ---");
        System.out.printf("Total Interest Earned: $%.2f\n", interestEarned);
    }
    public static void runAnnuityCalculator(Scanner scanner) {
        System.out.print("Enter the monthly payout: ");
        double payment = scanner.nextDouble();

        System.out.print("Enter the annual interest rate (e.g., 2.5): ");
        double annualRate = scanner.nextDouble() / 100;

        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();

        int n = years * 12;
        double i = annualRate / 12;

        double presentValue = payment * (1 - Math.pow(1 + 1, -n)) / i;
        System.out.printf("Present Value of Annuity: $%.2f\n", presentValue);
    }
}










