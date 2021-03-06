package com.zhang.chapter3.section35;

import com.zhang.chapter1.section13.Bag;
import com.zhang.chapter3.section31.Chapter30102;
import com.zhang.chapter3.section33.RedBlackBST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 应用
 * 1.对于典型的应用程序，应该在散列表和二叉查找树之间进行选择。
 * 2.相对于二叉查找树，散列表的优点在于代码更简单，且查找时间最优。
 * 3.二叉查找树相对于散列表的优点在于抽象结构更简单（不需要设计散列函数），
 *   红黑树可以保证最坏情况下的性能，且能支持更多操作（排名，选择，排序和范围查找）。
 */
public class AnswerList {
    /**
     * 3.5.1
     * Solution:
     *      详见实现
     */
    /**
     * 3.5.2
     * Solution:
     *      详见实现
     */
    /**
     * 3.5.3
     * Solution:
     *      详见实现
     */
    /**
     * 3.5.4  3.5.5  3.5.6  3.5.7
     * Solution:
     *      详见实现
     */
    /**
     * 3.5.8 线性探测允许重复值 3.5.9 二叉查找树支持重复值   3.5.10 红黑树支持重复值
     * Solution:
     *      详见类中实现
     */
    /**
     * 3.5.11 多重集合
     * Solution:
     *      详见实现
     */
    /**
     * 3.5.12 一个键关联多个值 （3.5.13 查找时根据相应逻辑）
     * Solution:
     *      两种方法a.调用允许重复值的ST，直接插入重复的键，搜索时搜出全部键相等的值
     *            b.调用不允许重复的ST，val为一个链表，插入前先查找val，将值插入再将键值对插入ST
     */
    /**
     * 3.5.14 转为重复键集合
     */
    public static RedBlackBST invert(Chapter30102.ST<String, Bag<String>> st) {
        RedBlackBST<String, String> newSt;
        newSt = new RedBlackBST<>();

        for (String key : st.keys()) {
            Bag<String> bag = st.get(key);
            for (String s : bag) {
                newSt.put(key, s);
            }
        }

        return newSt;
    }

    /**
     * 3.5.15 依序输出输入的键值对
     * Solution:
     *      如下
     */
    public void test15() {
        RedBlackBST<Integer, String> redBlackBST = new RedBlackBST<>();

        while (true) {
            int num = StdIn.readInt();
            if (num == -1) break;
            String s = StdIn.readString();
            redBlackBST.put(num, s);
        }

        while (!redBlackBST.isEmpty()) {
            StdOut.println(redBlackBST.size());
            StdOut.println(redBlackBST.min() + "--" + redBlackBST.get(redBlackBST.min()));
            redBlackBST.deleteMin();
        }
    }

    /**
     * 3.5.20 对照索引：根据索引，找出上下文
     */

    /**
     * 3.5.24 不重叠的区间查找
     * Solution:
     *      由于不重叠，所以插入使有序，二分法查找，返回索引为基数（等于区间尽头元素除外）则不在任何区间，为偶数，则k/2 + 1区间
     */
    /**
     * 3.5.25 登记员的日程安排
     * Solution:
     *      将每个老师的时间插入set，先判断存在性，存在则冲突
     */
    /**
     * 3.5.26 LRU缓存(least recently used)
     *      用一个双向链表和符号表实现：链表存插入的key，符号表存key在链表中的位置
     *      添加元素：链表存在此元素，删除，从链表头插入元素，更新符号表；不存在则从链表头插入，插入符号表，更新符号表
     *      删除元素：内存过大删除最不常用的元素，即从尾部删除元素
     */
    /**
     * 3.5.27 列表
     *Solution:
     *      详见实现
     */
    /**
     * 3.5.29 支持随机访问的符号表
     * Solution:
     *      随机队列和符号表结合：随机访问队列的key，删除符号表中键值对
     */


    /**
     * 主测试程序
     * @param args
     */
    public static void main(String[] args) {
        AnswerList al = new AnswerList();
        al.test15();
    }
}
