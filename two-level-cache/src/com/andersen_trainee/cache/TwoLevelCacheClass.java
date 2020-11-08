package com.andersen_trainee.cache;

import java.io.IOException;
import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

public class TwoLevelCacheClass<KeyType, ValueType extends Serializable> extends Object implements ILeveledCache<KeyType, ValueType> {

    RamCacheClass<KeyType, ValueType> ramCache;
    MemoryCacheClass<KeyType, ValueType> memoryCache;
    int maxRamCacheCapacity;
    int numberOfRequests;
    int numberOfRequestsForRecahce;

    public TwoLevelCacheClass(int _maxRamCacheCapacity, int _numberOfRequestsForRecache) {
        maxRamCacheCapacity = _maxRamCacheCapacity;
        numberOfRequestsForRecahce = _numberOfRequestsForRecache;
        ramCache = new RamCacheClass<KeyType, ValueType>();
        memoryCache = new MemoryCacheClass<KeyType, ValueType>();
        numberOfRequests = 0;
    }


    @Override
    public void cache(KeyType key, ValueType value) throws IOException, ClassNotFoundException {
        ramCache.cache(key, value);
    }


    @Override
    public ValueType getObject(KeyType key) throws IOException, ClassNotFoundException {
        if (ramCache.containsKey(key)) {
            numberOfRequests++;
            if (numberOfRequests > numberOfRequestsForRecahce) {
                this.recache();
                numberOfRequests = 0;
            }
            return ramCache.getObject(key);
        }
        if (memoryCache.containsKey(key)) {
            numberOfRequests++;
            if (numberOfRequests > numberOfRequestsForRecahce) {
                this.recache();
                numberOfRequests = 0;
            }
            return memoryCache.getObject(key);
        }
        return null;
    }


    @Override
    public void deleteObject(KeyType key) {
        if (ramCache.containsKey(key)) {
            ramCache.deleteObject(key);
        }
        if (memoryCache.containsKey(key)) {
            memoryCache.deleteObject(key);
        }
    }


    @Override
    public void clearCache() {
        memoryCache.clearCache();
        ramCache.clearCache();
    }


    @Override
    public ValueType removeObject(KeyType key) throws IOException, ClassNotFoundException {
        if (ramCache.containsKey(key)) {
            return ramCache.removeObject(key);
        }
        if (memoryCache.containsKey(key)) {
            return memoryCache.removeObject(key);
        }
        return null;
    }


    @Override
    public boolean containsKey(KeyType key) {
        if (ramCache.containsKey(key)) {
            return true;
        }
        if (memoryCache.containsKey(key)) {
            return true;
        }
        return false;
    }


    @Override
    public int size() {
        return ramCache.size() + memoryCache.size();
    }


    @Override
    public void recache() throws IOException, ClassNotFoundException {
        TreeSet<KeyType> ramKeySet = new TreeSet<KeyType>(ramCache.getMostFrequentlyUsedKeys());
        int boundFrequency = 0;


        // вычисление среднего арифметического для отбрасывания редко вызываемых объектов
        for (KeyType key : ramKeySet) {
            boundFrequency += ramCache.getFrequencyOfCallingObject(key);
        }
        boundFrequency /= ramKeySet.size();


        for (KeyType key : ramKeySet) {
            if (ramCache.getFrequencyOfCallingObject(key) <= boundFrequency) {
                memoryCache.cache(key, ramCache.removeObject(key));
            }
        }

        TreeSet<KeyType> memoryKeySet = new TreeSet<KeyType>(memoryCache.getMostFrequentlyUsedKeys());
        for (KeyType key : memoryKeySet) {
            try {
                if (memoryCache.getFrequencyOfCallingObject(key) > boundFrequency) {
                    ramCache.cache(key, memoryCache.removeObject(key));
                }
            } catch (IOException ex) {
                memoryCache.deleteObject(key);
                continue;
            } catch (ClassNotFoundException ex) {
                // simply dummy
                continue;
            }
        }
    }


    @Override
    public Set<KeyType> getMostFrequentlyUsedKeys() {
        TreeSet<KeyType> set = new TreeSet<KeyType>(ramCache.getMostFrequentlyUsedKeys());
        set.addAll(memoryCache.getMostFrequentlyUsedKeys());
        return set;
    }


    @Override
    public int getFrequencyOfCallingObject(KeyType key) {
        if (ramCache.containsKey(key)) {
            return ramCache.getFrequencyOfCallingObject(key);
        }
        if (memoryCache.containsKey(key)) {
            return memoryCache.getFrequencyOfCallingObject(key);
        }
        return 0;
    }
}
