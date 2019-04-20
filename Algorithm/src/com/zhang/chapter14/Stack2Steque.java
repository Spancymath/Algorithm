package com.zhang.chapter14;

import com.zhang.chapter13.Stack;

public class Stack2Steque<Item> {
    //顶栈
    private Stack<Item> headStack;
    //尾栈
    private Stack<Item> tailStack;
    //大小
    private int n;
    //构造方法
    public Stack2Steque() {
        headStack = new Stack<>();
        tailStack = new Stack<>();
        n = 0;
    }
    //顶部入栈
    public void push(Item item) {
        while (!tailStack.isEmpty()) {
            headStack.push(tailStack.pop());
        }
        headStack.push(item);
        n++;
    }
    //顶部出栈
    public Item pop() {
        while (!tailStack.isEmpty()) {
            headStack.push(tailStack.pop());
        }
        if (headStack.isEmpty()) return null;
        n--;
        return headStack.pop();
    }
    //尾部入栈
    public void enqueue(Item item) {
        while (!headStack.isEmpty()) {
            tailStack.push(headStack.pop());
        }
        tailStack.push(item);
        n++;
    }
}
