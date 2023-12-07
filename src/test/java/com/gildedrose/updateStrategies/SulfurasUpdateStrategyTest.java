package com.gildedrose.updateStrategies;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.gildedrose.Constants;
import com.gildedrose.Item;

public class SulfurasUpdateStrategyTest {

    @Test
    void testUpdateQuality() {
        // GIVEN
        Item item = new Item(Constants.SULFURAS_ITEM_NAME, 10, 80);
        // AND
        SulfurasUpdateStrategy sulfurasUpdateStrategy = new SulfurasUpdateStrategy(item);

        // WHEN
        sulfurasUpdateStrategy.updateQuality();

        // THEN
        assertEquals(10, sulfurasUpdateStrategy.item.sellIn);
        // AND
        assertEquals(80, sulfurasUpdateStrategy.item.quality);
    }

}
