package com.zhang.chapter3.section31;

import edu.princeton.cs.algs4.Queue;

public class Chapter3003OrderSeqSST<Key extends Comparable<Key>, Value> {
    private int n = 0;
    private Node first;
    //定义链表数据结构
    private class Node {
        Key key;
        Value val;
        Node next;
        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
    //得到键对应的值
    public Value get(Key key) {
        Node head = first;
        while (head != null && head.key.compareTo(key) < 1) {
            if (key.equals(head.key)) {
                return head.val;
            }
            head = head.next;
        }
        return null;
    }
    //查找给定的键，更新值，或者新建结点
    public void push(Key key, Value val) {
        if (first == null || first.key.compareTo(key) < 1) {
            Node temp = new Node(key, val, first);
            first = temp;
            n++;
        }
        for (Node node = first; node != null; node = node.next) {
            if (key.equals(node.key)) {
                node.val = val;
                break;
            }
            if (node.next == null || node.next.key.compareTo(key) > 1) {
                Node temp = new Node(key, val, node.next);
                node.next = temp;
                n++;
                break;
            }
        }
    }
    //删除指定键
    public void delete(Key key) {
        if (first == null) return;
        if (first.key.compareTo(key) == 0) {
            Node temp = first;
            first = first.next;
            temp = null;
            n--;
            return;
        }
        for (Node node = first; node != null && node.key.compareTo(key) <= 0; node = node.next) {
            if (node.next != null && node.next.key.compareTo(key) == 0) {
                Node temp = node.next;
                node.next = temp.next;
                temp = null;
                n--;
            }
        }
    }
    //返回符号表的大小
    public int size() {
        return n;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        Node head = first;
        while (head != null) {
            queue.enqueue(head.key);
        }
        return queue;
    }

    //应该实现rank方法使得实现更简单点儿//

}
