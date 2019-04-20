package com.zhang.chapter24;

public class MaxPQlist<Key extends Comparable<Key>> {
    private class Node {
        Key key = null;
        Node next = null;
    }

    private Node head;
    private int N;

    public MaxPQlist() {
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
        head = new Node();
        head.key = key;
        head.next = node;
        N++;
    }

    public Key deleteMax() {
        if (isEmpty()) return null;
        Key key = head.key;
        Node node = head;
        int i = 0;
        int t = 0;
        while (node != null) {
            if (less(key, node.key)) {
                key = node.key;
                t = i;
            }
            node = node.next;
            i++;
        }
        if (t == 0) {
            head = head.next;
        } else {
            node = head;
            i = 0;
            while (i < t - 1) {
                node = node.next;
            }
            node.next = node.next.next;
        }
        N--;
        return key;

    }

    public boolean less(Key k1, Key k2) {
        return k1.compareTo(k2) < 0;
    }

}
