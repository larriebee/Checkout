package com.eye.tee.vee.coding.kata.domain;

import java.util.Map;
import java.util.logging.Logger;

/**
 * Implementation of the pricing rules that apply to offers
 */
public class OffersPricing implements Pricing {
    private static final Logger LOGGER = Logger.getLogger( OffersPricing.class.getName() );

    /**
     * A list of current offers to be applied to a checkout transaction
     */
    private final Map<String, Offer> offers;

    public OffersPricing(Map<String, Offer> offers) {
        this.offers = offers;
    }

    @Override
    public long calculatePrice(Item item, int quantity) {
        if (offers.containsKey(item.getSku())){
            return offers.get(item.getSku()).calculatePrice(item, quantity);
        } else {
            return item.getPrice() * quantity;
        }

    }
}
