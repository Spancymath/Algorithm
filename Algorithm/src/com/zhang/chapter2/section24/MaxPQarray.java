package com.zhang.chapter2.section24;

public class MaxPQarray<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;
    public MaxPQarray(int maxN) {
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
        pq[N++] = key;
    }

    public Key deleteMax() {
        int t = 0;
        for (int i = 1; i < N; i++) {
            if (less(pq[t], pq[i])) {
                t = i;
            }
        }
        Key key = pq[t];
        exch(t, N - 1);
        pq[t] = null;
        N--;
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
