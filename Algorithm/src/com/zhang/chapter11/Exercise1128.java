package com.zhang.chapter11;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1128 {
	
	public static int rank(int key, int[] a) {
		//数组必须有序
		
		int lo = 0;
		int hi = a.length - 1;
		while (lo<=hi) {
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
		
		int[] num = new int[1000];
		for (int i = 0; i < num.length; i++) {
			num[i] = 0;
		}
		
		while (!StdIn.isEmpty()) {
			int key = StdIn.readInt();
			if (rank(key, whitelist) >= 0 && num[key] == 0) {
				num[key]++;
				StdOut.println(key);
			}
		}
	}

}
