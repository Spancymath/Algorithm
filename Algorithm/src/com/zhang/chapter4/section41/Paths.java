package com.zhang.chapter4.section41;

/**
 * 路径的api
 */
public abstract class Paths {

    Paths(){};

    Paths(Graph G, int s){};

    boolean hasPathTo(int v){return false;};

    Iterable<Integer> pathTo(int v){return null;};
}
