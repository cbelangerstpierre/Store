package com.yahoo.cedricbstpierre.Service;

import com.yahoo.cedricbstpierre.Item.BarBaz;
import com.yahoo.cedricbstpierre.Item.Console;
import com.yahoo.cedricbstpierre.Item.ConsoleController;
import com.yahoo.cedricbstpierre.Item.Fooger;
import com.yahoo.cedricbstpierre.Item.Item;
import com.yahoo.cedricbstpierre.Item.TV;
import com.yahoo.cedricbstpierre.Item.TVController;
import com.yahoo.cedricbstpierre.Person;

public class TakeItemsService {
    public static void addPersonItems(Person person) {
        person.getItemsList().forEach(itemType -> {
            Item item;
            switch (itemType) {
                case TV -> item  = new TV();
                case Console -> item = new Console();
                case Fooger -> item = new Fooger();
                case BarBaz -> item = new BarBaz();
                case TVController -> item = new TVController();
                case ConsoleController -> item = new ConsoleController();
                default -> throw new NullPointerException();
            }

            person.getCart().addItem(item);
        });
    }
}
