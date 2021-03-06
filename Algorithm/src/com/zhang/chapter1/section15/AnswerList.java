package com.zhang.chapter1.section15;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Union-find算法
 * 1.算法定义-UF：包含除了union方法的实现
 * 2.实现一（quick-find）:id数组存的是两个分量的表示，两个分量合并，把其中一个的根结点换成另一个
 * 3.实现二（quick-union）:id数组存的上一个结点，find递归查出根结点，union只把根结点指向另一个根结点
 * 4.实现三（加权quick-union）：记录树的大小，总是将小的树连到较大的树上
 */
public class AnswerList {
    String tinyUF = "C:\\Users\\Mather\\IdeaProjects\\Algorithm\\Algorithm\\file\\tinyUF.txt";
    String mediumUF = "C:\\Users\\Mather\\IdeaProjects\\Algorithm\\Algorithm\\file\\mediumUF.txt";
    String largeUF = "C:\\Users\\Mather\\IdeaProjects\\Algorithm\\Algorithm\\file\\largeUF.txt";
    //测试quickFind
    private void quickFind() {
        In in = new In(mediumUF);
        int N = in.readInt();
        QuickFind UF = new QuickFind(N);
        while (!in.isEmpty()) {
            int p = in.readInt();
            int q = in.readInt();
            if (UF.connected(p, q)) continue;
            UF.union(p, q);
            StdOut.println(p + ", " + q);
        }
        StdOut.println(UF.count() + "components.");

    }
    //测试quickUnion
    private void quickUnion() {
        In in = new In(largeUF);
        int N = in.readInt();
        QuickUnion UF = new QuickUnion(N);
        int i = 1;
        while (!in.isEmpty()) {
            int p = in.readInt();
            int q = in.readInt();
            if (UF.connected(p, q)) continue;
            UF.union(p, q);
            StdOut.println(p + ", " + q);
            StdOut.println(i++);
        }
        StdOut.println(UF.count() + "components.");

    }
    //测试weightedquickunion
    private void weightedQuickUion() {
        In in = new In(largeUF);
        int N = in.readInt();
        WeigtedQuickUnion qwu = new WeigtedQuickUnion(N);
        while (!in.isEmpty()) {
            int p = in.readInt();
            int q = in.readInt();
            if (qwu.connected(p, q)) continue;
            qwu.union(p, q);
            StdOut.println(p + ", " + q);
        }
        StdOut.println(qwu.count() + " components.");
    }
    //测试unionFind
    public void unionFind() {
        In in = new In(tinyUF);
        int N = in.readInt();
        UnionFind uf = new UnionFind(N);
        while (!in.isEmpty()) {
            int p = in.readInt();
            int q = in.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + ", " + q);
        }
        StdOut.println(uf.count + " components.");
    }

    /**
     * 1.5.1
     * 分析quick-union算法
     * 答案：
     *              0  1  2  3  4  5  6  7  8  9
     *      初始化   0  1  2  3  4  5  6  7  8  9
     *      9-0     9  1  2  3  4  5  6  7  8  9
     *      3-4     9  1  2  3  3  5  6  7  8  9
     *      5-8     9  1  2  3  3  5  6  7  5  9
     *      7-2     9  1  7  3  3  5  6  7  5  9
     *      2-1     9  7  7  3  3  5  6  7  5  9
     *      5-7     9  5  5  3  3  5  6  5  5  9
     *      0-3     9  5  5  9  9  5  6  5  5  9
     *      4-2     9  9  9  9  9  9  6  9  9  9
     */
    /**
     * 1.5.2
     * 分析quick-union算法
     * 答案：
     *              0  1  2  3  4  5  6  7  8  9
     *      初始化   0  1  2  3  4  5  6  7  8  9
     *      9-0     9  1  2  3  4  5  6  7  8  9
     *      3-4     9  1  2  3  3  5  6  7  8  9
     *      5-8     9  1  2  3  3  5  6  7  5  9
     *      7-2     9  1  7  3  3  5  6  7  5  9
     *      2-1     9  7  7  3  3  5  6  7  5  9
     *      5-7     9  7  7  3  3  5  6  5  5  9
     *      0-3     9  5  5  9  3  5  6  5  5  9
     *      4-2     9  5  5  9  3  9  6  5  5  9
     */
    /**
     * 1.5.3
     * 分析加权quick-union-find
     * 略
     */
    /**
     * 1.5.4
     * 分析加权quick-union-find
     * 略
     */
    /**
     * 1.5.7
     * 详见QuickFind和QuickUnion类
     */
    /**
     * 1.5.8
     * 反例：
     *      0-1， 1-2之后0，1，2应该是一个连通分量的
     *      但find(1):0, find(2):1
     */
    /**
     * 1.5.9
     * 不可能：
     *      加权得到的树的最大高度是lgN
     */
    /**
     * 1.5.10
     * 有答案
     *
     */
    /**
     * 1.5.11
     * 答案：
     *      这也是路径压缩，减少元素到根元素的距离，提高find效率
     */


    /**
     * 第五节主方法
     * @param args
     */
    public static void main(String[] args) {
        AnswerList al = new AnswerList();
        //al.quickFind();
        //al.quickUnion();
        //al.weightedQuickUion();
        al.unionFind();
    }
}
