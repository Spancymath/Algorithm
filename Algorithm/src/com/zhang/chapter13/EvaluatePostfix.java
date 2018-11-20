package com.zhang.chapter13;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 计算后序表达式的值
 */
public class EvaluatePostfix {
    public String evaluatePostfix(Queue<String> queue) {
        String OPERATORS = "+-*/";
        //计算用的栈
        Stack<String> stack = new Stack<>();
        //计算结果
        double res = 0.0;
        //从左到右遍历算式队列
        while (!queue.isEmpty()) {
            String temps = queue.dequeue();
            //数字则压入栈
            if (!OPERATORS.contains(temps)) stack.push(temps);
            //符号则出栈两个数字，计算结果，结果压入栈
            else {
                double num2 = Double.parseDouble(stack.pop());
                double num1 = Double.parseDouble(stack.pop());
                switch (temps) {
                    case "+": {
                        res = num1 + num2;
                        break;
                    }
                    case "-": {
                        res = num1 - num2;
                        break;
                    }
                    case "*": {
                        res = num1 * num2;
                        break;
                    }
                    case "/": {
                        res = num1 / num2;
                        break;
                    }
                    default: {
                        break;
                    }
                }
                stack.push(res + "");
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        In in = new In("C:\\Users\\Mather\\IdeaProjects\\Algorithm\\Algorithm\\file\\infix");
        while (!in.isEmpty()) {
            queue.enqueue(in.readString());
        }
        String res = new EvaluatePostfix().evaluatePostfix(
                new InfixToPostfix().infixToPostfix(queue)
        );
        StdOut.println(res);
    }
}
