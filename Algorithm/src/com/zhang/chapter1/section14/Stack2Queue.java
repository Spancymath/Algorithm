package com.zhang.chapter1.section14;

import com.zhang.chapter1.section13.Stack;

public class Stack2Queue<Item> {
    //入队列的栈
    private Stack<Item> pushStack;
    //出队列的栈
    private Stack<Item> popStack;
    //队列大小
    int n;
    //构造队列
    public Stack2Queue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
        n = 0;
    }
    //判空
    public boolean isEmpty() {
        return n == 0;
    }
    //返回队列大小
    public int size() {
        return n;
    }
    //入队
    public void push(Item item) {
        while (!popStack.isEmpty()) {
            pushStack.push(popStack.pop());
        }
        pushStack.push(item);
        n++;
    }
    //出队
    public Item pop() {
        if (this.isEmpty()) return null;
        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
        n--;
        return popStack.pop();
    }
}
