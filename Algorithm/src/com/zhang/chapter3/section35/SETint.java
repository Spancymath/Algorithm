package com.zhang.chapter3.section35;

import javax.swing.*;

public class SETint {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;//根结点

    private Node lastNode = null;//上一次访问结点
    //结点
    private class Node {
        int key;//键
        Node left, right;//左右子树
        int N;//这棵子树中结点数
        boolean color;//其父结点指向它的链接的颜色
        public Node(int key, int N, boolean color) {
            this.key = key;
            this.N = N;
            this.color = color;
        }
    }
    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    //判空
    public boolean isEmpty() {
        return size(root) == 0;
    }

    public int size() {
        return size(root);
    }

    //返回结点树
    public int size(Node x) {
        return x.N;
    }

    //左旋h的右链接
    Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    //右旋h的左链接
    Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    //颜色转换
    void flipColors(Node h) {
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }

    public void add(int key) {
        root = put(root, key);
        root.color = BLACK;
    }

    //插入
    private Node put(Node h, int key) {
        if (h == null) return new Node(key, 1, RED);

        int cmp = key - h.key;
        if (cmp < 0) h.left = put(h.left, key);
        else if (cmp > 0) h.right = put(h.right, key);

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);
        h.N = size(h.left) + size(h.right) + 1;
        return h;

    }

    public int get(int key) {
        if (lastNode == null || lastNode.key != key) {
            lastNode = new Node(key, 1, BLACK);
        }
        return lastNode.key;
    }

    public int get(Node x, int key) {
        if (x == null) return 0xfffffff;
        int cmp = key - x.key;
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.key;
    }

    //恢复红黑树
    private Node balance(Node h) {
        if (isRed(h.right)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    //删除最小元素
    public void deleteMin() {
        if (!isRed(root.left) && !isRed(root.right)) root.color = RED;
        root = deleteMin(root);
        if (!isEmpty()) root.color = BLACK;
    }

    private Node moveRedLeft(Node h) {
        flipColors(h);
        if (isRed(h.right.left)) {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
        }
        return h;
    }

    private Node deleteMin(Node h) {
        if (h.left == null) return null;
        if (!isRed(h.left) && !isRed(h.left.left)) h = moveRedLeft(h);
        h.left = deleteMin(h.left);
        return balance(h);
    }

    //删除最大元素
    public void deleteMax() {
        if (!isRed(root.left) && !isRed(root.right)) root.color = RED;
        root = deleteMax(root);
        if (!isEmpty()) root.color = BLACK;
    }

    private Node moveRedRight(Node h) {
        flipColors(h);
        if (!isRed(h.left.left)) h = rotateRight(h);
        return h;
    }

    private Node deleteMax(Node h) {
        if (isRed(h.left)) h = rotateRight(h);
        if (h.right == null) return null;
        if (!isRed(h.right) && !isRed(h.right.left)) h = moveRedRight(h);
        h.right = deleteMax(h.right);
        return balance(h);
    }
    public int min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    public int max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) return x;
        return max(x.right);
    }

    //删除操作
    public void delete(int key) {
        if (!isRed(root.left) && !isRed(root.right)) root.color = RED;
        root = delete(root, key);
        if (!isEmpty()) root.color = BLACK;
    }

    private Node delete(Node h, int key) {
        if (key - h.key < 0) {
            if (!isRed(h.left) && !isRed(h.left.left)) h = moveRedLeft(h);
            h.left = delete(h.left, key);
        } else {
            if (isRed(h.left)) h = rotateRight(h);
            if (key - h.key == 0 && h.right == null) return null;
            if (!isRed(h.right) && !isRed(h.right.left)) h = moveRedRight(h);
            if (key - h.key == 0) {
                h.key = min(h.right).key;
                h.right = deleteMin(h.right);
            } else {
                h.right = delete(h.right, key);
            }
        }
        return balance(h);
    }

    //右链接合法性
    public boolean is23() {
        if (root == null) return true;
        return is23(root);
    }

    public boolean is23(Node x) {
        if (x.left != null) {
            if (x.color == RED && x.left.color == RED) return false;
            return is23(x.left);
        }
        if (x.right != null) {
            if (x.right.color == RED) return false;
            return is23(x.right);
        }
        return true;
    }

    //检测是否平衡
    public boolean isBalanced() {
        int black = 0;
        Node x = root;
        while (x != null) {
            if (!isRed(x)) black++;
            x = x.left;
        }
        return isBalanced(root, black);
    }

    private boolean isBalanced(Node x, int black) {
        if (x == null) return black == 0;
        if (!isRed(x)) black--;
        return isBalanced(x.left, black) && isBalanced(x.right, black);
    }

}
