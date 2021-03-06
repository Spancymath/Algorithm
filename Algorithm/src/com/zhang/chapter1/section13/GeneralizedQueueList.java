package com.zhang.chapter1.section13;

/**
 * Josephus问题链表实现
 */
public class GeneralizedQueueList<Item> {
    //结点
    public class Node {
        Item item = null;
        Node next = null;
    }
    //链表尾
    private Node last;
    //链表大小
    private int n;
    //构造
    public GeneralizedQueueList() {
        last = null;
        n = 0;
    }
    //判空
    public boolean isEmpty() {
        return n == 0;
    }
    //添加元素
    public void insert(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (!isEmpty()) {
            last.next = oldLast.next;
            oldLast.next = last;
        } else {
            last.next = last;
        }
        n++;
    }
    //删除被杀的人
    public Item delete(int k) {
        if (isEmpty()) return null;
        for (int i = 0; i < k - 1; i++) {
            last = last.next;
        }
        Item item = last.next.item;
        last.next = last.next.next;
        n--;
        return item;
    }
}
