package com.zhang.chapter12;

import edu.princeton.cs.algs4.StdIn;

public class Chapter1207 {

	//·´×ª×Ö·û´®
	public static String mystery(String s) {
		int N = s.length();
		if (N <= 1) return s;
		String a = s.substring(0, N/2);
		String b = s.substring(N/2, N);
		return mystery(b) + mystery(a);
	}
	
	public static void main(String[] args) {
		String s = StdIn.readString();
		String reverseS = mystery(s);
		System.out.println(reverseS);
	}

}
