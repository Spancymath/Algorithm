package com.zhang.chapter2.section22;

import com.zhang.chapter2.section21.InsertionWithoutExch;
import com.zhang.chapter2.section21.Sortbase;

/**
 * 归并排序（自顶向下）
 *
 * 三个改进方法：
 *              对小规模数组使用插入排序
 *              测试数组是否已经有序
 *              不将元素复制到辅助数组
 */
public class MergeDown extends Sortbase{
    private static Comparable[] aux;

    @Override
    public void sort(Comparable[] a) {
        //改进一：小数组
        if (a.length < 20) {
            new InsertionWithoutExch().sort(a);
            return;
        }
        aux = new Comparable[a.length];
        sort(a, 0, a.length);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        //改进二：判断数组是否有序
        if (less(a[mid], a[mid + 1])) return;
        merge(a, lo, mid, hi);
    }

    private void merge(Comparable[] a, int lo, int mid, int hi) {

        int i = lo, j = mid + 1;

        /**for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }**/

        //改进三：交换参数避免数组复制
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                mergej(a, i, k, j);
                j++;
            }
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[i], aux[j])) a[k] = aux[i++];
            else {
                mergej(a, i, k, j);
                j++;
            }
        }
    }
    private void mergej(Comparable[] a, int i, int k, int j) {
        Comparable temp = a[j];
        for (int p = j; p > k; p--) a[p - 1] = a[p];
        a[k] = temp;
    }
}
