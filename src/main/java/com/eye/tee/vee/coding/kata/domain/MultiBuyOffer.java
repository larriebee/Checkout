package com.eye.tee.vee.coding.kata.domain;

/**
 * Implementation for {@link Offer} which calculates the price
 * of an item when a qualifying quantity is purchased
 */
public class MultiBuyOffer implements Offer {

    /**
     * Monatary value of the offer
     */
    private final long offerPrice;

    /**
     * number of items needed to qualify for the offer
     */
    private final int qualifyingQuantity;

    public MultiBuyOffer(long offerPrice, int qualifyingQuantity) {
        this.offerPrice = offerPrice;
        this.qualifyingQuantity = qualifyingQuantity;
    }

    @Override
    public long calculatePrice(Item item, int quantity) {
        if (quantity >= qualifyingQuantity) {
            long totalPrice = 0L;
            int offerQualifierCount = quantity / qualifyingQuantity;
            int normalPricedItems = quantity % qualifyingQuantity;

            totalPrice = totalPrice + (offerQualifierCount * this.offerPrice);
            totalPrice = totalPrice + (normalPricedItems * item.getPrice());

            return totalPrice;
        } else {
            return quantity * item.getPrice();
        }
    }
}
