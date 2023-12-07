package com.gildedrose.updateStrategies;

import com.gildedrose.Constants;
import com.gildedrose.Item;

public class ConjuredUpdateStrategy implements UpdateStrategy {
    Item item;

    public ConjuredUpdateStrategy(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {
        if (item.quality > 1) {
            // Degrade in quality twice as fast as normal items
            item.quality -= 2;
        } else item.quality = Constants.QUALITY_MINIMUM_VALUE;
        
        item.sellIn -= 1;
        
        if (item.sellIn < Constants.SELL_IN_DATE_PASSING_VALUE) {
            // Once the sell by date has passed, Quality degrades twice as fast
            if(item.quality > 1) {
                item.quality -= 2;
            } else item.quality = Constants.QUALITY_MINIMUM_VALUE; // Quality of an item is never negative
        }
    }
}
