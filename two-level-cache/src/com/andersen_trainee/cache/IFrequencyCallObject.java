package com.andersen_trainee.cache;

import java.util.Set;

public interface IFrequencyCallObject<KeyType> {

    Set<KeyType> getMostFrequentlyUsedKeys();

    int getFrequencyOfCallingObject(KeyType key);
}
