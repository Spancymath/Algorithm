package com.zhang.chapter11;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise1122 {
	/**
     * 递归查找关键词的索引
     * @param key
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public static int rank(int key, int[] arr, int low, int high, int depth) {
        printCallInfo(low, high, depth);
        if(low > high)
            return -1;
        int mid = low + ((high - low) >> 1);
        if(key < arr[mid])
            return rank(key, arr, low, mid - 1, depth + 1);
        else if(key > arr[mid])
            return rank(key, arr, mid + 1, high, depth + 1);
        else
            return mid;
    }

    /**
     * 二分查找 ： 递归描述
     * @param key
     * @param arr
     * @return
     */
    public static int binarySearch(int key, int[] arr, int depth) {
        return rank(key, arr, 0, arr.length - 1, depth);
    }

    /**
     * 打印缩进
     * @param indents    缩进数
     */
    private static void printIndent(final int indents) {
        for(int i = 0; i < indents; ++i)
            StdOut.print("----------");
    }

    /**
     * 打印调用信息
     * @param low
     * @param high
     * @param depth
     */
    private static void printCallInfo(int low, int high, int depth) {
        StdOut.print(depth + "\t");
        printIndent(depth);
        StdOut.println(low + "\t" + high);
    }

    public static void main(String[] args) {
        int N = 1024;
        int[] arr = new int[N];
        for(int i = 0; i < N; ++i)
            arr[i] = StdRandom.uniform(N * 50);
        // 排序
        Arrays.sort(arr);
        // 从随机数组中随机抽取一个元素作为关键字
        // 输出随机数组
        StdOut.print("seq = ");
        for(int i = 0 ; i < N; ++i)
            StdOut.print(arr[i] + "\t");
        int key = arr[StdRandom.uniform(N)];
        StdOut.println("\nkey = " + key);
        StdOut.println("---------------------------------------------------------------------------------------");
        binarySearch(key, arr, 0);
    }
}
