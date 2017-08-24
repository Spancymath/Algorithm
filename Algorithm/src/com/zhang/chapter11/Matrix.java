package com.zhang.chapter11;

public class Matrix {
	
	static double dot(double[] x, double[] y) {
		int sum = 0;
		for (int i = 0; i < x.length; i++) {
			sum += x[i] * y[i];
		}
		
		return sum;
	}
	
	static double[][] mult(double[][] a, double[][] b) {
		
		double[][] result = new double[a.length][b[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				double sum = 0;
				for (int k = 0; k < b[0].length; k++) {
					sum += a[i][k]*b[k][j];
				}
				result[i][j] = sum;
			}
		}
		
		return result;
	}
	
	static double[][] transpose(double[][] a) {
		double[][] transa = new double[a[0].length][a.length];
		for (int i = 0; i < a[0].length; i++) {
			for (int j = 0; j < a.length; j++) {
				transa[i][j] = a[j][i];
			}
		}
		
		return transa;
	}
}
