package com.zhang.chapter4.section41;

/**
 * 深度优先搜索
 */
public class DepthFirstSearch {
    private boolean[] marked;//被标记的顶点
    private int count;//走过的顶点数

    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        count++;
        for (int w : G.adj(v)) {
            if (!marked[w]) dfs(G, w);
        }
    }

    private boolean marked(int w) {
        return marked[w];
    }

    private int count() {
        return count;
    }

}
