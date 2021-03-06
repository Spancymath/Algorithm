package com.zhang.chapter1.section13;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

//定容栈
public class ResizingArrayStack<Item> implements Iterable<Item>{
    private Item[] a;
    private int N;
    public ResizingArrayStack() {
        a = (Item[]) new Object[1];
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public int size() {
        return N;
    }
    public void push(Item item) {
        if (N == a.length) resize(a.length * 2);
        a[N++] = item;
    }
    public Item pop() {
        Item item = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length / 4) resize(a.length / 2);
        return item;
    }

    public void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }


    //迭代器
    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {

        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove() {
            return;
        }
    }

    public static void main(String[] args) {
        ResizingArrayStack<String> fs = new ResizingArrayStack<>();
        In in = new In("C:\\Users\\Mather\\IdeaProjects\\Algorithm\\Algorithm\\file\\tobe.txt");
        while (!in.isEmpty()) {
            String item = in.readString();
            if (!item.equals("-")) {
                fs.push(item);
            } else if (!fs.isEmpty()){
                StdOut.println(fs.pop());
            }
        }
        in.close();
        StdOut.println("(" + fs.size() + "left on stack)");
    }

}
