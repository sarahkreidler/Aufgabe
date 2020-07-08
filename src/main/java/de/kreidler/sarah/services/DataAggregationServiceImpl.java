package de.kreidler.sarah.services;

import de.kreidler.sarah.domain.AggData;
import de.kreidler.sarah.domain.Mapping;
import de.kreidler.sarah.domain.Price;
import de.kreidler.sarah.services.interfaces.DataAggregationService;

import java.security.Key;
import java.util.*;

public class DataAggregationServiceImpl implements DataAggregationService {


    @Override
    public List<AggData> aggregateData(List<Mapping> mappings, List<Price> prices) {

        Map<Mapping, List<Price>> mappingPriceMap = new HashMap<Mapping, List<Price>>();
        for (Mapping mappingObj : mappings) {
            List<Price> pricesPerIsin = new ArrayList<>();
            for (Price elem : prices) {
                if (elem.getisin().equals(mappingObj.getisin())) {
                    pricesPerIsin.add(elem);
                }
            }

            mappingPriceMap.put(mappingObj, pricesPerIsin);
        }
            System.out.println(mappingPriceMap.values());
            for (Map.Entry pairEntry : mappingPriceMap.entrySet()) {
                List<Price> priceSorted = new ArrayList<Price>((Collection<? extends Price>) pairEntry.getValue());
                Collections.sort(priceSorted);

                int i = 0;
                for (Price temp : priceSorted) {
                    int j = ++i;
                    if (j == 1) {
                        System.out.println(temp.getisin() + ": " + "MIN_PREIS = " + temp.getPrice());
                    }
                }
            }
        return null;
    }
}