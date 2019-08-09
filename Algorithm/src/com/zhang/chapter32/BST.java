package com.zhang.chapter32;

import com.zhang.chapter13.Queue;
import com.zhang.chapter13.Stack;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 基于二叉查找树的符号表
 * @param <Key> 键
 * @param <Value> 值
 */
public class BST <Key extends Comparable<Key>, Value>{
    //树的结点
    private class Node {
        private Key key;//键
        private Value value;//值
        private Node left, right;//指向子树的链接
        private int N;//以该结点为跟的子树中结点总数

        private Node pred, succ;//指向前后结点

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
            this.pred = null;
            this.succ = null;
        }
    }
    //根结点
    private Node root;

    //上一次访问的结点
    private Node lastNode;

    public int size() {
        return size(this.root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    public Value get(Key key) {
        if (lastNode == null || lastNode.key == key) {
            lastNode = new Node(key, get(root, key), 1);
        }
        return lastNode.value;
    }

    public Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.value;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) return new Node(key, value, 1);
        int cmp = key.compareTo(x.key);
        //支持重复键：小于改为小于等于删除else
        if (cmp <= 0) {
            x.left = put(x.left, key, value);
            //加前后结点指针
            x.left.succ = x;
            x.left.pred = x.pred;
            x.pred = x.left;
        }
        else if (cmp > 0) {
            x.right = put(x.right, key, value);
            //加前后结点指针
            x.right.pred = x;
            x.right.succ = x.succ;
            x.succ = x.right;
        }
        x.N = size(x.left) + size(x.right);
        return x;
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) return x;
        return max(x.right);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }

    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if (x == null) return null;
        return x.key;
    }

    public Node ceiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp > 0) return ceiling(x.right, key);
        Node t = ceiling(x.left, key);
        if (t != null) return t;
        else return x;
    }

    //找到排名为k的键
    public Key select(int k) {
        return select(root, k).key;
    }

    private Node select (Node x, int k) {
        if (x == null) return null;
        int t = size(x.left);
        if (t > k) return select(x.left, k - 1);
        else if (t < k) return select(x.right, k - t - 1);
        else return x;
    }

    //找出键key的排名
    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else return size(x.left);
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) {
            //加前后结点指针
            x.pred.succ = null;
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
    //删除键为key的元素
    public void delete(Key key) {
        //支持重复键
        while (get(key) != null) {
            root = delete(root, key);
        }
    }

    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
            //加前后结点指针
            x.pred = t.pred;
            t.pred.succ = x;
            t.succ.pred = x;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    //二叉查找树的范围查找
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo > 0) keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
        if (cmphi < 0) keys(x.right, queue, lo, hi);
    }

    //树的高度
    public int height() {
        return height(root);
    }

    public int height(Node x) {
        if (x == null) return 0;
        int leftH = height(x.left);
        int rightH = height(x.right);
        return 1 + (leftH > rightH ? leftH : rightH);
    }

    //随机命中平均比较次
    public int avgCompares() {
        return totalCompares(root, 0, 0) / size();
    }

    private int totalCompares(Node x, int total, int length) {
        if (x == null) return 0;
        length++;
        return total + totalCompares(x.left, total, length) + totalCompares(x.right, total, length);
    }

    public static int optCompares(int N) {
        if (N <= 0) return 0;
        if (N == 1) return 1;
        int n = 0;
        int temp = N;
        while (temp != 0) {
            temp /= 2;
            n++;
        }
        //StdOut.println(n);

        int total = 0;
        int n2 = 1;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                n2 *= 2;
            }
            total += n2;
        }

        total += N % n2;
        //StdOut.println(N % n2);
        return total / N + ( total % N == 0 ? 0 : 1);
    }

    /**
     * 随机返回一个键
     */
    public Key randomKey() {
        if (root == null) return null;
        int height = height();
        int n = StdRandom.uniform(height);
        StdOut.println(n);
        Node x = root;
        for (int i = 0; i < n; i++) {
            int rand = StdRandom.uniform(2);
            StdOut.println(rand);
            if (rand == 0) {
                if (x.left == null) return x.key;
                x = x.left;
            } else {
                if (x.right == null) return x.key;
                x = x.right;
            }
        }
        return x.key;
    }
    //二叉树检查
    public boolean isBinaryTree(Node x) {
        if (x == null) return true;
        boolean leftflag = isBinaryTree(x.left);
        boolean rightflag = isBinaryTree(x.right);
        if (!leftflag || !rightflag) return false;
        int leftN = treeSize(x.left);
        int rightN = treeSize(x.right);
        if (x.N != leftN + rightN + 1) return false;
        else return true;
    }


    private int treeSize(Node x) {
        if (x == null) return 0;
        int total = 1;
        if (x.left != null) total += x.left.N;
        if (x.right != null) total += x.right.N;
        return total;
    }

    //有序性检查
    public boolean isOrdered(Node x, Key min, Key max) {
        if (x == null) return true;
        boolean leftflag = isOrdered(x.left, min, x.key);
        boolean rightflag = isOrdered(x.right, x.key, max);
        if (!leftflag || !rightflag) return false;
        if (x.key.compareTo(min) >= 0 && x.key.compareTo(max) <= 0) return true;
        return false;
    }

    //等值键检查
    public boolean hasNoDuplicates(Node x) {
        if (x == null) return true;
        boolean leftflag = hasNoDuplicates(x.left);
        boolean rightflag = hasNoDuplicates(x.right);
        if (!leftflag || !rightflag) return false;
        if (x.left != null && x.key.compareTo(x.left.key) == 0) return false;
        if (x.right != null && x.key.compareTo(x.right.key) == 0) return false;
        return true;
    }

    //验证
    private boolean isBST() {
        if (!isBinaryTree(root)) return false;
        if (!isOrdered(root, min(), max())) return false;
        if (!hasNoDuplicates(root)) return false;
        return true;
    }

    //选择/排名检查
    public boolean checkRank(int i) {
        return i == rank(select(i));
    }

    //选择/排名检查
    public boolean checkSelect(Key key) {
        return key.compareTo(select(rank(key))) == 0;
    }

    public Iterable<Key> keys1() {
        Queue<Key> queue = new Queue<>();
        keys(root, queue);
        return queue;
    }
    //中序遍历
    private void keys(Node x, Queue<Key> queue) {
        if (x == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(x);
        queue.enqueue(x.key);
        while (!stack.isEmpty()) {
            while (stack.peek().left != null) {
                Node top = stack.peek();
                stack.push(top.left);
                queue.enqueue(top.left.key);
            }
            Node del = stack.pop();
            if (del.right != null) {
                stack.push(del.right);
                queue.enqueue(del.right.key);
            }
        }
    }

    //按层遍历
    public Iterable<Key> keys2() {
        Queue<Key> queue = new Queue<>();
        keys2(root, queue);
        return queue;
    }

    private void keys2(Node x, Queue<Key> queue) {
        if (x == null) return;
        Queue<Node> nodeQueue = new Queue<>();
        nodeQueue.enqueue(x);
        while (!nodeQueue.isEmpty()) {
            Node temp = nodeQueue.dequeue();
            queue.enqueue(temp.key);
            if (temp.left != null) nodeQueue.enqueue(temp.left);
            if (temp.right != null) nodeQueue.enqueue(temp.right);
        }
    }
}
