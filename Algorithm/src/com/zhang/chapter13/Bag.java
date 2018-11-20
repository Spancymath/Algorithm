package com.zhang.chapter13;

import java.util.Iterator;

/**
 * 背包
 * @param <Item>
 */
public class Bag<Item> implements Iterable<Item> {
    //链表头
    private Node first;
    //背包大小
    private int N;
    //定义链表结点
    private class Node {
        Item item;
        Node next;
    }
    //构造方法
    public Bag() {
        first = null;
        N = 0;
    }
    //放入背包
    public void add(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    //重写迭代器
    @Override
    public Iterator<Item> iterator() {
        return null;
    }
    public class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return null;
        }

        @Override
        public void remove() {

        }
    }
}
