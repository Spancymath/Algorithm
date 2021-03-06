package com.zhang.chapter2.section23;

import com.zhang.chapter2.section21.Sortbase;

/**
 * 快速分割的方法实现快速排序
 * 花了好久才实现，烦烦烦
 */
public class Quick3wayFastpattition extends Sortbase {
    @Override
    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int i = lo, p = lo + 1, j = hi + 1, q = hi;
        Comparable v = a[lo];
        while (true) {
            while (!less(v, a[++i])) {
                if (i == hi) break;
                if (v.equals(a[i])) {
                    exch(a, p, i);
                    p++;
                }
            }
            while (!less(a[--j], v)) {
                if (j == lo) break;
                if (v.equals(a[j])) {
                    exch(a, q, j);
                    q--;
                }
            }
            if (i >= j) break;
            exch(a, i, j);
        }
        int lt = lo, ht = hi;
        while (lt < p && j >= p) {
            exch(a, lt++, j--);
        }
        while (ht > q && i <= q) {
            exch(a, ht--, i++);
        }

        sort(a, lo, j);
        sort(a, i, hi);
    }
}
