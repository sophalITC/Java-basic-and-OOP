// package com.example.demo;

public class BankModel {
    private int id;
    private String name;
    private int minLoan;
    private int maxLoan;
    private double firstInterest;
    private double secondInterest;

    public BankModel(int id, String name, int minLoan, int maxLoan, double firstInterest, double secondInterest) {
        this.id = id;
        this.name = name;
        this.minLoan = minLoan;
        this.maxLoan = maxLoan;
        this.firstInterest = firstInterest;
        this.secondInterest = secondInterest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinLoan() {
        return minLoan;
    }

    public void setMinLoan(int minLoan) {
        this.minLoan = minLoan;
    }

    public int getMaxLoan() {
        return maxLoan;
    }

    public void setMaxLoan(int maxLoan) {
        this.maxLoan = maxLoan;
    }

    public double getFirstInterest() {
        return firstInterest;
    }

    public void setFirstInterest(double firstInterest) {
        this.firstInterest = firstInterest;
    }

    public double getSecondInterest() {
        return secondInterest;
    }

    public void setSecondInterest(double secondInterest) {
        this.secondInterest = secondInterest;
    }
}
