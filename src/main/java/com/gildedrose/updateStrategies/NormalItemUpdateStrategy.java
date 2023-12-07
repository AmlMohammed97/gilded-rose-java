package com.gildedrose.updateStrategies;

import com.gildedrose.Constants;
import com.gildedrose.Item;

public class NormalItemUpdateStrategy implements UpdateStrategy {
    Item item;

    public NormalItemUpdateStrategy(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {
        // At the end of each day our system lowers both values for every item
        if (item.quality > Constants.QUALITY_MINIMUM_VALUE) {
            item.quality -= 1;
        }
        item.sellIn -= 1;
        // Once the sell by date has passed, Quality degrades twice as fast
        if (item.quality > Constants.QUALITY_MINIMUM_VALUE && item.sellIn < Constants.SELL_IN_DATE_PASSING_VALUE) {
            item.quality -= 1;
        }
    }
}
