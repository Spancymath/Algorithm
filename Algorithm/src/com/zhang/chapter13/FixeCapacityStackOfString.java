package com.zhang.chapter13;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

//定容栈
public class FixeCapacityStackOfString {
    private String[] a;
    private int N;
    public FixeCapacityStackOfString(int cap) {
        a = new String[cap];
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public boolean isFull() {
        return N == a.length;
    }
    public int size() {
        return N;
    }
    public void push(String item) {
        a[N++] = item;
    }
    public String pop() {
        return a[--N];
    }


    public static void main(String[] args) {
        FixeCapacityStackOfString fs = new FixeCapacityStackOfString(100);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                fs.push(item);
            } else if (!fs.isEmpty()){
                StdOut.println(fs.pop());
            }
        }
        StdOut.println("(" + fs.size() + "left on stack");
    }

}
