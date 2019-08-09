package com.zhang.chapter32;

import java.util.Arrays;

public class PerfectBalance {
    private static void perfect(BST bst, String[] a) {
        Arrays.sort(a);
        perfect(bst, a, 0, a.length - 1);
    }
    //precondition: a[lo..hi] is sorted
    private static void perfect(BST bst, String[] a, int lo, int hi) {
        if (hi < lo) return;
        int mid = lo + (hi - lo) / 2;
        bst.put(a[mid], mid);
        perfect(bst, a, lo, mid - 1);
        perfect(bst, a, mid + 1, hi);
    }
}
