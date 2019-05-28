package com.eye.tee.vee.coding.kata.service;

import com.eye.tee.vee.coding.kata.datasource.Inventory;
import com.eye.tee.vee.coding.kata.domain.Item;
import com.eye.tee.vee.coding.kata.domain.Pricing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Represents a checkout transaction
 */
public class Checkout {
    private static final Logger LOGGER = Logger.getLogger( Checkout.class.getName());

    /**
     * Pricing strategy to be applied to the current transaction
     *
     * i.e. Pricing that applies to current offers
     */
    private final Pricing pricing;

    /**
     * Datastore containing all the items available for purchase
     */
    private final Inventory inventory;

    /**
     * List of items being processed
     */
    private List<Item> items;

    public Checkout(Pricing pricing, Inventory inventory) {
        this.pricing = pricing;
        this.inventory = inventory;
        this.items = new ArrayList<>();
    }

    /**
     * Adds item to list currently being processed
     *
     * @param sku stock keeping unit for current item
     */
    public void addItem(String sku) {
        if (sku != null && inventory.hasItem(sku)) {
            items.add(inventory.getItem(sku));
        } else {
            LOGGER.warning(String.format("'%s' is not a valid sku, it will not be added", sku));
        }
    }

    /**
     * Calculates the total amount payable for the current transaction, including offers.
     *
     * @return monetary value for item in the processed list
     */
    public long calculateTotal() {
        long total = 0;
        Map<Item, Long> itemToQuantityMap = items.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (Map.Entry<Item, Long> entry : itemToQuantityMap.entrySet()) {
            Item item = entry.getKey();
            int quantity = Math.toIntExact(entry.getValue());
            total = total + pricing.calculatePrice(item, quantity);
        }

        return total;
    }
}
