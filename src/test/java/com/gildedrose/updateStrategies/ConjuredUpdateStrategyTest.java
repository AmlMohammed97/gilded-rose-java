package com.gildedrose.updateStrategies;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.gildedrose.Constants;
import com.gildedrose.Item;

public class ConjuredUpdateStrategyTest {

    @Test
    void testUpdateQualityIfQualityIsThreeAndSellByDatePassed() {
        // GIVEN
        Item item = new Item(Constants.CONJURED_ITEM_NAME, 0, 3);
        // AND
        ConjuredUpdateStrategy conjuredUpdateStrategy = new ConjuredUpdateStrategy(item);

        // WHEN
        conjuredUpdateStrategy.updateQuality();

        // THEN
        assertEquals(-1, conjuredUpdateStrategy.item.sellIn);
        // AND
        assertEquals(0, conjuredUpdateStrategy.item.quality);
    }

    @Test
    void testUpdateIfQualityIsOneAndSellByDateDidntPass() {
        // GIVEN
        Item item = new Item(Constants.CONJURED_ITEM_NAME, 3, 1);
        // AND
        ConjuredUpdateStrategy conjuredUpdateStrategy = new ConjuredUpdateStrategy(item);

        // WHEN
        conjuredUpdateStrategy.updateQuality();

        // THEN
        assertEquals(2, conjuredUpdateStrategy.item.sellIn);
        // AND
        assertEquals(0, conjuredUpdateStrategy.item.quality);
    }

    @Test
    void testUpdateQualityIfSellByDatePassed() {
        // GIVEN
        Item item = new Item(Constants.CONJURED_ITEM_NAME, 0, 10);
        // AND
        ConjuredUpdateStrategy conjuredUpdateStrategy = new ConjuredUpdateStrategy(item);

        // WHEN
        conjuredUpdateStrategy.updateQuality();

        // THEN
        assertEquals(-1, conjuredUpdateStrategy.item.sellIn);
        // AND
        assertEquals(6, conjuredUpdateStrategy.item.quality);
    }

    @Test
    void testUpdateQualityIfSellByDateDidntPassPassed() {
        // GIVEN
        Item item = new Item(Constants.CONJURED_ITEM_NAME, 1, 10);
        // AND
        ConjuredUpdateStrategy conjuredUpdateStrategy = new ConjuredUpdateStrategy(item);

        // WHEN
        conjuredUpdateStrategy.updateQuality();

        // THEN
        assertEquals(0, conjuredUpdateStrategy.item.sellIn);
        // AND
        assertEquals(8, conjuredUpdateStrategy.item.quality);
    }

}
