package com.eye.tee.vee.coding.kata.domain;

import com.eye.tee.vee.coding.kata.domain.Item;
import com.eye.tee.vee.coding.kata.domain.MultiBuyOffer;
import com.eye.tee.vee.coding.kata.domain.Offer;
import com.eye.tee.vee.coding.kata.domain.OffersPricing;
import com.eye.tee.vee.coding.kata.domain.Pricing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OffersPricingTest {

    private Map<String, Offer> offers;

    private Pricing pricing;

    @BeforeEach
    public void setup() {
        offers = new HashMap<>();
        offers.put("A", new MultiBuyOffer(130L, 3));
        pricing = new OffersPricing(offers);
    }

    @Test
    void calculatePriceWhenOfferApplies() {
        long price = pricing.calculatePrice(new Item("A", 50), 3);
        assertEquals(price, 130);
    }

    @Test
    void calculatePriceWhenOfferDoesntApply() {
        long price = pricing.calculatePrice(new Item("A", 50), 2);
        assertEquals(price, 100);
    }
}