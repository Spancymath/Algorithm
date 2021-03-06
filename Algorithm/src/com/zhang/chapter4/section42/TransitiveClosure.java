package com.zhang.chapter4.section42;

/**
 * 顶点对的可达性
 * 局限性：构造需要的空间和V的平方成正比，所以不适用于巨型图
 */
public class TransitiveClosure {

    private DirectedDFS[] all;

    public TransitiveClosure(Digraph G) {
        all = new DirectedDFS[G.V()];
        for (int v = 0; v < G.V(); v++) {
            all[v] = new DirectedDFS(G, v);
        }
    }

    public boolean reachable(int v, int w) {
        return all[v].marked(w);
    }
}
