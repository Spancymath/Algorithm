package com.zhang.chapter2.section22;

import com.zhang.chapter2.section21.Sortbase;

public class MergeDownAux extends Sortbase {
    //private static Comparable[] aux;

    @Override
    public void sort(Comparable[] a) {
        //aux = new Comparable[a.length];
        sort(a, 0, a.length, new Comparable[a.length]);
    }

    private void sort(Comparable[] a, int lo, int hi, Comparable[] aux) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid, aux);
        sort(a, mid + 1, hi, aux);
        merge(a, lo, mid, hi, aux);
    }

    private void merge(Comparable[] a, int lo, int mid, int hi, Comparable[] aux) {

        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[i], aux[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }
}
