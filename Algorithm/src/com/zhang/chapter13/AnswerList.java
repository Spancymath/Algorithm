package com.zhang.chapter13;

import edu.princeton.cs.algs4.StdOut;

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
     *
     * 见EvaluatePostfix.java
     */
    /**1.3.12
     *
     */

    /**
     * 测试主方法
     * @param args
     */

    public static void main(String[] args) {
        AnswerList al = new AnswerList();
        //1.3.5
        //StdOut.println(al.ToBinary(100));
    }

}
