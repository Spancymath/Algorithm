package com.zhang.chapter21;

/**
 * 排序算法的基方法
 */
public abstract class Sortbase {
    //排序方法
    public abstract void sort(Comparable[] a);
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
