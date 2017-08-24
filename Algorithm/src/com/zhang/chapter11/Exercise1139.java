package com.zhang.chapter11;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise1139 {
	
	public static int BinarySearch(int key, int[] a, int lo, int hi) {
		
		if (lo > hi) return -1;
		int mid = (lo + hi) / 2;
		if (a[mid] < key) {
			return BinarySearch(key, a, mid +1, hi);
		} else if (a[mid] > key) {
			return BinarySearch(key, a, lo, mid - 1);
		} else {
			return mid;
		}
	}

	public static void main(String[] args) {
		int T = StdIn.readInt();
		int[] N = {1000, 10000, 100000, 1000000};
		int[] result = new int[4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < T; j++) {
				int[] a  = new int[N[i]];
				int[] b  = new int[N[i]];
				
				for (int k = 0; k < N[i]; k++) {
					a[k] = StdRandom.uniform(0, N[i]);
					b[k] = StdRandom.uniform(0, N[i]);
				}
				
				Arrays.sort(a);
				for (int p = 0; p < N[i]; p++) {
					if (BinarySearch(b[p], a, 0, a.length-1) != -1) {
						result[i]++;
					}
				}
			}
			result[i] /= T;
			StdOut.println(result[i]);
		}
	}

}
