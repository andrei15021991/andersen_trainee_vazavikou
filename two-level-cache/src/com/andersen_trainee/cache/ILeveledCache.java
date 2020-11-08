package com.andersen_trainee.cache;

import java.io.IOException;

public interface ILeveledCache<KeyType, ValueType> extends ICaсhe<KeyType, ValueType>, IFrequencyCallObject<KeyType> {

    void recache() throws IOException, ClassNotFoundException;

}
