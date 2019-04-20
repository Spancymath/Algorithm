package com.zhang.chapter13;

/**
 * 环形缓冲区
 */
public class RingBuffer<Item> {
    //缓冲区大小
    private int N;
    //对列数组
    private Item[] queue;
    //队首位置
    private int head;
    //队尾位置
    private int tail;
    //队列中已有元素个数
    private int n;
    //构造队列
    public RingBuffer(int N) {
        this.N = N;
        queue = (Item[]) new Object[N];
        head = 0;
        tail = N - 1;
        n = 0;
    }
    //判空
    public boolean isEmpty() {
        return n == 0;
    }
    //判队列已满
    public boolean isFull() {
        return n == N;
    }
    //入队
    public void enqueue(Item item) {
        if (isFull()) return;
        tail = (tail + 1) % N;
        queue[tail] = item;
        n++;
    }
    //出队
    public Item dequeue() {
        if (isEmpty()) return null;
        Item item = queue[head];
        head = (head + 1) % N;
        n--;
        return item;
    }
}
