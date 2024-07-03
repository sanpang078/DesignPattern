package com.sanpang.behavior.strategy;

import java.util.HashMap;

public class SortAlgFactory {
    private static final HashMap<String, ISortAlg> algs = new HashMap<String, ISortAlg>();

    static {
        algs.put("QuickSort", new QuickSort());
        algs.put("ExternalSort", new ExternalSort());
        algs.put("ConcurrentExternalSort", new ConcurrentExternalSort());
        algs.put("MapreduceSort", new MapreduceSort());
    }

    public static ISortAlg getSortAlg(String type){
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty.");
        }
        return algs.get(type);
    }
}
