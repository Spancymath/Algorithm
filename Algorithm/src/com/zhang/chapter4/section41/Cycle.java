package com.zhang.chapter4.section41;

import com.zhang.chapter3.section35.SET;

/**
 * 一个图是否有环: 路径上的某个顶点存在一个相邻顶点被标记，但此顶点不是此路径上该顶点的上一个顶点
 */
public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph G) {
        marked = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s, s);
            }
        }
    }

    public void dfs(Graph G, int v, int u) {
        //允许自环，平行边
        SET<Integer> set = new SET<>();
        int count = 0;
        for (int w : G.adj(v)) {
            if (w == v) hasCycle = true;
            set.add(w);
            count++;
        }
        if (set.size() != count) hasCycle = true;

        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w, v);
            } else if (w != u) {
                hasCycle = true;
            }
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }
}
