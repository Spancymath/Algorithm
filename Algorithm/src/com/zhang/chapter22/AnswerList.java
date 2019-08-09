package com.zhang.chapter22;

import com.zhang.chapter13.Queue;

/**
 * 归并排序
 * 1.原地归并：用一个辅助数组，两个指针都指向辅助数组，对比值填充到原数组
 * 2.自顶向下的归并，递归
 * 3.自底向上的归并排序
 * 4.归并排序是一种渐进最优的基于比较排序的算法，复杂度NlgN
 */
public class AnswerList {
    /**
     * 2.2.1
     * merge（）轨迹
     * answer：
     *       k  0  1  2  3  4  5  6  7  8  9  10 11   i  j   0  1  2  3  4  5  6  7  8  9  10 11
     * input    A  E  Q  S  U  Y  E  I  N  O  S  T
     * copy     A  E  Q  S  U  Y  E  I  N  O  S  T           A  E  Q  S  U  Y  E  I  N  O  S  T
     *                                                0  6
     *       0  A                                     1  6   A                 E
     *       1     E                                  2  6      E              E
     *       2        E                               2  7         Q           E
     *       3           I                            2  8         Q             I
     *       4              N                         2  9         Q                N
     *       5                 O                      2  10        Q                   O
     *       6                    Q                   3  10        Q                      S
     *       7                       S                4  10           S                   S
     *       8                          S             4  11              U                S
     *       9                             T          4  12              U                   T
     *       10                               U       5  12              U
     *       11                                  Y    6  12                 Y
     * result   A  E  E  I  N  O  Q  S  S  T  U  Y
     */

    /**
     * 2.2.2
     * 自顶向下归并排序轨迹
     * answer：
     *                            0  1  2  3  4  5  6  7  8  9  10 11
     *                            E  A  S  Y  Q  U  E  S  T  I  O  N
     *        merge(a, 0, 1, 1)   A  E
     *        merge(a, 2, 2, 2)         S
     *        merge(a, 0, 1, 2)   A  E  S
     *        merge(a, 3, 4, 4)            Q  Y
     *        merge(a, 5, 5, 5)                  U
     *        merge(a, 3, 4, 5)            Q  U  Y
     *        merge(a, 0, 2, 5)   A  E  Q  S  U  Y
     *        merge(a, 6, 7, 7)                     E  S
     *        merge(a, 8, 8, 8)                           T
     *        merge(a, 6, 7, 8)                     E  S  T
     *        merge(a, 9, 10,10)                             I  O
     *        merge(a, 11,11,11)                                   N
     *        merge(a, 9, 10,11)                             I  N  O
     *        merge(a, 6, 8, 11)                    E  I  N  O  S  T
     *        merge(a, 0, 5, 11)  A  E  E  I  N  O  Q  S  S  T  U  Y
     */
    /**
     * 2.2.3
     * 自底向上的归并排序轨迹
     * answer：
     *                            0  1  2  3  4  5  6  7  8  9  10 11
     *                            E  A  S  Y  Q  U  E  S  T  I  O  N
     *        merge(a, 0, 0, 1)   A  E
     *        merge(a, 2, 2, 3)         S  Y
     *        merge(a, 4, 4, 5)               Q  U
     *        merge(a, 6, 6, 7)                     E  S
     *        merge(a, 8, 8, 9)                           I  T
     *        merge(a, 10,10,11)                                N  O
     *        merge(a, 0, 1, 3)   A  E  S  Y
     *        merge(a, 4, 5, 7)               E  Q  S  U
     *        merge(a, 8, 9, 11)                          I  N  O  T
     *        merge(a, 0, 3, 7)   A  E  E  Q  S  S  U  Y
     *        merge(a, 8, 11,11)                          I  N  O  T
     *        merge(a, 0, 7, 11)  A  E  E  I  N  O  Q  S  S  T  U  Y
     *
     */
    /**
     * 2.2.4
     * 归并子数组必须有序
     * answer：
     *          是的，假如一个子数组有两个元素无序，排序后这两个元素相对位置不变，还是无序数组
     *          反例：1 2  和  5 4，归并后是1 2 5 4
     *
     */
    /**
     * 2.2.5
     * N为39，给出归并子数组大小
     * answer：
     *          0  38，19，9，4，2，1； 20 38，29，24，22，21；30 38，34，32，31；35 38，36
     *          自顶向下：
     *                  0  1
     *                        2
     *                  0     2
     *                           3  4
     *                  0           4
     *                                 5  6
     *                                      7
     *                                 5    7
     *                                         8  9
     *                                 5          9
     *                  0                         9
     *                                               10 11
     *                                                     12
     *                                               10    12
     *                                                        13 14
     *                                               10          14
     *                                                              15 16
     *                                                                    17
     *                                                              15    17
     *                                                                       18 19
     *                                                              15          19
     *                                               10                         19
     *                  0                                                       19
     *                                                                             20 21
     *                                                                                   22
     *                                                                             20    22
     *                                                                                      23 24
     *                                                                             20          24
     *                                                                                            25 26
     *                                                                                                  27
     *                                                                                            25    27
     *                                                                                                     28 29
     *                                                                                            25          29
     *                                                                             20                         29
     *                                                                                                           30 31
     *                                                                                                                 32
     *                                                                                                           30    32
     *                                                                                                                    33 34
     *                                                                                                           30          34
     *                                                                                                                          35 36
     *                                                                                                                                37 38
     *                                                                                                                          35       38
     *                                                                                                           30                      38
     *                                                                             20                                                    38
     *                  0                                                                                                                38
     *
     *
     *          自底向上：
     *          sz=1    0  1
     *                        2  3
     *                              4  5
     *                                    6  7
     *                                          8  9
     *                                               10 11
     *                                                     12 13
     *                                                           14 15
     *                                                                 16 17
     *                                                                       18 19
     *                                                                             20 21
     *                                                                                   22 23
     *                                                                                         24 25
     *                                                                                               26 27
     *                                                                                                     28 29
     *                                                                                                           30 31
     *                                                                                                                 32 33
     *                                                                                                                       34 35
     *                                                                                                                             36 37
     *                                                                                                                                   38
     *          sz=2    0        3
     *                              4        7
     *                                          8      11
     *                                                    12       15
     *                                                                16       19
     *                                                                            20       23
     *                                                                                        24       27
     *                                                                                                    28       31
     *                                                                                                                32       35
     *                                                                                                                            36    38
     *          sz=4    0                    7
     *                                          8                  15
     *                                                                16                   23
     *                                                                                        24                   31
     *                                                                                                                32                38
     *          sz=8    0                                          15
     *                                                                16                                           31
     *                                                                                                                32                38
     *          sz=16   0                                                                                          31
     *                                                                                                                32                38
     *          sz=32   0                                                                                                               38
     */
    /**
     * 2.2.6
     * 略
     */
    /**
     * 2.2.7
     * 略
     */
    /**
     * 2.2.8
     * 略
     */
    /**
     * 2.2.9
     * Solution:
     *          详见MergeDownAux.java
     */
    /**
     * 2.2.10
     * 快速归并
     * Solution：
     *          下标都向中间走，一边循环完，就只能循环另一边了
     */
    private void merge(Comparable[] a, int lo, int mid, int hi) {

        int i = lo, j = hi;
        Comparable[] aux = new Comparable[a.length];

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (less(aux[i], aux[j])) a[k] = aux[i++];
            else a[k] = aux[j--];
        }
    }
    public boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    /**
     * 2.2.11
     * 改进
     * solution：
     *          详见MergeDown.java
     */
    /**
     * 2.2.12
     * 次线性的额外空间
     * 略
     */
    /**
     * 2.2.13
     * 平均情况的下限
     * solution：
     *          N个元素有N!个排列，有N!个叶子结点的牌序树的高度最小，
     *          是树平衡的时候，为lgN!近似于NlgN
     */
    /**
     * 2.2.14
     * 归并有序的队列
     * solution：
     *
     */
    public Queue mergerQueue(Queue<Comparable> a, Queue<Comparable> b) {
        int i = a.size();
        while (i != 0 || !b.isEmpty()) {
            if (b.isEmpty()) {
                a.enqueue(a.dequeue());
                i--;
            }
            else if (i == 0) {
                a.enqueue(b.dequeue());
            } else if (less(a.peek(), b.peek())) {
                a.enqueue(a.dequeue());
                i--;
            } else {
                a.enqueue(b.dequeue());
            }
        }
        return a;
    }
    /**
     * 2.2.15
     * 自底向上的有序队列归并排序
     * solution：
     *          入参的队列中的也是队列
     */
    public Queue MergeQueueSort(Queue<Queue> q) {
        if (q.isEmpty()) return null;
        while (q.size() != 1) {
            q.enqueue(mergerQueue(q.dequeue(), q.dequeue()));
        }
        return q;
    }
    /**
     * 2.2.16
     * 自然的归并排序
     */
    public void natureMerge(Comparable[] a) {
        int N = a.length;
        int lo = 0;
        int mid = arrayEnd(a, 0);
        int hi = arrayEnd(a, mid + 1);
        while (!(lo == 0 && hi == N - 1)) {
            merge(a, lo, mid, hi);
            lo = hi + 1;
            if (lo >= N) lo = 0;
            mid = arrayEnd(a, lo);
            if (mid == N - 1) {
                lo = 0;
                mid = arrayEnd(a, lo);
            }
            hi = arrayEnd(a, mid + 1);
        }
    }

    /**
     * 找到有序部分的结束位置
     */
    public int arrayEnd(Comparable[] a, int start) {
        while (start + 1 < a.length) {
            if (less(a[start], a[start + 1])) start++;
            else break;
        }
        return start;
    }
    /**
     * 2.2.17
     * 链表排序
     */
    public class Node{
        Comparable item;
        Node last;
        Node next;
    }
    //自然链表排序
    public void natureMergeList(Node head) {
        int N = 0;
        for (Node p = head; p != null; p = p.next) N++;
        Node p = head;
        int i = arrayLength(head, 0);
        int j = arrayLength(head, i);
        while (i != N) {
            p = mergeList(p, i, j);
            if (p == null) p = head;
            i = arrayLength(p, 0);
            j = arrayLength(p, i);
        }
    }
    //找出有序部分长度
    public int arrayLength(Node tail, int ignore) {
        while (ignore-- != 0 && tail != null) {
            tail = tail.next;
        }
        if (tail == null) return 0;
        int i = 1;
        tail = tail.next;
        for (; tail != null && less(tail.last.item, tail.item); tail = tail.next) {
                i++;
        }
        return i;
    }
    //归并两个有序数组
    public Node mergeList(Node node1, int l1, int l2) {
        Node node2 = node1;
        while (l1-- != 0) {
            node2 = node2.next;
        }
        Node p = node1;
        while (l1 !=0 || l2 != 0) {
            if (l1 == 0) {
                node2 = node2.next;
                exchList(node1, node2.last);
                l2--;
            } else if (l2 == 0) {
                node1 = node1.next;
                l1--;
            } else if (less(node1.item, node2.item)) {
                node1 = node1.next;
                l1--;
            } else {
                node2 = node2.next;
                exchList(node1, node2.last);
                l2--;
            }
        }
        return node2;
    }
    //移动后边Node的位置
    public void exchList(Node node1, Node node2) {
        Node p = node2;
        node2.next.last = node2.last;
        node2.last.next = node2.next;

        p.last = node1.last;
        p.next = node1;
        node1.last.next = p;
        node1.last = p;
    }

    /**
     * 打乱链表
     * Solution：
     *
     */
    public void unsortList(Node head) {
        int N = 0;
        Node temp = head;
        while ( temp != null) {
            N++;
            temp = temp.next;
        }
        int i = 1;
        while (i < N) {
            //初始化node1,node2
            Node node1 = head;
            Node node2 = head;
            int k = i;
            while (k-- > 0 && node2 != null) {
                node2 = node2.next;
            }
            if (node2 == null) {
                i *= 2;
                continue;
            }
            //打乱
            for (int j = 0; j < i && node2 != null;) {
                Comparable t = node1.item;
                node1.item = node2.item;
                node2.item = t;
                node1 = node1.next;
                node2 = node2.next;
                if (j == i - 1) {
                    k = i;
                    while (k-- > 0 && node2 != null) {
                        node2 = node2.next;
                        node1 = node1.next;
                    }
                    j = 0;
                } else {
                    j++;
                }
            }
            i *= 2;
        }
    }

    /**
     * 2.2.19
     * 倒置
     * solution：
     *          统计链表自然排序中exchList的执行次数
     */

    /**
     * 2.2.20
     * 间接排序
     * Solution:
     *              交换元素改为交换元素下标
     */

    /**
     * 2.2.21
     * 一式三份
     * solution：
     *          1.将三个列表排序
     *          2.按照merge的思路遍历三个数组
     *          3.有重复值出现则停止且返回
     */

}