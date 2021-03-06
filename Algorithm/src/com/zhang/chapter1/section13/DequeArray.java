package com.zhang.chapter1.section13;

import java.util.Iterator;

/**
 * 双向链表动态数组实现
 */
public class DequeArray<Item> implements Iterable<Item> {
    //初始队列容量
    private int capacity;
    //队列数组
    private Item[] queue;
    //队列头
    private int head;
    //队列尾
    private int tail;
    //队列实际大小
    private int n;
    //构造队列
    public DequeArray() {
        capacity = 8;
        queue = (Item[]) new Object[capacity];
        head = n - 1;
        tail = 0;
        n = 0;
    }
    //动态调整队列容量
    private void resize(int cap) {
        Item[] temp = (Item[]) new Object[cap];
        for (int i = 0; i < n; i++) {
            temp[i] = queue[(head + i) % capacity];
        }
        queue = temp;
        head = n - 1;
        tail = 0;
        capacity = cap;
    }
    //判空
    public boolean isEmpty() {
        return n == 0;
    }
    //队列大小
    public int size() {
        return n;
    }
    //头部入队
    public void pushHead(Item item) {
        if (n == capacity) resize(capacity * 2);
        head = (head + 1) % capacity;
        queue[head] = item;
        if (n == 0) tail = head;
        n++;
    }
    //尾部入队
    public void pushTail(Item item) {
        if (n == capacity) resize(capacity * 2);
        tail = tail - 1 >= 0 ? tail - 1 : capacity - 1;
        queue[tail] = item;
        if (n == 0) head = tail;
        n++;
    }
    //头部出队
    public Item popHead() {
        if (isEmpty()) return null;
        Item item = queue[head--];
        head = head >= 0 ? head : capacity - 1;
        n--;
        if (n >= 2 && n < capacity / 4) resize(capacity / 2);
        return item;
    }
    //尾部入队
    public Item popTail() {
        if (isEmpty()) return null;
        Item item = queue[tail];
        tail = (tail + 1) % capacity;
        n--;
        if (n >= 2 && n < capacity / 4) resize(capacity / 2);
        return item;
    }

    //头部
    public Item head() {
        if (isEmpty()) return null;
        Item item = queue[head];
        return item;
    }
    @Override
    public Iterator<Item> iterator() {
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
            Item item = queue[current];
            current = current - 1 >= 0 ? current - 1 : capacity - 1;
            num++;
            return item;
        }

        @Override
        public void remove() {

        }
    }
}
