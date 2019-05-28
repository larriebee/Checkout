package com.eye.tee.vee.coding.kata.service;

import com.eye.tee.vee.coding.kata.datasource.InMemoryInventory;
import com.eye.tee.vee.coding.kata.datasource.Inventory;
import com.eye.tee.vee.coding.kata.domain.*;
import com.eye.tee.vee.coding.kata.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CheckoutTest {

    private Checkout checkout;

    @BeforeEach
    public void setUp() {
        Map<String, Offer> offers = new HashMap<>(2);
        offers.put("A", new MultiBuyOffer(130L, 3));
        offers.put("B", new MultiBuyOffer(45L, 2));

        Map<String, Item> priceList = new HashMap<>(4);
        priceList.put("A", new Item("A", 50));
        priceList.put("B", new Item("B", 30));
        priceList.put("C", new Item("C", 20));
        priceList.put("D", new Item("D", 15));

        Inventory inventory = new InMemoryInventory(priceList);

        Pricing pricing = new OffersPricing(offers);
        checkout = new Checkout(pricing, inventory);
    }

    @Test
    public void addSingleItem() {
        checkout.addItem("A");

        long total = checkout.calculateTotal();
        assertEquals(total, 50);
    }

    @Test
    public void addMultiBuyItems() {
        checkout.addItem("A");
        checkout.addItem("A");
        checkout.addItem("A");

        long total = checkout.calculateTotal();
        assertEquals(total, 130);
    }

    @Test
    public void addForMoreThanOneMultiBuy() {
        checkout.addItem("A");
        checkout.addItem("A");
        checkout.addItem("A");
        checkout.addItem("B");
        checkout.addItem("B");

        long total = checkout.calculateTotal();
        assertEquals(total, 175);
    }

    @Test
    public void addInRandomOrder() {
        checkout.addItem("A");
        checkout.addItem("B");
        checkout.addItem("A");
        checkout.addItem("B");
        checkout.addItem("A");

        long total = checkout.calculateTotal();
        assertNotNull(total);
        assertEquals(total, 175);
    }

    @Test
    public void addNonOfferItems() {
        checkout.addItem("C");
        checkout.addItem("D");
        checkout.addItem("C");

        long total = checkout.calculateTotal();
        assertNotNull(total);
        assertEquals(total, 55);
    }

    @Test
    public void addInvalidItem() {
        checkout.addItem("E");

        long total = checkout.calculateTotal();
        assertNotNull(total);
        assertEquals(total, 0);
    }

    @Test
    public void addNullItem() {
        checkout.addItem(null);

        long total = checkout.calculateTotal();
        assertNotNull(total);
        assertEquals(total, 0);
    }
}