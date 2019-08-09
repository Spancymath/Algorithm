package com.zhang.chapter34;

import com.zhang.chapter13.Queue;

/**
 * 基于线性探测的符号表
 */
public class LinearProbingHashST<Key, Value> {
    private int N;//键值对的总数
    private int M = 16;//线性探测表的大小
    private Key[] keys;//键
    private Value[] vals;//值

    public LinearProbingHashST(int M) {
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
        this.M = M;
    }

    public int size() {
        return N;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int M) {
        //错误的写法
        /*this.M = M;

        Key[] oldKeys = keys;
        Value[] oldVals = vals;

        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];

        for (int i = 0; i < M; i++) {
            keys[i] = oldKeys[i];
            vals[i] = oldVals[i];
        }*/
        LinearProbingHashST<Key, Value> t;
        t = new LinearProbingHashST<>(M);
        for (int i = 0; i < this.M; i++) {
            if (keys[i] != null) {
                t.put(keys[i], vals[i]);
            }
        }
        keys = t.keys;
        vals = t.vals;
        this.M = t.M;
    }

    public void put(Key key, Value val) {
        if (N >= M / 2) resize(M * 2);

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            //允许重复的键
            /*if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }*/
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) return vals[i];
        }
        return null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void delete(Key key) {
        if (!contains(key)) return;

        int i = hash(key);

        //支持插入重复的键
        int hashi = i;
        for (;; i = (i + 1) % M) {
            if (keys[i] == null) break;
            if (key.equals(keys[i])) {
                keys[i] = null;
                vals[i] = null;
            }
        }
        boolean backFlag = false;
        for (i = hashi; ; i = (i + 1) % M) {
            if (keys[i] == null) continue;
            if (hash(keys[i]) != hash(key)) break;
            if (backFlag && i == hashi) break;
            Key keyToRedo = keys[i];
            Value valueRedo = vals[i];
            keys[i] = null;
            vals[i] = null;
            N--;
            put(keyToRedo, valueRedo);
            if (i + 1 == M) backFlag = true;
        }

        /*while (!key.equals(keys[i])) {
            i = (i + 1) % M;
        }
        keys[i] = null;
        vals[i] = null;
        i = (i + 1) % M;
        while (keys[i] != null) {
            Key keyToRedo = keys[i];
            Value valToRedo = vals[i];
            keys[i] = null;
            vals[i] = null;
            N--;
            put(keyToRedo, valToRedo);
            i = (i + 1) % M;
        }*/

        N--;
        if (N > 0 && N == M / 8) resize(M / 2);
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) queue.enqueue(keys[i]);
        }
        return queue;
    }
}
