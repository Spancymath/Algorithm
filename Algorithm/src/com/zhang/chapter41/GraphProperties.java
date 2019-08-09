package com.zhang.chapter41;

/**
 * 得到图的直径、半径
 */
public class GraphProperties {
    //离心率
    private int eccentricity[];
    public GraphProperties(Graph G) {
        eccentricity = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            int max = 0;
            BreadthFirstPaths bfp = new BreadthFirstPaths(G, i);
            for (int j = 0; j < G.V(); j++) {
                if (bfp.distTo(j) > max) {
                    max = bfp.distTo(j);
                }
            }
            eccentricity[i] = max;
        }
    }

    //v的离心率
    public int eccentricity(int v) {
        if (v < 0 || v >= eccentricity.length) throw new IllegalArgumentException("Illegal index");
        return eccentricity[v];
    }

    //G的直径
    public int diameter() {
        int diameter = 0;
        for (int i = 0; i < eccentricity.length; i++) {
            if (eccentricity[i] > diameter) {
                diameter = eccentricity[i];
            }
        }
        return diameter;
    }

    //G的半径
    public int radius() {
        int radius = 0x7fffffff;
        for (int i = 0; i < eccentricity.length; i++) {
            if (eccentricity[i] < radius) {
                radius = eccentricity[i];
            }
        }
        return radius;
    }

    //G的某个中点
    public int center() {
        int radius = 0x7fffffff;
        int vertex = -1;
        for (int i = 0; i < eccentricity.length; i++) {
            if (eccentricity[i] < radius) {
                radius = eccentricity[i];
                vertex = i;
            }
        }
        return vertex;
    }
}
