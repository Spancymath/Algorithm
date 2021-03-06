package com.zhang.chapter3.section35;

import com.zhang.chapter3.section31.ST;

public class SparseVector {
    private int d;//维数
    private ST<Integer, Double> st;

    public SparseVector(int d) {
        this.d = d;
        this.st = new ST<Integer, Double>();
    }

    public int size() {
        return d;
    }

    public void put(int i, double value) {
        if (i < 0 || i >= d) throw new IllegalArgumentException("Illegal index");
        if (value == 0.0) st.delete(i);
        else st.put(i, value);
    }

    public double get(int i) {
        if (i < 0 || i >= d) {
            throw new IllegalArgumentException("Illegal index");
        }
        if (st.contains(i)) return st.get(i);
        else return 0.0;
    }

    //普通向量点乘
    public double dot(double[] that) {
        double sum = 0.0;
        for (int i : st.keys()) {
            sum += that[i] * this.get(i);
        }
        return sum;
    }

    //稀疏向量点乘
    public double dot(SparseVector that) {
        if (this.d != that.d) {
            throw new IllegalArgumentException("Vector lengths disagree");
        }
        double sum = 0.0;
        if (this.st.size() <= that.st.size()) {
            for (int i : this.st.keys()) {
                if (that.st.contains(i)) sum += this.get(i) * that.get(i);
            }
        } else {
            for (int i : that.st.keys()) {
                if (this.st.contains(i)) sum += this.get(i) * that.get(i);
            }
        }
        return sum;
    }

    public SparseVector plus(SparseVector that) {
        if (this.d != that.d) {
            throw new IllegalArgumentException("Vector lengths disagree");
        }
        SparseVector c = new SparseVector(d);
        for (int i : this.st.keys()) c.put(i, this.get(i));
        for (int i : that.st.keys()) c.put(i, that.get(i) + c.get(i));
        return c;
    }
}
