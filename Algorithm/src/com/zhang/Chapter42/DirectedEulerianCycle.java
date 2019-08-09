package com.zhang.Chapter42;

import com.zhang.chapter13.Stack;
import edu.princeton.cs.algs4.Digraph;

import java.util.Iterator;

/**
 * 有向欧拉环(任意一个)
 *   即一条每条边只出现一次的有向环
 *     方法：有向图G是连通的且每个顶点的出度和入度都相同
 */
public class DirectedEulerianCycle {

    private Stack<Integer> cycle = null;

    public DirectedEulerianCycle(Digraph G) {
        if (G.E() == 0) return;

        for (int v = 0; v < G.V(); v++) {
            if (G.outdegree(v) != G.indegree(v)) return;
        }

        Iterator<Integer>[] adj = (Iterator<Integer>[]) new Iterator[G.V()];
        for (int v = 0; v < G.V(); v++) {
            adj[v] = G.adj(v).iterator();
        }

        int s = nonIsolatedVertex(G);
        Stack<Integer> stack = new Stack<>();
        stack.push(s);

        cycle = new Stack<>();
        while (!stack.isEmpty()) {
            int v = stack.pop();
            while (adj[v].hasNext()) {
                stack.push(v);
                v = adj[v].next();
            }
            cycle.push(v);
        }

        if (cycle.size() != G.E() + 1) {
            cycle = null;
        }
    }

    private int nonIsolatedVertex(Digraph G) {
        for (int v = 0; v < G.V(); v++) {
            if (G.outdegree(v) > 0) return v;
        }
        return -1;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

    public boolean hasEulerianCycle() {
        return cycle != null;
    }
}
