package com.yahoo.cedricbstpierre.Service;

import com.yahoo.cedricbstpierre.Item.Item;
import com.yahoo.cedricbstpierre.Person;
import com.yahoo.cedricbstpierre.Store;

import java.util.ArrayList;

public class InteractionService {
    Store store;
    ArrayList<Person> people;

    public InteractionService(Store store, ArrayList<Person> people) {
        this.store = store;
        this.people = people;
        start();
    }

    public void start() {
        welcomeMessage();
        allStepsForSomeone("Éric");
        allStepsForSomeone("François");
    }

    public void allStepsForSomeone(String name) {
        putSomeoneItemsInCart(name);
        printSomeoneItemsPrice(name);
        printSomeoneItemsPriceAfterAdjustments(name);
        pay(name);
    }

    public void welcomeMessage() {
        System.out.printf("Welcome to %s's store !", store.getName());
    }

    private void putSomeoneItemsInCart(String name) {
        TakeItemsService.addPersonItems(getSomeone(name));
    }

    public Person getSomeone(String name){
        try {
            return people.stream()
                    .filter(person -> person.getName().equals(name))
                    .findFirst()
                    .orElseThrow(() -> new Exception("Person not found - " + name));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
            return null;
        }
    }

    public ArrayList<Item> getContentOfPerson(String name) {
        return getSomeone(name).getCart().getContent();
    }

    public void printEachItemPrice(String name, double adjustments) {
        getContentOfPerson(name).forEach(item -> System.out.printf("- %s -> %.2f$\n",
                item.getItemType().toString(),
                store.getPrice(item.getItemType()) * adjustments));
    }

    public double getTotalPrice(String name) {
        return PriceService.getSumPriceItems(getContentOfPerson(name), store);
    }

    public void printSomeoneItemsPrice(String name) {
        printItemPriceMessage(name, "avant");
        printEachItemPrice(name, 1);
        System.out.printf("\nFor a total of %.2f$\n", getTotalPrice(name));
    }

    public void printItemPriceMessage(String name, String time) {
        System.out.printf(
                "\nVoici le prix de chaque item dans le panier de %s %s taxes et %s rabais : \n\n",
                name, time, time);
    }

    public void printSomeoneItemsPriceAfterAdjustments(String name) {
        printItemPriceMessage(name, "après");
        double totalPrice = getTotalPrice(name);
        double adjustments = PriceService.calculateAdjustments(totalPrice);

        printEachItemPrice(name, adjustments);
        System.out.printf("\nFor a total of %.2f$\n", totalPrice * adjustments);
    }

    public void pay(String name) {
        double totalPrice = getTotalPrice(name);
        double finalPrice = totalPrice * PriceService.calculateAdjustments(totalPrice);
        Person someone = getSomeone(name);
        someone.getCreditCard().addDebt(finalPrice);
        someone.resetCart();
        someone.resetItemsList();
    }
}