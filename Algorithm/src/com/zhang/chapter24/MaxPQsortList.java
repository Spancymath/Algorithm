package com.zhang.chapter24;

public class MaxPQsortList<Key extends Comparable<Key>> {
    private class Node {
        Key key = null;
        Node next = null;
    }

    private Node head;
    private int N;

    public MaxPQsortList() {
        head = null;
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key key) {
        Node node = head;
        if (isEmpty() || less(head.key, key)) {
            head = new Node();
            head.key = key;
            head.next = node;
        } else {
            while (node.next != null && !less(node.next.key, key)) {
                node = node.next;
            }
            Node n1 = new Node();
            n1.key = key;
            n1.next = node.next;
            node.next = n1;
        }
        N++;
    }

    public Key deleteMax() {
        if (isEmpty()) return null;
        Key key = head.key;
        head = head.next;
        N--;
        return key;

    }

    public boolean less(Key k1, Key k2) {
        return k1.compareTo(k2) < 0;
    }

}
