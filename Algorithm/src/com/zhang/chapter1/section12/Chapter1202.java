package com.zhang.chapter1.section12;

import edu.princeton.cs.algs4.StdIn;

public class Chapter1202 {

	public static void main(String[] args) {
		int N = StdIn.readInt();
		double[][] interval1D = new double[N][2];
		for (int i = 0; i < N; i++) {
			interval1D[i][0] = StdIn.readDouble();
			interval1D[i][1] = StdIn.readDouble();
		}
		
		for (int i = 0; i < N; i++) {
			System.out.println(interval1D[i][0] + " " + interval1D[i][1]);
		}
	}

}
