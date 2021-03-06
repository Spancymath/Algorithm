package com.zhang.chapter2.section24;

/**
 * 快速插入的优先队列
 * @param <Key>
 */
public class MinPQFastInsert<Key extends Comparable<Key>> {
    private int N;
    private Key[] queue;

    private static int INIT_SIZE = 10;

    public MinPQFastInsert() {
        N = 0;
        queue = (Key[]) new Comparable[INIT_SIZE];
    }

    //判空
    public boolean isEmpty() {
        return size() == 0;
    }
    //队列大小
    public int size() {
        return N;
    }
    //插入
    public void insert(Key key) {
        if (N == queue.length - 1) resize(queue.length * 2);
        queue[++N] = key;
        swim(N);
    }
    //删除
    private Key delete() {
        Key key = queue[1];
        exch(1, N--);
        sink(1);
        if (N + 1 < queue.length / 4) resize(queue.length / 2);
        return key;
    }
    //下沉
    public void sink(int k) {
        while (k * 2 <= N) {
            int j = k * 2;
            if (j < N && less(j + 1, j)) j++;
            if (!less(j, k)) break;
            exch(k, j);
            k = j;
        }
    }
    //上浮
    private void swim(int k) {
        int i = find(k, 1, k);
        exch(i, k);
    }
    //二分查找
    private int find(int k, int lo, int hi) {
        if (lo >= hi) return lo;
        int temp = k;
        int mid = findMid(lo, hi);
        if (less(k, mid / 2)) {
            temp = find(k, lo, mid / 2 / 2);
        } else {
            temp = find(k, mid, hi);
        }
        return temp;
    }
    //求中间点
    private int findMid(int lo, int hi) {
        int temp = hi;
        int i = 0;
        while (temp >= lo) {
            temp = temp / 2;
            i++;
        }
        i = i / 2;
        while (--i >= 0) {
            hi = hi / 2;
        }
        return hi;
    }

    //小于比较
    private boolean less(int i, int j) {
        if (queue[i].compareTo(queue[j]) < 0) return true;
        return false;
    }
    //交换
    private void exch(int i, int j) {
        Key key = queue[i];
        queue[i] = queue[j];
        queue[j] = key;
    }

    //改变数组容量
    private void resize(int capacity) {
        Key[] temp = (Key[]) new Comparable[capacity];
        for (int i = 1; i <= N; i++) {
            temp[i] = queue[i];
        }
        queue = temp;
    }
}
