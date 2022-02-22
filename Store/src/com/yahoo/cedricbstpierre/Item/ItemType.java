package com.yahoo.cedricbstpierre.Item;

import java.util.EnumSet;

public enum ItemType {

    BarBaz("BarBaz"),
    Fooger("Fooger"),
    TV("TV"),
    Console("Console"),
    TVController("TV Controller"),
    ConsoleController("Console Controller");

    private final String name;

    public static EnumSet<ItemType> controllerType = EnumSet.of(TVController, ConsoleController);
    public static EnumSet<ItemType> GameType = EnumSet.of(BarBaz, Fooger);
    public static EnumSet<ItemType> entertainmentSystemType = EnumSet.of(TV, Console);

    ItemType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}