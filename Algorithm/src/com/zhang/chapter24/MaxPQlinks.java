package com.zhang.chapter24;

import com.zhang.chapter13.DequeArray;

import java.util.Deque;

/**
 * 二叉树实现的优先队列
 * @param <Key>
 */
public class MaxPQlinks<Key extends Comparable<Key>> {
    private class Node{
        Key key = null;
        Node root = null;
        Node lchild = null;
        Node rchild = null;
    }

    Node head;
    Node tail;
    int N;
    DequeArray<Node> q;
    public MaxPQlinks() {
        head = null;
        tail = null;
        N = 0;
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public int size() {
        return N;
    }

    public void insert(Key key) {
        Node node = new Node();
        if (isEmpty()) {
            head = new Node();
            head.key = key;
            head.root = null;
            head.lchild = null;
            head.rchild = null;
            tail = head;
            q.pushTail(head);
        } else {
            node.key = key;
            node.lchild = null;
            node.rchild = null;
            node.root = q.head();
            if (q.head().lchild != null) {
                q.head().rchild = node;
                q.popHead();
            } else {
                q.head().lchild = node;
            }
        }

        //swim
        while (node.root != null && less(node.root.key, node.key)) {
            exch(node.root.key, node.key);
        }
    }

    public Key deleteMax() {
        Key key = head.key;
        if (q.head().rchild == null) {
            head.key = q.popHead().lchild.key;
        } else {
            head.key = q.head().rchild.key;
            q.head().rchild = null;
        }
        //sink
        Node node = head;
        while (node.lchild != null) {
            if (node.rchild != null && less(node.lchild.key, node.rchild.key)) {
                if (!less(node.key, node.rchild.key)) break;
                exch(node.key, node.rchild.key);
                node = node.rchild;
            } else {
                if (!less(node.key, node.lchild.key)) break;
                exch(node.key, node.lchild.key);
                node = node.lchild;
            }
        }
        return key;
    }

    public boolean less(Key k1, Key k2) {
        return k1.compareTo(k2) < 0;
    }

    public void exch(Key k1, Key k2) {
        Key temp = k1;
        k1 = k2;
        k2 = temp;
    }
}
