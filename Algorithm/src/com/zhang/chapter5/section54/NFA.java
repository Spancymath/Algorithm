package com.zhang.chapter5.section54;

import com.zhang.chapter4.section42.Digraph;
import com.zhang.chapter4.section42.DirectedDFS;
import com.zhang.chapter1.section13.Bag;
import com.zhang.chapter1.section13.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 正则表达式的模式匹配（grep）
 */
public class NFA {
    private char[] re;//匹配的转换
    private Digraph G;//epsilon转换
    private int M;//状态的数量

    public NFA(String regexp) {
        //根据定义的正则表达式构造NFA
        Stack<Integer> ops = new Stack<>();
        re = regexp.toCharArray();
        M = re.length;
        G = new Digraph(M+1);

        for (int i = 0; i < M; i++) {
            int lp = i;
            if (re[i] == '(' || re[i] == '|') ops.push(i);
            else if (re[i] == ')') {
                int or = ops.pop();
                if (re[or] == '|') {
                    lp = ops.pop();
                    G.addEdge(lp, or+1);
                    G.addEdge(or, i);
                } else {
                    lp = or;
                }
            }
            if (i < M-1 && re[i+1] == '*') {//查看下一个字符
                G.addEdge(lp, i+1);
                G.addEdge(i+1, lp);
            }
            if (re[i] == '(' || re[i] == '*' || re[i] == ')') {
                G.addEdge(i, i+1);
            }
        }
    }

    public boolean recognizes(String txt) {
        //NFA是否能够识别文本txt
        Bag<Integer> pc = new Bag<>();
        DirectedDFS dfs = new DirectedDFS(G, 0);
        for (int v = 0; v < G.V(); v++) {
            if (dfs.marked(v)) pc.add(v);
        }

        for (int i = 0; i < txt.length(); i++) {
            Bag<Integer> match = new Bag<>();
            for (int v : pc) {
                if (v < M) {
                    if (re[v] == txt.charAt(i) || re[v] == '.') {
                        match.add(v+1);
                    }
                }
            }
            pc = new Bag<>();
            dfs = new DirectedDFS(G, match);
            for (int v = 0; v < G.V(); v++) {
                if (dfs.marked(v)) pc.add(v);
            }
        }
        for (int v : pc) {
            if (v == M) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String regexp = "(.*" + args[0] + ".*";
        NFA nfa = new NFA(regexp);
        while (StdIn.hasNextLine()) {
            String txt = StdIn.readLine();
            if (nfa.recognizes(txt)) {
                StdOut.println(txt);
            }
        }
    }
}
