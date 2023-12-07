package com.gildedrose;

public class SulfurasUpdateStrategy implements Update {
    Item item;

    public SulfurasUpdateStrategy(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {}
}
