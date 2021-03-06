package com.zhang.chapter1.section11;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1120 {

	public static void main(String[] args) {
		int N;
		while (StdIn.hasNextChar()) {
			N = StdIn.readInt();
			StdOut.println(ln(N));
		}
	}

	private static double ln(int n) {
		if (n == 1) return 0;
		return ln(n-1) + Math.log(n);
	}

}
