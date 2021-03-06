package com.zhang.chapter2.section21;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * 比较排序算法效率
 */
public class SortCompare {
    //执行排序算法，并记录时间
    public double time(String alg, Double[] a) {
        Stopwatch time = new Stopwatch();
        if (alg.equals("Insertion")) new Insertion().sort(a);
        if (alg.equals("Selection")) new Selection().sort(a);
        if (alg.equals("Shell")) new Shell().sort(a);
        if (alg.equals("InsertionWithSentinel")) new InsertionWithSentinel().sort(a);
        if (alg.equals("InsertionWithoutExch")) new InsertionWithoutExch().sort(a);
        if (alg.equals("ShellStatic")) new ShellStatic().sort(a);
        return time.elapsedTime();
    }
    //生成数组并调用排序方法
    public double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
            //StdOut.println(new Insertion().isSorted(a));
        }
        return total;
    }

    //主方法
    public static void main(String[] args) {
        String alg1 = "Insertion";
        String alg2 = "Selection";
        String alg3 = "Shell";
        //String alg4 = "InsertionWithSentinel";
        //String alg5 = "InsertionWithoutExch";
        String alg6 = "ShellStatic";
        int N = 1000;
        int T = 10;
        SortCompare sc = new SortCompare();
        double t1 = sc.timeRandomInput(alg1, N, T);
        double t2 = sc.timeRandomInput(alg2, N, T);
        double t3 = sc.timeRandomInput(alg3, N, T);
        //double t4 = sc.timeRandomInput(alg4, N, T);
        //double t5 = sc.timeRandomInput(alg5, N, T);
        double t6 = sc.timeRandomInput(alg6, N, T);
        StdOut.println(alg1 + ": " + t1);
        StdOut.println(alg2 + ": " + t2);
        StdOut.println(alg3 + ": " + t3);
        //StdOut.println(alg4 + ": " + t4);
        //StdOut.println(alg5 + ": " + t5);
        StdOut.println(alg6 + ": " + t6);
        StdOut.println(alg2 + "/" + alg1 + ": " + t2/t1);
        StdOut.println(alg2 + "/" + alg3 + ": " + t2/t3);
        //StdOut.println(alg2 + "/" + alg4 + ": " + t2/t4);
        //StdOut.println(alg2 + "/" + alg5 + ": " + t2/t5);
        StdOut.println(alg2 + "/" + alg6 + ": " + t2/t6);
    }
}
