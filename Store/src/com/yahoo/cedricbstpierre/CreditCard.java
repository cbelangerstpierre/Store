package com.yahoo.cedricbstpierre;

public class CreditCard {
    private double limit;
    private double amountUsed;

    public CreditCard(double limit) {
        this.limit = limit;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public void addDebt(double amount) {
        amountUsed += amount;
    }

    public void payDebt(double amount) {
        amountUsed -= amount;
    }

    public double getAmountUsed() {
        return amountUsed;
    }
}
