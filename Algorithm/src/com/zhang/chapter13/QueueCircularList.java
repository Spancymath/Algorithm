package com.zhang.chapter13;

public class QueueCircularList<Item> {
    //链表结点
    private class Node {
        Item item;
        Node next;
    }
    //队列最后一个结点
    private Node last;
    //队列长度
    private int n;
    //队列构造函数
    public QueueCircularList() {
        last = null;
        n = 0;
    }
    //队列判空
    public boolean isEmpty() {
        return n == 0;
    }
    //队列大小
    public int size() {
        return n;
    }
    //入队
    public void enqueue(Item item){
        Node node = last;
        last = new Node();
        last.item = item;
        if (size() == 0) last.next = last;
        else {
            last.next = node.next;
            node.next = last;
        }
        n++;

    }
    //出队
    public Item dequeue() {
        if (last == null) return null;
        Item item = last.next.item;
        if (size() == 1) last = null;
        else last.next = last.next.next;
        n--;
        return item;
    }

}
