package com.gildedrose.updateStrategies;

import com.gildedrose.Item;

public class SulfurasUpdateStrategy implements UpdateStrategy {
    Item item;

    public SulfurasUpdateStrategy(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {}
}
