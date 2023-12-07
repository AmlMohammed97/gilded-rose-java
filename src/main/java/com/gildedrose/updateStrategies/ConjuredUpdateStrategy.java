package com.gildedrose.updateStrategies;

import com.gildedrose.Item;

public class ConjuredUpdateStrategy implements UpdateStrategy {
    Item item;

    public ConjuredUpdateStrategy(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {
        item.sellIn -= 1;
        if (item.quality > 1 && item.sellIn >= 0) {
            item.quality -= 2;
        } else if (item.quality > 3 && item.sellIn < 0) {
            item.quality -= 4;
        } else item.quality = 0;
    }
}
