package com.zhang.Chapter42;

import com.zhang.chapter13.Bag;
import com.zhang.chapter13.Queue;

/**
 * 顶点的度
 */
public class Degrees {

    private int[] inDgrees;

    private int[] outDgrees;

    public Degrees(Digraph G) {
        inDgrees = new int[G.V()];
        outDgrees = new int[G.V()];
        for (int v = 0; v < G.V(); v++) {
            for (int j : G.adj(v)) {
                inDgrees[j]++;
                outDgrees[v]++;
            }
        }
    }

    public int indegree(int v) {
        return inDgrees[v];
    }

    public int outdegree(int v) {
        return outDgrees[v];
    }

    public Iterable<Integer> sources() {
        Bag<Integer> bag = new Bag<>();
        for (int v = 0; v < outDgrees.length; v++) {
            if (outDgrees[v] == 0) bag.add(v);
        }
        return bag;
    }

    public Iterable<Integer> sinks() {
        Bag<Integer> bag = new Bag<>();
        for (int v = 0; v < inDgrees.length; v++) {
            if (inDgrees[v] == 0) bag.add(v);
        }
        return bag;
    }

    //检测其是否属于拓扑排序
    public boolean isTopoligical(Digraph G, Queue<Integer> queue) {
        int[] ins = new int[inDgrees.length];
        for (int v = 0; v < ins.length; v++) {
            ins[v] = inDgrees[v];
        }

        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            if (ins[v] != 0) return false;
            for (int w : G.adj(v)) ins[w]--;
        }
        return true;
    }
}
