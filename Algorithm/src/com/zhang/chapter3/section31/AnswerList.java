package com.zhang.chapter3.section31;


import edu.princeton.cs.algs4.*;
import org.junit.jupiter.api.Test;

/**
 * 符号表
 * 1.符号表是一种存储键值对的数据结构，支持两种操作：插入，即将一组新的键值对存入表中；查找，即根据给定的键得到相应的值
 * 2.无序链表（每个结点存键和值）实现字典，顺序查找，因为需要判重，索引插入N个不同元素需要~N^2/2次比较
 * 3.有序数组实现字典，用一对平行的数组，一个存键一个存值。查找时可以用二分查找，查找一个键需要（lgN+1）次比较
 */
public class AnswerList {
    /**
     * 3.1.8
     * 统计双城记中出现频率最高的长度大于10的单词
     * out: monseigneur --> 101
     */
    FrequencyCounter Chapter30108 = new FrequencyCounter();
    /**
     * 3.1.9
     * 追踪最后一次put的字符串和前边处理的字符数
     * out:  1:  known beforeWordsNum: 135634
     *       8:  faltering beforeWordsNum: 135602
     *       10: disfigurement beforeWordsNum: 135587
     */
    FrequencyCounter Chapter30109 = new FrequencyCounter();
    /**
     * 3.1.10
     * 插入轨迹
     * Answer：E A S Y Q     U T I O N
     *         比较次数：0+1+2+3+4+5+1+3+6+7+8+9=49
     */

    /**
     * 3.1.11
     * 插入轨迹
     * Answer：A E I O Q S T U Y
     *         比较次数：0+1+2+2+2+3+2+3+3+3+3+4=28
     */

    /**
     * 3.1.12
     * 添加构造函数
     */
    BinarySearchST<String, Integer> st = new BinarySearchST<>();
    /**
     * 3.1.13
     * 更多插入的时候选哪种符号表
     * Answer：
     *          会选择BinarySearchST, 因为他的查找操作最高效
     */
    /**
     * 3.1.14
     * 更多插入的时候选哪种符号表
     * Answer：
     *          选择无序链表字典表，因为它的插入对时间和空间需求小
     */
    /**
     * 3.1.15
     * Answer:
     *          0     0.5      0.8
     */
    /**
     * 3.1.16
     * 实现delete()
     */
    @Test
    public void test16() {
        st.delete("key");
    }
    /**
     * 3.1.17
     * 实现floor（）方法
     */
    @Test
    public void test17() {
        st.floor("key");
    }
    /**
     * 3.1.18
     * 证明rank（）方法正确性
     * Answer：
     *          每次将数组缩小一半，对比中间值，大于搜左边，小于搜右边，最后总能找到等于的值
     *          如果不存在等于的值，lo ， hi , 返回lo
     *          全小于 lo=hi=N - 1, lo = mid + 1，返回lo + 1
     *          全大于lo = hi = 0, hi = mid - 1， 返回lo
     */
    /**
     *3.1.19
     * 打印所有出现频率最大的单词
     */
    @Test
    public void test19() {
        new FrequencyCounter();
    }
    /**
     * 3.1.20
     * Answer:
     *          。。
     */
    /**
     * 3.1.22
     * 自组织查找
     * Chapter30102的get方法
     */
    /**
     * 3.1.23
     * answer:
     *          C(n) = C(n/2) + 1; C(1) = 1; C(2) = 2
     *          每乘2倍，二进制就多一位
     */
    /**
     * 3.1.24
     * 实现插值查找法，比较插值法和二分法查找的效率
     * 通过main方法运行test24（）
     * 结果： 插值法的效率很很很很很低
     */
    public void test24() {
        StdOut.println("请输入要统计的单词的最短长度");
        int minlen = StdIn.readInt();
        //二分查找
        BinarySearchST<String, Integer> st = new BinarySearchST<>();
        //插值查找
        //InterpolationSearchST<String, Integer> st = new InterpolationSearchST<>();
        int n = 0;
        String lastWord = "";
        int lastN = 0;
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (word.equals("exit;")) break;
            n++;
            if (word.length() < minlen) continue;
            if (!st.contains(word)) {
                st.put(word, 1);
            }
            else {
                st.put(word, st.get(word) + 1);
            }
        }
        //打印出现频率最高的单词
        StdOut.println(st.maxKey() + ": " + st.maxVal());
    }

    /**
     * 3.1.25
     * 记录缓存访问最频繁的键
     * answer：
     *          BinarySearchST.get();
     */
    /**
     * 3.1.26
     * 打印字典序和频率排序两张表
     */
    private void test26() {
        StdOut.println("请输入要读取的文件名：");
        String file = StdIn.readString();
        StdOut.println("请输入字典序文件的文件名：");
        String dict = StdIn.readString();
        StdOut.println("请输入频率排序文件的文件名：");
        String dictAccess = StdIn.readString();

        String path = "C:\\Users\\Mather\\IdeaProjects\\Algorithm\\Algorithm\\file\\";

        BinarySearchST<String, Integer> st = new BinarySearchST<>();

        //读取文件，创建字典
        In in = new In(path+file + ".txt");
        while (in.hasNextChar()) {
            String word = in.readString();
            if (!st.contains(word)) {
                st.put(word, 1);
            } else {
                st.put(word, st.get(word) + 1);
            }
        }
        in.close();

        //写入字典序文件
        Out out = new Out(path+dict + ".txt");
        for (int i = 0; i < st.size(); i++) {
            out.println(st.getIkey(i) + ": " + st.getIvalue(i));
        }
        out.close();

        st.reorderst(st.getItems());
        //写入频率序文件
        out = new Out(path + dictAccess + ".txt");
        for (int i = 0; i < st.size(); i++) {
            out.println(st.getIvalue(i) + ": " + st.getIkey(i));
        }
        out.close();

    }

    /**
     * 3.1.27
     * 小符号表：构造有N个不同键的字典，需要S次查找，给出S的增长数量级
     * Answer：
     *          S = N + n * 3  (n是相同键的数量)
     */

    /**
     * 3.1.28
     * 有序插入：改造BinarySearchST，使得插入大于已有键的键值，只需要常数时间
     * Answer：
     *          改造BinarySearchST的rank方法
     */

    /**
     * 3.1.29
     * 验证BinarySearchST中函数的实现
     * Answer：
     *          TestBinarySearch
     */

    /**
     * 3.1.30
     * 插入/删除插入断言
     * Answer：
     *          BinarySearchST的put 和 delete里面加的
     */

    /**
     * 3.1.31
     * 性能测试
     */
    public void test31() {
        //StdOut.println((int) 'a' + "-" + (int) 'z');//97-122
        //StdOut.println((int) 'A' + "-" + (int) 'Z');//65-90
        int times = 10;

        int DICT_SIZE = 100000;
        String[] randSrings = genRandArray(DICT_SIZE);

        StdOut.println("程序运行时间：");

        while (times-- != 0) {
            long startTime = System.currentTimeMillis();
            BinarySearchST<String, Integer> st = new BinarySearchST();
            //构造字典
            for (int i = 0; i < DICT_SIZE; i++) {
                if (st.get(randSrings[i]) == null) {
                    st.put(randSrings[i], 1);
                } else {
                    st.put(randSrings[i], st.get(randSrings[i]) + 1);
                }
            }

            //get
            for (int i = 0; i < DICT_SIZE * 10; i++) {
                int j = StdRandom.uniform(DICT_SIZE);
                st.get(randSrings[j]);
                st.get(randSrings[j + DICT_SIZE]);
            }

            long endTime = System.currentTimeMillis();
            StdOut.println("第" + times + "次：" + (endTime - startTime) + "ms");
            //避免运行时间直线增长
            st = null;
        }
    }
    //生成随机字符串
    public String[] genRandArray(int length) {
        //32题
        //int CHARACTER_NUM = 2;
        //int MAXLENGTH = 2;
        //31题
        int CHARACTER_NUM = 26;
        int MAXLENGTH = 50;

        char[] character = new char[CHARACTER_NUM];
        char[] CHARACTER = new char[CHARACTER_NUM];
        for (int i = 0; i < CHARACTER_NUM; i++) {
            character[i] = (char) (65 + i);
            CHARACTER[i] = (char) (65 + 32 +i);
        }
        int minL = 2;
        int maxL = MAXLENGTH;
        String[] s = new String[length * 2];
        for (int i = 0; i < length; i++) {
            int l = StdRandom.uniform(minL, maxL + 1);
            String tempc = "";
            String tempC = "";
            while (l-- != 0) {
                int j = StdRandom.uniform(CHARACTER_NUM);
                tempc = tempc + character[j];
                tempC = tempC + CHARACTER[j];
            }
            s[i] = tempc;
            s[i + length] = tempC;
        }
        return s;
    }

    /**
     * 3.1.32
     * 练习
     * answer：
     *          31题的genRandArray中生成了只有两个字符串的字符串组，性能提高10多倍
     */
    /**
     * end   后边的太烦了
     */
    private static AnswerList ls = new AnswerList();

    public static void main(String args[]) {
        //ls.test24();
        //ls.test26();
        ls.test31();
    }
}
