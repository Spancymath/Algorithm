package com.zhang.chapter1.section11;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1130 {

	public static void main(String[] args) {
		while (true) {
			int n = StdIn.readInt();
			boolean[][] a = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= i; j++) {
					if (gcd(i, j) == 1 && j != 0) {
						a[i][j] = true;
						a[j][i] = true;
					} else {
						a[i][j] = false;
						a[j][i] = false;
					}
					StdOut.print(a[i][j] + "  ");
				}
				StdOut.println();
			}
		}
	}
	
	public static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}

}
