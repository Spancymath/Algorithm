package com.zhang.chapter1.section13;

/**
 * 双向队列实现两个栈
 */
public class QueueToStack<Item> {
    //双向队列
    private DoubleList<Item> doubleList;
    //第一个栈大小
    private int n1;
    //第二个栈大小
    private int n2;
    //构造
    public QueueToStack() {
        doubleList = new DoubleList<>();
        n1 = 0;
        n2 = 0;
    }
    //第一个栈判空
    public boolean isEmpty1() {return n1 == 0;}
    //第二个栈判空
    public boolean isEmpty2() {return n2 == 0;}
    //第一个栈入栈
    public void push1(Item item) {
        doubleList.addHead(item);
        n1++;
    }
    //第一个栈出栈
    public Item pop1() {
        if (!isEmpty1()) {
            n1--;
            return doubleList.deleteHead();
        }
        return null;
    }
    //第二个栈入栈
    public void push2(Item item) {
        doubleList.addTail(item);
        n2++;
    }
    //第二个栈出栈
    public Item pop2() {
        if (!isEmpty2()) {
            n2--;
            return doubleList.deleteTail();
        }
        return null;
    }
}
