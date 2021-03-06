package com.zhang.chapter4.section41;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import static com.zhang.constant.Constent.PROJECT_DIRECTORY;

/**
 * 无向图
 * 1.图是由一组顶点和一组能够将两个顶点相连的边组成的。
 * 2.自环：即一条连接一个顶点和其自身的边。
 * 3.平行边：连接同一对顶点的两条边。
 * 4.含有平行边的图称为多重图。
 * 5.没有含自环和平行边的图称为简单图。
 * 6.路径：由边顺序连接的一系列顶点。
 * 7.简单路径：一条没有重复顶点的路径。
 * 8.环：一条至少含有一条边且起点和终点相同的路径。
 * 9.简单环：一条除了起点和终点必须相同之外，不含有重复顶点和边的环。
 * 10.路径或者环的长度为其中所包含的边数。
 * 11.连通图：任意一个顶点都存在一条到达另一个顶点的路径。
 * 12.树是一幅无环连通图。互不相连的树组成的集合称为森林。
 * 13.当且仅当一幅含有V个结点的图G满足下列5个条件之一时，它是一棵树：
 *      a G有V-1条边且不含有环
 *      b G有V-1条边且是连通的
 *      c G是连通的，但删除任意一条边都会使它不再连通
 *      d G是无环图，但添加任意一条边都会产生一条环
 *      e G中任意一对顶点之间仅存在一条简单路径
 * 14.二分图：能够将所有结点分为两部分的图，每条边所连接的两个顶点都分别属于不同的部分。
 * 15.图的表示方式：
 *      邻接矩阵（v*v矩阵，两定点相连就有值）：顶点很多，空间需求太大
 *      边的数组（定义Edge类，含有两个int变量）：实现很慢
 *      邻接表数组（顶点为索引的数组，其中的每个元素都与该顶点相连）
 * 16.邻接表：Graph的实现。
 * 17.典型的用例程序会构造一幅图，将图传递给实现了某个算法的类。
 * 18.（DFS）深度优先搜索标记与起点连通的所有顶点所需的时间和顶点的度数之和成正比。
 * 19.单点路径：给定一幅图和一个起点s，找出给定目的顶点v到s是否存在路径，给出路径。
 * 20.(BFS)广度优先搜索
 * 21.基于深度优先搜索来解决图连通性问题的方法更适合实现图的抽象数据类型，在需要大量的
 *    查询和插入操作混合时，更倾向union-find算法
 * 22.符号图：
 *      顶点名为字符串
 *      用指定的分隔符来隔开顶点名（允许顶点名中含有空格）
 *      每一行都表示一组边的集合，每一条边都连接着这一行的第一个名称表示的顶点和其他名称所表示的顶点
 *      顶点总数V和边的总数E都是隐式定义的
 * 23.间隔的度数：广度优先搜索得到的最短路径长度即为所要的结果
 */
public class AnswerList {
    /**
     * 4.1.1
     * Solution:
     *      一幅含有V个顶点且不含平行边的图中至多含有(V*(V-1))/2条边
     *      一幅含有V个顶点的连通图至少含有V-1条边
     */
    /**
     * 4.1.2
     * Solution:
     *      picture/chapter4/4.1.02.jpg
     */
    /**
     * 4.1.3 4.1.4 4.1.5
     * Solution:
     *      详见Graph.java: Graph(Graph G)  hasEdge(int v, int w)  addEdge(int v, int w)
     */
    /**
     * 4.1.6 不可能构造出来的图
     * Solution:
     *      构造成对的，并穿插顺序，就是不可能出现的顺序，比如
     *      0:1 3
     *      1:2 0
     *      2:3 1
     *      3:0 2
     *      插入0-1，1-0中间有2，那就先插1-2，2-1中间有3，那就先插2-3，3-2中间有0，那就先插3-0
     *      0-3中间有1，那就先插0-1...
     */
    /**
     * 4.1.7 图的测试
     * Solution:
     *
     */
    @Test
    public void test07() {
        In in = new In(PROJECT_DIRECTORY + "file\\graph.txt");
        Graph graph = new Graph(in);
        StdOut.println(graph.toString());
    }
    /**
     * 4.1.8 使用union-find 实现search
     * Solution:
     *      UnionFindSearch
     */
    /**
     * 4.1.9 dfs轨迹
     * Solution:
     *      因为不连通部分遍历不到，所以不考虑那一部分
     *      轨迹：picture/chapter4/4.1.09.jpg
     *      edgeTo[]表示的树：picture/chapter4/4.1.09-1.jpg
     */
    @Test
    public void drawGraph419() {
        In in = new In(PROJECT_DIRECTORY + "file\\tinyGex2.txt");
        Graph graph = new Graph(in);
        StdOut.println(graph.toString());
    }
    /**
     * 4.1.10 删除不影响连通性的顶点
     * Solution:
     *      证明：首先，任意一幅连通图中的顶点都可以通过dfs遍历，从而也必然存在这样一个顶点，在遍历到它之前，
     *          所有与它相连的顶点都已经被遍历，比如最后一个遍历到的顶点肯定是这样。从而删掉这个顶点和相连的边，
     *          其他顶点间至少存在一条edgeTo[]的路径，所以图还是连通的。
     *      程序：如下，找到相邻顶点全被标记的顶点，返回
     */
    @Test
    public void test10() {
        Graph G = new Graph(new In());
        boolean[] marked = new boolean[G.V()];
        int vertex = dfs(G, 0, marked);
        StdOut.println("删除不影响连通性的顶点是：" + vertex);
    }

    public int dfs(Graph G, int v, boolean[] marked) {
        boolean flag = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                flag = false;
                break;
            }
        }
        if (flag) return v;
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                return  dfs(G, w, marked);
            }
        }
        return -1;
    }
    /**
     * 4.1.11 广度优先能否求多源最短路径
     * Solution:
     *      picture/chapter4/4.1.11.jpg
     */

    /**
     * 4.1.12 广度优先能否求多源最短路径
     * Solution:
     *      可以。分别得到v和w到根节点的路径，删除重叠部分即可
     */

    /**
     * 4.1.13 最短路径长度
     * Solution:
     *      见实现
     */
    /**
     * 4.1.14 广度优先换队列为栈可以不
     * Solution:
     *      No。换成栈之后就成了深度优先搜索。
     */
    /**
     * 4.1.15 构造函数输入邻接表
     * Solution:
     *      见实现
     */
    /**
     * 4.1.16 图的离心率/直径/半径
     * Solution:
     *      见GraphProperties
     */
    /**
     * 4.1.17 图的周长
     * Solution:
     *      用Cycle判断，是无环图则返回无穷大
     *      遍历每一个顶点，进行广度优先搜索；对每一个可达的顶点（排除与起点相邻顶点），最小环的长度为起点到此点的最短路径
     *      加上起点到此点相邻顶点（排除到此顶点最短路径的上一个顶点）的最短路径长度加1
     */
    /**
     * 4.1.18 CC 寻找连通分量的轨迹
     * Solution:
     *      picture/chapter4/4.1.18.jpg
     */
    /**
     * 4.1.28 Cycle允许自环和平行边
     * Solution:
     *      自环：邻接表中有和自身相等的结点
     *      平行边：邻接表中有重复的顶点
     *      这两种都是有环的标志
     */
    /**
     * 4.1.31 检测平行边
     * Solution:
     *      统计每一个顶点的邻接表的重复顶点的个数（用set），即重复边的个数
     *      求和，除2
     */
    /**
     * 4.1.35 边的连通性
     * Solution:
     *      顶点不在一个环中
     *      该顶点的邻接顶点除了路径的前一个顶点，还有且仅有一个其他顶点与它相邻
     */
}
