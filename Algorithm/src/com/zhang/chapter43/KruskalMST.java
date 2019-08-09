package com.zhang.chapter43;

import com.zhang.chapter13.Queue;
import com.zhang.chapter15.UnionFind;
import com.zhang.chapter24.MinPQ;

/**
 * 最小生成树的KruskalMST算法
 */
public class KruskalMST {
    private Queue<Edge> mst;

    public KruskalMST(EdgeWeightedGrpgh G) {
        mst = new Queue<>();
        MinPQ<Edge> pq = new MinPQ<Edge>(G.edges());
        UnionFind uf = new UnionFind(G.V());

        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);
            if (uf.connected(v, w)) continue;
            uf.union(v, w);
            mst.enqueue(e);
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
