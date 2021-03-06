package com.zhang.chapter3.section35;

import com.zhang.chapter3.section33.RedBlackBST;

public class SET<Key extends Comparable<Key>> {
    RedBlackBST<Key, Object> set;

    public SET() {
        set = new RedBlackBST<>();
    }

    public void add(Key key) {
        set.put(key, '0');
    }

    public void delete(Key key) {
        set.delete(key);
    }

    public boolean containts(Key key) {
        return set.get(key) != null;
    }

    public boolean isEmpty() {
        return set.size() == 0;
    }

    public int size() {
        return set.size();
    }
}
