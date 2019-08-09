package com.zhang.chapter25;

import java.util.Comparator;

/**
 * 带比较器的插入排序算法
 */
public class Insertion {

    public static void sort(Object[] a, Comparator c) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(c, a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    private static boolean less(Comparator c, Object v, Object w) {
        return c.compare(v, w) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    //为高位优先的字符串排序设计
    public static void sort(String[] a, int lo, int hi, int d) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1], d); j--) {
                exch(a, j, j-1);
            }
        }
    }

    private static boolean less(String v, String w, int d) {
        return v.charAt(d) < w.charAt(d);
    }
}
