package com.zhang.chapter1.section13;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Parentheses {
    private static final char LEFT_PAREN = '(';
    private static final char RIGHT_PAREN = ')';
    private static final char LEFT_BRACE = '{';
    private static final char RIGHT_BRACE = '}';
    private static final char LEFT_BRACKET = '[';
    private static final char RIGHT_BRACKET = ']';

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == LEFT_PAREN) stack.push(LEFT_PAREN);
            if (s.charAt(i) == LEFT_BRACE) stack.push(LEFT_BRACE);
            if (s.charAt(i) == LEFT_BRACKET) stack.push(LEFT_BRACKET);

            if (s.charAt(i) == RIGHT_PAREN) {
                if (stack.isEmpty()) return false;
                if (stack.pop() != LEFT_PAREN) return false;
            } else if (s.charAt(i) == RIGHT_BRACE) {
                if (stack.isEmpty()) return false;
                if (stack.pop() != LEFT_BRACE) return false;
            } else if (s.charAt(i) == RIGHT_BRACKET) {
                if (stack.isEmpty()) return false;
                if (stack.pop() != LEFT_BRACKET) return false;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        In in = new In("C:\\Users\\Mather\\IdeaProjects\\Algorithm\\Algorithm\\file\\Brackets.txt");
        String s = in.readAll().trim();
        StdOut.println(isBalanced(s));
        /*Stack<Character> stack = new Stack<>();
        In in = new In("C:\\Users\\Mather\\IdeaProjects\\Algorithm\\Algorithm\\file\\Brackets.txt");
        while (!in.isEmpty()) {
            char c = in.readChar();
            if ("([{".contains(c + "") ) stack.push(c);
            else if(stack.isEmpty()) {
                StdOut.println("false");
                return;
            } else {
                char tempc = stack.pop();
                if (c == ')' && tempc != '(' || c == ']' && tempc != '['
                        || c == '}' && tempc != '{') {
                    StdOut.println("false");
                    return;
                }

            }
        }
        in.close();
        if (stack.isEmpty()) {
            StdOut.println("true");
        } else {
            StdOut.println("false");
        }*/
    }
}
