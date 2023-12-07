package com.gildedrose.updateStrategies;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.gildedrose.Constants;
import com.gildedrose.Item;

public class SulfurasUpdateStrategyTest {

    @Test
    void testUpdateQuality() {
        Item item = new Item(Constants.SULFURAS_ITEM_NAME, 10, 80);
        SulfurasUpdateStrategy app = new SulfurasUpdateStrategy(item);
        app.updateQuality();
        assertEquals(10, app.item.sellIn);
        assertEquals(80, app.item.quality);
    }

}
