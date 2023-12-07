package com.gildedrose;
import com.gildedrose.updateStrategies.AgedBrieUpdateStrategy;
import com.gildedrose.updateStrategies.BackstagePassesUpdateStrategy;
import com.gildedrose.updateStrategies.ConjuredUpdateStrategy;
import com.gildedrose.updateStrategies.NormalItemUpdateStrategy;
import com.gildedrose.updateStrategies.SulfurasUpdateStrategy;
import com.gildedrose.updateStrategies.UpdateStrategy;

public class StrategyFactory {
   public UpdateStrategy findUpdateStrategy(Item item) {
      if(item.name.contains("Aged")) return new AgedBrieUpdateStrategy(item);
      if(item.name.contains("Backstage")) return new BackstagePassesUpdateStrategy(item);
      if(item.name.contains("Sulfuras")) return new SulfurasUpdateStrategy(item);
      if(item.name.contains("Conjured")) return new ConjuredUpdateStrategy(item);
      return new NormalItemUpdateStrategy(item);
   }
}
