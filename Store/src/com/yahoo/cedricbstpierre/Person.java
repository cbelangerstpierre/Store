package com.yahoo.cedricbstpierre;

import com.yahoo.cedricbstpierre.Item.ItemType;

import java.util.ArrayList;

public class Person {
    private final String name;
    private final ShoppingCart cart;
    private final CreditCard creditCard;
    private final ArrayList<ItemType> itemsList;

    public Person(String name, double creditCardLimit, ArrayList<ItemType> itemsList) {
        this.name = name;
        this.itemsList = itemsList;
        this.cart = new ShoppingCart();
        creditCard = new CreditCard(creditCardLimit);
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void resetCart() {
        getCart().getContent().clear();
    }

    public void resetItemsList() {
        getItemsList().clear();
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public String getName() {
        return name;
    }

    public ArrayList<ItemType> getItemsList() {
        return itemsList;
    }
}
