package com.yahoo.cedricbstpierre.Service;

public class RebatesService {
    public static double calculateRebate(double price) {
        return price >= 200 ? (price >= 1000 ? 0.15 : 0.02) : 0.0;
    }
}
