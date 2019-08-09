package com.zhang.chapter24;

import java.util.Iterator;

/**
 * 基于堆的优先队列
 */
public class MinPQ<Key extends Comparable<Key>> {
    private Key[] pq;//基于堆的完全二叉树
    private int N = 0;

    public MinPQ() {
        this(8);
    }

    public MinPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public MinPQ(Iterable<Key> iter) {
        this(8);
        for (Key key : iter) {
            insert(key);
        }
    }

    private void resize(int capacity) {
        Key[] temp = (Key[]) new Comparable[capacity];
        for (int i = 1; i <= N; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        if (N == pq.length - 1) resize(pq.length * 2);
        pq[++N] = v;
        swim(N);
    }

    public Key delMin() {
        Key min = pq[1];
        pq[1] = pq[N--];
        pq[N+1] = null;
        sink(1);
        if (N < pq.length / 4) resize(pq.length / 2);
        return min;
    }

    private boolean more(int i, int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }

    private boolean more(Key ki, Key kj) {
        return ki.compareTo(kj) > 0;
    }

    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private void swim(int k) {
        Key key = pq[k];
        while (k > 1 && more(pq[k / 2], key)) {
            pq[k] = pq[k / 2];
            k = k / 2;
        }
        pq[k] = key;
        /**while (k > 1 && more(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }**/
    }

    private void sink(int k) {
        Key key = pq[k];
        while (k * 2 <= N) {
            int j = k * 2;
            if (j < N && more(j, j + 1)) j++;
            if (!more(key, pq[j])) break;
            pq[k] = pq[j];
            k = j;
        }
        pq[k] = key;
        /**while (k * 2 <= N) {
            int j = k * 2;
            if (j < N && more(j, j + 1)) j++;
            if (!more(k, j)) break;
            exch(k, j);
            k = j;
        }**/
    }
}
