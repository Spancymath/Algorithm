package com.zhang.chapter24;
/**
    同时面向最大最小元素的优先队列
      1.创建两个优先队列，一个最大优先队列，一个最小优先队列
      2.插入元素：元素大于最大队列的最后一个元素，插入最大队列，否则插入最小队列。
            插入后的队列元素数比未插入的队列多于2，则将最后一个元素插入另一个队列
      3.删除元素：
        最大：最大队列第一个
        最小：最小队列第一个
        比较队列个数差，超过两个则移入另一个队列
 */

public class MaxPminQ<Key extends Comparable<Key>> {
    Key[] p;
    Key[] q;
    int pNum;
    int qNum;

    public MaxPminQ(int maxN) {
        p = (Key[]) new Comparable[maxN];
        q = (Key[]) new Comparable[maxN];
        pNum = 0;
        qNum = 0;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return pNum + qNum;
    }

    private void insertp(Key key) {
        int pN = pNum + 1;
        p[pN] = key;
        while (pN > 1 && less(p, pN / 2, pN)) {
            exch(p, pN, pN / 2);
            pN = pN / 2;

        }
        pNum++;
    }

    private void insertq(Key key) {
        int qN = qNum + 1;
        q[qN] = key;
        while (qN > 1 && less(q, qN, qN / 2)) {
            exch(q, qN / 2, qN);
        }
        qNum++;
    }

    public void insert(Key key) {
        if (pNum == 0 || (key.compareTo(p[pNum]) > 0)) {
            insertp(key);
            if (pNum - qNum > 1) {
                insertq(p[pNum--]);
            }
        } else {
            insertq(key);
            if (qNum - pNum > 1) {
                insertp(q[qNum--]);
            }
        }
    }

    public Key deleteMin() {
        if (isEmpty()) return null;
        if (qNum == 0) insertq(p[pNum--]);
        Key key = q[1];
        q[1] = q[qNum];
        int i = 1;
        while (i * 2 <= qNum) {
            int j = i * 2;
            if (j < qNum && less(q, j + 1, j)) j++;
            if (less(q, i, j)) break;
            exch(q, i, j);
            i = j;
        }
        qNum--;
        if (pNum - qNum > 1) {
            insertq(p[pNum--]);
        }
        return key;
    }

    public Key deleteMax() {
        if (isEmpty()) return null;
        if (pNum == 0) insertp(q[qNum--]);
        Key key = p[1];
        p[1] = p[pNum];
        int i = 1;
        while (i * 2 <= pNum) {
            int j = i * 2;
            if (j < pNum && less(p, j, j + 1)) j++;
            if (less(p, j, i)) break;
            exch(p, i, j);
            i = j;
        }
        pNum--;
        if (qNum - pNum > 1) {
            insertp(q[qNum--]);
        }
        return key;
    }

    public Key min() {
        if (isEmpty()) return null;
        if (qNum == 0) return p[1];
        return q[1];
    }
    public Key max() {
        if (isEmpty()) return null;
        if (pNum == 0) return q[1];
        return p[1];
    }

    public boolean less(Key[] k, int i, int j) {
        return k[i].compareTo(k[j]) < 0;
    }

    public void exch(Key[] k, int i, int j) {
        Key key = k[i];
        k[i] = k[j];
        k[j] = key;
    }
}
