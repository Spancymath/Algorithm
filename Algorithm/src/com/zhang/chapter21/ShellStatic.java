package com.zhang.chapter21;

import edu.princeton.cs.algs4.StdOut;

/**
 * 带预先定义好的递增序列的数组
 */
public class ShellStatic extends Sortbase{
    @Override
    public void sort(Comparable[] a) {
        int i = 0;
        int N = a.length;
        while (SHELL_ARR[i] < N) i++;
        i--;
        while (i >= 0) {
            int h = SHELL_ARR[i];
            for (int j = h; j < N; j++) {
                for (int k = j; k >= h && less(a[k], a[k - h]); k -= h) {
                    exch(a, k, k - h);
                }
            }
            i--;
        }
        //StdOut.println(isSorted(a));
    }
    //递增序列
    private static int[] SHELL_ARR = {1,
                                      5,
                                      19,
                                      41,
                                      109,
                                      209,
                                      505,
                                      929,
                                      2161,
                                      3905,
                                      8929,
                                      16001,
                                      36289,
                                      64769,
                                      146305,
                                      260609};
    private static int SHELL_N;
    //构造方法
    public ShellStatic() {
        /*SHELL_N = 20;
        SHELL_ARR[0] = 1;
        for (int j = 1; j < SHELL_N; j++) {
            SHELL_ARR[j] = 3 * SHELL_ARR[j - 1] + 1;
        }*/
    }
}
