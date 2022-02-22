package com.yahoo.cedricbstpierre;

import com.yahoo.cedricbstpierre.Item.ItemType;

import java.util.HashMap;

public class Store {
    private final String name;
    private final HashMap<ItemType, Double> pricesList;

    public Store(String name) {
        this.name = name;
        pricesList = new HashMap<>();
        createPricesList();
    }

    public String getName() {
        return name;
    }

    public double getPrice(ItemType item) {
        return pricesList.get(item);
    }

    private void createPricesList() {
//      Entertainment Systems
        pricesList.put(ItemType.TV, 1275.00);
        pricesList.put(ItemType.Console, 400.00);

//      Games
        pricesList.put(ItemType.BarBaz, 75.00);
        pricesList.put(ItemType.Fooger, 95.00);

//      Controllers
        pricesList.put(ItemType.TVController, 20.00);
        pricesList.put(ItemType.ConsoleController, 35.00);
    }
}
