package com.zhang.chapter1.section12;

public class Accumulator {
	//private double total;
	private int N;
	private double m;
	private double s;
	
	public void addDataValue(double val) {
		N++;
		//total += val;
		s = s + 1.0 * (N - 1) / N * (val - m) * (val - m);
		m = m + (val - m) / N;
	}
	
	public double mean() {
		//return total / N;
		return m;
	}
	
	public double var() {
		return s / (N - 1);
	}
	
	public double stddev() {
		return Math.sqrt(this.var());
	}
	
	public String toString() {
		return "Mean (" + N + " values): " + String .format("%7.5f",  mean());
	}
}
