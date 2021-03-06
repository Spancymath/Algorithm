package com.zhang.chapter3.section32;

import com.zhang.chapter1.section13.Queue;

/**
 * 非递归实现二叉查找树
 */

public class NonrecursiveBST<Key extends Comparable<Key>, Value> {

    //结点内部类
    private class Node {
        Key key;
        Value val;
        Node left, right;
        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    //根节点
    public Node root;
    //树中元素总数
    public int N;
    //返回元素个数
    public int size() {
        //return N;
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        int n = 0;
        Queue<Node> queue = new Queue<>();
        queue.enqueue(x);
        while (!queue.isEmpty()) {
            n++;
            Node t = queue.dequeue();
            if (t.left != null) queue.enqueue(t.left);
            if (t.right != null) queue.enqueue(t.right);
        }
        return n;
    }
    //插入元素
    public void put(Key key, Value val) {
        put(root, key, val);
    }

    private void put(Node x, Key key, Value val) {
       if (x == null) {
           x = new Node(key, val);
           root = x;
           return;
       }
       while (true) {
           int cmp = key.compareTo(x.key);
           if (cmp < 0) {
               if (x.left == null) {
                   N++;
                   x.left = new Node(key, val);
                   return;
               } else {
                   x = x.left;
               }
           } else if (cmp > 0) {
               if (x.right == null) {
                   N++;
                   x.right = new Node(key, val);
                   return;
               } else {
                   x = x.right;
               }
           } else {
               x.val = val;
               return;
           }
       }
    }
    //得到元素
    public Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) return x.val;
            else if (cmp < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return null;
    }
    //得到最小元素
    public Value min() {
        Node x = root;
        if (x == null) return null;
        while (true) {
            if (x.left == null) return x.val;
            x = x.left;
        }
    }
    //得到最大元素
    public Value max() {
        Node x = root;
        if (x == null) return null;
        while (true) {
            if (x.right == null) return x.val;
            x = x.right;
        }
    }
    //小于等于给定元素最大值
    public Value floor(Key key) {
        Node x = root;
        if (x == null) return null;
        Queue<Node> queue = new Queue<>();
        queue.enqueue(x);
        Node floor = null;
        while (!queue.isEmpty()) {
            Node temp = queue.dequeue();
            if (temp.left != null) queue.enqueue(temp.left);
            if (temp.right != null) queue.enqueue(temp.right);
            int cmp = key.compareTo(temp.key);
            if (cmp == 0) return temp.val;
            else if (cmp > 0) {
                if (floor == null) floor = temp;
                else if (floor.key.compareTo(temp.key) < 0) {
                    floor = temp;
                }
            }
        }
        if (floor == null) return null;
        return floor.val;
    }
    //大于等于给定元素最小值
    public Value ceiling(Key key) {
        if (root == null) return null;
        Queue<Node> queue = new Queue<>();
        queue.enqueue(root);
        Node ceiling = null;
        while (!queue.isEmpty()) {
            Node temp = queue.dequeue();
            if (temp.left != null) queue.enqueue(temp.left);
            if (temp.right != null) queue.enqueue(temp.right);
            int cmp = key.compareTo(temp.key);
            if (cmp == 0) return temp.val;
            else if (cmp < 0) {
                if (ceiling == null) ceiling = temp;
                else if (ceiling.key.compareTo(temp.key) > 0) {
                    ceiling = temp;
                }
            }
        }
        if (ceiling == null) return null;
        return ceiling.val;
    }
    //给定元素的排名
    public int rank(Key key) {
        if (key == null) return 0;
        Node x = root;
        Queue<Node> queue = new Queue<>();
        queue.enqueue(x);
        int rank = 0;
        while (!queue.isEmpty()) {
            Node temp = queue.dequeue();
            int cmp = key.compareTo(temp.key);
            if (cmp < 0) {
                if (temp.left != null) queue.enqueue(temp.left);
            } else if (cmp > 0) {
                rank += size(temp.left) + 1;
                if (temp.right != null) queue.enqueue(temp.right);
            } else {
                rank += size(temp.left);
            }
        }
        return rank;
    }
    //给定排名的元素
    public Key select(int k) {
        if (k < 0) return null;
        if (k > size()) return null;
        Node x = root;
        while (true) {
            int t = size(x.left);
            if (t == k) return x.key;
            if (t < k) {
                k = k - t - 1;
                x = x.right;
            } else {
                x = x.left;
            }
        }
    }


}
