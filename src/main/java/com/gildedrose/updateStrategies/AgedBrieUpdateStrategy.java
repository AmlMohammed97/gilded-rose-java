package com.gildedrose.updateStrategies;

import com.gildedrose.Item;
import com.gildedrose.StrategyType;

public class AgedBrieUpdateStrategy implements UpdateStrategy {
    Item item;

    public AgedBrieUpdateStrategy(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {
        item.sellIn -= 1;
        if(item.sellIn < 0) {
            item.quality = 0;
        } else if (item.quality < 50) {
            if(item.sellIn <= 5) {
                item.quality +=3 ;
            } else if(item.sellIn <= 10) {
                item.quality +=2 ;
            }
        }
    }

    @Override
    public StrategyType getStrategyType() {
        return StrategyType.AGED_BRIE;
    }
    
}
