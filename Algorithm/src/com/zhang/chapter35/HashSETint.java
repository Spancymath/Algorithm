package com.zhang.chapter35;

import com.zhang.chapter13.Queue;

import javax.swing.*;

public class HashSETint {
    private int N;//键值对的总数
    private int M = 16;//线性探测表的大小
    private Integer[] keys;//键

    public HashSETint(int M) {
        keys =  new Integer[M];
        this.M = M;
    }

    public int size() {
        return N;
    }

    private int hash(Integer key) {
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
        HashSETint t;
        t = new HashSETint(M);
        for (int i = 0; i < this.M; i++) {
            if (keys[i] != null) {
                t.add(keys[i]);
            }
        }
        keys = t.keys;
        this.M = t.M;
    }

    public void add(Integer key) {
        if (N >= M / 2) resize(M * 2);

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                return;
            }
        }
        keys[i] = key;
        N++;
    }

    public Integer get(Integer key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) return keys[i];
        }
        return null;
    }

    public boolean contains(Integer key) {
        return get(key) != null;
    }

    public void delete(Integer key) {
        if (!contains(key)) return;

        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % M;
        }
        keys[i] = null;
        i = (i + 1) % M;
        while (keys[i] != null) {
            Integer keyToRedo = keys[i];
            keys[i] = null;
            N--;
            add(keyToRedo);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && N == M / 8) resize(M / 2);
    }

    public Iterable<Integer> keys() {
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) queue.enqueue(keys[i]);
        }
        return queue;
    }
}
