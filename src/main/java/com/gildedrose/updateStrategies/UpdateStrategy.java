package com.gildedrose.updateStrategies;

import com.gildedrose.StrategyType;

public interface UpdateStrategy {
    public void updateQuality();
    StrategyType getStrategyType();
}
