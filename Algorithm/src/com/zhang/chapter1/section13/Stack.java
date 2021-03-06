package com.zhang.chapter1.section13;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
    private Node first;
    private int N;
    //pop和push的次数
    private int operator;
    private class Node {
        Item item;
        Node next;
    }

    public Stack() {
        first = null;
        N = 0;
    }

    public Stack(Stack s) {
        operator = 0;
        first = null;
        N = 0;
        Node sFirst = s.first;
        while (sFirst != null) {
            push(sFirst.item);
            sFirst = sFirst.next;
        }
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
        operator++;
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
        operator++;
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

    //连接一个栈
    public void catenation(Stack s) {
        Stack<Item> temp = new Stack<>();
        while (first != null) {
            temp.push(first.item);
            first = first.next;
            N--;
        }
        while (!temp.isEmpty()) s.push(temp.pop());
        while (!s.isEmpty()) {
            this.push((Item)s.pop());
        }
    }

    //构造迭代器
    @Override
    public Iterator<Item> iterator() {
        return new reverseIterator();
    }

    private class reverseIterator implements Iterator<Item>{
        private Node current = first;
        private int iniOperator = operator;

        @Override
        public boolean hasNext() {
            if (operator != iniOperator) {
                throw new java.util.ConcurrentModificationException();
            }
            return current != null;
        }

        @Override
        public Item next() {
            if (operator != iniOperator) {
                throw new java.util.ConcurrentModificationException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            return;
        }
    }

    //12题的要求，返回给定栈的副本
    public Stack<Item> copy(Stack<Item> stack) {
        Stack<Item> stackCopy = new Stack<>();
        Stack<Item> stackTemp = new Stack<>();
        for (Item item : stack) {
            stackTemp.push(item);
        }
        for (Item item : stackTemp) {
            stackCopy.push(item);
        }
        return stackCopy;
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
