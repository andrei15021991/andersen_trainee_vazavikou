package com.andersen_trainee.cache;

import java.util.Comparator;
import java.util.Map;

public class ComparatorClass implements Comparator {

    Map base;


    public ComparatorClass(Map base) {
        this.base = base;
    }

    @Override
    public int compare(Object o1, Object o2) {
        if ((Integer) base.get(o1) < (Integer) base.get(o2)) {
            return 1;
        } else if ((Integer) base.get(o1) == (Integer) base.get(o2)) {
            return 1;
        } else {
            return -1;
        }
    }
}
