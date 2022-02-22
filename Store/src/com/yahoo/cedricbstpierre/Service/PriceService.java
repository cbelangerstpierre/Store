package com.yahoo.cedricbstpierre.Service;

import com.yahoo.cedricbstpierre.Item.Item;
import com.yahoo.cedricbstpierre.Store;

import java.util.ArrayList;

public class PriceService {
    public static double getSumPriceItems(ArrayList<Item> itemList, Store store) {
        return itemList.stream()
                .mapToDouble(item -> store.getPrice(item.getItemType()))
                .sum();
    }

    public static double calculateAdjustments(double totalPrice) {
        return (1 - RebatesService.calculateRebate(totalPrice)) * 1.15;
    }
}
