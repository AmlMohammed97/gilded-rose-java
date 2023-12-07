package com.gildedrose.updateStrategies;

import com.gildedrose.Constants;
import com.gildedrose.Item;

public class BackstagePassesUpdateStrategy implements UpdateStrategy {
    Item item;

    public BackstagePassesUpdateStrategy(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {
        item.sellIn -= 1;

        if(item.sellIn < Constants.SELL_IN_DATE_PASSING_VALUE) {
            // Quality drops to 0 after the concert
            item.quality = Constants.QUALITY_MINIMUM_VALUE;
        } else if (item.quality < Constants.QUALITY_MAXIMUM_VALUE) { // The Quality of an item is never more than 50
            if(item.sellIn <= 5) {
                // Quality increases by 3 when there are 5 days or less
                item.quality +=3 ;
            } else if(item.sellIn <= 10) {
                // Quality increases by 2 when there are 10 days or less
                item.quality +=2 ;
            }
        }
    }
}
