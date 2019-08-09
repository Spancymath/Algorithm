package com.zhang.chapter34;

public class SeparateChainingHashSTDirect<Key, Value> {
    public class Node {
        Key key;
        Value val;
        Node next;
        int n;

        Node (Key key, Value val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }

    private int N;
    private int M;
    private Node[] nodes;

    public SeparateChainingHashSTDirect() {
        this(997);
    }

    public SeparateChainingHashSTDirect(int M) {
        this.M = M;
        nodes = (Node[]) new Object[M];
        this.N = 0;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key) {
        if (key == null) return null;
        Node temp = nodes[hash(key)];
        while (temp != null) {
            if (temp.key.equals(key)) return temp.val;
            temp = temp.next;
        }
        return null;
    }

    public void put(Key key, Value val) {
        if (key == null) return;
        if (val == null) delete(key);
        for (Node x = nodes[hash(key)]; x != null; x = x.next) {
            if (x.key.equals(key)) {
                x.val = val;
                return;
            }
        }
        Node node = nodes[hash(key)];
        nodes[hash(key)] = new Node(key, val);
        nodes[hash(key)].next = node;
        nodes[hash(key)].n = size();
        this.N++;
    }

    public void delete(Key key) {
        if (key == null) return;
        nodes[hash(key)] = delete(nodes[hash(key)], key);
    }

    private Node delete(Node first, Key key) {
        if (first == null) return null;
        if (first.key.equals(key)) {
            this.N--;
            return first.next;
        }
        Node temp = first;
        while (temp.next != null) {
            if (temp.next.key.equals(key)) {
                temp.next = temp.next.next;
                this.N --;
                break;
            }
        }
        return first;
    }
}
