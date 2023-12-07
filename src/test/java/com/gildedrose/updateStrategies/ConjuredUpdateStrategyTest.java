package com.gildedrose.updateStrategies;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.gildedrose.Constants;
import com.gildedrose.Item;

public class ConjuredUpdateStrategyTest {

    @Test
    void testUpdateQualityIfQualityIsOneAndSellByDatePassed() {
        Item item = new Item(Constants.CONJURED_ITEM_NAME, 0, 1);
        ConjuredUpdateStrategy app = new ConjuredUpdateStrategy(item);
        app.updateQuality();
        assertEquals(-1, app.item.sellIn);
        assertEquals(0, app.item.quality);
    }

    @Test
    void testUpdateIfQualityIsOneAndSellByDateDidntPass() {
        Item item = new Item(Constants.CONJURED_ITEM_NAME, 3, 1);
        ConjuredUpdateStrategy app = new ConjuredUpdateStrategy(item);
        app.updateQuality();
        assertEquals(2, app.item.sellIn);
        assertEquals(0, app.item.quality);
    }

    @Test
    void testUpdateQualityIfSellByDatePassed() {
        Item item = new Item(Constants.CONJURED_ITEM_NAME, 0, 10);
        ConjuredUpdateStrategy app = new ConjuredUpdateStrategy(item);
        app.updateQuality();
        assertEquals(-1, app.item.sellIn);
        assertEquals(6, app.item.quality);
    }

    @Test
    void testUpdateQualityIfSellByDateDidntPassPassed() {
        Item item = new Item(Constants.CONJURED_ITEM_NAME, 1, 10);
        ConjuredUpdateStrategy app = new ConjuredUpdateStrategy(item);
        app.updateQuality();
        assertEquals(0, app.item.sellIn);
        assertEquals(8, app.item.quality);
    }

}
