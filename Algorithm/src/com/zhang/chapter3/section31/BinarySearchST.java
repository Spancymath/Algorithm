package com.zhang.chapter3.section31;

import edu.princeton.cs.algs4.Queue;

/**
 *
 * @param <Key>
 * @param <Value>
 */
public class BinarySearchST<Key extends Comparable<Key>, Value extends Comparable<Value>> {
    //存放键和值的类
    private class Item {
        //键
        private Key key;
        //值
        private Value val;
        //访问次数
        private int access;
    }
    //数组初始大小
    private int INIT_SIZE = 8;
    //字典实际大小
    private int N;
    //字典数组
    private Object[] st;
    //构造函数
    public BinarySearchST() {
        st = new Object[INIT_SIZE];
        N = 0;
    }

    //访问最频繁的键
    private Object mostAccess = null;
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
        if (key == null) return null;
        if (isEmpty()) return null;
        if (mostAccess != null && key.compareTo(((Item)mostAccess).key) == 0) {
            ((Item)mostAccess).access++;
            return (Value) ((Item)mostAccess).val;
        }
        int i = rank(key);
        if (i < N && key.compareTo(((Item)st[i]).key) == 0) {
            ((Item) st[i]).access++;
            if (mostAccess == null) {
                mostAccess = new Object();
                mostAccess = (Item) st[i];
            }else if (((Item) st[i]).access > ((Item)mostAccess).access) {
                mostAccess = st[i];
            }
            return ((Item) st[i]).val;
        }else return null;
    }
    //向字典中添加元素
    public void put(Key key, Value val) {
        //查找键是否存在于字典中
        int i = rank(key);
        //存在
        if (i < N && key.compareTo(((Item)st[i]).key) == 0) {
            ((Item)st[i]).val = val;
            assert(i != rank(select(i))) : "数据已不完整";
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
        item.access = 0;
        st[i] = item;
        N++;
        assert(i != rank(select(i))) : "数据已不完整";
    }
    //删除字典中元素
    public void delete(Key key) {
        int i = rank(key);
        if (i < N && key.compareTo(((Item)st[i]).key) == 0) {
            for (int j = i; j < N - 1; j++) {
                st[j] = st[j + 1];
            }
            st[N - 1] = null;
            N--;
            if (N > 2 && N == st.length / 4) resize(st.length / 2);
        }
        assert(i != rank(select(i))) : "数据已不完整";
    }

    //排名为k的键
    public Key select(int k) {
        if (k < N) return ((Item)st[k]).key;
        return null;
    }
    //小于等于key的最大键
    public Key floor(Key key) {
        int i = rank(key);
        if (i == 0 && ((Item)st[i]).key.compareTo(key) > 0) return null;
        if (i == N) return ((Item)st[N - 1]).key;
        if (((Item)st[i]).key.compareTo(key) == 0) return ((Item)st[i]).key;
        else return ((Item)st[i - 1]).key;

    }

    //大于等于key的最小键
    public Key ceiling(Key key) {
        int i = rank(key);
        if (i < N - 1 && ((Item)st[i]).key.compareTo(key) <= 0) return key;
        if (i == N - 1 && ((Item)st[i]).key.compareTo(key) == 0) return key;
        return null;
    }

    //得到最大值的键
    public Key maxKey() {
        return ((Item)st[N - 1]).key;
    }

    //得到最小的键
    public Key minKey() {
        return ((Item)st[0]).key;
    }

    //得到最大的键值
    public Value maxVal() {
        return ((Item)st[N - 1]).val;
    }

    //删除最小键
    public void deleteMin() {
        delete(minKey());
    }

    //删除最大键
    public void deleteMax() {
        delete(maxKey());
    }
    //生成迭代器
    public Queue keys() {
        Queue<Key> queue = new Queue<>();
        for (int i = 0; i < N; i++) {
            queue.enqueue(((Item)st[i]).key);
        }
        return queue;
    }

    //12题的要求
    public void reorderst(Object[] items) {
        Object[] temp = new Object[N];
        for (int i = 1; i < N; i = i * 2) {
            for (int j = 0; j + i < N; j = j + i * 2) {
                for (int k = j; k < j + i; k++) {
                    temp[k] = st[k];
                }
                int jj = j, ja = j, jb = j + i;
                while (jj < j + i * 2 && jj < N) {
                    if (ja == j + i) {
                        st[jj++] = st[jb++];
                        continue;
                    }
                    if (jb == j + i * 2 || jb == N) {
                        st[jj++] = temp[ja++];
                        continue;
                    }
                    int cmp = ((Item)st[jb]).val.compareTo(((Item)temp[ja]).val);
                    if (cmp <= 0) {
                        st[jj++] = st[jb++];
                    } else {
                        st[jj++] = temp[ja++];
                    }

                }
            }
        }
    }

    //返回第i个键
    public Key getIkey(int i) {
        return (Key) ((Item)st[i]).key;
    }

    //返回第i个键值
    public Value getIvalue(int i) {
        return (Value) ((Item)st[i]).val;
    }

    //返回Item[]
    public Object[] getItems() {
        return st;
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
        //使得插入键值大于最大键值时，需要常数级别时间
        if (N != 0 && ((Item)st[N - 1]).key.compareTo(key) < 0) return N;
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(((Item)st[mid]).key);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }
}
