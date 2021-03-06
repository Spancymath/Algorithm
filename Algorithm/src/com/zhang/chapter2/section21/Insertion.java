package com.zhang.chapter2.section21;

/**
 * 插入排序：
 * 特点：
 *      所需时间取决于输入元素的初始顺序
 *      倒置数量很小时，该算法效率最高
 */
public class Insertion {
    //排序
    public void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {

            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
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
    //判断数组是否有序
    public boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i - 1]) < 0) return false;
        }
        return true;
    }
}
