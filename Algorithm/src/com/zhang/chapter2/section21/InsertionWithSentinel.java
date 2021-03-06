package com.zhang.chapter2.section21;

/**
 * 带哨兵的插入排序：先将数组的最小元素放到起始位置，从而去掉条件j > 0
 */
public class InsertionWithSentinel extends Sortbase{
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        //找出最小元素，放数组最前边
        int min = 0;
        for (int i = 1; i < N; i++) {
            if (less(a[i], a[min])) {
                min = i;
            }
        }
        exch(a, 0, min);

        for (int i = 2; i < N; i++) {
            for (int j = i; less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }

    }
}
