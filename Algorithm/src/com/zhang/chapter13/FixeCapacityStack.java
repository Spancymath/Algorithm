package com.zhang.chapter13;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

//定容栈
public class FixeCapacityStack<Item> {
    private Item[] a;
    private int N;
    public FixeCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public int size() {
        return N;
    }
    public void push(Item item) {
        a[N++] = item;
    }
    public Item pop() {
        return a[--N];
    }


    public static void main(String[] args) {
        FixeCapacityStack<String> fs = new FixeCapacityStack<>(100);
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
