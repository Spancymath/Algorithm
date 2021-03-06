package com.zhang.chapter2.section23;

import com.zhang.chapter1.section13.Stack;
import com.zhang.chapter2.section21.Sortbase;

/**
 * 不使用递归的快速排序
 */
public class NonrecursiveQuicksort extends Sortbase {
    private class pos {
        int lo;
        int hi;
        public pos(int i, int j) {
            lo = i;
            hi = j;
        }
    }
    @Override
    public void sort(Comparable[] a) {
        int lo = 0, hi = a.length - 1;
        Stack<pos> stack = new Stack<>();
        boolean flag = false;
        while (true) {
            if (lo >= hi) {
                if (stack.isEmpty()) break;
                pos temp = stack.pop();
                lo = temp.lo;
                hi = temp.hi;
                continue;
            }
            int j = partiton(a, lo, hi);
            //if (j + 1 < hi) {
                pos p = new pos(j + 1, hi);
                stack.push(p);
            //}
            hi = j - 1;
        }
    }

    public int partiton(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }
}
