package com.zhang.chapter35;

import com.zhang.chapter34.LinearProbingHashST;

public class HashSET<Key> {
    private LinearProbingHashST<Key, Object> hashSet;

    public HashSET() {
        hashSet = new LinearProbingHashST<>(997);
    }

    public void add(Key key) {
        hashSet.put(key, 1);
    }

    public void delete(Key key) {
        hashSet.delete(key);
    }

    public boolean contains(Key key) {
        return hashSet.get(key) != null;
    }

    public boolean isEmpty() {
        return hashSet.size() == 0;
    }

    public int size() {
        return hashSet.size();
    }
}
