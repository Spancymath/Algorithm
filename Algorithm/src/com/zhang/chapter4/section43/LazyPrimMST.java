package com.zhang.chapter4.section43;

import com.zhang.chapter1.section13.Queue;
import com.zhang.chapter2.section24.MinPQ;

/**
 * 最小生成树的Prim算法的延时实现
 */
public class LazyPrimMST {

    //最小生成树的顶点
    private boolean[] marked;
    //最小生成树的边
    private Queue<Edge> mst;
    //横切边(包括失效的边)
    private MinPQ<Edge> pq;

    public LazyPrimMST(EdgeWeightedGrpgh G) {
        pq = new MinPQ<>();
        marked = new boolean[G.V()];
        mst = new Queue<>();
        visit(G, 0);
        while (!pq.isEmpty()) {
            Edge e = pq.delMin();

            int v = e.either(), w = e.other(v);
            if (marked[v] && marked[w]) continue;
            mst.enqueue(e);
            if (!marked[v]) visit(G, v);
            if (!marked[w]) visit(G, w);
        }

    }

    //标记顶点v,并将所有连接v,和未被标记的顶点的边加入pq
    private void visit(EdgeWeightedGrpgh G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            if (!marked[e.other(v)]) pq.insert(e);
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        int weight = 0;
        for (Edge e : mst) {
            weight += e.weight();
        }
        return weight;
    }
}
