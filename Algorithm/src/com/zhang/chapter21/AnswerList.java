package com.zhang.chapter21;

import jdk.nashorn.internal.ir.annotations.Ignore;

/**
 * 初级排序算法
 * 1.排序算法类的模板
 * 2.选择排序：依次找到子数组的最小元素，和子数组的第一个元素交换
 * 3.插入排序：依次把元素插入前面已经有序的数组
 * 4.对于随机排序的无重复主键的数组，插入排序和选择排序的运行时间是平方级别的，两者的比应该是一个较小的常数。
 * 5.希尔排序（基于插入排序），主要思想是数组中任意间隔为h的元素都是有序的。（h = 3*h+1）
 */
public class AnswerList {
    /**
     * 2.1.1
     * 选择排序的轨迹
     * answer：
     *          E A S Y Q U E S T I O N
     *          A E S Y Q U E S T I O N
     *          A E S Y Q U E S T I O N
     *          A E E S Y Q U S T I O N
     *          A E E I S Y Q U S T O N
     *          A E E I N S Y Q U S T O
     *          A E E I N O S Y Q U S T
     *          A E E I N O Q S Y U S T
     *          A E E I N O Q S Y U S T
     *          A E E I N O Q S S Y U T
     *          A E E I N O Q S S T Y U
     *          A E E I N O Q S S T U Y
     *          A E E I N O Q S S T U Y
     */
    /**
     * 2.1.2
     * 选择排序，元素交换次数
     * answer：
     *          一个元素最多被交换n - 1次（最大元素在第一个位置，后面都有序）
     *          总共n个元素，需要n - 1次交换，每次交换涉及两个元素。
     *          故所有元素的所有交换次数是（n - 1） * 2, 除以n，平均为2
     *          （n - 1 + 1 * (n - 1)） / n = 2
     */
    /**
     * 2.1.3
     * a[j] < a[min]成功次数最多
     * answer：
     *          倒序数组
     */
    /**
     * 2.1.4
     * 插入排序轨迹
     * answer：
     *          E A S Y Q U E S T I O N
     *          A E S Y Q U E S T I O N
     *          A E S Y Q U E S T I O N
     *          A E S Y Q U E S T I O N
     *          A E Q S Y U E S T I O N
     *          A E Q S U Y E S T I O N
     *          A E E Q S U Y S T I O N
     *          A E E Q S S U Y T I O N
     *          A E E Q S S T U Y I O N
     *          A E E I Q S S T U Y O N
     *          A E E I O Q S S T U Y N
     *          A E E I O N Q S S T U Y
     */
    /**
     * 2.1.5
     * 插入排序内循环两个判断结果总是假的序列
     * answer：
     *          有序数组
     */
    /**
     * 2.1.6
     * 主键相同，选择排序、插入排序哪个快
     * answer：
     *          插入排序快
     *          插入排序：n - 1次比较和0次交换
     *
     */
    /**
     * 2.1.7
     * 逆序数组，插入排序、选择排序谁快
     * answer：
     *          选择排序更快
     *          比较次数相同，n的平方
     *          交换次数插入排序n的平方，选择排序n - 1
     */
    /**
     * 2.1.8
     * 数组中只有三种值，插入排序的效率
     * answer：
     *          平方级别
     */
    /**
     * 希尔排序轨迹
     * answer：
     *          0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0
     *     13   E A S Y S H E L L S O R T Q U E S T I O N   --21(13, 4, 1)
     *          E                         Q
     *            A                         U
     *              E                         S
     *                S                         Y
     *                  S                         T
     *                    I                         H
     *                      E                         O
     *                        L                         N
     *     4    E       S
     *            A       I
     *              E       E
     *                L       S
     *          E       L       S
     *            A       I       S
     *              E       E       O
     *                L       R       S
     *          E       L       S       T
     *            A       I       Q       S
     *              E       E       O       U
     *                L       R       S       S
     *          E       L       S       T       Y
     *            A       I       Q       S       T
     *              E       E       H       O       U
     *                L       O       R       S       S
     *          E       L       N       S       T       Y
     *     1    A E
     *          A E E
     *          A E E L
     *          A E E L L
     *          A E E I L L
     *          A E E E I L L
     *          A E E E I L L O
     *          A E E E I L L N O
     *          A E E E I L L N O Q
     *          A E E E H I L L N O Q
     *          A E E E H I L L N O Q R
     *          A E E E H I L L N O Q R S
     *          A E E E H I L L N O Q R S S
     *          A E E E H I L L N O O Q R S S
     *          A E E E H I L L N O O Q R S S S
     *          A E E E H I L L N O O Q R S S S T
     *          A E E E H I L L N O O Q R S S S T T
     *          A E E E H I L L N O O Q R S S S T T U
     *          A E E E H I L L N O O Q R S S S S T T U
     *          A E E E H I L L N O O Q R S S S S T T U Y
     *
     */
    /**
     * 2.1.10
     * 希尔排序为什么不改进选择排序
     * answer：
     *          选择排序在排列部分有序数组时并没有优势，所以也没有改进的效果
     */
    /**
     * 2.1.11
     * 将希尔排序递增序列存在一个数组中
     * answer：
     *          详见ShellStatic类
     */
    /**
     * 2.1.12
     *希尔排序比较次数和数组大小统计
     * answer：
     *          数组长度         10  100  1000  10000
     *          比较次数比数组长度 2    7    13    23
     */
    /**
     * 2.1.13
     * 纸牌按花色排序
     * answer：
     *          插入排序，定义黑桃<红桃<梅花<方片
     */
    /**
     * 2.1.14
     * 出列顺序
     * answer：
     *          选择排序，依次找到最小的放到最下边
     */
    /**
     * 2.1.15
     * 昂贵的交换
     * answer：
     *          选择排序，针对普通情况有最优的移动次数
     */
    /**
     *2.1.16
     * 验证排序后的数组有序，没被修改
     * answer：
     *          调用isSorted()方法验证有序性
     *          对原数组的调用Array.sort()方法排序，对两个数组依次用equal方法比较
     */
    /**
     * 2.1.17
     * 动画
     *          略
     */
    /**
     * 2.1.18
     * 可视轨迹
     *          略
     */
    /**
     * 2.1.19
     * 希尔排序的最坏情况
     * answer:
     *          逆序数组
     */
    /**
     * 2.1.20
     * 希尔排序的最好情况
     * answer：
     *          正序数组
     *          需要59 + 86 + 95 + 99 次比较，0次交换
     */
    /**
     * 2.1.21
     * 可比较的交易
     *
     */
    public class Transaction implements Comparable<Transaction> {

        private final double amount = 0;
        @Override
        public int compareTo(Transaction that) {
            if (this.amount > that.amount) return +1;
            if (this.amount < that.amount) return -1;
            return 0;
        }
    }
    /**
     * 2.1.22
     * 事务排序测试用例
     *               略
     */
    /**
     *2.1.23
     * 纸牌排序
     *               略
     */
    /**
     * 2.1.24
     * 插入排序的哨兵
     * answer:
     *          详见InsertionWithSentinel（并没有提升效率的作用）
     */
    /**
     * 2.1.25
     * 不需要交换的插入排序
     * answer:
     *          详见InsertionWithoutExch（比有交换的插入排序慢很多）
     */
    /**
     * 2.1.26
     * 原始数据类型
     *               略
     */
    /**
     * 2.1.27
     * 希尔排序的用时是次平方级别
     */
    /**
     * 1.2.28
     * 相等的主键
     * answer：
     *          我猜插入排序快，哈哈
     */
    /**
     * 1.2.29
     * 希尔排序的递增序列
     * 结论：
     *          稍微好点儿，没好太多
     */
}
