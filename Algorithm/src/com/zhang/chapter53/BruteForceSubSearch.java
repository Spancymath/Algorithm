package com.zhang.chapter53;

/**
 * 暴力子字符串查找
 */
public class BruteForceSubSearch {

    //常规版本
    public static int search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (txt.charAt(i+j) != pat.charAt(j)) break;
            }
            if (j == M) return i;
        }
        return N;
    }

    //显式回退版本
    public static int searchNew(String pat, String txt) {
        int j, M = pat.length();
        int i, N = txt.length();
        for (i = 0, j = 0; i < N && j < M; i++) {
            if (txt.charAt(i) == pat.charAt(j)) j++;
            else {
                i -= j;
                j = 0;
            }
        }
        if (j == M) return i - M;//找到匹配
        else return N;//未找到匹配
    }
}
