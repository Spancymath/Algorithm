package com.zhang.chapter31;


import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * 实现一种无序的泛型符号表的API
 */
public class Chapter30102 {
    public  class Obj implements Comparable<Obj> {
        private int num;
        private char flag;

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public char getFlag() {
            return flag;
        }

        public void setFlag(char flag) {
            this.flag = flag;
        }

        @Override
        public int compareTo(Obj o) {
            if (this.num > o.num) {
                return  1;
            } else if (this.num == o.num){
                return 0;
            } else {
                return -1;
            }
        }
    }
    //符号表
    public class ST<Key extends Comparable<Key>, Value> {
        private static final int INT_SIZE = 8;

        private Object[] keys;
        private Object[] values;
        private int n = 0;
        //创建符号表
        public ST() {
//            keys = null;
//            values = null;
//            n = 0;
            keys = new Object[INT_SIZE];
            values = new Object[INT_SIZE];
        }
        //resize the parallel arrays to the given capacity
        private void resize(int capcity) {
            Object[] tempk = new Object[capcity];
            Object[] tempv = new Object[capcity];
            for (int i = 0; i < n; i++) {
                tempk[i] = (Key)keys[i];
                tempv[i] = (Key)values[i];
            }
            keys = tempk;
            values = tempv;
        }

        /**
         * 键值对存入表中
         * @param key
         * @param value
         */
        void put(Key key, Value value) {
//            if (value != null) {
//                keys[n] = key;
//                values[n] = value;
//                n++;
//            }
            //to deal with duplicates
            delete(key);
            //double size of arrays if necessary
            if (n >= values.length) resize(2*n);
            //add new key and value at the end of array
            values[n] = value;
            keys[n] = key;
            n++;
        }
        public Value get(Key key) {
            for (int i = 0; i < n; i++) {
                if (((Key)keys[i]).equals(key)) {
                    //自组织查找
                    Object k = keys[i];
                    Object v = values[i];
                    for (int j = i; j > 0; j--) {
                        keys[j] = keys[j - 1];
                        values[j] = values[j - 1];
                    }
                    keys[0] = k;
                    values[0] = v;

                    return (Value) v;
                }
            }
            return null;
        }
        //remove given key(and associated value)
        void delete(Key key) {
//            boolean flag = false;
//            for (int i = 1; i < n; i++) {
//                if (flag) {
//                    keys[i-1] = keys[i];
//                    values[i-1] = values[i];
//                    continue;
//                }
//                if (keys[i].equals(key)) {
//                    flag = true;
//                    n--;
//                }
//            }
            for (int i = 0; i < n; i++) {
                if (key.equals((Key) keys[i])) {
                    //StdOut.print("==");
                    keys[i] = keys[n-1];
                    values[i] = values[n-1];
                    keys[n-1] = null;
                    values[n-1] = null;
                    n--;
                    if (n > 2 && n == keys.length/4) {
                        //StdOut.println(n + "    " + keys.length);
                        resize(keys.length/2);
                    }
                    return;
                }
            }
            
        }
        //生成数组迭代器
        public Iterable<Key> keys() {
            Queue<Key> queue = new Queue<Key>();
            for (int i = 0; i < n; i++) {
                queue.enqueue((Key) keys[i]);
            }
            return queue;
        }
        boolean contains(Key key) {
            for (int i = 0; i < n; i++) {
                Key k = (Key) keys[i];
                if (k.equals(key)) return true;
            }
            return false;
            /*for (Key k :
                    (Key[]) keys) {
                if (k.equals(key)) return true;
            }
            return false;*/
        }
        boolean isEmpty() {
//            if (n == 0) {
//                return true;
//            } else {
//                return false;
//            }
            return size() == 0;
        }
        int size() {
            return n;
        }
        Key min() {
            Key minKey = (Key) keys[0];
            for (Key k :
                    (Key[]) keys) {
                if (k.compareTo(minKey) < 0)  {
                    minKey = k;
                }
            }
            return minKey;
        }
        Key max() {
            Key maxKey = (Key) keys[0];
            for (Key k :
                    (Key[]) keys) {
                if (k.compareTo(maxKey) > 0)  {
                    maxKey = k;
                }
            }
            return maxKey;
        }
        Key floor(Key key) {
            Key floor = key;
            boolean flag = false;
            for (Key k :
                    (Key[]) keys) {
                if (!flag && k.compareTo(key) < 0) {
                    floor = k;
                    flag = true;
                    continue;
                }
                if (flag && k.compareTo(floor) > 0 && k.compareTo(key) < 0) {
                    floor = k;
                }
            }
            return floor;
        }
        Key ceiling(Key key) {
            Key ceiling = key;
            boolean flag = false;
            for (Key k :
                    (Key[]) keys) {
                if (k.compareTo(key) > 0) {
                    if (!flag) {
                        ceiling = k;
                        flag = true;
                        continue;
                    }
                    if (flag && k.compareTo(ceiling) < 0) {
                        ceiling = k;
                    }
                }
            }
            return ceiling;
        }
        int rank(Key key) {
            int i = 0;
            for (Key k:
                    (Key[]) keys) {
                if (k.compareTo(key) < 0) {
                    i++;
                }
            }
            return i;
        }
        Key select(int k) {
            for (int i = 0; i < n - 2; i++) {
                int min = i;
                for (int j = i; j < n-1; j++) {
                    if (((Key)keys[j]).compareTo((Key)keys[j]) < 0) {
                        min = j;
                    }
                }
                Key temp = (Key) keys[min];//value同样
                keys[min] = keys[i];
                keys[i] = temp;
            }
            return (Key) keys[k];
        }
        void deleteMin() {
            delete(min());
        }
        void deleteMax() {
            delete(max());
        }
        int size(Key lo, Key hi) {
            int i = 0;
            for (Key k :
                    (Key[]) keys) {
                if (k.compareTo(lo) >= 0 && k.compareTo(hi) <= 0) {
                    i++;
                }
            }
            return i;
        }
    }
}
