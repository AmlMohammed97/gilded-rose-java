package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SulfurasUpdateStrategyTest {

    @Test
    void testUpdateQuality() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 10, 10);
        SulfurasUpdateStrategy app = new SulfurasUpdateStrategy(item);
        app.updateQuality();
        assertEquals(10, app.item.sellIn);
        assertEquals(10, app.item.quality);
    }

}
