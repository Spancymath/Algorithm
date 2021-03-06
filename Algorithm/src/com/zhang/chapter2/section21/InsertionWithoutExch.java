package com.zhang.chapter2.section21;

/**
 * 不需要交换的插入排序
 */
public class InsertionWithoutExch extends Sortbase{
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            int j = i;
            Comparable temp = a[i];
            for (; j > 0 && less(temp, a[j - 1]); j--) {
                a[j] = a[j - 1];
            }
            a[j] = temp;
        }
        //StdOut.println(isSorted(a));
    }
}
