package de.kreidler.sarah.services;

import de.kreidler.sarah.domain.Mapping;
import de.kreidler.sarah.services.interfaces.FileDataLoader;

import java.util.List;


public class FileDataLoaderImpl implements FileDataLoader {

    private List<Mapping> mappings;

    @Override
    public List<Mapping> getMappings() {
        System.out.println("Load and Parse the Data from csv file search for java 8 example");
        return null;
    }
}
