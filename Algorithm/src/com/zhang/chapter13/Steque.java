package com.zhang.chapter13;

import java.util.Iterator;

/**
 * 以栈为目标的队列
 */
public class Steque<Item> implements Iterable<Item> {
    //结点
    public class Node {
        Item item;
        Node next;
    }
    //队列头
    private Node first;
    //队列尾
    private Node last;
    //队列大小
    int n;
    //构造队列
    public Steque() {
        first = null;
        last = null;
        n = 0;
    }
    //判空
    public boolean isEmpty() {
        return n == 0;
    }
    //返回队列大小
    public int size() {
        return n;
    }
    //头部入队
    public void push(Item item) {
        Node temp = first;
        first = new Node();
        first.item = item;
        first.next = temp;
        if (size() == 0) last = first;
        n++;
    }
    //头部出栈
    public Item pop() {
        //空队列
        if (size() == 0) return null;

        Item item = first.item;
        first = first.next;
        n--;
        //出队后为空队列
        if (size() == 0) last = null;
        return item;
    }
    //尾部入栈
    public void enqueue(Item item) {
        Node temp = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (size() != 0) {
            temp.next = last;
        } else {
            first = last;
        }
        n++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseIterator();
    }

    public class ReverseIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            return;
        }
    }
}
