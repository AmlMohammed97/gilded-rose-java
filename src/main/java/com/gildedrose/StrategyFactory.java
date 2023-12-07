package com.gildedrose;
import com.gildedrose.updateStrategies.AgedBrieUpdateStrategy;
import com.gildedrose.updateStrategies.BackstagePassesUpdateStrategy;
import com.gildedrose.updateStrategies.ConjuredUpdateStrategy;
import com.gildedrose.updateStrategies.NormalItemUpdateStrategy;
import com.gildedrose.updateStrategies.SulfurasUpdateStrategy;
import com.gildedrose.updateStrategies.UpdateStrategy;

public class StrategyFactory {
   
   public UpdateStrategy findUpdateStrategy(Item item) {
      if(item.name.equals(Constants.AGED_BRIE_ITEM_NAME)) return new AgedBrieUpdateStrategy(item);
      if(item.name.equals(Constants.BACKSTAGE_PASSES_ITEM_NAME)) return new BackstagePassesUpdateStrategy(item);
      if(item.name.equals(Constants.SULFURAS_ITEM_NAME)) return new SulfurasUpdateStrategy(item);
      if(item.name.equals(Constants.CONJURED_ITEM_NAME)) return new ConjuredUpdateStrategy(item);
      return new NormalItemUpdateStrategy(item);
   }
}
