package com.zhang.chapter11;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1119 {

	public static void main(String[] args) {
//		for (int N = 0; N < 100; N++) {
//			StdOut.println(N + ": " + F(N));
//		}
		
		int N = 100;
		long[] a = new long[N];
		a[0] = 0;
		a[1] = 1;
		for (int i = 0; i < N; i++) {
			if (i > 1) {
				a[i] = a[i-1] + a[i-2];
			}
			StdOut.println(i + ": " + a[i]);
		}
	}

	public static long F(int N) {
		if (N == 0) return 0;
		if (N == 1) return 1;
		return F(N - 1) + F(N - 2);
	}
}
