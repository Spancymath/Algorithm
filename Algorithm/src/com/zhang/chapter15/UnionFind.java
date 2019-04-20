package com.zhang.chapter15;

/**
 * union-find的三种实现之第四种，路径压缩加权quickUnion
 */
public class UnionFind {
    //触点所在连通分量的标记
    int[] id;
    //连通分量触点个数（仅对根触点有效）
    int[] num;
    //连通分量个数
    int count;
    //构造方法
    public UnionFind(int N) {
        count = N;
        id = new int[N];
        num = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            num[i] = 1;
        }
    }
    //返回连通分量个数
    public int count() {
        return count;
    }
    //判断两个触点连通
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    //寻找触点所在的连通分量
    public int find(int p) {
        int q = id[p];
        while (id[q] != q) q = id[q];
        while (id[p] != q) {
            int temp = id[p];
            id[p] = q;
            p = temp;
        }
        return q;
    }
    //合并连个连通分量
    public void union(int p, int q) {
        int idp = find(p);
        int idq = find(q);
        if (idp == idq) return;
        count--;
        if (num[idp] < num[idq]) {
            id[idp] = idq;
            num[idq] += num[idp];
        } else {
            id[idq] = idp;
            num[idp] += num[idq];
        }
    }
}
