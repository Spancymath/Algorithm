package com.zhang.chapter35;

public class SequentialSearchSET<Key> {

    private class Node {
        Key key;
        Node next;
        public Node(Key key, Node next) {
            this.key = key;
            this.next = next;
        }
    }
    private Node first;
    private int N;

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void add(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return;
            }
        }
        first = new Node(key, first);
        N++;
    }

    public boolean contains(Key key) {
        if (key == null) return false;
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) return true;
        }
        return false;
    }

    public void delete(Key key) {
        if (key == null) return;
        if (key.equals(first.key)) {
            first = first.next;
            N--;
            return;
        }
        for (Node x = first; x.next != null; x = x.next) {
            if (key.equals(x.next.key)) {
                x.next = x.next.next;
                N--;
                return;
            }
        }
    }
}
