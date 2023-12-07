package com.gildedrose.updateStrategies;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.gildedrose.Item;
import com.gildedrose.updateStrategies.AgedBrieUpdateStrategy;

public class AgedBrieUpdateStrategyTest {

    String AGED_BRIE_ITEM_NAME = "Aged Brie";

    @Test
    void testUpdateQualityIfConcertPassed() {
        Item item = new Item(AGED_BRIE_ITEM_NAME, 0, 10);
        AgedBrieUpdateStrategy app = new AgedBrieUpdateStrategy(item);
        app.updateQuality();
        assertEquals(-1, app.item.sellIn);
        assertEquals(0, app.item.quality);
    }
    
    @Test
    void testUpdateQualityIfFiveDaysOrLessRemaining() {
        Item item = new Item(AGED_BRIE_ITEM_NAME, 5, 10);
        AgedBrieUpdateStrategy app = new AgedBrieUpdateStrategy(item);
        app.updateQuality();
        assertEquals(4, app.item.sellIn);
        assertEquals(13, app.item.quality);
    }

    @Test
    void testUpdateQualityIfTenDaysOrLessRemaining() {
        Item item = new Item(AGED_BRIE_ITEM_NAME, 9, 10);
        AgedBrieUpdateStrategy app = new AgedBrieUpdateStrategy(item);
        app.updateQuality();
        assertEquals(8, app.item.sellIn);
        assertEquals(12, app.item.quality);
    }

    @Test
    void testUpdateQualityIfQualityIsFifty() {
        Item item = new Item(AGED_BRIE_ITEM_NAME, 3, 50) ;
        AgedBrieUpdateStrategy app = new AgedBrieUpdateStrategy(item);
        app.updateQuality();
        assertEquals(2, app.item.sellIn);
        assertEquals(50, app.item.quality);
    }

    @Test
    void testUpdateQualityIfQualityIsZero() {
        Item item = new Item(AGED_BRIE_ITEM_NAME, 0, 0);
        AgedBrieUpdateStrategy app = new AgedBrieUpdateStrategy(item);
        app.updateQuality();
        assertEquals(-1, app.item.sellIn);
        assertEquals(0, app.item.quality);
    }

}
