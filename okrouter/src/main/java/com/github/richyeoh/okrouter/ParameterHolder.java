package com.github.richyeoh.okrouter;

import android.support.v4.util.SparseArrayCompat;

public class ParameterHolder {
    private static SparseArrayCompat<TransferParameters> sParameter = new SparseArrayCompat<>();

    public static void put(int key, TransferParameters value) {
        sParameter.put(key, value);
    }

    public static TransferParameters get(int key) {
        return sParameter.get(key);
    }

    public static void remove(int key) {
        sParameter.remove(key);
    }
}
