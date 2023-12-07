package com.gildedrose.updateStrategies;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.gildedrose.Item;

public class NormalItemUpdateStrategyTest {

    String NORMAL_ITEM_NAME = "Normal item";

    @Test
    void testUpdateQualityIfQualityIsZero() {
        // GIVEN
        Item item = new Item(NORMAL_ITEM_NAME, 3, 0);
        // AND
        NormalItemUpdateStrategy normalItemUpdateStrategy = new NormalItemUpdateStrategy(item);

        // WHEN
        normalItemUpdateStrategy.updateQuality();

        // THEN
        assertEquals(2, normalItemUpdateStrategy.item.sellIn);
        // AND
        assertEquals(0, normalItemUpdateStrategy.item.quality);
    }

    @Test
    void testUpdateIfSellByDateDidntPass() {
        // GIVEN
        Item item = new Item(NORMAL_ITEM_NAME, 3, 1);
        // AND
        NormalItemUpdateStrategy normalItemUpdateStrategy = new NormalItemUpdateStrategy(item);

        // WHEN
        normalItemUpdateStrategy.updateQuality();

        // THEN
        assertEquals(2, normalItemUpdateStrategy.item.sellIn);
        // AND
        assertEquals(0, normalItemUpdateStrategy.item.quality);
    }

    @Test
    void testUpdateQualityIfSellByDatePassed() {
        // GIVEN
        Item item = new Item(NORMAL_ITEM_NAME, 0, 10);
        // AND
        NormalItemUpdateStrategy normalItemUpdateStrategy = new NormalItemUpdateStrategy(item);

        // WHEN
        normalItemUpdateStrategy.updateQuality();

        // THEN
        assertEquals(-1, normalItemUpdateStrategy.item.sellIn);
        // AND
        assertEquals(8, normalItemUpdateStrategy.item.quality);
    }

}
