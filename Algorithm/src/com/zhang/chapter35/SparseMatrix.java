package com.zhang.chapter35;

/**
 * 稀疏矩阵
 */
public class SparseMatrix {
    private int n;
    private SparseVector[] rows;

    public SparseMatrix(int n) {
        this.n = n;
        rows = new SparseVector[n];
        for (int i = 0; i < n; i++) {
            rows[i] = new SparseVector(n);
        }
    }

    public void put(int i, int j, double value) {
        if (i < 0 || i >= n) throw new IllegalArgumentException("Illegal index");
        if (j < 0 || j >= n) throw new IllegalArgumentException("Illegal index");
        rows[i].put(j, value);
    }

    public double get(int i, int j) {
        if (i < 0 || i >=n) throw new IllegalArgumentException("Illegal index");
        if (j < 0 || j >= n) throw new IllegalArgumentException("Illegal index");
        return rows[i].get(j);
    }

    public SparseVector times(SparseVector x) {
        if (n != x.size()) throw new IllegalArgumentException("Dimensions disagree");
        SparseVector b = new SparseVector(n);
        for (int i = 0; i < n; i++) {
            b.put(i, rows[i].dot(x));
        }
        return b;
    }

    public SparseMatrix plus(SparseMatrix that) {
        if (this.n != that.n) throw new RuntimeException("Dimensions disagree");
        SparseMatrix result = new SparseMatrix(n);
        for (int i = 0; i < n; i++) {
            result.rows[i] = this.rows[i].plus(that.rows[i]);
        }
        return result;
    }


}
