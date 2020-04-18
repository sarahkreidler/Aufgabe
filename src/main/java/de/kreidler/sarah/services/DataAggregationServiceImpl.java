package de.kreidler.sarah.services;

import de.kreidler.sarah.domain.AggData;
import de.kreidler.sarah.domain.Mapping;
import de.kreidler.sarah.domain.Price;
import de.kreidler.sarah.services.interfaces.DataAggregationService;

import java.util.List;

public class DataAggregationServiceImpl implements DataAggregationService {


    @Override
    public List<AggData> aggregateData(List<Mapping> mappings, List<Price> prices) {

        System.out.println("Aggreate Data Here");
        return null;
    }
}
