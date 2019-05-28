package com.eye.tee.vee.coding.kata.domain;

import com.eye.tee.vee.coding.kata.domain.Item;
import com.eye.tee.vee.coding.kata.domain.MultiBuyOffer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MultiBuyOfferTest {

    private MultiBuyOffer offer;

    @BeforeEach
    public void setup() {
        offer = new MultiBuyOffer(130, 3);
    }

    @Test
    public void calculatePriceForQualifyingQuantity() {
        long price = offer.calculatePrice(new Item("A", 50), 3);

        assertEquals(price, 130);
    }

    @Test
    public void calculatePriceForNonQualifyingQuantity() {
        long price = offer.calculatePrice(new Item("D", 15), 2);

        assertEquals(price, 30);
    }
}