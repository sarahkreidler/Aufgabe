package com.programcreek.helloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;


public class MappingItemProcessor implements ItemProcessor<Mapping, Mapping>{

        private static final Logger log = LoggerFactory.getLogger(MappingItemProcessor.class);

        @Override
        public Mapping process(final Mapping mapping) throws Exception {
            final String isin = mapping.getisin().toUpperCase();
            final String tradeid = mapping.gettradeid().toUpperCase();

            final Mapping transformedMapping = new Mapping(isin, tradeid);

            log.info("Converting (" + mapping + ") into (" + transformedMapping + ")");

            return transformedMapping;
        }

    }