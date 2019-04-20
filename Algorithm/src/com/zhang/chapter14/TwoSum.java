package com.zhang.chapter14;

import edu.princeton.cs.algs4.StdOut;

/**
 * 找出任意两个数和为0的个数
 */
public class TwoSum {
    public int count(int[] num) {
        int cnt = 0;
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if (isZero(num[i], num[j])) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
    //两个数求和
    public boolean isZero(int a, int b) {
        StdOut.println("a: " + a + "  b: " + b + "   a+b: " + (a + b));
        //if (a + b == 0) return true;
        //避免溢出1
        if ((long)a + b == 0) return true;
        //避免溢出2
        /*int a1 = a % 100;
        int a2 = b % 100;
        int temp = a1 + a2;
        if (temp == 0) {
            a = a / 100;
            b = b / 100;
            if (a + b + temp / 100 == 0) {
                return true;
            }
        }*/
        return false;
    }

    public static void main(String[] args) {
        double s = Math.pow(2, 31);
        StdOut.println(s + "");
        int maxInt = (int)Math.pow(2, 31);
        StdOut.println(maxInt);
        TwoSum sum = new TwoSum();
        boolean res = sum.isZero(maxInt, 1);
        StdOut.println(res);

        StdOut.println(101 % 100);
        StdOut.println(-101 % 100);
    }
}
