package com.zhang.chapter43;

import com.zhang.chapter13.Bag;
import edu.princeton.cs.algs4.In;

/**
 * 加权无向图的数据类型
 */
public class EdgeWeightedGrpgh {
    //顶点的总数
    private final int V;
    //边的总数
    private int E;
    //邻接表
    private Bag<Edge>[] adj;

    //构造函数
    public EdgeWeightedGrpgh(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Edge>();
        }
    }

    //输入流构造
    public EdgeWeightedGrpgh(In in) {
        this(in.readInt());//读取顶点数初始化邻接表
        int edges = in.readInt();
        for (int i = 0; i < edges; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            addEdge(new Edge(v, w, weight));
        }

    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    //添加一条边
    public void addEdge(Edge e) {
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    //邻接边
    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    //返回所有边
    public Iterable<Edge> edges() {
        Bag<Edge> b = new Bag<Edge>();
        for (int v = 0; v < V; v++) {
            for (Edge e : adj(v)) {
                if (e.other(v) > v) b.add(e);
            }
        }
        return b;
    }
}
