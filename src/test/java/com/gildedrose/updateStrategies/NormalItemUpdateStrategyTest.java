package com.gildedrose.updateStrategies;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.gildedrose.Item;
import com.gildedrose.updateStrategies.NormalItemUpdateStrategy;

public class NormalItemUpdateStrategyTest {

    String NORMAL_ITEM_NAME = "Normal item";

    @Test
    void testUpdateQualityIfQualityIsZero() {
        Item item = new Item(NORMAL_ITEM_NAME, 3, 0);
        NormalItemUpdateStrategy app = new NormalItemUpdateStrategy(item);
        app.updateQuality();
        assertEquals(2, app.item.sellIn);
        assertEquals(0, app.item.quality);
    }

    @Test
    void testUpdateIfSellByDateDidntPass() {
        Item item = new Item(NORMAL_ITEM_NAME, 3, 1);
        NormalItemUpdateStrategy app = new NormalItemUpdateStrategy(item);
        app.updateQuality();
        assertEquals(2, app.item.sellIn);
        assertEquals(0, app.item.quality);
    }

    @Test
    void testUpdateQualityIfSellByDatePassed() {
        Item item = new Item(NORMAL_ITEM_NAME, 0, 10);
        NormalItemUpdateStrategy app = new NormalItemUpdateStrategy(item);
        app.updateQuality();
        assertEquals(-1, app.item.sellIn);
        assertEquals(8, app.item.quality);
    }

}
