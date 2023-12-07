package com.gildedrose.updateStrategies;

import com.gildedrose.Item;
import com.gildedrose.StrategyType;

public class SulfurasUpdateStrategy implements UpdateStrategy {
    Item item;

    public SulfurasUpdateStrategy(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {}

    @Override
    public StrategyType getStrategyType() {
        return StrategyType.SULFURAS;

    }
}
