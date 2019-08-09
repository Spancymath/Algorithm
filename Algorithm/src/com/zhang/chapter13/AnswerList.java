package com.zhang.chapter13;

import com.zhang.chapter12.Transaction;
import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 背包、队列和栈
 * 1.泛型
 * 2.背包：不支持从中删除元素的数据类型
 * 3.队列：先进先出
 * 4.下压栈：后进先出
 * 5.算术表达式求值
 *   将操作数压入操作数栈
 *   将运算符压入运算符栈
 *   忽略左括号
 *   遇到右括号，弹出一个运算符，弹出所需数量的操作数，并将运算符和操作数的结果压入操作数栈
 * 6.调整数组大小：元素个数等于数组容量，数组扩容一倍；元素个数小于数组容量1/4，数组缩小一半
 * 7.可迭代的数据类型
 *   实现一个iterator()方法，并返回一个iterator对象
 *   Iterator类必须包含两个方法：hasNext() 和 next()
 *   在类的声明中加入implements Iterable<Item>
 * 8.链表：是数组的一种重要的替代方式
 */
public class AnswerList {
    /**
     * 1.3.1 添加isFull（）方法
     * answer：
     *          FixeCapacityStackOfString.isFull()
     */
    /**
     * 1.3.2 出栈顺序
     * answer:
     *          was best times of the was the it
     */
    /**
     * 1.3.3 不可能的出栈顺序
     * answer:
     *          b f g
     */
    /**
     * 1.3.4 括号是否匹配
     * answer：
     *          Parentheses
     */
    /**
     * 1.3.5 生成数的二进制表示
     * 测试见main方法
     */
    public String ToBinary(int decimal) {
        Stack<Integer> stack = new Stack<>();
        while (decimal > 0) {
            stack.push(decimal % 2);
            decimal = decimal / 2;
        }
        String binary = "";
        for (int d : stack) binary += d;
        return binary;
    }
    /**
     * 3.1.6
     * answer：
     *          倒序队列
     */
    /**
     * 3.1.7
     * answer：
     *          见stack
     */
    /**
     * 3.1.8
     * answer：
     *          最后是空栈
     */
    /**
     * 中序表达式：我们日常用到的直观的表达式
     *              例：2*3/(2-1)+3*(4-1)
     * 前序表达式：运算符写在操作数的前边，从右到左依次读取一个操作符和两个操作数
     *              计算结果压入栈中。 例：+/*23-21*3-41
     * 后序表达式：运算符写在操作数后边，从左到右，依次读取两个操作数和一个操作符
     *              计算结果压入栈中。例：23*21-/341-*+
     */
    /**
     * 1.3.9补全左括号
     * 思路：v1.0初始化两个栈，符号栈和结果栈。从右往左依次读取字符串，遇到右括，继续
     *      读取，直到下一个不是右括号，读取两个数字，一个符号，压入结果栈，并将
     *      符号压入符号栈，此时看符号栈右几个符号，就压入结果栈几个左括号，清空符号栈
     *      v1.2 从右到左读取，遇到数字，如果操作符栈顶不是右括号，加左括号
     *详见RepaiParen.java
     */
    /**
     * 1.3.10 中序转后序表达式
     * 思路：
     *      遇到数字入结果队列
     *      遇到符号，入符号栈
     *      遇到左括号，忽略；遇到右括号则符号出栈入到结果队列
     *
     *      见InfixToPostfix.java
     */
    /**
     * 1.3.11 计算中序表达式的值
     *answer：
     *      见EvaluatePostfix.java
     */
    /**1.3.12
     * answer：
     *      见stack的copy（）
     */
    /**
     * 1.3.13
     * answer:
     *      b c d
     */
    /**
     * 1.3.14
     * answer:
     *          见ResizingArrayQueueOfStrings的resize（）方法
     */
    /**
     * 1.3.15
     *answer:
     *          见test15
     */

    private String EXIT = "exit;";

    public void test15() {
        Queue<String> queue = new Queue<>();
        StdOut.print("输入k：");
        int k = StdIn.readInt();
        while (true) {
            String s = StdIn.readString();
            if (s.equals(EXIT)) break;
            if (queue.size() == k) queue.dequeue();
            queue.enqueue(s);
        }
        StdOut.println(queue.dequeue());
    }
    /**
     * 1.3.16
     * answer：
     *          见下边readDates（）
     */
    public Date[] readDates() {
        Queue<Date> queue = new Queue<>();
        while (true) {
            String date = StdIn.readString();
            if (date.equals(EXIT)) break;
            queue.enqueue(new Date(date));
        }
        Date[] dates = new Date[queue.size()];
        int i = 0;
        while (!queue.isEmpty()) {
            dates[i++] = queue.dequeue();
        }
        return dates;
    }
    /**
     * 1.3.17
     * answer:
     *          见下边readTrasaction（）
     */
    public Transaction[] readTransaction() {
        Queue<Transaction> queue = new Queue<>();
        while (true) {
            String transaction = StdIn.readString();
            if (transaction.equals(EXIT)) break;
            queue.enqueue(new Transaction(transaction));
        }
        Transaction[] transactions = new Transaction[queue.size()];
        int i = 0;
        while (!queue.isEmpty()) {
            transactions[i] = queue.dequeue();
        }
        return transactions;
    }
    /**
     * 3.1.18
     * answer:
     *          删除x的后续节点
     */
    /**
     * 3.1.19
     * answer:
     *          见下边deleteLast（）
     */
    public class Node<Item> {
        Item item;
        Node next;
        public Node() {
            item = null;
            next = null;
        }
    }
    public Node deleteLast(Node first) {
        //判断链表为空，或者只有一个元素
        if (first.next == null || first == null) {
            first = null;
            return null;
        }
        Node temp = first;
        while (first.next.next != null) first = first.next;
        first.next = first.next.next;
        return temp;
    }
    /**
     * 1.3.20
     * 删除链表第k个元素
     * answer：
     *          见下边delete（）
     */
    public Node delete(int k, Node first) {
        if (k == 0 || first == null) return null;
        if (k == 1) return first.next;
        Node temp = first;
        while (--k != 1 && first.next != null) {
            first =  first.next;
        }
        if (k == 1 && first.next != null) first.next = first.next.next;
        return temp;
    }
    //打印链表
    public void printNodes(Node first) {
        if (first == null) return;
        while (first != null) {
            StdOut.print(first.item + " ");
            first = first.next;
        }
        StdOut.println();
    }
    /**
     * 1.3.21
     * 查找链表存在某元素
     * answer：
     *          见find()
     */
    public boolean find(Node node, Node first) {
        if (node == null || node.item == null) return false;
        while (first != null) {
            if (node.item.equals(first.item)) return true;
            first = first.next;
        }
        return false;
    }
    /**
     * 1.3.22
     * answer:
     *          插入结点t，并使它成为x的后续结点
     */
    /**
     * 1.3.23
     * answer：
     *          更新t.next时x.next已经不指向x的后续结点
     */
    /**
     * 1.3.24
     * 删除链表中一个结点的后序结点
     */
    public void removeAfter(Node node) {
        if (node == null || node.next == null) return;
        node.next = null;
    }
    /**
     * 1.3.25
     * 使第二个链表成为第一个链表的后序结点
     */
    public void insertAfter(Node node1, Node node2) {
        if (node1 == null || node2 == null) return;
        node1.next = node2;
    }
    /**
     * 1.3.26
     * 删除key值的结点
     */
    public void remove(Node node, String key) {
        if (node == null) return;
        while (node != null && node.item.equals(key)) node = node.next;
        while (node.next != null) {
            if (node.next.item.equals(key)) {
                node.next = node.next.next;
            }
            node = node.next;
        }
    }
    /**
     * 1.3.27
     * 找出链表最大值
     */
    public int max(Node node) {
        int max = 0;
        while (node != null) {
            if (max < (int)node.item) max = (int)node.item;
            node = node.next;
        }
        return max;
    }
    /**
     * 1.3.28
     * 递归找出链表的最大值
     */
    public int max28(Node node) {
        if (node == null) return 0;
        int temp = max28(node.next);
        if (temp > (int)node.item) {
            return temp;
        } else {
            return (int)node.item;
        }
    }
    /**
     * 1.3.29
     * 循环队列
     * 详见QueueCircularList类
     * 下边为测试方法
     */
    public void test29() {
        QueueCircularList<String> queueCircularList = new QueueCircularList<>();
        //StdOut.println("输入操作指令：1-->入队；2-->出队；0-->退出");
        while (true) {
            StdOut.println("输入操作指令：1-->入队；2-->出队");
            String word = StdIn.readString();
            if (word.equals("1")) {
                queueCircularList.enqueue(StdIn.readString());
            } else if (word.equals("2")) {
                StdOut.println(queueCircularList.dequeue());
            } else if (word.equals("0")) {
                StdOut.println("退出");
                break;
            }
        }
    }
    /**
     * 1.3.30
     * 反转链表的两个方法：迭代、递归
     * 迭代思路：依次把原链表结点插入新链表头
     * 递归思想：依次从倒数第二个结点开始，把当前结点的next置空，把原下一个结点的next指向当前结点
     */
    //迭代方法
    public Node reverse1(Node x) {
        Node first = x;
        Node reverse = null;
        while (first != null) {
            Node seconde = first.next;
            first.next = reverse;
            reverse = first;
            first = seconde;
        }
        return reverse;
    }
    //递归方法
    public Node reverse2(Node first) {
        //原链表为空
        if (first == null) return null;
        //尾结点
        if (first.next == null) return first;
        Node second = first.next;
        //这一行second的next不能变，所以只能放在这儿
        Node ret = reverse2(second);
        second.next = first;
        first.next = null;
        return ret;
    }
    /**
     * 1.3.31
     * 双向链表
     * 详见DoubleNode类
     */
    public void test31() {
        DoubleList<String> list = new DoubleList<>();
        while (true) {
            StdOut.println("1添加链表头；2删除链表头；3添加链表尾；4删除链表尾；" +
                    "5删除指定结点；6指定结点前插入；7指定结点后插入；0退出");
            int option = StdIn.readInt();
            if (option == 1) list.addHead(StdIn.readString());
            else if (option == 2) list.deleteHead();
            else if (option == 3) list.addTail(StdIn.readString());
            else if (option == 4) list.deleteTail();
            else if (option == 5) list.deleteItem(StdIn.readString());
            else if (option == 6) list.addItemPrevoius(StdIn.readString(), StdIn.readString());
            else if (option == 7) list.addItemNext(StdIn.readString(), StdIn.readString());
            else if (option == 0) break;
            list.print();
        }
    }
    /**
     * 1.3.32
     * Steque以栈为目标的队列
     * API：
     *      public class Steque<Item> implements Iterable<Item>
     *      ***************************************************
     *                     Steque()            创建队列
     *      boolean        isEmpty()           队列是否为空
     *      int            size()              队列中元素数量
     *      void           push(Item item)     队列头部添加元素
     *      Item           pop()               队列头部删除元素
     *      void           enqueue(Item item)  队列尾部添加元素
     *
     */
    /**
     * 1.3.32
     * 以栈为目标的队列Steque
     * 测试
     */
    public void test32() {
        Steque<String> steque = new Steque<>();
        while (true) {
            StdOut.println("1入栈；2出栈；3栈尾入栈；0退出");
            int option = StdIn.readInt();
            if (option == 1) steque.push(StdIn.readString());
            else if (option == 2) StdOut.println(steque.pop());
            else if (option == 3) steque.enqueue(StdIn.readString());
            else if (option == 0) break;

            for (String s : steque) {
                StdOut.print(s + ", ");
            }
            if (!steque.isEmpty()) StdOut.println();
        }

    }

    /**
     * 1.3.33
     * 双向队列：
     *          链表实现DequeList
     *          动态数组实现DequeArray
     * 测试
     */
    public void test33() {
        //测试链表实现
        //DequeList<String> dequeList = new DequeList<>();
        //测试数组实现
        DequeArray<String> dequeList = new DequeArray<>();
        while (true) {
            StdOut.println("1添加链表头；2删除链表头：3添加链表尾；4删除链表尾；0退出");
            int option = StdIn.readInt();
            if (option == 1) dequeList.pushHead(StdIn.readString());
            else if (option == 2) StdOut.println(dequeList.popHead());
            else if (option == 4) StdOut.println(dequeList.popTail());
            else if (option == 3) dequeList.pushTail(StdIn.readString());
            else if (option == 0) break;
            for (String s:dequeList) {
                StdOut.print(s + ", ");
            }
            StdOut.println();
        }

    }

    /**
     * 1.3.34
     * 随机背包RandomBag
     */
    public void test34() {
        RandomBag<String> bag = new RandomBag<>();
        while (true) {
            StdOut.println("添加");
            bag.add(StdIn.readString());
            for (String s : bag) {
                StdOut.print(s + ", ");
            }
            if (!bag.isEmpty()) StdOut.println();
        }
    }
    /**
     * 1.3.35
     * 随机队列RandomQueue
     * 测试：扑克发牌
     */
    public void test35() {
        class Card {
            char color;
            int point;
        }
        RandomQueue<Card> queue = new RandomQueue<>();
        for (int i = 0; i < 4; i++) {
            int num = (int) 'A';
            char color = (char) (num + i);
            for (int j = 1; j < 14; j++) {
                Card card = new Card();
                card.color = color;
                card.point = j;
                queue.enqueue(card);
            }
        }
        String[] person = {"", "", "", "", "", ""};
        while (queue.sample() != null) {
            for (int i = 1; i < 5; i++) {
                Card card = queue.dequeue();
                person[i] += card.color + "" + card.point + ",";
            }
        }
        for (int i = 1; i < 5; i++) {
            StdOut.println(person[i]);
        }
    }
    /**
     * 1.3.36
     * 队列随机迭代器
     */
    public void test36() {
        class Card {
            char color;
            int point;
        }
        RandomQueue<Card> queue = new RandomQueue<>();
        for (int i = 0; i < 4; i++) {
            int num = (int) 'A';
            char color = (char) (num + i);
            for (int j = 1; j < 14; j++) {
                Card card = new Card();
                card.color = color;
                card.point = j;
                queue.enqueue(card);
            }
        }
        String[] person = {"", "", "", "", "", ""};
        int i = 1;
        for (Card card : queue) {
            person[i] += card.color + "" + card.point + ",";
            i = i % 4 + 1;
        }

        for (i = 1; i < 5; i++) {
            StdOut.println(person[i]);
        }

    }
    /**
     * 1.3.38       (好像是37题，呵呵呵哒，，管他呢)
     * Josephus问题
     * 测试：
     *          数组实现GeneralizedQueueArray
     *          链表实现
     */
    public void test38() {
        StdOut.println("依次输入总人数、杀第几个：");
        int n = StdIn.readInt();
        int m = StdIn.readInt();
        //测试数组实现
        //GeneralizedQueueArray<Integer> queue = new GeneralizedQueueArray<>(n, m);
        //测试链表实现
        GeneralizedQueueList<Integer> queue = new GeneralizedQueueList<>();
        for (int i = 0; i < n; i++) {
            queue.insert(i);
        }
        while (!queue.isEmpty()) {
            StdOut.println(queue.delete(m) + "  ");
        }
        StdOut.println();
    }
    /**
     * 1.3.39
     * 环形缓冲区ringbuffer
     * API:
     *          Public class RingBuffer
     *          **********************************************************
     *                      Buffer(int N)       创建一个空队列
     *          boolean     isEmpty()           队列为空
     *          boolean     isFull()            队列已满
     *          void        enqueue(Item item)  入队
     *          Item        dequeue()           出队
     */

    /**
     * 1.3.40
     * 前移编码  MoveToFirst
     * API:
     *          Public class MoveToFirst
     *          **********************************************************
     *                      MoveToFirst         创建一个空链表
     *          boolean     isEmpty()           判空
     *          int         size()              链表中元素多少
     *          int         contain(Item item)  是否包含某个元素
     *          void        delete(int k)       删除元素
     *          void        push(Item item)     加入元素到链表
     *          Item        pop()               出栈
     */
    /**
     * 1.3.42
     * 复制队列
     * 测试
     */
    public void test42() {
        Queue<Integer> q = new Queue<>();
        StdOut.println("输入加入队列的数字，以-1结束");
        while (true) {
            int num = StdIn.readInt();
            if (num == -1) break;
            q.enqueue(num);
        }
        StdOut.println("q:");
        for (Integer num : q) {
            StdOut.print(num + ",");
        }
        StdOut.println();
        Queue<Integer> r = new Queue<>(q);
        StdOut.println("r:");
        for (Integer num : r) {
            StdOut.print(num + ",");
        }
        StdOut.println();
        for (Integer num : q) {
            r.enqueue(num);
        }
        StdOut.println("r + q : ");
        for (Integer num : r) {
            StdOut.print(num + ",");
        }
    }

    /**
     * 1.3.43
     * 复制队列
     * 测试
     */
    public void test43() {
        Stack<Integer> q = new Stack<>();
        StdOut.println("输入加入栈的数字，以-1结束");
        while (true) {
            int num = StdIn.readInt();
            if (num == -1) break;
            q.push(num);
        }
        StdOut.println("q:");
        for (Integer num : q) {
            StdOut.print(num + ",");
        }
        StdOut.println();
        Stack<Integer> r = new Stack<>(q);
        StdOut.println("r:");
        for (Integer num : r) {
            StdOut.print(num + ",");
        }
        StdOut.println();
        for (Integer num : q) {
            r.push(num);
        }
        StdOut.println("r + q : ");
        for (Integer num : r) {
            StdOut.print(num + ",");
        }
    }
    /**
     * 1.3.45
     * 栈的可生成性
     */
    public void test45() {
        //序列个数
        int N = 20;
        //下一个入栈的数
        int i = 0;
        //栈
        Stack<Integer> stack = new Stack<>();
        //需要判断的序列
        Queue<Integer> queue = new Queue<>();
        //生成序列。。。
        //存放结果的队列
        Queue<String> result = new Queue<>();

        while (i < N && !queue.isEmpty()) {
            if (i > queue.peek() && queue.peek() < stack.peek()) {
                StdOut.println("fail");
                break;
            }
            while (i < N && i <= queue.peek()) {
                stack.push(i);
                result.enqueue(i++ + "");
            }
            while (!stack.isEmpty() && stack.peek() == queue.peek()) {
                stack.pop();
                queue.dequeue();
                result.enqueue("-");
            }
        }
    }
    /**
     * 测试主方法
     * @param args
     */

    public static void main(String[] args) {
        AnswerList al = new AnswerList();
        //1.3.5
        //StdOut.println(al.ToBinary(100));
        //1.3.15
        //al.test15();
        //新建链表，测试针对链表的练习
        /*Node<String> first = null;
        while (true) {
            String s = StdIn.readString();
            if (s.equals("exit;")) break;
            if (first == null) {
                first = al.new Node<String>();
                first.item = s;
                first.next = null;
                continue;
            }
            Node node = first;
            first = al.new Node<String>();
            first.item = s;
            first.next = node;
        }
        al.printNodes(first);*/
        //测试1.3.19
        //Node newFirst = al.deleteLast(first);
        //al.printNodes(newFirst);
        //测试1.3.20
        /*while (true) {
            StdOut.println("要删除第几个：");
            int k = StdIn.readInt();
            if (k == 0) break;
            first = al.delete(k, first);
            al.printNodes(first);
        }*/
        //测试1.3.21
        /*StdOut.println("请输入要查找的字符串:");
        String word = StdIn.readString();
        Node<String> node = al.new Node<>();
        node.item = word;
        boolean find = al.find(node, first );
        StdOut.println(find);
         */
        //测试1.3.24
        /*Node node = first;
        StdOut.println("删除第几个结点后的结点：");
        int i = StdIn.readInt();
        while (--i != 0) {
            node = node.next;
        }
        al.removeAfter(node);
        al.printNodes(first);*/
        //测试1.3.25
        /*Node<String> second = null;
        Node<String> node = first;
        while (node != null) {
            Node<String> tail = al.new Node<>();
            tail.item = node.item;
            tail.next = second;
            second = tail;
            node = node.next;
        }
        al.insertAfter(first, second);
        al.printNodes(first);*/

        //测试1.3.26
        /*StdOut.println("需要删除的键是：");
        String key = StdIn.readString();
        //修正不能删除第一个
        while (first != null && first.item.equals(key)) first = first.next;
        al.remove(first, key);
        al.printNodes(first);*/

        //测试1.3.27
        /*Node<Integer> second = null;
        Node<String> node = first;
        while (node != null) {
            Node<Integer> tail = al.new Node<>();
            tail.item = Integer.parseInt(node.item);
            tail.next = second;
            second = tail;
            node = node.next;
        }*/
        //StdOut.println(al.max(second));

        //测试1.3.28
        //StdOut.println(al.max28(second));
        //测试1.3.29
        //al.test29();
        //测试1.3.31
        //al.test31();
        //1.3.32
        //al.test32();
        //测试1.3.33
        //al.test33();
        //测试1.3.34
        //al.test34();
        //测试1.3.35
        //al.test35();
        //测试1.3.36
        //al.test36();
        //测试1.3.不知道37还是38了
        //al.test38();
        //测试1.3.42
        //al.test42();
        //测试1.3.43
        al.test43();
    }

}
