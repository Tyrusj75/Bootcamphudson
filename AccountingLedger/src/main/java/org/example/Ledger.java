package org.example;

import java.time.LocalDate;

import java.time.LocalTime;

public class Ledger {
    private String vendor;
    private String description;
    private LocalDate date;
    private LocalTime time;
    private double amount;

    public Ledger(String name, String description, LocalDate date, LocalTime time, double amount) {
        this.vendor = name;
        this.description = description;
        this.date = date;
        this.time = time;
        this.amount = amount;
    }

    public String getVendor() {
        return vendor;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public double getAmount() {
        return amount;
    }
}
