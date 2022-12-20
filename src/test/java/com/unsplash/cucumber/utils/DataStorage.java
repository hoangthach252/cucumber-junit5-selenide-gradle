package com.unsplash.cucumber.utils;

import ch.qos.logback.classic.Logger;

import org.slf4j.LoggerFactory;

import com.unsplash.cucumber.helper.CollectionHelper;

import java.util.ArrayList;
import java.util.List;

public class DataStorage {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(DataStorage.class);

    private final List<String> collectionNames;

    public DataStorage() {
        this.collectionNames = new ArrayList<>();
    }

    private List<String> getCollectionNames() {
        return this.collectionNames;
    }

    public void setCollectionNames(String collection) {
        this.collectionNames.add(collection);
    }

    private void cleanUpCollection() {
        for (String collectionName : getCollectionNames()) {
            boolean status = CollectionHelper.deleteCollectionById(CollectionHelper.getCollectionIdByName(collectionName));
            if (!status) {
                logger.warn("!!!!!!!!!!!!!!!!!!!!!!!!!! DELETE COLLECTION " + collectionName + " IS FAILED");
            }
            else {
                logger.info("!!!!!!!!!!!!!!!!!!!!!!!!!! DELETE COLLECTION " + collectionName + " IS SUCCESSFUL");
            }
        }
    }

    public void cleanUpAll() {
        cleanUpCollection();
    }

}
