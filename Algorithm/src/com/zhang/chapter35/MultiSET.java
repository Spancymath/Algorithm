package com.zhang.chapter35;

import com.zhang.chapter33.RedBlackBST;

/**
 * 允许重复值存在的集合
 * 注：由于红黑树在10题中实现了重复值处理，所以不必改这里的代码
 * @param <Key>
 */
public class MultiSET<Key extends Comparable<Key>> {
    RedBlackBST<Key, Object> set;

    public MultiSET() {
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
