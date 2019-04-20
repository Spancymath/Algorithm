package com.zhang.chapter14;

import com.zhang.chapter13.Stack;
import com.zhang.chapter13.Steque;

public class StackSteque2DoubleQueue<Item> {
    //栈
    private Stack<Item> stack;
    //steque
    private Steque<Item> steque;
    //大小
    //private int n;
    //构造方法
    public StackSteque2DoubleQueue() {
        stack = new Stack<>();
        steque = new Steque<>();
    }
    //判空
    public boolean isEmpty() {
        return size() == 0;
    }
    //返回大小
    public int size() {
        return steque.size();
    }
    //前边入队
    public void addHead(Item item) {
        steque.push(item);
        //n++;
    }
    //前边出队
    public Item deleteHead() {
        return steque.pop();
    }
    //后边入队
    public void addTail(Item item) {
        steque.enqueue(item);
        //n++;
    }
    //后边出队
    public Item deleteTail() {
        while (!steque.isEmpty()) {
            stack.push(steque.pop());
        }
        if (stack.isEmpty()) return null;
        Item temp = stack.pop();
        while (!stack.isEmpty()) {
            steque.push(stack.pop());
        }
        return temp;
    }
}
