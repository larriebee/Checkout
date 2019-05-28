package com.eye.tee.vee.coding.kata.domain;

import com.eye.tee.vee.coding.kata.domain.Item;

/**
 * Interface for calculating the pricing strategy for {@link Item}s
 */
public interface Offer {

    /**
     * Function that calculates the price for a specific item
     * depending on the purchasing quantity
     *
     * @param item item for which the offer applies
     * @param quantity quantity of items being purchased
     * @return the total price of the items for the requested quantity
     */
    long calculatePrice(Item item, int quantity);
}
