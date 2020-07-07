package de.kreidler.sarah.services.interfaces;

import de.kreidler.sarah.domain.Mapping;
import de.kreidler.sarah.domain.Price;

import java.util.List;

public interface FileDataLoader {

    List<Mapping> getMappings();
    List<Price> getPrices();
}
