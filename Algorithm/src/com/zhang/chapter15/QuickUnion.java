package com.zhang.chapter15;

/**
 * union-find的三种实现之第二种，quick-union
 */
public class QuickUnion {
    //所在连通分量的标记
    private int[] id;
    //连通分量的数量
    private int count;
    //构造方法
    public QuickUnion(int N) {
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
        while (id[p] != p) p = id[p];
        return p;
    }
    //合并两个连通分量
    public void union(int p, int q) {
        int idp = find(p);
        int idq = find(q);
        if (idp == idq) return;
        count--;
        id[idq] = idp;
    }
}

