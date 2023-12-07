package com.gildedrose.updateStrategies;

import com.gildedrose.Constants;
import com.gildedrose.Item;
public class AgedBrieUpdateStrategy implements UpdateStrategy {
    Item item;

    public AgedBrieUpdateStrategy(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {
        if (item.quality < Constants.QUALITY_MAXIMUM_VALUE) { // Quality of an item is never more than 50
            // Quality increases by 1 when there are more than 10 days
            item.quality +=1 ;
            if(item.sellIn < 6) {
                // Quality increases by 2 when there are 10 days or less
                item.quality +=1 ;
            }
            if(item.sellIn < 11) {
                // Quality increases by 3 when there are 5 days or less
                item.quality +=1 ;
            } 
        }
        item.sellIn -= 1;
        if(item.sellIn < Constants.SELL_IN_DATE_PASSING_VALUE) {
            // Quality drops to 0 after the concert
            item.quality = Constants.QUALITY_MINIMUM_VALUE;
        } 
    }
}
