package com.zhang.chapter24;

public class MaxPQsortArray<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;
    public MaxPQsortArray(int maxN) {
        pq = (Key[]) new Comparable[maxN];
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key key) {
        int i = N - 1;
        for (; i >= 0; i--) {
            if (less(key, pq[i])) {
                pq[i + 1] = pq[i];
            } else {
                break;
            }
        }
        pq[i + 1] = key;
        N++;
    }

    public Key deleteMax() {
        Key key = pq[--N];
        pq[N] = null;
        return key;
    }



    public boolean less(Key k1, Key k2) {
        return k1.compareTo(k2) < 0;
    }

    public void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
}
