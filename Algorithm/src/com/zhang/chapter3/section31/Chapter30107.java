package com.zhang.chapter3.section31;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Objects;

public class Chapter30107 {
    //1000次随机非负整数，有多少次命中不同数字
    /**三分之一的操作将表增大，则1000次操作将有333次增加了表故增加的是333
     * 10：命中全部需要10*3 = 30；故全部命中
     * 100：100*3 = 300；全部命中
     * 1000：1000 * 3 = 3000；1000 * （1000 / 3000） = 333；
     * 10000：
     *
     * 实验结果：
     * 10命中次数：10
     * 100命中次数：100
     * 1000命中次数：629
     * 10000命中次数：950
     * 100000命中次数：996
     * 1000000命中次数：999
     */

//    public class PutN {
        private int[] ints = new int[1000000];
        public void put(int n) {
            ints[n] = 1;
        }
        public int get(int n) {
            return ints[n];
        }
        public int identifyInt(int N) {
            int num = 0;
            for (int i = 0; i < N; i++) {
                if (ints[i] == 1) num++;
            }
            return num;
        }
//

    public static void main(String args[]) {
        int repeatN = 10;
        int[] total = {10, 100, 1000, 10000, 100000, 1000000};
        int[] results = new int[6];
        /**for (int i = 0; i < 6; i++) {
            int sum = 0;
            for (int k = 0; k < repeatN; k++) {
                Chapter30107 putN = new Chapter30107();
                for (int j = 0; j < 1000; j++) {
                    int randInt = StdRandom.uniform(total[i]);
                    putN.put(randInt);
                }
                sum += putN.identifyInt(total[i]);
            }
            results[i] = sum/repeatN;
            StdOut.println(total[i] + "命中次数：" + results[i]);
        }*/
        Chapter30102 chapter30102 = new Chapter30102();
        for (int i = 0; i < 6; i++) {
            int sum = 0;
            for (int k = 0; k < repeatN; k++) {
                Chapter30102.ST<Integer, Integer> st = chapter30102.new ST<>();
                for (int j = 0; j < 1000; j++) {
                    int randInt = StdRandom.uniform(total[i]);
                    st.put(new Integer(randInt), new Integer(1));
                }
                sum += st.size();
            }
            results[i] = sum/repeatN;
            StdOut.println(total[i] + "命中次数：" + results[i]);
        }
    }

    public static class Integer implements Comparable<Integer>{
        private int a = 0;

        public int getA() {
            return this.a;
        }

        @Override
        public int compareTo(Integer o) {
            if (this.a > o.a)return 1;
            if (this.a == o.a) return 0;
            if (this.a < o.a) return -1;
            return 0;
        }
        public Integer(int a) {
            this.a = a;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Integer integer = (Integer) o;
            return a == integer.a;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a);
        }

        public boolean equals(Integer o) {
            return this.a == o.a;
        }
    }
}
