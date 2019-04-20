package com.zhang.chapter13;

import java.util.Iterator;

/**
 * 定常数组队列，自动调整大小
 */
public class ResizingArrayQueueOfStrings<Item> implements Iterable<Item> {
    //初始大小
    private int INIT_CAPACITY = 8;
    //队列
    private Item[] queue;
    //队列大小
    private int N;
    //头元素指针
    private int head;
    //尾元素指针
    private int tail;
    //构造方法
    public ResizingArrayQueueOfStrings() {
        queue = (Item[]) new Object[INIT_CAPACITY];
        N = 0;
        head = 0;
        tail = 0;
    }
    //队列是否为空
    public boolean isEmpty() {
        return N == 0;
    }
    //队列大小
    public int size() {
        return N;
    }
    //入队列
    public void enqueue(Item item) {
        if (N == queue.length) resize(queue.length * 2);
        queue[tail++] = item;
        if (tail == queue.length) tail = 0;
        N++;
    }
    //出队列
    public Item dequeue() {
        if (isEmpty()) return null;
        Item item = queue[head++];
        if (head == queue.length) head = 0;
        N--;
        if (N > 2 && N < queue.length / 4) resize(queue.length / 2);
        return item;
    }
    //调整队列大小
    public void resize(int capacity) {
        Item[] queueTemp = (Item[]) new Object[capacity];
        for (int i = head; i < 0; i++) {
            queueTemp[i] = queue[(i + head) % queue.length];
        }
        queue = queueTemp;
        head = 0;
        tail = N;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;

        @Override
        public boolean hasNext() {
            return i < N;
        }

        @Override
        public Item next() {
            if (!hasNext()) return null;
            Item item = queue[(i + head) % queue.length];
            i++;
            return item;
        }

        @Override
        public void remove() {

        }
    }
}
