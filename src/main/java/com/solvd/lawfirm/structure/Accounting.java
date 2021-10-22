package com.solvd.lawfirm.structure;

import com.solvd.lawfirm.people.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Accounting<E> {

    private static final Logger LOGGER = LogManager.getLogger(Client.class);

    private List<E> collection;

    public void print(List<E> collection) {
        for (E element : collection) {
            LOGGER.info(element);
        }
    }

    public int count(List<E> collection) {
        return collection.size();
    }

    public List<E> getCollection() {
        return collection;
    }

    public void setCollection(List<E> collection) {
        this.collection = collection;
    }
}
