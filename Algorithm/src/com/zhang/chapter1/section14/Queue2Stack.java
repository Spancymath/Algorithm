package com.zhang.chapter1.section14;

import com.zhang.chapter1.section13.Queue;

public class Queue2Stack<Item> {
    //队列
    private Queue<Item> queue;
    //大小
    int n;
    //构造方法
    public Queue2Stack() {
        queue = new Queue<>();
        n = 0;
    }
    //判空
    public boolean isEmpty() {
        return n == 0;
    }
    //返回大小
    public int size() {
        return n;
    }
    //入栈
    public void push(Item item) {
        queue.enqueue(item);
        n++;
    }
    //出栈
    public Item pop() {
        if (isEmpty()) return null;
        int i = 0;
        while (i++ < n - 1) {
            queue.enqueue(queue.dequeue());
        }
        n--;
        return queue.dequeue();
    }
}
