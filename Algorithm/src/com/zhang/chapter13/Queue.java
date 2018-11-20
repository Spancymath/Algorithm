package com.zhang.chapter13;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public Queue() {
        first = null;
        last = null;
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    //入队
    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
        N++;
    }

    //出队
    public Item dequeue() {
        if (isEmpty()) return null;
        Item item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) last = first;
        return item;
    }

    //返回队首元素，但不出队
    public Item peek() {
        if (isEmpty()) return null;
        return first.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseItorator();
    }

    private class ReverseItorator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = first.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }


    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        In in = new In("C:\\Users\\Mather\\IdeaProjects\\Algorithm\\Algorithm\\file\\tobe.txt");
        while (!in.isEmpty()) {
            String word = in.readString();
            if (!"-".equals(word)) {
                queue.enqueue(word);
            }else {
                StdOut.println(queue.dequeue());
            }
        }
        in.close();
        StdOut.println("( " + queue.size() + " word still in queue.)");
    }
}
