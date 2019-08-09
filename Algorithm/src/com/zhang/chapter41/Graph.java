package com.zhang.chapter41;

import com.zhang.chapter13.Bag;
import edu.princeton.cs.algs4.In;

import java.util.Iterator;

public class Graph {
    private final int V;//顶点数目
    private int E;//边的数目
    private Bag<Integer>[] adj;//邻接表

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    public Graph(Graph G) {
        this.V = G.V();
        this.E = G.E();
        adj = new Bag[G.V()];
        for (int v = 0; v < G.V(); v++) {
            adj[v] = new Bag<Integer>(G.adj(v));
        }
    }

    public Graph(In in) {
        this(in.readInt());//读取V并将图初始化
        int E = in.readInt();//读取E
        for (int i = 0; i < E; ) {
            //int v = in.readInt();
            //int w = in.readInt();
            //addEdge(v, w);//添加一条边
            String s = in.readLine();
            String[] vertex = s.split(" ");
            for (int j = 1; j < vertex.length; j++, i++) {
                addEdge(Integer.parseInt(vertex[0]), Integer.parseInt(vertex[j]));
            }
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    //添加一条边
    public void addEdge(int v, int w) {
        //不允许自环
        if (v == w) throw new RuntimeException("不允许自环");
        //不允许平行边
        if (hasEdge(v, w)) throw new RuntimeException("不允许平行边");
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    //返回所有相邻的顶点
    public Iterable<Integer> adj(int v) {
        if (v < 0 || v >= V) throw new IllegalArgumentException("Illegal Edge!");
        return adj[v];
    }

    //判断是否含有某条边
    public boolean hasEdge(int v, int w) {
        if (v < 0 || v >= V) throw new IllegalArgumentException("Illegal Edge!");
        if (w < 0 || w >= V) throw new IllegalArgumentException("Illegal Edge!");
        Iterator<Integer> itr = adj[v].iterator();
        while (itr.hasNext()) {
            if (itr.next() == w) return true;
        }
        return false;
    }

    //顶点的度
    public int degree(int v) {
        int degree = 0;
        for (int w : adj(v)) degree++;
        return degree;
    }

    //最大度
    public int maxDegree() {
        int max = 0;
        for (int v = 0; v < V; v++) {
            if (degree(v) > max) {
                max = degree(v);
            }
        }
        return max;
    }

    //平均度
    public int avgDegree() {
        return 2 * E() / V();
    }

    //自环数
    public int numberOfSelfLoops() {
        int count = 0;
        for (int v = 0; v < V; v++) {
            for (int w : adj(v)) {
                if (v == w) {
                    count++;
                }
            }
        }
        return count / 2;
    }

    public String toString() {
        String s = V + " vertices, " + E + " edges\n";
        for (int v = 0; v < V; v++) {
            s += v + ": ";
            for (int w : this.adj(v)) {
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }
}
