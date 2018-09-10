package com.github.richyeoh.okrouter;

import android.support.v4.util.SparseArrayCompat;

public class PublishHolder {
    private static SparseArrayCompat<ResultPublisher> sPublisher = new SparseArrayCompat<>();

    public static void put(int key, ResultPublisher value) {
        sPublisher.put(key, value);
    }

    public static ResultPublisher get(int key) {
        return sPublisher.get(key);
    }

    public static void remove(int key) {
        sPublisher.remove(key);
    }
}
