package com.gildedrose;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.gildedrose.updateStrategies.UpdateStrategy;

public class StrategyFactory {
    private Map<StrategyType, UpdateStrategy> strategies = new HashMap<StrategyType, UpdateStrategy>();
  
  public StrategyFactory(Set<UpdateStrategy> updateStrategy) {
     createStrategy(updateStrategy);
  }
  
  public UpdateStrategy findUpdateStrategy(StrategyType strategyType) {
     return strategies.get(strategyType);
  }
  private void createStrategy(Set<UpdateStrategy> updateStrategy) {
      updateStrategy.forEach( 
   strategy ->strategies.put(strategy.getStrategyType(), strategy));
 }
}
