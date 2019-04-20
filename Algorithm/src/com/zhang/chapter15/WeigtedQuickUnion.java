package com.zhang.chapter15;

/**
 * quick-union三种实现方法之第三种weighted-quick-union
 */
public class WeigtedQuickUnion {
    //触点所在连通分量标记
    private int[] id;
    //连通分量触点个数（只对根触点有效）
    private int[] num;
    //连通分量个数
    private int count;
    //构造方法
    public WeigtedQuickUnion(int N) {
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
    //判断是否连通
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    //寻找所在连通分量
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
        if (num[idp] < num[idq]) {
            id[idp] = idq;
            num[idq] += num[idp];
        } else {
            id[idq] = idp;
            num[idp] += num[idq];
        }
    }
}
