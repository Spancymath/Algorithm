package com.zhang.chapter2.section24;

/**
 * 索引优先队列
 * 见表2.4.5
 * @param <Key>
 */
public class IndexMinPQ<Key extends Comparable<Key>> {
    private int N;
    private int[] pq;
    private int[] qp;
    private Key[] keys;
    public IndexMinPQ(int maxN) {
        keys = (Key[]) new Comparable[maxN + 1];
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        for (int i = 0; i <= maxN; i++) qp[i] = -1;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public boolean contains(int k) {
        return qp[k] != -1;
    }

    public void insert(int k, Key key) {
        N++;
        qp[k] = N;
        pq[N] = k;
        keys[k] = key;
        swim(N);
    }

    public Key min() {
        return keys[pq[1]];
    }

    public int delmMin() {
        int indexOfMin = pq[1];
        exch(1, N--);
        sink(1);
        keys[pq[N+1]] = null;
        qp[pq[N+1]] = -1;
        return indexOfMin;
    }

    public int minIndex() {
        return pq[1];
    }

    public void change(int k, Key key) {
        keys[k] = key;
        swim(qp[k]);
        sink(qp[k]);
    }

    public void delete(int k) {
        exch(k, N--);
        swim(qp[k]);
        sink(qp[k]);
        keys[pq[N+1]] = null;
        qp[pq[N+1]] = -1;
    }

    public void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    public void sink(int k) {
        while (k * 2 <= N) {
            int j = k * 2;
            if (j < N && less(j + 1, j)) j++;
            if (!less(j, k)) break;
            exch(k, j);
            k = j;
        }
    }

    public boolean less(int i, int j) {
        return keys[qp[i]].compareTo(keys[qp[j]]) < 0;
    }

    public void exch(int i, int j) {
        int t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
}
