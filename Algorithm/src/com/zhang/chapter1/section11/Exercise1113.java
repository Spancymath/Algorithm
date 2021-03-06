package com.zhang.chapter1.section11;

import edu.princeton.cs.algs4.StdIn;

public class Exercise1113 {

	public static void main(String[] args) {
		int M, N;
		M = 3;
		N = 2;
		int[][] matrix = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = StdIn.readInt();
			}
		}
		
		matrixOut(matrix);
		
		int[][] matrixTrans = new int[N][M];
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				matrixTrans[j][i] = matrix[i][j];
			}
		}
		
		matrixOut(matrixTrans);
	}

	public static void matrixOut(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j]);
			}
			System.out.println();
		}
	}
}
