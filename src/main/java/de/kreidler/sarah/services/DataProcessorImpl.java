package de.kreidler.sarah.services;

import de.kreidler.sarah.dao.MarketDao;
import de.kreidler.sarah.domain.AggData;
import de.kreidler.sarah.domain.Mapping;
import de.kreidler.sarah.domain.Price;
import de.kreidler.sarah.services.interfaces.DataAggregationService;
import de.kreidler.sarah.services.interfaces.DataProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//@Service("dataProcessor")
public class DataProcessorImpl implements DataProcessor {

    @Autowired
    private FileDataLoaderImpl fileDataLoader;

    @Autowired
    private MarketDao dao;

    @Autowired
    DataAggregationService dataAggregationService;

    @Override
    public void process() {
        List<Mapping> fileMappings = fileDataLoader.getMappings();
        fileMappings = List.of( new Mapping("isin1", "tradeid1"));
        //SK: commented out
        //dao.save(fileMappings);
        //List<Mapping> dbMappings = dao.getMappings();
        //List<Price> dbPrices = null;
        List<Mapping> dbMappings = dao.save(fileDataLoader.getMappings());
        List<Price> dbPrices = dao.savePrice(fileDataLoader.getPrices());

        List<AggData> aggData = dataAggregationService.aggregateData(dbMappings, dbPrices);

        //dataExportService.exportData(dbAggData)

    }
}
