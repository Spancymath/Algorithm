package com.zhang.Chapter42;

import com.zhang.chapter13.Bag;
import com.zhang.chapter44.DirectedEdge;
import com.zhang.chapter44.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.In;

/**
 * 有向图
 */
public class Digraph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public Digraph(In in) {
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

    public Digraph(Digraph G) {
        this.V = G.V();
        this.E = G.E;
        adj = new Bag[G.V()];
        for (int v = 0; v < V; v++) {
            for (int w : G.adj(v)) {
                this.adj[v].add(w);
            }
        }
    }

    public Digraph(EdgeWeightedDigraph G) {
        this.V = G.V();
        this.E = G.E();
        adj = new Bag[G.V()];
        for (int v = 0; v < V; v++) {
            for (DirectedEdge e : G.adj(v)) {
                this.adj[v].add(e.to());
            }
        }
    }

    public int V() {
        return V;
    }

    public int E(){
        return E;
    }

    public boolean hasEdge(int v, int w) {
        return adj[v].contains(w);
    }

    public void addEdge(int v, int w) {
        //不允许平行边和自环
        if (v == w) throw new RuntimeException("不允许自环！");
        if (adj[v].contains(w)) throw new RuntimeException("不允许平行边！");

        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj(v)) {
                R.addEdge(w, v);
            }
        }
        return R;
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
