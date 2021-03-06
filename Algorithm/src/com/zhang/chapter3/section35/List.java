package com.zhang.chapter3.section35;

import com.zhang.chapter3.section33.RedBlackBST;

import java.util.Iterator;

/**
 * 链表的高效实现
 * 删除的时候可以和尾部元素交换再删除尾部元素，效率更高
 * @param <Item>
 */

public class List<Item extends Comparable<Item>> implements Iterable<Item> {

    //双向链表结点
    private class Node implements Comparable<Node> {
        Item item;
        Node prev;
        Node next;
        public Node(Item item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
            if (prev != null) prev.next = this;
            if (next != null) next.prev = this;
        }

        @Override
        public int compareTo(Node o) {
            return this.item.compareTo(o.item);
        }
    }
    //使用没有重复值的红黑树
    //键在链表的位置
    RedBlackBST<Node, Integer> stToK;
    //链表第k个位置的值
    RedBlackBST<Integer, Node> stToV;

    //链表头结点
    private Node head;
    //链表尾结点
    private Node tail;
    //链表元素个数
    private int N;

    //构造函数
    public List() {
        stToK = new RedBlackBST<>();
        stToV = new RedBlackBST<>();
        head = null;
        tail = null;
        N = 0;
    }
    //从前边添加元素
    public void addFront(Item item) {
        head = new Node(item, null, head);
        if (isEmpty()) tail = head;
        N++;
        stToK = new RedBlackBST<>();
        stToV = new RedBlackBST<>();
        Node node = head;
        for (int i = 0; i < size(); i++) {
            stToK.put(node, i);
            stToV.put(i, node);
            node = node.next;
        }
    }

    //从后边添加元素
    public void addBack(Item item) {
        tail = new Node(item, tail, null);
        if (isEmpty()) head = tail;
        N++;
        stToK.put(tail, N - 1);
        stToV.put(N - 1, tail);
    }

    //从前边删除元素
    public void deleteFront() {
        if (isEmpty()) return;
        stToV.delete(0);
        stToK.delete(head);
        if (size() == 1) {
            head = null;
            tail = null;
        } else {
            head = new Node(head.next.item, head.prev, head.next.next);
        }
        N--;
        Node node = head;
        for (int i = 0; i <size(); i++) {
            stToV.put(i, node);
            stToK.put(node, i);
            node = node.next;
        }
    }

    //从后边删除元素
    public void deleteBack() {
        if (isEmpty()) return;
        stToK.delete(tail);
        stToV.delete(N - 1);
        if (size() == 1) {
            head = null;
            tail = null;

        } else {
            tail = new Node(tail.prev.item, tail.prev.prev, tail.next);
        }
        N--;
    }

    //删除元素
    public void delete(Item item) {
        if (!contains(item)) throw new RuntimeException("该元素不存在");
        int pos = stToK.get(new Node(item, null, null));
        Node x = stToV.get(pos);
        stToV.delete(pos);
        stToK.delete(x);
        Node node = x.next;
        while (node != null) {
            stToK.put(node, pos);
            stToV.put(pos, node);
            pos++;
            node = node.next;
        }
        if (x.prev != null) x.prev.next = x.next;
        if (x.next != null) x.next.prev = x.prev;
        N--;
    }

    //在链表的第i个位置添加元素
    public void add(int i, Item item) {
        if (i < 0 || i > N - 1) throw new IllegalArgumentException("Illegal index");
        Node x = stToV.get(i);
        x = new Node(item, x, x.next);
        N++;
        for (; i < N; i++) {
            stToV.put(i, x);
            stToK.put(x, i);
        }
    }

    //删除第i个位置的元素
    public Item delete(int i) {
        if (i < 0 || i > N - 1) throw new IllegalArgumentException("Illegal index");
        Item item;
        Node x = stToV.get(i);
        stToK.delete(x);
        item = x.item;
        if (i == N - 1) {
            x.prev.next = null;
            tail = x.prev;
        } else if (i == 0) {
            x.next.prev = null;
            head = x.next;
        } else {
            x = new Node(x.next.item, x.prev, x.next.next);
        }
        N--;
        for (; i < N; i++) {
            stToK.put(x, i);
            stToV.put(i, x);
            x = x.next;
        }
        return item;
    }

    //包含某个元素
    public boolean contains(Item item) {
        return stToK.get(new Node(item, null, null)) != null;
    }

    //判空
    public boolean isEmpty() {
        return size() == 0;
    }

    //链表元素个数
    public int size() {
        return N;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
