package com.zhang.chapter1.section13;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 中序表达式转为后序表达式
 * v1.0 20181118
 *
 */
public class InfixToPostfix {
    public Queue<String> infixToPostfix(Queue<String> queue) {
        String OPERATORS = "+-*/";
        String LEFT_PAREN = "(";
        String RIGHT_PAREN = ")";
        //结果栈
        Queue<String> res = new Queue<>();
        //符号栈
        Stack<String> ope = new Stack<>();
        //从左到右遍历字符串队列
        while (!queue.isEmpty()) {
            String temps = queue.dequeue();
            if (!(OPERATORS + LEFT_PAREN + RIGHT_PAREN).contains(temps)) res.enqueue(temps);
            else if (temps.equals(RIGHT_PAREN)) res.enqueue(ope.pop());
            else if (OPERATORS.contains(temps)) ope.push(temps);
        }
        return res;
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        In in = new In("C:\\Users\\Mather\\IdeaProjects\\Algorithm\\Algorithm\\file\\infix");
        while (!in.isEmpty()) {
            queue.enqueue(in.readString());
        }
        Queue<String> stack = new InfixToPostfix().infixToPostfix(queue);
        while (!stack.isEmpty()) {
            StdOut.print(stack.dequeue() + " ");
        }
    }
}
