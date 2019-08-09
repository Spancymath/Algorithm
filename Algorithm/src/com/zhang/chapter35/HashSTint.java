package com.zhang.chapter35;

import com.zhang.chapter13.Queue;

public class HashSTint {
    private int N;//键值对的总数
    private int M = 16;//线性探测表的大小
    private Integer[] keys;//键
    private Integer[] vals;//值

    public HashSTint(int M) {
        keys =  new Integer[M];
        vals = new Integer[M];
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
        HashSTint t;
        t = new HashSTint(M);
        for (int i = 0; i < this.M; i++) {
            if (keys[i] != null) {
                t.put(keys[i], vals[i]);
            }
        }
        keys = t.keys;
        vals = t.vals;
        this.M = t.M;
    }

    public void put(Integer key, Integer val) {
        if (N >= M / 2) resize(M * 2);

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Integer get(Integer key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) return vals[i];
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
        vals[i] = null;
        i = (i + 1) % M;
        while (keys[i] != null) {
            Integer keyToRedo = keys[i];
            Integer valToRedo = vals[i];
            keys[i] = null;
            vals[i] = null;
            N--;
            put(keyToRedo, valToRedo);
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
