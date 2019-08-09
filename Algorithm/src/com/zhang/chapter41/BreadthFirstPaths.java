package com.zhang.chapter41;

import com.zhang.chapter13.Queue;
import com.zhang.chapter13.Stack;

/**
 * 广度优先搜索
 */
public class BreadthFirstPaths {
    private boolean[] marked;//到达该顶点的最短路径是否已知
    private int[] edgeTo;//到达该顶点已知路径的最后一个顶点
    private final int s;//起点

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new Queue<>();
        marked[s] = true;
        queue.enqueue(s);
        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> stack = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            stack.push(x);
        }
        stack.push(s);
        return stack;
    }

    //到给定顶点的距离
    public int distTo(int v) {
        if (!hasPathTo(v)) return -1;
        int count = 0;
        for (int x = v; x != s; x = edgeTo[x]) {
            count++;
        }
        count++;
        return count;
    }
}
