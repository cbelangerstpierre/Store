package com.yahoo.cedricbstpierre.Item;

public class Item {
    private final ItemType itemType;

    public Item(ItemType itemType) {
        this.itemType = itemType;
    }

    public ItemType getItemType() {
        return itemType;
    }
}
