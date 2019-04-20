package com.zhang.chapter13;

/**
 * 前移编码
 */
public class MoveToFirst<Item> {
    //结点
    public class Node{
        Item item;
        Node next;
    }
    //链表头
    private Node first;
    //链表元素数
    private int n;
    //构造链表
    public MoveToFirst() {
        first = null;
        n = 0;
    }
    //判空
    public boolean isEmpty() {
        return n == 0;
    }
    //返回元素数量
    public int size() {
        return n;
    }
    //包含某个元素，包含则返回位置，否则返回-1
    private int contain(Item item) {
        if (item == null) return -1;
        Node node = first;
        int pos = -1;
        int i = 1;
        while (node != null) {
            if (first.item.equals(item)) {
                pos = i;
                break;
            }
            node = node.next;
            i++;
        }
        return pos;
    }
    //删除元素
    private void delete(int k) {
        if (n == 0) return;
        if (k< 1 || k > n) return;
        if (k == 1) {
            first = first.next;
            n--;
            return;
        }
        Node node = first;
        int i = 1;
        while (i + 1 < k) {
            node = node.next;
            i++;
        }
        node.next = node.next.next;
        n--;
    }
    //加入元素
    public void push(Item item) {
        if (item == null) return;
        int k = contain(item);
        if (k > 0) delete(k);
        Node node = first;
        first = new Node();
        first.item = item;
        first.next = node;
    }
    //弹出元素
    public Item pop() {
        if (isEmpty()) return null;
        Item item = first.item;
        first = first.next;
        return item;
    }
}
