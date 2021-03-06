package com.zhang.chapter1.section13;

import edu.princeton.cs.algs4.StdOut;

/**
 * Josepus问题
 */
public class GeneralizedQueueArray<Item> {
    //开始位置
    private int start;
    //数组
    Item[] queue;
    //人数
    private int N;
    //第几个被杀
    private int M;
    //下一个加入的人
    private int next;
    //构造函数
    public GeneralizedQueueArray(int n, int m) {
        next = 0;
        M = m;
        N = n;
        queue = (Item[]) new Object[N];
    }
    //判空
    public boolean isEmpty() {
        return N == 0;
    }
    //添加一个元素
    public void insert(Item item) {
        queue[next] = item;
        next++;
    }
    //删除并返回被杀的人
    public Item delete(int k) {
        for (int i = 0; i < k; i++) {
            start = (start + i) % N;
        }
        Item item = queue[start];
        for (int i = start; i < N - 1; i++) {
            queue[i] = queue[i+1];
        }
        N--;
        return item;
    }
}
