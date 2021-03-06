package com.zhang.chapter3.section35;


/**
 * 不允许有重复值的队列，存在则忽略插入请求
 */
public class Uniqueue<Item extends Comparable<Item>> {

    //链表结点
    private class Node {
        Item item;
        Node next;
        public Node(Item item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    //头结点
    private Node head;
    //尾结点
    private Node tail;
    //元素个数
    private int N;
    //构造函数
    public Uniqueue() {
        head = null;
        tail = null;
        N = 0;
        set = new SET<>();
    }

    //符号表判重
    private SET<Item> set;

    //插入元素
    public void enqueue(Item item) {
        if (set.containts(item)) return;
        if (isEmpty()) {
            head = new Node(item, null);
            tail = head;
        } else {
            Node node = tail;
            tail = new Node(item, null);
            node.next = tail;
        }
        N++;
        set.add(item);
    }

    //删除元素
    public Item dequeue() {
        if (isEmpty()) return null;
        Item item = head.item;
        set.delete(item);
        head = head.next;
        N--;
        return item;
    }

    //判空
    public boolean isEmpty() {
        return size() == 0;
    }

    //元素个数
    public int size() {
        return N;
    }
}
