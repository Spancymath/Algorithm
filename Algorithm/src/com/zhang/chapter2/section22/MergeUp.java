package com.zhang.chapter2.section22;

import com.zhang.chapter2.section21.Sortbase;

/**
 * 归并排序（原地归并）
 * 特点：
 *      效率NlogN
 *      需要和N成正比的额外空间
 *      归并排序是一种渐进最优的基于比较排序的算法
 *
 *      空间复杂度并不是最优
 *
 */
public class MergeUp extends Sortbase {

    private static Comparable[] aux;
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int i = 1; i < N; i *= 2) {
            for (int j = 0; j < N - i; j += i * 2) {
                merge(a, j, j + i - 1,
                        j + i * 2 - 1 >= N ? N - 1 : j + i * 2 - 1);
            }
        }
    }

    public void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j < hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }
}
