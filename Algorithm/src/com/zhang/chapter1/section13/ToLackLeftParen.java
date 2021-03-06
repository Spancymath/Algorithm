package com.zhang.chapter1.section13;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 把正常表达式转为缺少左括号的标准表达式
 * v1.0 20181118
 * v1.1 20181118 modify 由读取到数字判断，改为读取到操作符判断
 * v1.2 20181118 modify 改回v1.1 增加符号栈压入左括号
 * v1.3 20181119 modify 读到数字或右括号都判断
 * v1.4 20181119 modify 栈顶操作符优先级大于队首，若栈顶下面一个还是操作符，继续和队首符号比较
 *
 *v1.2 思路
 * 数字：
 *     比较后边的操作符和符号栈栈顶操作符
 *         符号栈不为空，且栈顶不是左括号，且队列不为空，遍历符号栈
 *         前边操作符优先级大于后边，加括号，否则继续
 *
 *         队列为空，且符号栈不为空，遍历符号栈
 *         加括号
 *
 * 操作符和左括号：
 *     入结果栈和符号栈
 *
 * 右括号：
 *     出符号栈左括号
 *     符号栈不为空，且栈顶不是左括号，遍历符号栈
 *     加括号
 *
 *v1.3思路
 * 数字和右括号都需要加括号
 *
 * 数字或右括号：
 *     数字：
 *              入结果栈
 *              符号栈为空或栈顶是左括号，不加；
 *              队列为空或下一个是右括号，遍历符号栈直到遇到左括号，每个符号加一个右括号；
 *              比较队列下一个符号（非空非右括号）和栈顶符号（非空非右括号），栈顶优先级高则加括号
 *     右括号：
 *              不入结果栈，且删除符号栈栈顶符号（左括号）
 *              符号栈为空或栈顶是左括号，不加；
 *              队列为空或下一个是右括号，遍历符号栈直到遇到左括号，每个符号加一个右括号；
 *              比较队列下一个符号（非空非右括号）和栈顶符号（非空非右括号），栈顶优先级高则加括号
 *
 *     ↓↓↓↓↓↓
 *     ↓↓↓↓↓↓
 *
 *     数字：
 *              入结果栈
 *     右括号：
 *              不入结果栈，且删除符号栈栈顶符号（左括号）
 *
 *     符号栈为空或栈顶是左括号，不加；
 *     队列为空或下一个是右括号，遍历符号栈直到遇到左括号，每个符号加一个右括号；
 *     队列不为空且下一个不是右括号，比较队列下一个符号（非空非右括号）和栈顶符号（非空非右括号，若连着两个都符合则都比较），栈顶优先级高则加括号
 *
 * 左括号和符号：入结果栈和符号栈
 */
public class ToLackLeftParen {
    public Stack<String> toLackLeftParen(Queue<String> queue) {
        String LEFT_PAREN = "(";
        String RIGHT_PAREN = ")";
        String OPERATORS = "+-*/";
        //结果栈
        Stack<String> res = new Stack<>();
        //符号暂存栈
        Stack<String> opes = new Stack<>();
        //从左到右遍历字符串
        while (!queue.isEmpty()) {
            String s = queue.dequeue();
            //modify v1.3 思路及修改点见上边
            //操作符和左括号入栈
            if ((OPERATORS + LEFT_PAREN).contains(s)) {
                if (!s.equals(LEFT_PAREN)) res.push(s);
                opes.push(s);
            } else {
                //右括号
                if (s.equals(RIGHT_PAREN)) opes.pop();
                //数字
                else res.push(s);
                //栈顶是空或左括号
                if (opes.isEmpty() || opes.peek().equals(LEFT_PAREN)) continue;
                //队列是空或右括号
                if (queue.isEmpty() || queue.peek().equals(RIGHT_PAREN)) {
                    while (!opes.isEmpty() && !opes.peek().equals(LEFT_PAREN)) {
                        res.push(RIGHT_PAREN);
                        opes.pop();
                    }
                } else {
                    if (comparePririoty(opes.peek(), queue.peek())) {
                        res.push(RIGHT_PAREN);
                        opes.pop();
                        //v1.4 modify 前边优先级高，可能前边的前边优先级也高
                        if (!opes.isEmpty() && !opes.peek().equals(LEFT_PAREN) && comparePririoty(opes.peek(), queue.peek())) {
                            res.push(RIGHT_PAREN);
                            opes.pop();
                        }
                    }
                }

            }
            /**
            //modify v1.2 左括号不能忽略，右括号则出栈左括号
            if (s.equals(RIGHT_PAREN)) {
                opes.pop();
                while (!opes.isEmpty() && !opes.peek().equals(LEFT_PAREN)) {
                    res.push(RIGHT_PAREN);
                    opes.pop();
                }
                continue;
            }**/
            //左括号，忽略
            //if (s.equals(LEFT_PAREN)) continue;
            /**modify v1.1 读取到操作符进行判断，加括号
            //右括号加入结果栈，并出栈符号栈符号
            if (s.equals(RIGHT_PAREN)) {
                opes.pop();
            }
            //符号
            if (OPERATORS.contains(s)) {
                if (queue.peek().equals(LEFT_PAREN)) {
                    opes.push(s);
                } else {
                    if (opes.isEmpty()) opes.push(s);
                    else {
                        while (!opes.isEmpty() && comparePririoty(opes.peek(), s)) {
                            res.push(RIGHT_PAREN);
                            opes.pop();
                        }
                    }
                }
            }//数字, 其他都入栈

            res.push(s);**/
            //入栈
            /**
            //modify v1.2 左符号不入结果集
            if (!s.equals(LEFT_PAREN)) res.push(s);
            //操作符入符号栈   //modify v1.2 左符号也入符号栈
            if ((OPERATORS + LEFT_PAREN).contains(s)) opes.push(s);
            //数字
            else {
                if (opes.isEmpty() || opes.peek().equals(LEFT_PAREN))continue;
                //队列为空或下一个是右括号
                if (queue.isEmpty() || queue.peek().equals(RIGHT_PAREN)) {
                    while (!opes.isEmpty() && !opes.peek().equals(LEFT_PAREN)) {
                        res.push(RIGHT_PAREN);
                        opes.pop();
                    }
                } else {
                    if (comparePririoty(opes.peek(), queue.peek())) {
                        res.push(RIGHT_PAREN);
                        opes.pop();
                    }
                }
                //下一个是右括号，则入结果栈，弹出符号栈符号
                while (!queue.isEmpty() && queue.peek().equals(RIGHT_PAREN)) {
                    res.push(queue.dequeue());
                    opes.pop();
                }
                //队列为空，符号栈出栈，且加右括号
                if (queue.isEmpty()) {
                    while (!opes.isEmpty()) {
                        res.push(RIGHT_PAREN);
                        opes.pop();
                    }
                }
                //前面符号优先级大于等于后边，加括号
                else if (!opes.isEmpty()) {
                    if (comparePririoty(opes.peek(), queue.peek())) {
                        res.push(RIGHT_PAREN);
                        opes.pop();
                    }
                }**/
            //}
        }
        //modify v1.1 最后加括号
        /**while (!opes.isEmpty()) {
            res.push(RIGHT_PAREN);
            opes.pop();
        }**/

        return res;
    }

    /**
     * ope1优先级是否大于等于ope2
     * @param ope1
     * @param ope2
     * @return
     */
    private boolean comparePririoty(String ope1, String ope2) {
        String PLUS_MINUS = "+-";
        String MULTIPLY_DIVISION = "*/";
        if (PLUS_MINUS.contains(ope1) && MULTIPLY_DIVISION.contains(ope2)) return false;
        return true;

    }

    public static void main(String[] args) {
        //求一般表达式的值

        //读取表达式
        Queue<String> queue = new Queue<>();
        In in = new In("C:\\Users\\Mather\\IdeaProjects\\Algorithm\\Algorithm\\file\\lackParen");
        while (!in.isEmpty()) {
            String s = in.readString();
            //if (!s.equals("("))
            queue.enqueue(s);
        }
        in.close();
        //中序表达式
        Stack<String> infixStack = new RepairParen().repairParen(
                new ToLackLeftParen().toLackLeftParen(queue)//右括号表达式
        );
        //中序表达式放队列里
        Queue<String> infixQueue = new Queue<>();
        while (!infixStack.isEmpty()) infixQueue.enqueue(infixStack.pop());
        //求后序的值
        String result = new EvaluatePostfix().evaluatePostfix(
                new InfixToPostfix().infixToPostfix(//中序转后序
                        infixQueue
                )
        );
        StdOut.println(result);
        /**
         *测试普通表达式到右括号表达式转化
         *Stack<String> stackT = new ToLackLeftParen().toLackLeftParen(queue);
        Stack<String> stack = new Stack<>();
        while (!stackT.isEmpty()) stack.push(stackT.pop());

        while (!stack.isEmpty()) {
            StdOut.print(stack.pop() + " ");
        }**/
    }
}
