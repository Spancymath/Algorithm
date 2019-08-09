package com.zhang.chapter53;

/**
 * 网上更一般的KMP算法
 */
public class KMPnormal {
    int[] next;

    public KMPnormal(String pat) {
        int M = pat.length();
        next = new int[M];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < M - 1) {
            if (k == -1 || pat.charAt(j) == pat.charAt(k)) {
                ++k;
                ++j;
                if (pat.charAt(j) != pat.charAt(k)) {
                    next[j] = k;
                } else {
                    next[j] = next[k];
                }
            } else {
                k = next[k];
            }
        }
    }

    public int search(String s, String p) {
        int i = 0;
        int j = 0;
        int N = s.length();
        int M = p.length();
        while (i < N && j < M) {
            if (j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == M) return i - j;
        else return -1;
    }

}
