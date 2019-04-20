package com.zhang.chapter13;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

/**
 * 随机背包
 */
public class RandomBag<Item> implements Iterable<Item> {
    //背包容量
    private int capacity;
    //背包数组
    private Item[] bag;
    //背包实际大小
    int n;
    //构造背包
    public RandomBag() {
        capacity = 8;
        bag = (Item[]) new Object[capacity];
        n = 0;
    }
    //动态改变数组大小
    public void resize(int cap) {
        Item[] temp = (Item[]) new Object[cap];
        for (int i = 0; i < n; i++) {
            temp[i] = bag[i];
        }
        bag = temp;
        capacity = cap;
    }
    //判空
    public boolean isEmpty() {
        return n == 0;
    }
    //返回背包大小
    public int size() {
        return n;
    }
    //添加元素
    public void add(Item item) {
        if (n == capacity) resize(capacity * 2);
        bag[n++] = item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseIterator();
    }

    public class ReverseIterator implements Iterator<Item>{
        private int current = 0;
        @Override
        public boolean hasNext() {
            return current < n;
        }

        @Override
        public Item next() {
            if (current != n - 1) {
                int randn = StdRandom.uniform(current, n - 1);
                Item temp = bag[current];
                bag[current] = bag[randn];
                bag[randn] = temp;
            }
            current++;
            return bag[current - 1];
        }

        @Override
        public void remove() {
            return;
        }
    }
}
