package org.example;

public class SalesContract extends Contract {
    int id;
    String contractType;
    double salesTaxAmount;
    double recordingFee;
    double processingFee;
    boolean isFinancing;
    double monthlyPayment = 0;

    double endingTotal;

    public SalesContract(String date, String customerName, String customerEmail, String vehicleSold, double totalPrice, double monthlyPayment, boolean isFinancing) {
        super(date, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
        this.salesTaxAmount = 0.05;
        this.recordingFee = 100;
        this.isFinancing = isFinancing;
        this.contractType = "SALE";
        getMonthlyPayment();
        getTotalPrice();

    }

    @Override
    public void getTotalPrice() {

        System.out.printf("This is the total of after all payments and fees $%.2f "  ,endingTotal );
        System.out.println();


    }
    @Override
    public void getMonthlyPayment() {
        if (isFinancing) {
            if (this.totalPrice >= 10_000) {
                this.processingFee = 495;
                double interestRate = 0.0425;
                double monthlyInterestRate = interestRate / 12;
                int monthTerm = 48;

                monthlyPayment = (totalPrice * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -monthTerm));
                endingTotal = (monthlyPayment * 48) + this.recordingFee + processingFee * this.salesTaxAmount;


            } else {
                this.processingFee = 495;
                double interestRate = 0.0525;
                double monthlyInterestRate = interestRate / 12 ;

                int monthTerm = 24;

                monthlyPayment = (this.totalPrice * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -monthTerm));
                endingTotal = (monthlyPayment * 24) + this.recordingFee + processingFee * this.salesTaxAmount;



            }
        } else {
            monthlyPayment = 0;
            endingTotal =  this.totalPrice + this.recordingFee + processingFee * this.salesTaxAmount;
        }

        System.out.printf("Monthly payment is $%.2f", monthlyPayment);
        System.out.println();
    }
}
