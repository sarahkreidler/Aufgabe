package de.kreidler.sarah.services;

import de.kreidler.sarah.domain.Mapping;
import de.kreidler.sarah.domain.Price;
import de.kreidler.sarah.services.interfaces.FileDataLoader;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileDataLoaderImpl implements FileDataLoader {

    private List<Mapping> mappings;
    private List<Price> prices;

    @Override
    public List<Mapping> getMappings() {

        String fileName = "c://mapping.csv";
        //SK: skip header
        try (Stream<String> stream = Files.lines(Paths.get(fileName)).skip(1)) {
            List<String> mappingStrings = stream.collect(Collectors.toList());
            System.out.println(mappingStrings);

            List<Mapping> result = new ArrayList<>();
            for(String mappingLine: mappingStrings) {
                String [] columns = mappingLine.split(";");
                String firstelement = columns[0];
                String secondelement = columns[1];

                Mapping mapping = new Mapping(firstelement,secondelement);
                result.add(mapping);}

            return result;

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return mappings;
    }

    @Override
    public List<Price> getPrices() {
        String fileNamePrice = "c://prices.csv";

        List<Price> prices = new ArrayList<Price>();
        try (Stream<String> stream = Files.lines(Paths.get(fileNamePrice)).skip(1)) {

            List<String> priceStrings = stream.collect(Collectors.toList());
            System.out.println(priceStrings);

            List<Price> result = new ArrayList<>();
            for(String priceLine: priceStrings) {
                String [] columns = priceLine.split(";");
                String firstelement = columns[0];
                String secondelement = columns[1];
                String thirdelement = columns[2];

                int thirdelementAsInt  = (Integer.parseInt( thirdelement ));

                Price price = new Price(firstelement,secondelement,thirdelementAsInt);
                result.add(price);
            }
            return result;

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return prices;
    }

}
