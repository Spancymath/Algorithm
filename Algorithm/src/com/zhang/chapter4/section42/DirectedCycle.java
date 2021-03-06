package com.zhang.chapter4.section42;

import com.zhang.chapter1.section13.Stack;

/**
 * 判断有向图是否有环
 * 无向图的Cycle不能判断的原因：存在且仅存在一条集合A指向集合B的边v->w，
 *   集合B先遍历，不可能遍历到v；遍历集合A发现w已标记，判断有环，但不可能存在包含v->w边的环
 */
public class DirectedCycle {

    private boolean[] marked;
    private int[] edgsTo;
    private Stack<Integer> cycle;//有向环的所有顶点
    private boolean[] onStack;//递归调用栈上的所有顶点

    public DirectedCycle (Digraph G) {
        onStack = new boolean[G.V()];
        edgsTo = new int[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) dfs(G, v);
        }
    }

    private void dfs(Digraph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (this.hasCycle()) return;
            else if (!marked[w]) {
                edgsTo[w] = v;
                dfs(G, w);
            } else if (onStack[w]) {
                cycle = new Stack<>();
                for (int x = v; x != w; x = edgsTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
            onStack[v] = false;
        }
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }
}
