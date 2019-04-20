package com.zhang.chapter21;

import edu.princeton.cs.algs4.StdOut;

/**
 * 希尔排序
 * 特点：
 *      改进插入排序，交换不相邻的元素，从而对数组的局部进行排序
 *      是初级算法中的最好选择
 *
 * 序列：
 *      h = 3*h+1
 */
public class Shell extends Sortbase{
    int less_n;
    @Override
    public void sort(Comparable[] a) {
        less_n = 0;
        int N = a.length;
        int h = 1;
        while (h < N/3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
        StdOut.println("比较次数：" + less_n);
    }

    @Override
    public boolean less(Comparable a, Comparable b) {
        less_n++;
        return a.compareTo(b) < 0;
    }
}
