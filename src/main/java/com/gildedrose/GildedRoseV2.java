package com.gildedrose;

import com.gildedrose.updateStrategies.UpdateStrategy;

public class GildedRoseV2 {
    UpdateStrategy updateStrategy;

    public GildedRoseV2(UpdateStrategy updateStrategy) {
        this.updateStrategy = updateStrategy;
    }

    public void updateQuality() {
        updateStrategy.updateQuality();
    }
}
