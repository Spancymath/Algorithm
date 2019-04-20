package com.zhang.chapter14;

import com.zhang.chapter13.Stack;

/**
 * still not find out the answer yet..
 * @param <Item>
 */
public class ThreeStack2DoubleQueue<Item> {
    //栈1
    private Stack<Item> stack1;
    //栈2
    private Stack<Item> stack2;
    //栈3
    private Stack<Item> stack3;
    //3到1出栈
    private boolean pop3_1;
    //1到3出栈
    private boolean pop1_3;
    //构造方法
    public ThreeStack2DoubleQueue() {
        stack1 = new Stack<>();//头栈
        stack2 = new Stack<>();//空栈（中转栈）
        stack3 = new Stack<>();//尾栈
    }
    //判空
    public boolean isEmty() {
        return size() == 0;
    }
    //返回栈大小
    public int size() {
        return stack3.size() + stack1.size() + stack2.size();
    }
    //头入
    public void addHead(Item item) {
        stack1.push(item);
    }
    //头出
    public Item deleteHead() {
        if (size() == 0) return null;
        return stack1.pop();
    }
    //尾入
    public void addTail(Item item) {
        stack3.push(item);
    }
    //尾出
    public Item deleteTail() {
        return stack3.pop();
    }
}
