package com.zhang.chapter1.section13;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 补充左括号
 * v1.0 20181118
 * v1.1 20181118 modify 括号里面奇数个操作数
 * v1.2 20181118 modify 遇到数字，判断符号栈为操作符则加左括号
 */
public class RepairParen {
    public Stack<String> repairParen(Stack<String> ori) {
        String OPERATORS = "()+-*/";
        //符号栈
        Stack<String> ope = new Stack<>();
        //结果栈
        Stack<String> res = new Stack<>();
        //初始化初始字符串栈
        //从右往左依次读取
        while (!ori.isEmpty()) {
            //弹出字符串
            String pops = ori.pop();
            res.push(pops);
            //modify v1.2 如果是数字且操作符栈栈顶是操作符，加左括号；
            // 否则入结果栈，同时把非数字入操作符栈
            if (!OPERATORS.contains(pops)) {
                while (!ope.isEmpty() && !ope.peek().equals(")")) {
                    res.push("(");
                    ope.pop();
                    ope.pop();
                }
            } else {
                ope.push(pops);
            }
            /**
             * 遇到右括号，且下一个不是右括号
            if (pops.equals(")") && !ori.peek().equals(")")) {
                //add v1.1 右括号也压入符号栈
                ope.push(pops);

                res.push(pops);
                //压入三个字符串到结果栈
                res.push(ori.pop());
                //压入其中一个符号到符号栈
                ope.push(ori.peek());
                res.push(ori.pop());
                //add v1.1 第三个符号是右括号则继续读取
                if (ori.peek().equals(")")) continue;

                res.push(ori.pop());
                //压入结果栈左括号，个数等于符号栈大小
                //清空符号栈
                while (!ope.isEmpty()) {
                    //modify v1.1 符号栈栈顶是符号才补充符号
                    //ope.pop();
                    if (ope.peek().equals(")")) break;
                    res.push("(");
                    ope.pop();
                    ope.pop();
                }

            } else {
                res.push(pops);
                //modify v1.1 右括号也插入符号栈
                //if (!pops.equals(")")) ope.push(pops);
                ope.push(pops);
            }**/
        }
        return res;
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        In in = new In("C:\\Users\\Mather\\IdeaProjects\\Algorithm\\Algorithm\\file\\lackLeftParen");
        while (!in.isEmpty()) {
            stack.push(in.readString());
        }
        stack = new RepairParen().repairParen(stack);
        while (!stack.isEmpty()) {
            StdOut.print(stack.pop() + " ");
        }
    }
}
