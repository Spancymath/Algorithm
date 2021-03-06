package com.zhang.chapter2.section23;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 快速排序
 * 1.相比较于归并排序，归并排序将数组分成两个子数组分别排序，并将有序的子数组归并以将整个数组排序；
 *    而快速排序将数组排序的方式则是当两个子数组都有序时整个数组自然也就有序了。第一种情况，递归调
 *    用发生在处理整个数组之前；第二种情况中，递归调用发生在处理整个数组之后。归并排序中，一个数组被
 *    等分为两半；快速排序中，切分的位置取决于数组的内容。
 * 2.将长度为N的无重复数组排序，快速排序平均需要2NlnN次比较。
 * 3.改进：
 *   对于小数组切换到插入排序（5 ~ 15的结果都不错）
 *   三取样切分：取子数组的一小部分元素的中位数来作为切分元素
 *   三向切分的快速排序，能够很好地处理重复元素很多的数组，也是排序库函数的最佳算法选择
 * 4.
 */

public class AnswerList {
    /**
     * 2.3.1
     * partition()轨迹
     *
     *                E  A  S  Y  Q  U  E  S  T  I  O  N
     *                A  E  S  Y  Q  U  E  S  T  I  O  N
     */
    /**
     * 2.3.2
     * 快速排序轨迹
     *                E  A  S  Y  Q  U  E  S  T  I  O  N
     *      E分割      A  E  S  Y  Q  U  E  S  T  I  O  N
     *                      S  N                       Y
     *                      S        O              U
     *                      S              I     S
     *      S分割            I  N  Q  O  E  S  T  S  U  Y
     *                      I  E        N
     *      I分割            E  I  Q  O  N
     *      Q分割                  N     Q
     *      N分割                  N  O
     *      T分割                              S  T  U  Y
     *      U分割                                    U  Y
     *                A  E  E  I  N  O  Q  S  S  T  U  Y
     */
    /**
     * 2.3.3
     * 最大数最多交换次数
     * solution：
     *              lgN
     */
    /**
     * 2.3.4
     * 快排性能最差的数组
     * solution：
     *          有序数组、逆序数组、只有一个值数组
     */
    /**
     * 2.3.5
     * 两种主键值的数组排序
     *
     */
    public void sortDistinct2(Comparable[] a) {
        Comparable v = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(v) != 0) {
                if (a[i].compareTo(v) < 0) {
                    v = a[i];
                }
                break;
            }
        }
        int i = -1, j = a.length;
        while (true) {
            while (a[++i].compareTo(v) < 0) if (i == a.length - 1) break;
            while (a[--j].compareTo(v) > 0) if (j == 0) break;
            if (i >= j) break;
        }
    }
    /**
     * 2.3.6
     * 计算Cn的准确值
     * solution：
     *              N    100    1000   10000
     *              Cn   804    12102  161124
     *            2NlnN  1200   18000  260000
     *
     */
    public void test06() {
        int N = 10000;
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) {
            a[i] = i;
        }
        QuickSort quickSort = new QuickSort();
        quickSort.sort(a);
        StdOut.println(quickSort.cn);
    }
    /**
     * 2.3.7
     * 长度为0个1个2个的数组的个数
     * solution：
     *          0：
     *          1：
     *          2：
     */
    /**
     * 2.3.8
     * 处理全重复数组的比较次数
     * solution：
     *          N的平方（不同意nlg n）
     */
    /**
     * 2.3.9
     * 数组多重复值的情形
     * Solution:
     *          略
     */
    /**
     * 2.3.10
     * 略
     */
    /**
     * 2.3.11
     * 遇到重复切分元素继续扫描的复杂度n的平方
     * solution：
     *          显然，子数组只比上一数组差一个元素
     */
    /**
     * 2.3.12
     * 信息量最佳的快速排序轨迹
     * Solution:
     *          三分快速排序
     *                  B  A  B  A  B  A  B  A  C  A  D  A  B  R  A
     *                  A  B
     *                     A     B
     *                        A        B
     *                           A           B
     *                                          A                 C
     *                              A           B
     *                                 A           B
     *                                                R        D
     *                                                B     R
     *                                    A              B
     *                  A  A  A  A  A  A  A  B  B  B  B  B  R  D  C
     */
    /**
     * 2.3.13
     * 最佳、最坏、平均情况递归深度
     * Solution：
     *          最佳：logN
     *          最坏：N
     *          平均：
     */
    /**
     * 2.3.14
     * 证明:
     *      略
     */
    /**
     * 2.3.15
     * 螺丝和螺帽
     * Solution：
     *          随机挑选一个螺丝，将螺帽分为大于和小于以及等于三堆
     *          随机挑选一个螺丝，比较已经配对的螺帽，看其属于哪堆继续分堆
     */
    /**
     * 2.3.16
     * 最佳状况：
     *
     */
    public int[] test16() {
        int N = 10;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = i;
        }
        generic(a, 0, a.length - 1);
        for (int i = 0; i < N; i++) {
            StdOut.print(a[i] + ", ");
        }
        return a;
    }

    public void generic(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        exch(a, mid, lo + (mid - lo) / 2);
        generic(a, lo, mid);
        generic(a, mid + 1, hi);
    }

    public void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * 2.3.17
     * 哨兵
     * solution：
     *          由于切分元素本来就是一个哨兵，左边界检查可以直接去掉
     *          打乱数组后，把数组最大元素放到最后，右边界也可去掉
     */
    /**
     * 2.3.18
     * 略
     */
    /**
     * 2.3.19
     * 五取样切分
     * solution：
     *          二分法插入排序
     *          求5个数平均值，取距离最近一个
     */
    /**
     * 2.3.20
     * 非递归的快速排序
     */
    private void test20() {
        int N = 10;
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) {
            a[i] = N - i;
        }
        new NonrecursiveQuicksort().sort(a);
        for (int i = 0; i < N; i++) {
            StdOut.print(a[i] + ", ");
        }
        StdOut.println();
    }
    /**
     * 2.3.21
     * 排列重复元素的比较次数的下界
     * 略
     */
    /**
     * 2.3.22
     * 快速三向切分
     */
    private void test22() {
        int N = 20;
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) {
            a[i] = N - i;
            if (StdRandom.uniform(1, 3) == 2) {
                a[i] = StdRandom.uniform(1, N / 2);
            }
        }
        new Quick3wayFastpattition().sort(a);
        for (int i = 0; i < N; i++) {
            StdOut.print(a[i] + ", ");
        }
        StdOut.println();
    }

    /**
     * 2.3.23
     * java的排序库函数
     * 9个元素中位数，小数组选择插入排序
     */
    /**
     * 2.3.24
     * 取样排序
     * 略
     */

    /**
     *
     * @param args
     */

    public static void main(String[] args) {
        AnswerList al = new AnswerList();
        //al.test06();
        //al.test16();
        //al.test20();
        al.test22();
    }
}
