package com.zhang.chapter1.section13;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

/**
 * 随机队列
 */
public class RandomQueue<Item> implements Iterable<Item> {
    //队列容量
    private int capacity;
    //队列数组
    private Item[] queue;
    //队列头
    private int head;
    //队列尾
    private int tail;
    //队列元素个数
    private int n;
    //构造队列
    public RandomQueue() {
        capacity = 8;
        queue = (Item[]) new Object[capacity];
        n = 0;
        head = 0;
        tail = n - 1;
    }
    //调整数组大小
    private void resize(int cap) {
        Item[] temp = (Item[]) new Object[cap];
        for (int i = 0; i < n; i++) {
            temp[i] = queue[(head + i) % capacity];
        }
        queue = temp;
        capacity = cap;
        head = 0;
        tail = n - 1;
    }
    //判空
    public boolean isEmpty() {
        return n == 0;
    }
    //队列大小
    public int size() {
        return n;
    }
    //添加元素
    public void enqueue(Item item) {
        if (n == capacity) resize(capacity * 2);
        tail = (tail + 1) % capacity;
        queue[tail] = item;
        n++;
    }
    //随机删除元素并返回
    public Item dequeue() {
        if (isEmpty()) return null;
        int temp;
        if (size() == 1) temp = head;
        else temp = StdRandom.uniform(head, head + n - 1);
        temp = temp % capacity;
        Item item = queue[temp];
        queue[temp] = queue[head];
        queue[head] = item;
        head++;
        n--;
        if (n > 2 && n < capacity / 4) resize(capacity / 2);
        return item;
    }
    //随机返回一个元素不删除
    public Item sample() {
        if (isEmpty()) return null;
        int temp = StdRandom.uniform(head, head + n -1);
        temp %= capacity;
        return queue[temp];
    }

    @Override
    public Iterator<Item> iterator(){
        return new ReverseIterator();
    }

    public class ReverseIterator implements Iterator<Item> {
        private int current = head;
        private int num = 0;
        @Override
        public boolean hasNext() {
            return num < n;
        }

        @Override
        public Item next() {
            int temp;
            if (num == n - 1) temp = current;
            else temp = StdRandom.uniform(current, current + n - num - 1);
            Item item = queue[temp];
            queue[temp] = queue[current];
            queue[current] = item;
            current = (current + 1) % capacity;
            num++;
            return item;
        }

        @Override
        public void remove() {
            return;
        }
    }
}
