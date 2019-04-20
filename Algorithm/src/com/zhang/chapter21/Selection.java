package com.zhang.chapter21;

/**
 * 选择排序
 * 特点：
 *      1.运行时间和输入无关
 *      2.数据移动最少
 *
 * 思考：
 *
 *      可以同时找到最大值最小值，提高效率，时间复杂度有待分析
 */
public class Selection {
    //排序
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }
    //是否小于
    public boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
    //交换两个值
    public void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    //数组是否有序
    public boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i - 1]) < 0) return false;
        }
        return true;
    }
}
