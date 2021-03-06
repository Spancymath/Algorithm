package com.zhang.chapter2.section25;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 找出一个数组中第k小的元素
 */
public class FindKth {

    private static int cnt = 0;

    public static Comparable select(Comparable[] a, int k, int lo, int hi) {
        int j = partion(a, lo, hi);
        if (j > k) return select(a, k, lo, j - 1);
        if (j < k) return select(a, k, j + 1, hi);
        return a[j];
    }

    public static Comparable select(Comparable[] a, int k) {
        StdRandom.shuffle(a);
        int lo = 0, hi = a.length - 1;
        if (k > hi || k < 0) return null;
        while (hi >= lo) {
            int j = partion(a, lo, hi);
            if (j == k) {
                StdOut.println("比较" + cnt);
                return a[k];
            }
            else if (j > k) hi = j - 1;
            else if (j < k) lo = j + 1;
        }
        StdOut.println("比较" + cnt);
        return a[k];
    }

    private static int partion(Comparable[] a, int lo, int hi) {
        if (lo == hi) return lo;
        Comparable c = a[lo];
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v))  {
                if (hi == i) break;
            }
            while (less(v, a[--j])) if (lo == j) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static boolean less(Comparable a, Comparable b) {
        cnt++;
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
