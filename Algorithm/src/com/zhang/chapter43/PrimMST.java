package com.zhang.chapter43;

import com.zhang.chapter13.Bag;
import com.zhang.chapter24.IndexMinPQ;

/**
 * 最小生成树的Prim算法（即时删除无效边）: 依次加入所有顶点
 */
public class PrimMST {
    //距离树最近的边
    private Edge[] edgeTo;
    //distTo[w] = edgeTo[w].weight()
    private double[] distTo;
    //如果v在树中则为true
    private boolean[] marked;
    //有效的横切边
    private IndexMinPQ<Double> pq;

    public PrimMST(EdgeWeightedGrpgh G) {
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        pq = new IndexMinPQ<>(G.V());

        distTo[0] = 0.0;
        pq.insert(0, 0.0);

        while (!pq.isEmpty()) {
            visit(G, pq.delmMin());
        }
    }

    private void visit(EdgeWeightedGrpgh G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            int w = e.other(v);

            if (marked[w]) continue;
            if (e.weight() < distTo[w]) {
                edgeTo[w] = e;

                distTo[w] = e.weight();
                if (pq.contains(w)) pq.change(w, distTo[w]);
                else pq.insert(w, distTo[w]);
            }
        }
    }

    public Iterable<Edge> edges() {
        Bag<Edge> b = new Bag<>();
        for (int v = 1; v < edgeTo.length; v++) {
            b.add(edgeTo[v]);
        }
        return b;
    }

    public double weight() {
        double weight = 0;
        for (Edge e : edges()) {
            weight += e.weight();
        }
        return weight;
    }
}
