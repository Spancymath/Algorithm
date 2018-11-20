package com.zhang.chapter13;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
    private Node first;
    private int N;
    private class Node {
        Item item;
        Node next;
    }

    public Stack() {
        first = null;
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    /**
     * 入栈
     * @param item
     */
    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    /**
     * 出栈
     * @return
     */
    public Item pop() {
        if (size() == 0) return null;
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    /**
     * 返回栈顶元素，不弹出
     * @return
     */
    public Item peek() {
        if (isEmpty()) return null;
        return first.item;
    }

    //构造迭代器
    @Override
    public Iterator<Item> iterator() {
        return new reverseIterator();
    }

    private class reverseIterator implements Iterator<Item>{
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            return;
        }
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        In in = new In("C:\\Users\\Mather\\IdeaProjects\\Algorithm\\Algorithm\\file\\tobe.txt");
        while (!in.isEmpty()) {
            String word = in.readString();
            if ("-".equals(word)) {
                StdOut.println(stack.pop());
            } else {
                stack.push(word);
            }
        }
        in.close();
        StdOut.println("(" + stack.size() + " left on stack.)");
    }


}
