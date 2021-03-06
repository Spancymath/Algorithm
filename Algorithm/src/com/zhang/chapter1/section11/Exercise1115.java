package com.zhang.chapter1.section11;

import edu.princeton.cs.algs4.StdIn;

public class Exercise1115 {

	public static void main(String[] args) {
		int M = 1000;
		while (true) {
			int N = StdIn.readInt();
			int[] a = new int[N];
			for (int i = 0; i < N; i++) {
				a[i] = StdIn.readInt();
			}
			int[] gram = histogram(a, M);
			
			arrayOut(gram);
		}
		
	}
	private static int[] histogram(int[] a, int m) {
		int[] b = new int[m];
		for (int i = 0; i < m; i++) {
			b[i] = 0;
		}
		for (int j = 0; j < a.length; j++) {
			b[a[j]] ++;
		}
		return b;
	}
	public static void arrayOut(int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] != 0) {
				System.out.println(i + ":" + a[i]);
			}
		}
	}
}
