package com.zhang.test;

import edu.princeton.cs.algs4.StdOut;

class StaticDemo {
    static int a = 42;
    static int b = 99;
    static void callme() {
        StdOut.println("a = " + a);
    }
}

public class StaticByName {
    public static void main(String[] args) {
        StaticDemo.callme();
        StdOut.println(StaticDemo.b);
    }
}
