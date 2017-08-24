package com.zhang.chapter12;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Chapter1209 {

	public static int rank(Counter counter, int key, int[] a) {
		//数组必须有序
		int lo = 0;
		int hi = a.length - 1;
		while (lo<=hi) {
			counter.increment(); 
			int mid = (lo + hi) / 2;
			if (key < a[mid]) {
				hi = mid - 1;
			} else if (key > a[mid]) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		@SuppressWarnings("deprecation")
		int[] whitelist = In.readInts(args[0]);
		Arrays.sort(whitelist);
		while (!StdIn.isEmpty()) {
			int key = StdIn.readInt();
			Counter counter = new Counter("keys:");
			if (rank(counter, key, whitelist) < 0) {
				StdOut.println(counter.toString() + key);
			}
		}
	}


}
