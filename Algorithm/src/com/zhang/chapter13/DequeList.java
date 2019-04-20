package com.zhang.chapter13;

import java.util.Iterator;

//双向队列，双向链表实现
public class DequeList<Item> implements Iterable<Item> {

    //结点
    public class Node {
        Item item;
        Node previous = null;
        Node next = null;
    }
    //队列头
    private Node first;
    //队列尾
    private Node last;
    //队列大小
    int n;
    //构造双向链表
    public DequeList() {
        first = null;
        last = null;
        n = 0;
    }
    //判空
    public boolean isEmpty() {
        return n == 0;
    }
    //队列元素数量
    public int size() {
        return n;
    }
    //向头部添加新元素
    public void pushHead(Item item) {
        Node temp = first;
        first = new Node();
        first.item = item;
        first.next = temp;
        if (!isEmpty()) {
            temp.previous = first;
        } else {
            last = first;
        }
        n++;
    }
    //向尾部添加一个新元素
    public void pushTail(Item item) {
        Node temp = last;
        last = new Node();
        last.item = item;
        last.previous = temp;
        if (!isEmpty()) {
            temp.next = last;
        } else {
            first = last;
        }
        n++;
    }
    //从头部删除元素
    public Item popHead() {
        if (isEmpty()) return null;
        Item item = first.item;
        first = first.next;
        n--;
        if (!isEmpty()) {
            first.previous = null;
        } else {
            first = null;
            last = null;
        }
        return item;
    }
    //从尾部删除元素
    public Item popTail() {
        if (isEmpty()) return null;
        Item item = last.item;
        last = last.previous;
        n--;
        if (!isEmpty()) {
            last.next = null;
        } else {
            last = null;
            first = null;
        }
        return item;
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
