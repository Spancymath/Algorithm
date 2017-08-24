package com.zhang.chapter11;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1124 {

	public static void main(String[] args) {
		int a, b;
		while (true) {
			a = StdIn.readInt();
			b = StdIn.readInt();
			if (a < b) {
				int temp = a;
				a = b;
				b = temp;
			}
			System.out.println(a + "和" + b + "的最大公约数是：" + euclid(a, b));
		}
	}
	
	public static int euclid(int a, int b) {
		StdOut.println("a:" + a + ";b:" + b);
		if (a % b == 0) return b;
		else
			return euclid(b, a % b);
	}

}
