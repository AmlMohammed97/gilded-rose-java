package com.gildedrose.updateStrategies;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.gildedrose.Constants;
import com.gildedrose.Item;

public class AgedBrieUpdateStrategyTest {

    @Test
    void testUpdateQualityIfConcertPassed() {
        // GIVEN
        Item item = new Item(Constants.AGED_BRIE_ITEM_NAME, 0, 10);
        // AND
        AgedBrieUpdateStrategy agedBrieUpdateStrategy = new AgedBrieUpdateStrategy(item);

        // WHEN
        agedBrieUpdateStrategy.updateQuality();

        // THEN
        assertEquals(-1, agedBrieUpdateStrategy.item.sellIn);
        // AND
        assertEquals(0, agedBrieUpdateStrategy.item.quality);
    }
    
    @Test
    void testUpdateQualityIfFiveDaysOrLessRemaining() {
        // GIVEN
        Item item = new Item(Constants.AGED_BRIE_ITEM_NAME, 5, 10);
        // AND
        AgedBrieUpdateStrategy agedBrieUpdateStrategy = new AgedBrieUpdateStrategy(item);

        // WHEN
        agedBrieUpdateStrategy.updateQuality();

        // THEN
        assertEquals(4, agedBrieUpdateStrategy.item.sellIn);
        // AND
        assertEquals(13, agedBrieUpdateStrategy.item.quality);
    }

    @Test
    void testUpdateQualityIfTenDaysOrLessRemaining() {
        // GIVEN
        Item item = new Item(Constants.AGED_BRIE_ITEM_NAME, 9, 10);
        // AND
        AgedBrieUpdateStrategy agedBrieUpdateStrategy = new AgedBrieUpdateStrategy(item);

        // WHEN
        agedBrieUpdateStrategy.updateQuality();
        
        // THEN
        assertEquals(8, agedBrieUpdateStrategy.item.sellIn);
        // AND
        assertEquals(12, agedBrieUpdateStrategy.item.quality);
    }

    @Test
    void testUpdateQualityIfMoreThanTenDaysRemaining() {
        // GIVEN
        Item item = new Item(Constants.AGED_BRIE_ITEM_NAME, 11, 10);
        // AND
        AgedBrieUpdateStrategy agedBrieUpdateStrategy = new AgedBrieUpdateStrategy(item);

        // WHEN
        agedBrieUpdateStrategy.updateQuality();
        
        // THEN
        assertEquals(10, agedBrieUpdateStrategy.item.sellIn);
        // AND
        assertEquals(11, agedBrieUpdateStrategy.item.quality);
    }

    @Test
    void testUpdateQualityIfQualityIsFifty() {
        // GIVEN
        Item item = new Item(Constants.AGED_BRIE_ITEM_NAME, 3, 50);
        // AND
        AgedBrieUpdateStrategy agedBrieUpdateStrategy = new AgedBrieUpdateStrategy(item);

        // WHEN
        agedBrieUpdateStrategy.updateQuality();

        // THEN
        assertEquals(2, agedBrieUpdateStrategy.item.sellIn);
        // AND
        assertEquals(50, agedBrieUpdateStrategy.item.quality);
    }

    @Test
    void testUpdateQualityIfQualityIsZero() {
        // GIVEN
        Item item = new Item(Constants.AGED_BRIE_ITEM_NAME, 0, 0);
        // AND
        AgedBrieUpdateStrategy agedBrieUpdateStrategy = new AgedBrieUpdateStrategy(item);

        // WHEN
        agedBrieUpdateStrategy.updateQuality();

        // THEN
        assertEquals(-1, agedBrieUpdateStrategy.item.sellIn);
        // AND
        assertEquals(0, agedBrieUpdateStrategy.item.quality);
    }

}
