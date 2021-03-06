package com.zhang.chapter1.section15;

/**
 * union-find的三种实现之第一种，quick-find
 */
public class QuickFind {
    //所在连通分量的标记
    private int[] id;
    //连通分量的数量
    private int count;
    //构造方法
    public QuickFind(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }
    //返回连通分量数量
    public int count() {
        return count;
    }
    //判断两个触电是否连通
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    //返回触电所在的连通分量的标记
    public int find(int p) {
        return id[p];
    }
    //合并两个连通分量
    public void union(int p, int q) {
        int idp = find(p);
        int idq = find(q);
        if (idp == idq) return;
        count--;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == idq) id[i] = idp;
        }
    }
}
