package com.zhang.chapter32;

import edu.princeton.cs.algs4.StdOut;

/**
 * 二叉查找树（BST）：
 * 1.我们使用的数据结构由结点组成：每个结点只能指向一个父结点和两个子结点，每个结点还包含了一个键和一个值
 * 2.二叉查找树的每个结点的键，都大于左子树的结点的键，都小于右子树的任意结点的键
 * 3.size(x) = size(x.left) + size(x.right) + 1
 * 4.get(): 从根节点往下查找，小于根节点查找左子树，大于根节点查找右子树，相等则返回根节点
 * 5.put(): 从根节点往下查找，小于根节点查找左子树，大于根节点查找右子树，相等则更新值，为空则返回一个新的结点。更新结点的元素个数
 * 6.min(): 从根节点往下查找左子树，直到左子树为空，返回当前结点
 * 7.max(): 从根节点往下查找右子树，知道右子树为空，返回当前结点
 * 8.floor(): 从根节点往下查找，相等则返回，大于要查找的则查找左子树；小于要查找的，则在右子树查找，查找到空，返回当前结点，否则返回查找到的
 * 9.select(): 从根结点往下查找，左子树数量等于k, 返回结点；左子树数量大于k, 搜索左子树；左子树数量小于k, 搜索右子树
 * 10.rank(): 从根节点往下查找，相等返回左子树数量；小于当前结点，搜索左子树；大于当前结点，1+左子树+搜索右子树得到的值
 * 11.deleteMin(): 删除左子树为空的结点--父结点的左子树为空，父结点的左子树指向当前节点的右子树，更新结点的大小
 * 12.deleteMax(): 删除右子树为空的结点--父结点的右子树为空，父结点的右子树指向当前结点的左子树，更新结点大小
 * 13.delete(): 从根节点往下查找
 *              相等，右子树为空返回左子树，左子树为空返回右子树，都不为空，查找右子树最小结点赋给当前结点，并把右结点指向删
 *                  除了右子树最小结点的子树，左子树指向当前结点的左子树
 *              小于，搜索左子树
 *              大于，搜索右子树
 * 14.keys(): 维护一个队列，从根结点查找，大于要查找的下界键，查找左子树；大于要查找的下界键且小于要查找的上界键，入队列；小于要查找的上界键，查找右子树
 */
public class AnswerList {
    /**
     * 3.2.1二叉树构造
     * Solution:(有误，不想改了)
     *      0 E
     *      1   E
     *        A
     *      1    E
     *         A   S
     *      2   E
     *        A   S
     *              Y
     *      2   E
     *        A   S
     *          Q   Y
     *      3   E
     *        A   S
     *          Q   Y
     *             U
     *      2     E
     *         A     S
     *           E  Q  Y
     *                U
     *      3      E
     *         A        S
     *           E    Q    Y
     *               S    U
     *      4       E
     *         A        S
     *           E   Q     Y
     *              S    U
     *                  T
     *      4       E
     *         A        S
     *           E    Q    Y
     *               S    U
     *              I
     *      3       E
     *         A         S
     *           E     Q    Y
     *               S   O U
     *              I     T
     *      4       E
     *         A         S
     *           E    Q     Y
     *               S  O  U
     *              I     T
     *                N
     *      比较总次数：1+1+2+2+3+2+3+4+4+3+4=29
     */
    /**
     * 3.2.2 最坏二叉树排列
     * Solution:
     *      A C E H R S X
     *      X S R H E C A
     *      A X C E H R S
     *      X A S R H E C
     *      A X C S E H R
     */
    /**
     * 3.2.3 最优二叉树排列
     * Solution:
     *      H C S A E R X
     */
    /**
     * 3.2.4 错误的检查序列
     * Solution:
     *      b 找到5就停了，不应该有3
     *      d 7后边找的应该都是比7小的，8大于7，所以不对
     */
    /**
     * 3.2.5
     * Solution:
     *      按照查找频率的顺序
     */
    /**
     * 3.2.6
     * Solution:
     *      详见BST中height
     *      另一种略
     */
    public void test06() {
        BST<Integer, Integer> bst = new BST<>();
        int[] ints = {3, 4, 5, 1};
        for (int i = 0; i < ints.length; i++) {
            bst.put(ints[i], ints[i]);
        }
        StdOut.println(bst.height());
    }
    /**
     * 3.2.7 平均比较次数
     *      详见BST中avgCompares
     */
    /**
     * 3.2.8 最优二叉查找树平均比较次数
     * Solution:
     *      详见BST中optCompares
     */
    public void test08() {
        int N = 3;
        int optCompares = BST.optCompares(N);
        StdOut.println(optCompares);
    }
    /**
     * 3.2.9 二叉树可能性
     * Solution:
     *      2
     *          A           A
     *              B    B
     *      3
     *          A           A       A          A     A
     *        B   C       B           C      B          C
     *                  C               B      C      B
     *      4
     *             A           A       A                A         A    A
     *           B   C       B           C            B   C     B        C
     *         D           C               B                D C  D      B  D   ...
     *                  D                   D
     *
     *      5
     *                  A       A          A            A              A            A            A           A
     *                B       B   C      B   C        B    C         B            B            B           B
     *              C       D   E      D   E             D   E     C   D        C   D        C   D       C   D
     *            D                                              E                E            E               E
     *          E
     *            A            A            A           A                           A     A          A
     *              B            B            B           B                       B         B          B
     *            C   D        C   D        C   D       C   D                   C             C          C
     *          E                E            E               E               D                 D          D
     *                                                                          E              E             E  ...
     *      6 ...
     */
    /**
     * 3.2.10 测试BST中的方法
     * Solution:
     */
    public void test10() {
        BST<Integer, Integer> bst = new BST<>();
        int[] ints = {3, 4, 5, 1};
        for (int i = 0; i < ints.length; i++) {
            bst.put(ints[i], ints[i]);
        }
        StdOut.println("最小值：" + bst.min());
        StdOut.println("最大值：" + bst.max());
        StdOut.println("floor(0): " + bst.floor(0));
        StdOut.println("ceiling(2): " + bst.ceiling(2));
        StdOut.println("排名为2的键：" + bst.select(2));
        StdOut.println("键4的排名：" + bst.rank(4));
    }

    /**
     * 3.2.11
     * Solution:
     *      2^(N - 1)
     *      2^(N - 1)
     */
    /**
     * 3.2.12 实现二叉查找树不在Node中用计数器
     * Solution:
     *      //单独实现size()方法
     */
    /**
     * 3.2.13   3.2.14
     * Solution:
     */
    public void test14() {
        NonrecursiveBST<Integer, Integer> bst = new NonrecursiveBST<>();
        int[] ints = {3, 4, 5, 1};
        for (int i = 0; i < ints.length; i++) {
            bst.put(ints[i], ints[i]);
        }
        StdOut.println("最小值：" + bst.min());
        StdOut.println("最大值：" + bst.max());
        StdOut.println("floor(2): " + bst.floor(2));
        //StdOut.println("ceiling(2): " + bst.ceiling(2));
        StdOut.println("排名为2的键：" + bst.select(2));
        StdOut.println("键4的排名：" + bst.rank(4));
    }
    /**
     * 3.2.15 比较顺序
     * Solution:
     *      a. E D A Q
     *      b. E Q
     *      c. E Q
     *      d. E Q J
     *      e. E D
     *      f. E D A Q J M T S
     */
    /**
     * 3.2.16
     * 略
     */
    /**
     * 3.2.1构造的二叉树
     *              E
     *         A         S
     *           E    Q     Y
     *               S  O  U
     *              I     T
     *                N
     *       插入顺序：E A S Y Q U E S T I O N
     */
    /**
     * 3.2.17 按照插入顺序删除
     *      E:   I              A:      I             S:     I            Y:      I
     *        A      S              E         S            E       T            E      T
     *         E   Q    Y                  Q     Y              Q     Y              Q   U
     *            S  O U                 S   O  U             S   O  U             S   O
     *           N    T                N       T             N                    N
     *      Q:   I           U:      I         E:   I      S:  I    T:  I    I: O  O: N   N:
     *         E    T             E      T            T          T        O    N
     *            O   U                O             O          O        N
     *          S                     S             S          N
     *         N                     N             N
     */
    /**
     * 3.2.18 按照字母顺序删除
     *      A:     I         E:     I
     *          E      S         E      S
     *               Q    Y           Q    Y
     *              S  O U           S  O U
     *             N    T           N    T
     *      A:       E           E:       I          E:       I            I:     S      N:        S    S:      T     S:      T
     *          E         S          E         S                   S           Q    Y           Q    Y       Q    Y        Q    Y
     *                 Q     Y              Q     Y             Q     Y      S   O U          S   O U      S   O U           O U
     *                S  O  U              S  O  U             S  O  U      N     T                T
     *               I     T              N     T             N     T
     *                 N
     *
     */
    /**
     * 3.2.19
     * 略
     */
    /**
     * 3.2.20
     * 略
     */
    /**
     * 3.2.21 随机返回数组中一个键
     * Solution:
     *      详见BST中randomKey
     */
    public void test21() {
        BST<Integer, Integer> bst = new BST<>();
        int[] ints = {3, 4, 5, 1};
        for (int i = 0; i < ints.length; i++) {
            bst.put(ints[i], ints[i]);
        }
        StdOut.println("随机输出一个键：" + bst.randomKey());
    }
    /**
     * 3.2.23 delete方法符合交换律吗
     * Solution:
     *      符合
     */
    /**
     * 3.2.25 完美平衡
     * Solution:
     *      将数组排序，通过二分法，每次查找中间数据，插入二叉树
     */
    /**
     * 3.2.26 准确的概率
     * Solution:
     *      50 50
     *
     *
     */
    /**
     * 3.2.28 缓存
     * Solution:
     *      详见BST的lastNode
     */
    /**
     * 3.2.29 二叉树检查
     * Solution:
     *      详见BST
     */
    /**
     * 3.2.30 有序性检查
     * Solution:
     *      详见BST
     */
    /**
     * 3.2.31 等值键检查
     * Solution:
     *      详见BST
     */
    /**
     * 3.2.31 验证
     * Solution:
     *      详见BST
     */
    /**
     * 3.2.33 选择排名检查
     * Solution:
     *
     */
    /**
     * 3.2.34 验证
     * Solution:
     *      详见BST
     */
    /**
     * 3.2.26 迭代器
     * Solution:
     *      详见keys1
     */
    /**
     * 3.2.27 按层遍历
     * Solution:
     *      详见keys2
     */
    /**
     * 主方法
     * @param args
     */
    public static void main(String[] args) {
        AnswerList al = new AnswerList();
        //al.test06();
        //al.test08();
        //al.test10();
        //al.test14();
        al.test21();
    }

}
