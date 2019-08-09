package com.zhang.chapter35;

import com.zhang.chapter13.DoubleList;
import com.zhang.chapter33.RedBlackBST;

public class LRU<Key extends Comparable<Key>> {

    private DoubleList<Key> list;
    private RedBlackBST<Key, Integer> st;//无重复

    public LRU() {
        list = new DoubleList<>();
        st = new RedBlackBST<>();
    }

    public void access(Key key) {
        if (st.containts(key)) {
            list.deleteItem(key);
            list.addHead(key);
        } else {
            list.addHead(key);
        }
        for (int i = 0; i < list.size(); i++) {
            st.put(list.kth(i), i);
        }
    }

    public void delete(Key key) {
        if (!st.containts(key)) return;
        Key last = list.deleteTail();
        st.delete(last);
        while (!last.equals(key)) {
            last = list.deleteTail();
            st.delete(last);
        }
    }
}
