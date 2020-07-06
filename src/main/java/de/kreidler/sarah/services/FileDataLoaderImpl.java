package de.kreidler.sarah.services;

import de.kreidler.sarah.domain.Mapping;
import de.kreidler.sarah.domain.Price;
import de.kreidler.sarah.services.interfaces.FileDataLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;


public class FileDataLoaderImpl implements FileDataLoader {

    private List<Mapping> mappings;
    private List<Price> prices;

    @Override
    public List<Mapping> getMappings() {
        String fileName = "c://mapping.csv";
        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Price> getPrices() {
        String fileNamePrice = "c://prices.csv";
        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileNamePrice))) {

            stream.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
