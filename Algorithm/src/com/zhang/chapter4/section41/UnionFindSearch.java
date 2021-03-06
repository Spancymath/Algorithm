package com.zhang.chapter4.section41;

/**
 * 使用union-find方法实现连通性search
 */
public class UnionFindSearch {
    // 父节点数组
    private int[] root;
    // 连接的顶点数
    private int count;
    // 根节点
    private int rootV;

    public UnionFindSearch(Graph G, int s) {
        // 初始化根节点数组
        root = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            root[i] = i;
        }

        // 并
        for (int i = 0; i < G.V(); i++) {
            for (int v : G.adj(i)) {
                union(s, v);
            }
        }

        rootV = find(s);
        count = 0;
        for (int i = 0; i < G.V(); i++) {
            if (rootV == find(i)) count++;
        }
    }

    private int find(int s) {
        if (s < 0 || s > root.length - 1) throw new IllegalArgumentException("数组下标不合法");

        while (root[s] != s) {
            s = root[s];
        }
        return s;
    }

    private void union(int s, int v) {
        int root1 = find(s);
        int root2 = find(v);

        if (root1 == root2) return;

        root[s] = root2;
    }

    // 是否联通
    public boolean marked(int v) {
        return rootV == find(v);
    }

    // 联通的顶点数
    public int count() {
        return count;
    }
}
