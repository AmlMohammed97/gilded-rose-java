package com.gildedrose;

public class GildedRoseV2 {
    StrategyFactory strategyFactory;
    Item[] items;

    public GildedRoseV2(StrategyFactory strategyFactory, Item[] items) {
        this.strategyFactory = strategyFactory;
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            strategyFactory.findUpdateStrategy(items[i]).updateQuality();
        }
    }
}
