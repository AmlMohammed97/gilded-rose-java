package com.gildedrose.updateStrategies;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.gildedrose.Constants;
import com.gildedrose.Item;

public class BackstagePassesUpdateStrategyTest {

    @Test
    void testUpdateQualityIfConcertPassed() {
        // GIVEN
        Item item = new Item(Constants.BACKSTAGE_PASSES_ITEM_NAME, 0, 10);
        // AND
        BackstagePassesUpdateStrategy backstagePassesUpdateStrategy = new BackstagePassesUpdateStrategy(item);
        
        // WHEN
        backstagePassesUpdateStrategy.updateQuality();
        
        // THEN
        assertEquals(-1, backstagePassesUpdateStrategy.item.sellIn);
        // AND
        assertEquals(0, backstagePassesUpdateStrategy.item.quality);
    }

    @Test
    void testUpdateQualityIfFiveDaysOrLessRemaining() {
        // GIVEN
        Item item = new Item(Constants.BACKSTAGE_PASSES_ITEM_NAME, 4, 10);
        // AND
        BackstagePassesUpdateStrategy backstagePassesUpdateStrategy = new BackstagePassesUpdateStrategy(item);

        // WHEN
        backstagePassesUpdateStrategy.updateQuality();

        // THEN
        assertEquals(3, backstagePassesUpdateStrategy.item.sellIn);
        // AND
        assertEquals(13, backstagePassesUpdateStrategy.item.quality);
    }
    
    @Test
    void testUpdateQualityIfTenDaysOrLessRemaining() {
        // GIVEN
        Item item = new Item(Constants.BACKSTAGE_PASSES_ITEM_NAME, 10, 10);
        // AND
        BackstagePassesUpdateStrategy backstagePassesUpdateStrategy = new BackstagePassesUpdateStrategy(item);

        // WHEN
        backstagePassesUpdateStrategy.updateQuality();

        // THEN
        assertEquals(9, backstagePassesUpdateStrategy.item.sellIn);
        // AND
        assertEquals(12, backstagePassesUpdateStrategy.item.quality);
    }
 
    @Test
    void testUpdateQualityIfQualityIsFifty() {
        // GIVEN
        Item item =  new Item(Constants.BACKSTAGE_PASSES_ITEM_NAME, 3, 50);
        // AND
        BackstagePassesUpdateStrategy backstagePassesUpdateStrategy = new BackstagePassesUpdateStrategy(item);

        // WHEN
        backstagePassesUpdateStrategy.updateQuality();

        // THEN
        assertEquals(2, backstagePassesUpdateStrategy.item.sellIn);
        // AND
        assertEquals(50, backstagePassesUpdateStrategy.item.quality);
    }

    @Test
    void testUpdateQualityIfQualityIsZero() {
        // GIVEN
        Item item = new Item(Constants.BACKSTAGE_PASSES_ITEM_NAME, 0, 0);
        // AND
        BackstagePassesUpdateStrategy backstagePassesUpdateStrategy = new BackstagePassesUpdateStrategy(item);

        // WHEN
        backstagePassesUpdateStrategy.updateQuality();

        // THEN
        assertEquals(-1, backstagePassesUpdateStrategy.item.sellIn);
        // AND
        assertEquals(0, backstagePassesUpdateStrategy.item.quality);
    }

}
