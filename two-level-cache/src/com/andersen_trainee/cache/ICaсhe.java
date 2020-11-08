package com.andersen_trainee.cache;

import java.io.IOException;

public interface ICaсhe<KeyType, ValueType> {

    void cache(KeyType key, ValueType value) throws IOException, ClassNotFoundException;

    ValueType getObject(KeyType key) throws IOException, ClassNotFoundException;

    void deleteObject(KeyType key);

    void clearCache();

    ValueType removeObject(KeyType key) throws IOException, ClassNotFoundException;

    boolean containsKey(KeyType key);

    int size();
}
