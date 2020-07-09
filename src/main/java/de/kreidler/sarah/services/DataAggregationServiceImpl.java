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
                List<AggData> aggData = new ArrayList<>();

                int i = 0;
                int sum = 0;
                for (Price temp : priceSorted) {

                    int j = ++i;

                    sum = sum + temp.getPrice();

                    if (j == 1) {
                        System.out.println(temp.getisin() + ": " + "MIN_PREIS = " + temp.getPrice());
                        //SK: wie kann ich die TradeId befüllen? Über pairEntry.getKey()?
                    //aggData.add(new AggData(pairEntry.getKey(), temp.getisin(), temp.getPrice()));
                        aggData.add(new AggData("MIN", temp.getisin(), temp.getPrice()));

                    }
                    if (j == priceSorted.size()) {
                        System.out.println(temp.getisin() + ": " + "MAX_PREIS = " + temp.getPrice());
                        aggData.add(new AggData("MAX", temp.getisin(), temp.getPrice()));

                    }
                }
                if (priceSorted.size() != 0){
                    System.out.println(" MEAN = " + sum / priceSorted.size());
                int mean = sum / priceSorted.size();
                    //SK: wie kann ich die ISIN befüllen über pairEntry.getKeys()/getValues()?
                    aggData.add(new AggData("MEAN", "", mean));
                }
            }
        return null;
    }
}