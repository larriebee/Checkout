package com.eye.tee.vee.coding.kata.domain;

import java.util.Objects;

/**
 * Class to represent a product 
 */
public class Item {

    /**
     * Stock keeping unit
     *
     * i.e. 'A'
     */
    private final String sku;

    /**
     * Monary value for the item
     */
    private long price;

    public Item(String sku, long price) {
        this.sku = sku;
        this.price = price;
    }

    public String getSku() {
        return this.sku;
    }

    public long getPrice() {
        return this.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(sku, item.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku);
    }
}
