package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BackstagePassesUpdateStrategyTest {

    String BACKSTAGES_PASSES_ITEM_NAME = "Backstage passes to a TAFKAL80ETC concert";

    @Test
    void testUpdateQualityIfConcertPassed() {
        Item item = new Item(BACKSTAGES_PASSES_ITEM_NAME, 0, 10);
        BackstagePassesUpdateStrategy app = new BackstagePassesUpdateStrategy(item);
        app.updateQuality();
        assertEquals(-1, app.item.sellIn);
        assertEquals(0, app.item.quality);
    }

    @Test
    void testUpdateQualityIfFiveDaysOrLessRemaining() {
        Item item = new Item(BACKSTAGES_PASSES_ITEM_NAME, 4, 10);
        BackstagePassesUpdateStrategy app = new BackstagePassesUpdateStrategy(item);
        app.updateQuality();
        assertEquals(3, app.item.sellIn);
        assertEquals(13, app.item.quality);
    }
    
    @Test
    void testUpdateQualityIfTenDaysOrLessRemaining() {
        Item item = new Item(BACKSTAGES_PASSES_ITEM_NAME, 10, 10);
        BackstagePassesUpdateStrategy app = new BackstagePassesUpdateStrategy(item);
        app.updateQuality();
        assertEquals(9, app.item.sellIn);
        assertEquals(12, app.item.quality);
    }
 
    @Test
    void testUpdateQualityIfQualityIsFifty() {
        Item item =  new Item(BACKSTAGES_PASSES_ITEM_NAME, 3, 50);
        BackstagePassesUpdateStrategy app = new BackstagePassesUpdateStrategy(item);
        app.updateQuality();
        assertEquals(2, app.item.sellIn);
        assertEquals(50, app.item.quality);
    }

    @Test
    void testUpdateQualityIfQualityIsZero() {
        Item item = new Item(BACKSTAGES_PASSES_ITEM_NAME, 0, 0);
        BackstagePassesUpdateStrategy app = new BackstagePassesUpdateStrategy(item);
        app.updateQuality();
        assertEquals(-1, app.item.sellIn);
        assertEquals(0, app.item.quality);
    }

}
