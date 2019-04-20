package com.zhang.chapter14;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.Random;

/**
 * 答案和测试
 */
public class AnswerList {

    public int[] geneArray() {
        int N = 0;
        int[] a = new int[1000];
        StdOut.println("构造整形数组：（以-0结束）");
        while (true) {
            int inn = StdIn.readInt();
            if (inn == -0) break;
            a[N++] = inn;
        }
        int[] aout = new int[N];
        for (int i = 0; i < N; i++) {
            aout[i] = a[i];
        }
        return aout;
    }
    /**
     * 1.4.8
     * 计算相等的整数对的数量，要求线性对数级别复杂度
     */
    public void test08() {
        int N = 0;
        int[] a = new int[100];
        StdOut.println("构造整形数组：（以-0结束）");
        while (true) {
            int inn = StdIn.readInt();
            if (inn == -0) break;
            a[N++] = inn;
        }
        Arrays.sort(a, 0, N - 1);
        int total = 0;
        int lastN = 1;
        int lastNum = a[0];
        for (int i = 1; i <= N; i++) {
            if (i == N || a[i] != lastNum) {
                if (lastN != 1) {
                    total += pair(lastN);
                }
                lastNum = a[i];
                lastN = 1;
            } else {
                lastN++;
            }
        }
        StdOut.println(total);
    }

    //计算组数
    public int pair(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum += i;
        }
        return sum;
    }
    /**
     * 1.4.10
     * 修改二分查找，返回的总是索引最小元素
     */
    public int binarySearch(int[] a, int key, int toIndex) {
        int lo = 0;
        int hi = toIndex;
        int mid;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (a[mid] < key) {
                lo = mid + 1;
            } else if (a[mid] > key) {
                hi = mid -1;
            } else if (a[mid] == key) {
                if (mid > 0 && a[mid - 1] == key) {
                    hi = mid -1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }

    public void test10() {
        StdOut.println("构造整形数组：(以-0结束)");
        int[] a = new int[10];
        int i = 0;
        while (true) {
            int n = StdIn.readInt();
            if (n == -0) break;
            a[i++] = n;
        }
        Arrays.sort(a);
        for (int j = 0; j < a.length; j++) {
            StdOut.print(a[j]);
            if (j != a.length - 1) StdOut.print(",");
        }
        StdOut.println("要查找的元素：");
        StdOut.println(binarySearch(a, StdIn.readInt(),i - 1));
    }

    /**
     * 1.4.11
     * 统计给定整数个数，要求线性对数复杂度
     */
    public void test11() {
        int[] a = geneArray();
        Arrays.sort(a);
        StdOut.println("要查找的元素：");
        int key = StdIn.readInt();
        int position = binarySearch(a, key, a.length - 1);
        int total = 0;
        if (position >= 0) {
            for (int i = position; i < a.length; i++) {
                if (a[i] != key) break;
                total++;
            }
        }
        StdOut.println(total);
    }
    /**
     * 1.4.12
     * 有序打印两个有序数组的公共元素
     */
    public void test12() {
        int[] a = geneArray();
        int[] b = geneArray();
        Arrays.sort(a);
        Arrays.sort(b);
        int ia = 0;
        int ib = 0;
        while (ia < a.length && ib < b.length) {
            if (a[ia] == b[ib]) {
                int num = a[ia];
                while (ia < a.length && a[ia] == num) {
                    ia++;
                    StdOut.println(num);
                }
                while (ib < b.length && b[ib] == num) {
                    ib++;
                    StdOut.println(num);
                }
            } else if (a[ia] < b[ib]) {
                ia++;
            } else if (a[ia] > b[ib]) {
                ib++;
            }
        }
    }

    /**
     * 1.4.14
     * 4-sum
     * （生成所有的2个数和的结果，用新生成的结果做2-sum）
     */
    public void test14() {
        int[] a = {};
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    for (int l = 0; l < N; l++) {
                        if (a[i] + a[j] + a[k] + a[l] == 0) {
                            StdOut.println(a[i] + " " + a[j] + "" + a[k] + "" + a[l]);
                        }
                    }
                }
            }
        }
    }

    /**
     * 1.4.15
     * 快速2-sum（线性方法）：两个游标，前后各一个，小于则前边后移，大于则后边前移
     * 快速3-sum（平方级别）：
     */

    public int linear_2_sum(int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        int cnt = 0;
        while (lo < hi) {
            if (a[lo] + a[hi] < 0) lo++;
            else if (a[lo] + a[hi] > 0) hi--;
            else if (a[lo] + a[hi] == 0) {
                lo++;
                cnt++;
            }
        }
        return cnt;
    }

    public int square_3_sum(int[] a) {
        int N = a.length;
        int hi = N - 1;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            hi = N - 1;
            for (int j = i + 1; j < N; j++) {
                if (hi <= j) break;
                if (a[hi] + a[j] + a[i] > 0) hi--;
                else if (a[hi] + a[j] + a[i] < 0) j++;
                else if (a[hi] + a[j] + a[i] == 0) {
                    j++;
                    cnt++;
                }
            }

        }
        return cnt;
    }

    /**
     * 1.4.16
     * 最接近的一对
     */
    public void nearest(double[] a) {
        Arrays.sort(a);
        double a1, a2, minVal;
        a1 = a[0];
        a2 = a[1];
        minVal = Math.abs(a1 - a2);
        for (int i = 1; i < a.length - 1; i++) {
            if (Math.abs(a[i + 1] - a[i]) < minVal) {
                minVal = Math.abs(a[i + 1] - a[i]);
                a1 = a[i];
                a2 = a[i + 1];
            }
        }
        StdOut.println("最接近的一对是：" + a1 + '和' + a2);
    }
    /**
     * 1.4.17
     * 最遥远的一对
     */
    public void farest(double[] a) {
        if (a.length == 0) return;
        double minNum, maxNum;
        minNum = a[0];
        maxNum = a[0];
        for (int i = 1; i < a.length; i++) {
            if (maxNum < a[i]) maxNum = a[i];
            if (minNum > a[i]) minNum = a[i];
        }
        StdOut.println("最遥远的一对是：" + minNum + "和" + maxNum);
    }
    /**
     * 1.4.18
     * 数组的局部最小元素
     * 思路：
     *      依次寻找数组中间元素，是则退出，否则向小的一边搜索
     */
    public void test18() {
        int[] a = {1, 3, 5, 8, 9, 4, 7, 10, 6};
        int lo = 0;
        int hi = a.length - 1;
        int result = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int num = a[mid];
            if (mid - 1 < 0 || mid + 1 > a.length - 1 || (num < a[mid - 1] && num < a[mid + 1])) {
                result = num;
                break;
            } else if (a[mid - 1] < a[mid + 1]) {
                hi = mid - 1;
            } else if (a[mid - 1] > a[mid + 1]) {
                lo = mid + 1;
            }
        }
        StdOut.println(result);
    }
    /**
     * 1.4.19
     * 矩阵的局部最小元素
     * 思路：
     *      找N/2行最小元素，是局部最小则返回；否则找最小元素所在列的上下的最小元素，取最小元素所在的象限为新的矩阵
     */
    public void test19() {
        int[][] a = {{1, 3, 20, 49},
                    {5, 7, 30, 17},
                    {90, 4, 6, 28},
                    {23, 22, 34, 9}};
        int row = a.length;
        int col = a[0].length;
        int lorow = 0;
        int locol = 0;
        int hirow = row - 1;
        int hicol = col -1;

        while (lorow <= hirow) {
            int midrow = lorow + (hirow - lorow) / 2;
            int midcol = locol + (hicol - locol) / 2;
            int minimum = a[midrow][locol];
            int miniCol = 0;
            for (int i = locol + 1; i < hicol + 1; i++) {
                if (a[midrow][i] < minimum) {
                    minimum = a[midrow][i];
                    miniCol = i;
                }
            }
            if (midrow - 1 < 0 && minimum < a[midrow + 1][miniCol]
                    || midrow + 1 > row && minimum < a[midrow - 1][miniCol]
                    || minimum < a[midrow - 1][miniCol] && minimum < a[midrow + 1][miniCol]) {
                StdOut.println(minimum);
                break;
            }
            if (midrow + 1 > row || a[midrow - 1][miniCol] < a[midrow + 1][miniCol]) {
                hirow = midrow - 1;
            } else if (midrow - 1 < 0 || a[midrow - 1][miniCol] < a[midrow + 1][miniCol]) {
                lorow = midrow + 1;
            }
            if (miniCol <= midcol) hicol = midcol - 1;
            else locol = miniCol + 1;
        }
    }
    /**
     * 1.4.20
     * 双调查找（对数级复杂度）
     * 思路：
     *      需要用二分法的思想。二分之后，必有一边是单调数组，用二分法查找
     */
    //双调查找
    public boolean bitonic(int[] a, int lo, int hi, int key) {
        if (lo > hi) return false;
        int mid = lo + (hi - lo) / 2;
        if (a[mid] == key) return true;
        if (mid == lo || mid == hi) return false;
        boolean flag = false;
        if (a[mid - 1] < a[mid]) {
            flag = binarySearch1(a, lo, mid - 1, key);
            if (flag) return true;
            lo = mid + 1;
            return bitonic(a, lo, hi, key);
        }else{
            flag = binarySearch2(a,mid + 1, hi, key);
            if (flag) return true;
            hi = mid - 1;
            return bitonic(a, lo, hi, key);
        }
    }
    //二分法查找(递增)
    public boolean binarySearch1(int[] a, int lo, int hi, int key) {
        if (lo > hi) return false;
        int mid = lo + (hi - lo) / 2;
        if (a[mid] == key) return true;
        else if (a[mid] < key) return binarySearch1(a, mid + 1, hi, key);
        else return binarySearch1(a, lo, mid - 1, key);
    }
    //二分法查找(递减)
    public boolean binarySearch2(int[] a, int lo, int hi, int key) {
        if (lo > hi) return false;
        int mid = lo + (hi - lo) / 2;
        if (a[mid] == key) return true;
        else if (a[mid] > key) return binarySearch2(a, mid + 1, hi, key);
        else return binarySearch2(a, lo, mid - 1, key);
    }
    public void test20() {
        int[] a = {1, 2, 3, 4, 6, 9, 8, 2, 0};
        while (true) {
            StdOut.println("输入想要查找的数：（以-1结束）");
            int num = StdIn.readInt();
            StdOut.println(bitonic(a, 0, a.length - 1, num));
        }
    }
    /**
     * 1.4.21
     * 无重复值中的二分查找     *#应该是有重复值的二分查找，不想改了。。还是改了吧
     */
    //寻找最小位置
    public int minPos(int[] a, int lo, int hi, int key) {
        if (lo > hi) return hi;
        if (a[hi] != key) return hi;
        int mid = lo + (hi - lo) / 2;
        if (a[mid] < key && a[mid + 1] == key) return mid;
        else if (a[mid] == key) return minPos(a, lo, mid - 1, key);
        else return minPos(a,mid + 1, hi, key);
    }
    //寻找最大位置
    public int maxPos(int[] a, int lo, int hi, int key) {
        if (lo > hi) return lo;
        if (a[lo] != key) return lo;
        int mid = lo + (hi - lo) / 2;
        if (a[mid] > key && a[mid - 1] == key) return mid;
        else if (a[mid] == key) return maxPos(a, mid + 1, hi, key);
        else return maxPos(a, lo, mid - 1, key);
    }
    //二分查找
    public int rank(int[] a, int lo, int hi, int key) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (a[mid] == key) return mid;
        else if (a[mid] < key) return rank(a, maxPos(a, mid + 1, hi, a[mid]), hi, key);
        else return rank(a, lo, minPos(a, lo, mid - 1, a[mid]), key);
    }
    public boolean contains(int[] a, int num) {
        int pos = rank(a, 0, a.length - 1, num);
        if (pos != -1) return true;
        else return false;
    }
    public void test21() {
        int[] a = {1, 2, 3, 3, 3, 3, 3, 56, 78};
        while (true) {
            StdOut.println("请输入要查找的数：");
            int num = StdIn.readInt();
            if (contains(a, num)) StdOut.println("包含");
            else StdOut.println("不包含");
        }
    }
    /**
     * 仅用加减实现二分查找
     * 思路：
     *      用斐波那契数列代替2的幂
     */
    public boolean fiboSearch(int[] a, int lo, int hi, int fk, int fk_1, int key) {
        if (lo > hi || lo + fk_1 < lo) return false;
        if (lo + fk_1 > hi) return fiboSearch(a, lo, hi, fk_1, fk - fk_1, key);
        if (a[lo + fk_1] == key) return true;
        else if (a[lo + fk_1] < key) {
            return fiboSearch(a, fk_1, hi, fk - fk_1, fk_1 - (fk - fk_1), key);
        } else {
            return fiboSearch(a, lo, lo + fk_1 - 1, fk_1, fk - fk_1, key);
        }
    }
    public boolean containsFibo(int[] a, int num) {
        int fk = 1;
        int fk_1 = 1;
        while (fk < a.length) {
            int temp = fk + fk_1;
            fk_1 = fk;
            fk = temp;
        }
        return fiboSearch(a, -1, a.length - 1, fk, fk_1, num);

    }

    public void test22() {
        int[] a = {1, 2, 3, 5, 8, 12, 34, 56, 78};
        while (true) {
            StdOut.println("请输入要查找的数：");
            int num = StdIn.readInt();
            if (containsFibo(a, num)) StdOut.println("包含");
            else StdOut.println("不包含");
        }
    }
    /**
     * 对比二分法查找和斐波那契查找效率
     */
    public void searchCompare() {
        int initSize = 100000000;
        int[] a;
        StdOut.println("是否需要增大规模？y/n");
        //char c = StdIn.readChar();
        //if (c != 'y') break;
        initSize *= 10;
        StdOut.println(initSize);
        a = new int[initSize];
        for (int i = 0; i < initSize; i++) {
            a[i] = StdRandom.uniform(initSize * 10);
        }
        Arrays.sort(a);
        int[] key = new int[6];
        for (int i = 0; i < 6; i++) {
            key[i] = StdRandom.uniform(initSize * 10);
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 6; i++) {
            if (contains(a, key[i])) StdOut.print("包含");
            else StdOut.print("不包含");
        }
        StdOut.println();
        long endTime = System.currentTimeMillis();
        StdOut.println("二分法用时：" + (endTime - startTime) + "ms.");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 6; i++) {
            if (containsFibo(a, key[i])) StdOut.print("包含");
            else StdOut.print("不包含");
        }
        StdOut.println();
        endTime = System.currentTimeMillis();
        StdOut.println("Fibonacci用时：" + (endTime - startTime) + "ms.");
    }
    /**
     *1.4.23
     * 分数的二分查找
     * 题意：（这个很重要，我以为是给出N，然后让找出这个数）
     *      给出一个分数数组，查找是否包含一个给定的分数
     * 思路：
     *      没啥说的，题理解了，就容易了；只用更改二分查找的等于的比较条件，等于改成两个数的差小于N的平方分之一
     */
    public int fracBinaSearch(double[] a, int lo, int hi, int key) {
        if (lo > hi) return -1;
        int N = 10000;
        int mid = lo + (hi - lo) / 2;
        if (Math.abs(a[mid] - key) < 1 / (N * N)) return mid;
        else if (a[mid] < key) return fracBinaSearch(a, mid + 1, hi, key);
        else return fracBinaSearch(a, lo, mid - 1, key);
    }
    /**
     * 1.4.24
     * 扔鸡蛋，使成本为~2lgF
     * 思路：
     *      先找到一个最小的2的幂的楼层n，复杂度为lgF；
     *      再在1到n层之间用二分法查找复杂度也是lgF
     *      从而复杂度使2lgF
     */
    /**
     * 1.4.25
     * 扔两个鸡蛋
     * 思路：
     *      1由二分法的取数数列变成平方数的序列（根号N、2倍根号N。。）复杂度为2倍根N
     *      2先从1到k找到最小的k的平方小于F，从k的平方往后查找，必须经过1倍根号F、2倍根号F。。
     *       所以复杂度是c倍根号F
     */
    /**
     * 1.4.26
     * 三点共线
     * 思路:
     *      简单的证明。hint：a^3 - b^3 = (a - b) * (a^2 + ab + b^2)
     */
    /**
     * 1.4.27
     * 两个栈实现的队列
     * 实现：
     *      Stack2Queue
     */
    /**
     * 1.4.28
     * 一个队列实现的栈
     * 实现：
     *      Stack2Queue
     */
    /**
     * 1.4.29
     * 两个栈实现的steque
     * 实现：
     *      Stack2Steque
     */
    /**
     * 1.4.30
     * 一个栈和steque实现的双向队列
     * 实现：
     *      StackSteque2DoubleQueue
     */
    /**
     * 1.4.31
     * 三个栈实现一个双向队列
     * 实现：
     *      略。（还没想起到解决的方法）
     */
    /**
     * 1.4.32
     * 均摊分析：对于一个基于大小可变的数组实现的空栈的M次操作访问数组的次数和M成正比
     * 思路：
     *      所谓均摊分析即少量昂贵操作的成本通过大量廉价的操作摊平
     *      具体分析不会。
     */
    /**
     * 1.4.33
     * 32位计算机中的内存需求（引用4字节，对象开销8字节，填充为4字节倍数）
     * 作为对比：64位计算机中的内存需求（引用8字节，对象开销16字节，填充为8字节倍数）
     * 思路：
     *      boolean 1；byte 1；char 2；int 4；float 4；long 8；double 8
     *      Iteger：（12）8字节对象开销，4字节int值
     *      Date:（20）8字节对象开销，3 * 4字节int值
     *      Counter：（16）8字节对象开销，4字节int值，4字节用于他的String实例变量（一个引用）
     *      int[]：（12 + 4N）12字节头信息（8字节对象开销，4字节长度），加上保存值需要内存
     *      double[]：（12 + 8N）12字节头信息（8字节对象开销，4字节长度），加上保存值需要内存
     *      double[M][N]：（8MN + 20M + 12）12字节头信息（数组的数组）加上4M字节（所有子数组引用），加上12M字节（所有子数组头信息），加上8MN
     *      String：（24）8字节对象开销，4字节引用，3 * 4字节int值(字符数组中偏移量，字符长度，散列值)
     *      Node：（20）8字节对象开销，4字节值对象引用，4字节下一对象引用，4字节额外开销（内部类只想外部类的引用）
     *      Stack：（32N + 16）8字节对象开销，4字节引用实例变量，4字节int，一个Node的20和一个Integerr的12
     */
    /**
     * 1.4.34
     * 热还是冷
     * solution：
     *      1、二分区间，比如区间是a,b。先猜a,载猜b，确定在哪一半；循环则需要2lgN
     *      2、最后依次猜测为c，区间为a,b; 则猜d = （a + b） - c; 复杂度为lgN + 1
     */


    /**
     * 主测试方法
     * @param args
     */
    public static void main(String[] args) {
        AnswerList al = new AnswerList();
        //al.test08();
        //al.test10();
        //al.test11();
        //al.test12();
        //al.test18();
        //al.test19();
        //al.test20();
        al.test21();
        //al.test22();
        //al.searchCompare();
    }
}
