package com.eye.tee.vee.coding.kata.datasource;

import com.eye.tee.vee.coding.kata.domain.Item;

/**
 * A collection of inventory items
 */
public interface Inventory {

    /**
     * Operation that queries a datastore and returns the matching item
     *
     * @param sku stock keeping unit of the item being requested
     * @return item matching the sku in the inventory
     */
    Item getItem(String sku);

    /**
     * Checks its datastore to
     *
     * @param sku
     * @return
     */
    boolean hasItem(String sku);
}
