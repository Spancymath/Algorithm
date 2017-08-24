package com.zhang.chapter11;

import edu.princeton.cs.algs4.StdIn;

public class Exercise1114 {

	public static void main(String[] args) {
		int N;
		while (StdIn.hasNextChar()) {
			N = StdIn.readInt();
			System.out.println(lg(N));
		}
	}

	private static int lg(int n) {
		if (n == 1)
			return 0;
		return 1 + lg(n / 2);
	}

}
