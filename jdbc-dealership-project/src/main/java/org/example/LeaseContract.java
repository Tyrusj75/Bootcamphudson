package org.example;

public class LeaseContract extends Contract {
    int id;
    String contractType;
    double expectedEndingValue;
    double leaseFee;
    double interestRate = 4;
    int numberOfPayments = 36;
    double endTotalPrice;
    double monthlyPayment;



    public LeaseContract(String date, String customerName, String customerEmail, String vehicleSold, double totalPrice, double monthlyPayment, double expectedEndingValue, double leaseFee) {
        super(date, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
        this.expectedEndingValue = expectedEndingValue;
        this.leaseFee = leaseFee;
        this.contractType = "LEASE";
        getMonthlyPayment();
        getTotalPrice();
        setLeaseFee();
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = this.totalPrice / 2;
    }

    public double getLeaseFee() {
        return leaseFee;
    }
    public void setLeaseFee() {
        this.leaseFee = this.totalPrice * 0.07;
    }






    @Override
    public void getTotalPrice() {
        System.out.println("Total price paid $" + endTotalPrice);

    }

    public void getMonthlyPayment() {
        double residualPrice = this.totalPrice / 2;

        double moneyFactor = interestRate/2400;


        double depreciationFee = (this.totalPrice - residualPrice) / 36;


        double financeFee = (this.totalPrice + residualPrice) * moneyFactor;


        monthlyPayment = depreciationFee + financeFee;
        System.out.printf("Monthly payment is $%.2f", monthlyPayment);
        endTotalPrice = monthlyPayment * 36;


    }
}

