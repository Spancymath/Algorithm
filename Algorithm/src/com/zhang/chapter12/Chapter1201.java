package com.zhang.chapter12;

import java.util.Arrays;
import java.util.Comparator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class Chapter1201 {
	
	private static double minDistant; 
	
	public class Point2D {
		
		public Point2D() {}
		private double x;
		private double y;
		public double getX() {
			return x;
		}
		public void setX(double x) {
			this.x = x;
		}
		public double getY() {
			return y;
		}
		public void setY(double y) {
			this.y = y;
		}
	}

	public static double distance(Point2D a, Point2D b) {
		return Math.sqrt(Math.pow((a.getX() - b.getX()), 2) + Math.pow((a.getY() - b.getY()), 2));
	}
	
	public static void orginalFind(Point2D[] aa, int k, Point2D a1) {
		for (int i = 0; i < k; i++) {
			if (distance(aa[i], a1) < minDistant) {
				minDistant = distance(aa[i], a1);
			}
		}
	}
	
	class pointComperat implements Comparator<Point2D> {
		@Override
		public int compare(Point2D o1, Point2D o2) {
			return (int) (o1.x - o2.x);
		}
	}
	
	public static void speedXFind(Point2D[] aa) {
		for (int i = 1; i < aa.length; i++) {
			for (int j = i -1; j >= 0; j--) {
				if (Math.abs(aa[i].x - aa[j].x) >= minDistant) continue;
				if (distance(aa[i], aa[j]) < minDistant) {
					minDistant = distance(aa[i], aa[j]);
				}
			}
		}
	}
	public static void main(String[] args) {
		
		minDistant = 2;
		int N = StdIn.readInt();
		Point2D[] aa = new Point2D[N];
		for (int i = 0; i < N; i++) {
			aa[i] = new Chapter1201().new Point2D();
			aa[i].setX(StdRandom.uniform());
			aa[i].setY(StdRandom.uniform());
//			orginalFind(aa, i, aa[i]);
		}
		
		Arrays.sort(aa, new Chapter1201().new pointComperat());
		speedXFind(aa);
		
		System.out.println(minDistant);
	}

}
