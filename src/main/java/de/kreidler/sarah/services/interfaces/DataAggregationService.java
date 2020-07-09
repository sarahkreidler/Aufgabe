package de.kreidler.sarah.services.interfaces;

import de.kreidler.sarah.domain.AggData;
import de.kreidler.sarah.domain.Mapping;
import de.kreidler.sarah.domain.Price;

import java.util.List;

public interface DataAggregationService {

    List<AggData> aggregateData(List<Mapping> mappings, List<Price> prices);
}
