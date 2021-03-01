package com.zhang.chapter41;

/**
 * 得到图的直径、半径
 */
public class GraphProperties {
    // 离心率
    private int eccentricity[];
    // G的直径
    private int diameter;
    // G的半径
    private int radius;
    // G的某个中点
    private int center;

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

        diameter = calDiameter();
        radius = calRadius();
        center = calCenter();
    }

    //v的离心率
    public int eccentricity(int v) {
        if (v < 0 || v >= eccentricity.length) throw new IllegalArgumentException("Illegal index");
        return eccentricity[v];
    }

    // 计算G的直径
    private int calDiameter() {
        int diameter = 0;
        for (int i = 0; i < eccentricity.length; i++) {
            if (eccentricity[i] > diameter) {
                diameter = eccentricity[i];
            }
        }
        return diameter;
    }

    // 计算G的半径
    private int calRadius() {
        int radius = 0x7fffffff;
        for (int i = 0; i < eccentricity.length; i++) {
            if (eccentricity[i] < radius) {
                radius = eccentricity[i];
            }
        }
        return radius;
    }

    // 计算G的某个中点
    private int calCenter() {
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

    // G的直径
    public int diameter() {
        return diameter;
    }

    // G的半径
    public int radius() {
        return radius;
    }

    // G的某个中点
    public int center() {
        return center;
    }
}
