package com.gildedrose;

public class NormalItemUpdateStrategy implements Update {
    Item item;

    public NormalItemUpdateStrategy(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {
        item.sellIn -= 1;
        if (item.quality > 0) {
            item.quality -= 1;
        }
        if (item.quality > 0 && item.sellIn < 0) {
            item.quality -= 1;
        }
    }
}
