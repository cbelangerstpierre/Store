package com.yahoo.cedricbstpierre;

import com.yahoo.cedricbstpierre.Item.Item;

import java.util.ArrayList;

public class ShoppingCart {
    private final ArrayList<Item> content;

    public ShoppingCart() {
        content = new ArrayList<>();
    }

    public ArrayList<Item> getContent() {
        return content;
    }

    public void addItem(Item item) {
        content.add(item);
    }
}
