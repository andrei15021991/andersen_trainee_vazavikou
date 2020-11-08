package com.andersen_trainee.cache;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

public class RamCacheClass<KeyType, ValueType> implements ICaсhe<KeyType, ValueType>, IFrequencyCallObject<KeyType> {

    private HashMap<KeyType, ValueType> hashMap;
    private TreeMap<KeyType, Integer> frequencyMap;

    public RamCacheClass() {
        hashMap = new HashMap<KeyType, ValueType>();
        frequencyMap = new TreeMap<KeyType, Integer>();
    }

    @Override
    public void cache(KeyType key, ValueType value) {
        frequencyMap.put(key, 1);
        hashMap.put(key, value);
    }

    @Override
    public ValueType getObject(KeyType key) {
        if (hashMap.containsKey(key)) {
            int frequency = frequencyMap.get(key);
            frequencyMap.put(key, ++frequency);
            return hashMap.get(key);
        }


        return null;
    }

    @Override
    public void deleteObject(KeyType key) {
        if (hashMap.containsKey(key)) {
            hashMap.remove(key);
            frequencyMap.remove(key);
        }
    }

    @Override
    public void clearCache() {
        hashMap.clear();
        frequencyMap.clear();
    }

    @Override
    public ValueType removeObject(KeyType key) {
        if (hashMap.containsKey(key)) {
            ValueType result = this.getObject(key);
            this.deleteObject(key);
            return result;
        }
        return null;
    }

    @Override
    public boolean containsKey(KeyType key) {
        return hashMap.containsKey(key);
    }

    @Override
    public int size() {
        return hashMap.size();
    }

    @Override
    public Set<KeyType> getMostFrequentlyUsedKeys() {
        ComparatorClass comparator = new ComparatorClass(frequencyMap);
        TreeMap<KeyType, Integer> sorted = new TreeMap(comparator);
        sorted.putAll(frequencyMap);
        return sorted.keySet();
    }

    @Override
    public int getFrequencyOfCallingObject(KeyType key) {
        if (hashMap.containsKey(key)) {
            return frequencyMap.get(key);
        }
        return 0;
    }
}
