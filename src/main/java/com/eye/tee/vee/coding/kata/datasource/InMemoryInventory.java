package com.eye.tee.vee.coding.kata.datasource;

import com.eye.tee.vee.coding.kata.domain.Item;

import java.util.Map;

/**
 * A collection of inventory items held in a map
 */
public class InMemoryInventory implements Inventory {

    /**
     * A map of SKUs to items which make up the inventory
     */
    private final Map<String, Item> items;

    public InMemoryInventory(Map<String, Item> items) {
        this.items = items;
    }

    @Override
    public Item getItem(String sku) {
        return items.get(sku);
    }

    @Override
    public boolean hasItem(String sku) {
        return items.containsKey(sku);
    }

}
