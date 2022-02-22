package com.yahoo.cedricbstpierre;

import com.yahoo.cedricbstpierre.Item.*;
import com.yahoo.cedricbstpierre.Service.InteractionService;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Éric", 2500.00, new ArrayList<>(List.of(
                ItemType.TV,
                ItemType.Console,
                ItemType.ConsoleController,
                ItemType.Fooger
        ))));
        people.add(new Person("François", 2500.00, new ArrayList<>(List.of(
                ItemType.TVController,
                ItemType.ConsoleController,
                ItemType.BarBaz,
                ItemType.Fooger
        ))));

        new InteractionService(
                new Store("Best Bros"),
                people);
    }
}
