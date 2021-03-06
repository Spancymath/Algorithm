package com.zhang.chapter2.section23;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 快速排序
 */
public class QuickSort {

    public int cn;
    public void sort(Comparable[] a) {
        cn = 0;
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    //比较
    public boolean less(Comparable a, Comparable b) {
        cn++;
        return a.compareTo(b) < 0;
    }

    //交换
    public void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
