package com.zhang.chapter1.section11;

import edu.princeton.cs.algs4.StdIn;

public class Exercise1109 {

	public static void main(String[] args) {
		String s = "";
		while (true) {
			int N = StdIn.readInt();
			for (int n = N; n > 0; n /= 2) {
				s += (n % 2);
			}
			System.out.println(s);
		}
	}

}
