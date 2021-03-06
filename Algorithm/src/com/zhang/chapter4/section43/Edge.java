package com.zhang.chapter4.section43;

/**
 * 加权边
 */
public class Edge implements Comparable<Edge> {

    private final int v;//顶点
    private final int w;//顶点
    private final double weight;//权重

    //构造函数
    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    };
    //边的权重
    double weight() {
        return this.weight;
    };
    //边两端的顶点之一
    int either() {
        return v;
    };
    //另一个顶点
    int other(int v) {
        if (v == this.v) return w;
        else if (v == this.w) return v;
        else throw new RuntimeException("Inconsistent edge");
    }

    @Override
    public int compareTo(Edge that) {
        if (this.weight() < that.weight()) return -1;
        else if (this.weight() > that.weight()) return 1;
        else return 0;
    }
    //对象的字符串表示
    public String toString() {
        return String.format("%d-%d %.2f", v, w, weight);
    };
}
