package com.zhang.chapter31;

import edu.princeton.cs.algs4.Queue;

/**
 *
 * @param <Key>
 * @param <Value>
 */
public class InterpolationSearchST<Key extends Comparable<Key>, Value> {
    //存放键和值的类
    private class Item {
        //键
        private Key key;
        //值
        private Value val;
    }
    //数组初始大小
    private int INIT_SIZE = 8;
    //字典实际大小
    private int N;
    //字典数组
    private Object[] st;
    //构造函数
    public InterpolationSearchST() {
        st = new Object[INIT_SIZE];
        N = 0;
    }
    //返回字典大小
    public int size() {
        return N;
    }
    //判断字典非空
    public boolean isEmpty() {
        return N == 0;
    }
    //是否包含给定的键
    public boolean contains(Key key) {
        return get(key) == null ? false : true;
    }
    //得到键值
    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && key.compareTo(((Item)st[i]).key) == 0)
            return ((Item)st[i]).val;
        else return null;
    }
    //向字典中添加元素
    public void put(Key key, Value val) {
        //查找键是否存在于字典中
        int i = rank(key);
        //存在
        if (i < N && key.compareTo(((Item)st[i]).key) == 0) {
            ((Item)st[i]).val = val;
            return;
        }
        //字典实际长度大于等于数组长度，扩大数组
        if (st.length <= N) resize(N * 2);
        //没有存在
        for (int j = N; j > i; j--) {
            st[j] = st[j - 1];
        }
        Item item = new Item();
        item.key = key;
        item.val = val;
        st[i] = item;
        N++;
    }
    //删除字典中元素
    public void delete(Key key) {
        int i = rank(key);
        if (i < N && key.compareTo(((Item)st[i]).key) == 0) {
            for (int j = i; j < N - 1; j++) {
                st[j] = st[j + 1];
            }
            st[N - 1] = null;
            if (N > 2 && N == st.length / 4) resize(st.length / 2);
        }
    }
    //小于等于key的最大键
    public Key floor(Key key) {
        int i = rank(key);
        if (i == 0 && ((Item)st[i]).key.compareTo(key) > 0) return null;
        if (i == N) return ((Item)st[N - 1]).key;
        if (((Item)st[i]).key.compareTo(key) == 0) return ((Item)st[i]).key;
        else return ((Item)st[i - 1]).key;

    }

    //得到最大值的键
    public Key maxKey() {
        return ((Item)st[N - 1]).key;
    }

    //得到最大的键值
    public Value maxVal() {
        return ((Item)st[N - 1]).val;
    }

    //12题的要求
    public InterpolationSearchST(Item[] items) {
        Object[] temp = new Object[items.length];
        for (int i = 1; i <= items.length / 2; i = i * 2) {
            for (int j = 0; j < items.length; j = j + i * 2) {
                for (int k = j; k < j + i; j++) {
                    temp[k] = items[k];
                }
                int jj = j, ja = j, jb = j + i;
                while (jj < j + i * 2) {
                    if (ja == j + i) {
                        st[jj++] = st[jb++];
                        continue;
                    }
                    if (jb == j + i * 2) {
                        st[jj++] = temp[ja++];
                        continue;
                    }
                    int cmp = ((Item)st[jb]).key.compareTo(((Item)temp[ja]).key);
                    if (cmp <= 0) {
                        st[jj++] = st[jb++];
                    } else {
                        st[jj++] = temp[ja++];
                    }

                }
            }
        }
    }





    //改变数组长度
    public void resize(int capcity) {
        Object[] objects = new Object[capcity];
        for (int i = 0; i < N; i++) {
            objects[i] = (Item) st[i];
        }
        st = objects;
    }
    //二分法查找
    public int rank(Key key) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int interpolator = minus(key, ((Item)st[lo]).key) / minus(((Item)st[hi]).key, ((Item)st[lo]).key);
            int mid = lo + (hi - lo) * interpolator;
            int cmp = key.compareTo(((Item)st[mid]).key);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    private int minus(Key k1, Key k2) {
        int DOUBLE_FACTOR = 10000;
        if (k1 instanceof Integer) {
            return (Integer) k1 - (Integer) k2;
        }
        if (k1 instanceof Double) {
            return Math.getExponent(DOUBLE_FACTOR * ((Double) k1 - (Double) k2));
        }
        if (k1 instanceof String) {
            int minLength = Math.min(((String) k1).length(), ((String) k2).length());
            int i = 0;
            for (; i < minLength; i++) {
                if (((String)k2).indexOf(i) != ((String)k1).indexOf(i)) {
                    return ((String)k1).indexOf(i) - ((String)k1).indexOf(i);
                }
            }
            return 1;
        }
        return 1;
    }
}

