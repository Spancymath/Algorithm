package com.zhang.chapter34;

import edu.princeton.cs.algs4.StdOut;

/**
 * 散列表
 * 1.散列表：用算术操作将键转化为数组的索引来访问数组中的键值对
 * 2.散列的查找：a用散列函数将被查找的键转化为数组的一个索引b处理碰撞冲突
 * 3.两种解决碰撞冲突的方法：拉链法、线性探测法
 * 4.整数散列最常用的方法：除留余数法（除数最好是素数）
 * 5.浮点数：如果是0到1的实数，乘以M，四舍五入到0-(M-1)的索引值，但这样高位起的作用更大
 *         （java中将键表示为二进制数，再使用除留余数法）
 * 6.字符串：除留余数法， 例：  int hash = 0;
 *                          for (int i = 0; i < s.length(); i++) {
 *                              hash = (R * hash + s.charAt(i)) % M;
 *                          }
 * 7.java中得到索引的方法：
 *      private int hash(Key x) {
 *          return (x.hashCode() & 0x7fffffff) % M;
 *      }
 * 8.优秀的散列方法满足三个条件：
 *      一致性
 *      高效性
 *      均匀性
 * 9.基于拉链法的散列表：将大小为M的数组中每个元素指向一条链表，链表中每个结点都存储了散列值为该元素的索引的键值对
 * 10.散列表主要目的在于均匀的将键散布开，对于顺序不重要的应用，此方法很有效；但对于有序性相关的操作，效率往往都是线性的，也不是一个合适的选择
 * 11.开放地址散列表：用大小为M的数组保存N个键值对，M>N，依靠数组中的空位解决碰撞冲突
 * 12.基于线性探测法的散列表--开放地址散列表的一种
 *        当发生碰撞时，直接检查散列表的下一位置
 * 13.java中Integer的散列值取该整数的32位值；Double和Long取机器表示的前后32位异或的结果
 * 14.
 */
public class AnswerList {
    /**
     * 3.4.1 散列表的形成
     */
    public void test01() {
        int intA = 'A';
        for (int i = 0; i < 26; i++) {
            StdOut.print((char)('A' + i) + ":" + (intA + i) + "   ");
            if ((i + 1) % 8 == 0) StdOut.println();
        }
        StdOut.println();

        int M = 5;
        for (int i = 0; i < 26; i++) {
            StdOut.print((char)('A' + i) + ":" + (i + 1) * 11 % M + "   ");
            if ((i + 1) % 8 == 0) StdOut.println();
        }

    }

    /**
     * 3.4.2
     * Solution:
     *      详见SeparateChainingHashSTDirect.java
     */
    /**
     * 3.4.3
     * Solution:
     *      详见上一题
     */
    /**
     * 3.4.4 完美散列
     * Solution:
     *      19 5 1 18 3 8 24 13 16 12
     *      a = 1; M = 24
     *      可见最优的M小于等于24，a的值应该小于M
     *      故遍历
     *      M: 20;   a: 1
     */
    public void test04() {
        char[] cs = {'S', 'E', 'A', 'R', 'C', 'H', 'X', 'M', 'P', 'L'};
        int perfectM = 24;
        int perfectA = 1;
        int hash[] = new int[10];
        for (int j = 23; j >= 10; j--) {
            for (int i = 1; i < j; i++) {
                int k = 0;
                for (; k < 10; k++) {
                    hash[k] = (i * rankAlpha(cs[k])) % j;
                    if (!legal(hash[k], k, hash)) break;
                }
                if (k == 10) {
                    perfectM = j;
                    perfectA = i;
                    break;
                }
            }
        }
        StdOut.println("M: " + perfectM + ";   A: " + perfectA);
        for (int i = 0; i < 10; i++) {
            StdOut.print((perfectA * rankAlpha(cs[i])) % perfectM + " ");
        }
    }

    private boolean legal(int newhash, int k, int[] hash) {
        for (int i = k - 1; i >= 0; i--) {
            if (newhash == hash[i]) return false;
        }
        return true;
    }

    private int rankAlpha(char c) {
        return c - 'A' + 1;
    }

    /**
     * 3.4.5
     * Solution:
     *      合法，但使用此散列函数的每一个键的散列值都相同，导致效率很低
     */
    /**
     * 3.4.6
     * 略
     */
    /**
     * 3.4.7
     * 略
     */
    /**
     * 3.4.8
     * 略
     */
    /**
     * 3.4.9
     * Solution:
     *      详见实现
     */
    /**
     * 3.4.10
     */
    public void test10() {
        int M = 4;
        char[] cs = {'E', 'A', 'S', 'Y', 'Q', 'U', 'T', 'I', 'O', 'N'};
        for (int i = 0; i < cs.length; i++) {
            StdOut.print((11 * rankAlpha(cs[i])) % M + " ");
        }
        StdOut.println();
    }

    /**
     * 3.4.12
     * Solution:
     *      d-->  C D E F B A G
     */
    /**
     * 3.4.13
     * Solution:
     *      d
     */
    /**
     * 3.4.14
     * Solution:
     *      d
     */
    /**
     * 3.4.15
     * 略
     */
    /**
     * 3.4.16
     * 略
     */
    /**
     * 3.4.17 删除键C
     * Solution:
     *      P M A S H L E R X
     */
    /**
     * 3.4.18
     * 略
     */
    /**
     * 3.4.19 实现keys方法
     * Solution：
     *      见实现
     */
    /**
     * 3.4.20
     * 略
     */
    /**
     * 3.4.21
     * 略
     */
    /**
     * 3.4.22 hashCode
     * Solution:
     *      Point2D: x.hashCode + y.hashCode
     *      Interval: x.hashCode
     *      Interval2D: x.hashCode + y.hashCode
     *      Date: day.hashCode + month.hashCode + year.hashCode
     */
    /**
     * 3.4.23
     * 略
     */
    /**
     * 3.4.24
     * 略
     */



    /**
     * 主程序
     * @param args
     */
    public static void main(String[] args) {
        AnswerList al = new AnswerList();
        //al.test01();
        //al.test04();
        al.test10();
    }
}
