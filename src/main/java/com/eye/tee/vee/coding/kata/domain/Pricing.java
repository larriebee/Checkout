package com.eye.tee.vee.coding.kata.domain;

import com.eye.tee.vee.coding.kata.domain.Item;

/**
 * The set of pricing rules to be applied during a checkout transaction
 */
public interface Pricing {

    /**
     * Calculates the price of a specific item type
     *
     * @param item item being processed
     * @param quantity quantity of the specific item being processed
     * @return monetary value for the item(s) matching a sku
     */
    long calculatePrice(Item item, int quantity);
}
