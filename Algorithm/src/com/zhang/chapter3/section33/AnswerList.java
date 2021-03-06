package com.zhang.chapter3.section33;

/**
 * 平衡查找树
 * 1.2-3查找树一般由以下结点组成
 *     2-结点：含有一个键和两个链接，左链接指向的键都小于该结点，右链接指向的结点都大于该结点
 *     3-结点：含有两个键和三条链接，左链接指向的键都小于该结点，右链接指向的键都大于该结点，
 *            中链接指向的键都位于该键的两个结点之间
 * 2.一棵完美平衡的2-3查找树的所有空链接到根节点的距离相同。
 * 3.向2-结点中插入新键
 * 4.向一棵只含有一个3-结点的树中插入新键
 * 5.向一个父结点为2-结点的3-结点中插入新键
 * 6.向一个父结点为3-结点的3-结点中插入新键
 * 7.分解根结点
 * 8.这些局部变换不会影响树的全局有序性和平衡性
 * 9.由一条红色左连接相连的两个2-结点表示一个3结点，就由2-3树变为红黑树
 * 10.红黑树--满足下列条件的二叉查找树：
 *      红链接均为左链接
 *      没有任何一个结点同时和两条红链接相连
 *      该树是完美黑色平衡的，即任意空链接到根结点的路径上的黑链接数量相同
 * 11.左旋转：自身结点上移，父结点成为其左子结点，父结点右结点为原自身结点的左子结点
 * 12.右旋转：自身结点上移，父结点成为其右子结点，父结点结点为原自身结点的右子结点
 * 13.向2-结点（该树只有一个结点）中插入新键：
 *      新键小于老键：新增一条红色左链接
 *      新键大于老键：新增一条红色右链接，左旋，修正根结点
 * 14.向一颗双键树中插入新键
 *      新键大于原树两个键：添加红色右链接，将两个红色链接的颜色变为黑色（树依然平衡，但高度加1）
 *      新键小于原树两个键：添加红色左链接，右旋原左链接，将两个红色链接的颜色变为黑色
 *      新键介于两键之间：添加红色右链接，左旋，右旋原左链接，将两个红色链接的颜色变为黑色
 * 15.插入或传递规则：
 *      如果右子结点是红色，而左子结点是黑色，进行左旋
 *      如果左子结点是红色，且左子子结点是红色，进行右旋
 *      如果左右子结点均为红色，进行颜色转换
 * 16.
 */

public class AnswerList {
    /**
     * 3.3.1
     * Solution:
     *      详见草稿
     */
    /**
     * 3.3.2
     * Solution:
     *      详见草稿
     */
    /**
     *3.3.3 高度为1的序列
     * Solution:
     *      除了顺序和逆序
     */
    /**
     * 3.3.4 证明含有N个键的2-3树的高度在~log3N到lgN之间
     * Solution:
     *      略
     */
    /**
     * 3.3.5 2-3树的所有可能性
     * Soltion:
     *      略
     */
    /**
     * 3.3.6 上题中树出现概率
     * Solution:
     *      略
     */
    /**
     * 3.3.7 详细描述4结点拆分
     * Solution:
     *      略
     */
    /**
     * 3.3.8 2结点和红链接表示4结点的可能性
     * Solution:
     *      红色左链接
     *      红色右链接
     */
    /**
     * 3.3.9 哪些是红黑树
     * Solution:
     *      iii iv
     *      i 不平衡
     *      ii 左边右大于根结点元素
     */
    /**
     * 3.3.10
     * Solution:
     *      详见草稿
     */
    /**
     * 3.3.11
     * Solution:
     *      详见草稿
     */
    /**
     * 3.3.12
     * 略
     */
    /**
     * 3.3.13
     * Solution:
     *      true
     */
    /**
     * 3.3.14
     * Solution:
     *      见草稿
     */
    /**
     * 3.3.15
     * Solution:
     *      true
     */
    /**
     * 3.3.16
     * Solution：
     *      详见草稿
     */
    /**
     * 3.3.17
     * 略
     */
    /**
     * 3.3.18
     * 略
     */
    /**
     * 3.3.19
     *Solution:
     *      1位
     */
    /**
     * 3.3.20
     * 略
     */
    /**
     * 3.3.21
     */
    /**
     * 3.3.22
     * Solution:
     *      不存在
     */
    /**
     * 3.3.23 没有平衡性限制的2-3树
     * Solution:
     *      就是没有向上回溯的过程
     *      最坏情况--顺序或逆序插入，高度为n/2
     *      最好情况--树平衡，高度为lg(n/2)
     */
    /**
     * 3.3.24 红黑树的最坏情况
     * Solution:
     *      ...
     */
    /**
     * 3.3.25 自顶向下的2-3-4树
     * Sotlution:
     *
     */
    /**
     * 3.3.29 最优存储
     */
    /**
     * 3.3.30 缓存
     */
    /**
     * 3.3.31 树的绘制
     * 略
     */
    /**
     * 3.3.32 AVL树
     *      AVL树：左子树插入左结点，右旋
     *            右子树插入右结点，左旋
     *            左子树插入右结点，子树左旋，整体再右旋
     *            右子树插入左结点，子树右旋，整体再左旋
     */
}