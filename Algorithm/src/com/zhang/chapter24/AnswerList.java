package com.zhang.chapter24;

import com.zhang.chapter13.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 优先队列
 * 1.优先队列最重要的操作是删除最大元素和插入元素
 * 2.堆：二叉堆的数组中，每个元素都大于等于另两个特定位置的元素
 * 3.由下向上的堆有序化（上浮swim）
 * 4.由上至下的堆有序化（下沉sink）
 * 5.插入，把元素放入数组最后一个位置，上浮使堆有序
 * 6.删除，删去第一个元素，把最后一个元素放入堆顶，下沉使堆有序
 * 7.索引优先队列，为队列中的每个元素添加一个索引
 * 8.堆排序：将元素依次加入堆中，并顺序取出堆顶元素
 * 9.将N个元素排序，堆排序只需少于2NlgN+2N次比较，以及一半次数的交换
 */
public class AnswerList {
    /**
     * 2.4.1
     * 优先队列返回最大元素顺序
     * Solution:
     *          RRPOTYIIUQEU
     */
    /**
     * 2.4.2
     * Solution:
     *          为了更快的找到下一个最大元素，比常数时间更优
     */
    /**
     * 2.4.3
     *给定数据结构实现优先队列
     * Solution:
     *          无序数组：MaxPQarray
     *          有序数组：MaxPQsortArray
     *          无序链表：MaxPQlist
     *          有序链表：MaxPQsortList
     */
    /**
     * 2.4.4
     * 降序数组是最大堆吗
     * Solution:
     *              是，肯定是
     */
    /**
     * 2.4.5
     * 最大元素堆顺序
     * Solution：
     *          YTUSQNEASIOE
     */
    /**
     * 2.4.6
     * 略
     *
     */
    /**
     * 2.4.7
     * k大元素
     * Solution:
     *          2: 2或3位置
     *          3：2、3、4、5、6、7
     *          4：4、5、6、7、8、9、10、11、12、13、14、15
     */
    /**
     * 2.4.8
     * k小元素
     * Solution:
     *          1:16-31
     *          2:8-31
     *          3:4-31
     *          4:2-31
     */
    /**
     * 2.4.9
     * 堆的可能性
     * Solution:
     *          8， 2
     */
    /**
     * 2.4.10
     * 位置0也放数
     * Solution:
     *              k: 父结点((k - 1) / 2)
     *                 子结点（(k + 1) * 2 - 1, (k + 1) * 2）
     */
    /**
     * 2.4.11
     * 大量插入元素，堆，有序数组，无序数组那个合适
     * Solution:
     *          无序数组，复杂度为1
     */
    /**
     * 2.4.12
     * 大量找出最大元素的操作
     * Solution:
     *          有序数组，复杂度为1
     */
    /**
     * 2.4.13
     * sink中避免检查j < N
     * Solution:
     *          让N+1的值为sink元素的值
     */
    /**
     * 2.4.14
     * 交换元素个数
     * Solution:
     *           删除最大元素交换lgN - 1个
     *           2
     */
    /**
     * 2.4.15
     * 检测面向最小元素的堆
     *
     */
    public boolean testMinHeap(Comparable[] a, int N) {
        if (N == 1) return true;
        for (int i = 2; i <= N / 2; i++) {
            if (a[i / 2].compareTo(a[i]) > 0) return false;
        }
        return true;
    }
    /**
     * 2.4.16
     * 堆排序比较次数最大最小的堆
     * 略  https://www.cnblogs.com/longjin2018/p/9868636.html
     */
    /**
     * 2.4.17
     * 显然
     */
    /**
     * 2.4.18
     * Solution:
     *          相同
     *          相同
     */
    /**
     * 2.4.19
     * 略
     */
    /**
     * 2.4.20
     * 略
     */
    /**
     * 2.4.21
     * 略
     */
    /**
     * 2.4.22
     * 调整数组大小
     * 见MaxPQ.java
     */
    /**
     * 2.4.23
     * 略
     */
    /**
     * 2.4.24
     * 使用链接的优先队列
     * 见MaxPQlinks.java
     */
    /**
     * 2.4.25
     * 计算数论
     */
    public class Cube implements Comparable<Cube> {
        long sum = 0;
        int a = 0;
        int b = 0;
        public Cube(int a, int b) {
            this.a = a;
            this.b = b;
            this.sum = a * a * a + b * b * b;
        }

        @Override
        public int compareTo(Cube o) {
            long t = o.sum;
            if (this.sum < t) return -1;
            else if (this.sum > t) return 1;
            else return 0;
        }

        public String print() {
            return a + "," + b + "   ";
        }
    }

    public void CubeSum() {
        int N = 1000;
        MinPQ<Cube> pq = new MinPQ<>(N);
        for (int i = 0; i <= N; ++i) {
            pq.insert(new Cube(i, 0));
        }

        Queue<Cube> queue = new Queue<>();
        while (true) {
            if (pq.isEmpty()) break;
            Cube c = pq.delMin();
            if (queue.isEmpty() || queue.peek().sum == c.sum) {
                queue.enqueue(c);
            } else {
                if (queue.size() > 2) {
                    StdOut.print(queue.peek().sum + ": ");
                    while (!queue.isEmpty()) {
                        StdOut.print(queue.dequeue().print());
                    }
                    StdOut.println();
                } else {
                    queue.dequeue();
                }
                queue.enqueue(c);
            }
            int j = c.b;
            if (j < N) {
                pq.insert(new Cube(c.a, j + 1));
            }
        }
        if (!queue.isEmpty() && queue.size() > 1) {
            StdOut.println(queue.peek().sum + ": ");
            while (!queue.isEmpty()) {
                StdOut.print(queue.dequeue().print());
            }
        }
    }

    /**
     * 2.4.26
     * 无需交换的堆
     * 见MinPQ
     *
     */
    /**
     * 2.4.27
     * 找出最小元素
     * Solution:
     *          设置一个最小元素变量，insert的时候更新
     *          空队列返回null
     *          非空队列，不会delete最小元素（最起码留一个最小）
     */
    /**
     * 2.4.28
     * 选择过滤
     *
     */
    public class Eucidean implements Comparable<Eucidean> {
        double x = 0;
        double y = 0;
        double z = 0;
        double distance = 0;
        public Eucidean(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.distance = x * x + y * y + z * z;
        }

        @Override
        public int compareTo(Eucidean o) {
            if (this.distance < o.distance) return -1;
            else if (this.distance > o.distance) return 1;
            else return 0;
        }
    }

    public void topM() {
        int N = 100000000;
        int M = 10000;
        MinPQ<Eucidean> pq = new MinPQ<Eucidean>(N);
        for (int i = 0; i < N; i++) {
            pq.insert(new Eucidean(StdRandom.uniform(), StdRandom.uniform(), StdRandom.uniform()));
            if (i % M == 0) StdOut.println("insert " + i);
        }

        for (int i = 0; i < M; i++) {
            StdOut.println(pq.delMin().distance);
        }
    }
    /**
     * 2.4.29
     * 面向最大最小元素的优先队列
     */
    public void test29() {
        int N = 100;
        MaxPminQ<Integer> pq = new MaxPminQ<>(N);
        while (true) {
            int o = StdIn.readInt();
            switch (o) {
                case 1:
                    pq.insert(StdIn.readInt());
                    break;
                case 2:
                    StdOut.println(pq.deleteMax());
                    break;
                case 3:
                    StdOut.println(pq.deleteMin());
                    break;
                default:
                    StdOut.println("输入错误");
                    break;

            }
        }
    }
    class Parent {
        int i = 1;
        Parent() {
            System.out.println(i);
            int x = getValue();
            System.out.println(x);
        }
        {i = 2;}
        protected int getValue() {return i;}
    }
    class Son extends Parent {
        int j = 1;
        Son() {j = 2;}
        {j = 3;}
        protected int getValue() {
            return j;
        }
    }
    /**
     * 2.4.30
     * 动态中位数查找
     * 见MedianFinding.java
     */
    /**
     * 2.4.31
     * 快速插入
     * 见MinPQFastInsert.java
     */
    /**
     * 2.4.32
     * 下界
     * 略
     */
    /**
     * 2.4.33
     * 索引优先队列
     */
    /**
     * 主方法
     * @param args
     */

    public static void main(String[] args) {
        AnswerList al = new AnswerList();
        //al.CubeSum();
        //al.topM();
        //al.test29();
        //Son son = al.new Son();
        //System.out.println(son.getValue());
    }
}
