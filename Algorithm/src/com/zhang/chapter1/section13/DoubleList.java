package com.zhang.chapter1.section13;

import edu.princeton.cs.algs4.StdOut;

/**
 * 双向链表
 */
public class DoubleList<Item> {
    //结点类
    public class DoubleNode {
        private Item item;
        private DoubleNode previous;
        private DoubleNode next;
    }
    private DoubleNode first;
    private DoubleNode last;
    private int n;
    //链表构造函数
    public DoubleList() {
        first = null;
        last = null;
        n = 0;
    }
    //判空
    public boolean isEmpty() {
        return n == 0;
    }
    //链表大小
    public int size() {
        return n;
    }
    //从前边删除结点
    public Item deleteHead() {
        if (size() == 0) return null;
        Item item;
        if (size() == 1) {
            item = first.item;
            first = null;
            last = null;
            n--;
            return item;
        }
        item = first.item;
        DoubleNode temp = first;
        first = first.next;
        first.previous = null;
        temp = null;
        n--;
        return item;
    }
    //从前边添加结点
    public void addHead(Item item) {
        if (size() == 0) {
            first = new DoubleNode();
            first.item = item;
            first.previous = null;
            first.next = null;
            last = first;
            //n++;
        } else {
            DoubleNode temp = first;
            first = new DoubleNode();
            first.item = item;
            first.previous = null;
            first.next = temp;
            temp.previous = first;
            //n++;
        }
        n++;
    }
    //从后边添加结点
    public void addTail(Item item) {
        if (size() == 0) {
            first = new DoubleNode();
            first.item = item;
            first.previous = null;
            first.next = null;
            last = first;
        } else {
            DoubleNode temp = last;
            last = new DoubleNode();
            last.item = item;
            last.next = null;
            last.previous = temp;
            temp.next = last;
        }
        n++;
    }
    //从后边删除结点
    public Item deleteTail() {
        if (size() == 0) return null;
        Item item;
        item = first.item;
        if (size() == 1) {
            n--;
            first = null;
            last = null;
            return item;
        }
        DoubleNode temp = last;
        last = last.previous;
        last.next = null;
        temp = null;
        n--;
        return item;
    }
    //删除指定结点
    public void deleteItem(Item item) {
        DoubleNode temp = first;
        int i = 1;
        while (temp != null) {
            if (temp.item.equals(item)) {
                if (i == 1) deleteHead();
                else if (i == n) deleteTail();
                else {
                    temp.previous.next = temp.next;
                    temp.next.previous = temp.previous;
                    n--;
                }
                //修复删除多个出错
                i--;
            }
            temp = temp.next;
            i++;
        }
    }
    //指定结点前插入结点
    public void addItemPrevoius(Item item,Item addItem) {
        DoubleNode temp = first;
        int i = 1;
        while (temp != null) {
            if (temp.item.equals(item)) {
                if (i == 1) addHead(addItem);
                else {
                    DoubleNode node = temp;
                    temp = new DoubleNode();
                    temp.item = addItem;
                    temp.previous = node.previous;
                    temp.next = node;
                    node.previous.next = temp;
                    node.previous = temp;
                    temp = node;
                    n++;
                }
            }
            temp = temp.next;
            i++;
        }
    }
    //指定结点后插入结点
    public void addItemNext(Item item, Item addItem) {
        DoubleNode temp = first;
        int i = 1;
        while (temp != null) {
            if (temp.item.equals(item)) {
                if (i == n) addTail(addItem);
                else {
                    DoubleNode node = temp;
                    temp = new DoubleNode();
                    temp.item = addItem;
                    temp.previous = node;
                    temp.next = node.next;
                    node.next.previous = temp;
                    node.next = temp;
                    temp = node;
                    n++;
                }
            }
            temp = temp.next;
            i++;
        }
    }

    public Item kth(int k) {
        if (k < 0 || k >= n) throw new IllegalArgumentException("Illegal index");
        DoubleNode node = first;
        for (int i = 0; i < 0; i++, node = node.next);
        return node.item;
    }

    //输出链表
    public void print() {
        DoubleNode node = first;
        while (node != null) {
            StdOut.print(node.item);
            if (node.next != null) StdOut.print(", ");
            node = node.next;
        }
        StdOut.println();
    }
}
