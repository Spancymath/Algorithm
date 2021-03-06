package com.zhang.chapter2.section24;

/**
 * 动态查找中位数（2j个元素的数组，中位数为第j个）
 * 1.创建两个最大、最小优先队列，中位数为v，最大队列都小于v，最小队列都大于v
 * 2.插入元素：大于v插入最小队列（上浮），小于v插入最大队列（上浮）。最大比最小队列元素数多1
 *   移v到最小队列，最大队列删除最大元素，并将其赋给v。最小比最大队列元素数多2，移v到最大队列
 *   最小队列删除最小元素，并将其赋给v。
 * 3.删除中间元素：v即为中间元素。两个队列元素个数相等，最大队列删除最大元素，并将其赋给v。
 *   最小比最大队列元素数多1,最小队列删除最小元素，并将其赋给v。
 */

public class MedianFinding<Key extends Comparable<Key>> {
    Key[] minK;//最小优先队列
    Key[] maxK;//最大优先队列
    int minN;
    int maxN;

    Key v;//中位数

    static int INIT_SIZE = 100;

    public MedianFinding() {
        minK = (Key[]) new Comparable[INIT_SIZE];
        maxK = (Key[]) new Comparable[INIT_SIZE];
        minN = 0;
        maxN = 0;
        v = null;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        if (v == null) return 0;
        return minN + maxN + 1;
    }

    //查询中位数
    public Key median() {
        if (isEmpty()) return null;
        return v;
    }
    //插入元素
    public void insert(Key key) {
        if (isEmpty()){
            v = key;
            return;
        }
        if (key.compareTo(v) < 0) {
            addMax(key);
        } else {
            addMin(key);
        }

    }
    //检测两边是否平衡
    private void checkBalance() {
        if (maxN > minN) {
            addMin(v);
            v = deleteMax();
        }else if (minN - maxN > 1) {
            addMax(v);
            v = deleteMin();
        }
    }
    //删除中位数
    public void deleteMedian() {
        if (isEmpty()) return;
        if (size() == 1) v = null;
        if (maxN == minN) {
            v = deleteMax();
        } else {
            v = deleteMin();
        }
    }
    //最大队列删除顶元素并返回
    private Key deleteMax() {
        if (maxN == 0) return null;
        Key maxT = maxK[1];
        maxK[1] = maxK[maxN--];
        int k = 1;
        while (k * 2 <= maxN) {
            int j = k * 2;
            if (j < maxN && maxK[j].compareTo(maxK[j + 1]) < 0) j++;
            if (maxK[k].compareTo(maxK[j]) >= 0) break;
            exchMax(k, j);
            k = j;
        }
        return maxT;
    }
    //最大队列添加元素
    private void addMax(Key key) {
        minK[++maxN] = key;
        int k = maxN;
        while (k > 1 && maxK[k].compareTo(maxK[k / 2]) > 0) {
            exchMax(k, k / 2);
            k = k / 2;
        }
    }
    //最小队列删除顶元素并返回
    private Key deleteMin() {
        if (minN == 0) return null;
        Key minT = minK[1];
        minK[1] = minK[maxN--];
        int k = 1;
        while (k * 2 <= minN) {
            int j = k * 2;
            if (j < minN && minK[j].compareTo(minK[j + 1]) > 0) j++;
            if (minK[k].compareTo(minK[j]) <= 0) break;
            exchMin(k, j);
            k = j;
        }
        return minT;
    }
    //最小队列添加元素
    private void addMin(Key key) {
        minK[++minN] = key;
        int k = minN;
        while (k > 1 && minK[k].compareTo(minK[k / 2]) < 0) {
            exchMin(k, k / 2);
            k = k / 2;
        }
    }

    private void exchMax(int i, int j) {
        Key key = maxK[i];
        maxK[i] = maxK[j];
        maxK[j] = key;
    }

    private void exchMin(int i, int j) {
        Key key = minK[i];
        minK[i] = minK[j];
        minK[j] = key;
    }
}
