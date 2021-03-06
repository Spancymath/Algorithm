package com.zhang.chapter1.section11;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1129 {
	public static int rank(int key, int[] a) {
		//�����������
		int pos = -1;
		int lo = 0;
		int hi = a.length - 1;
		while (lo<=hi) {
			int mid = (lo + hi) / 2;
			if (key < a[mid]) {
				hi = mid - 1;
			} else if (key > a[mid]) {
				lo = mid + 1;
			} else {
				pos = mid;
				break;
			}
		}
		while (pos != -1 && a[pos] == key) {
			pos--;
		}
		return pos + 1;
	}
	
	public static int count(int key, int[] a) {
		
		int pos = -1;
		int num = 0;
		int lo = 0;
		int hi = a.length;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (a[mid] > key) {
				hi = mid;
			} else if(a[mid] < key) {
				lo = mid;
			} else {
				pos = mid;
				break;
			}
		}
		
		if (pos != -1) {
			num = 1;
		}
		int i = pos;
		while (--i >= 0 && a[i] == key) num++;
		i = pos;
		while (++i < a.length && a[i] == key) num++;
		return num;
	}

	public static void main(String[] args) {
		int[] whitelist = new int[10];
		int n = StdIn.readInt();
		for (int i = 0; i < n; i++) {
			whitelist[i] = StdIn.readInt();
		}
		Arrays.sort(whitelist);
		
		StdOut.println("����key��");
		
		while (!StdIn.isEmpty()) {
			int key = StdIn.readInt();
			int i = rank(key, whitelist);
			int j = count(key, whitelist);
			for (int k = i; k < i + j; k++) {
				StdOut.println(whitelist[k]);
			}
		}
	}


}
