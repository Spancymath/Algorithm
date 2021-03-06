package com.zhang.chapter1.section12;

import edu.princeton.cs.algs4.StdIn;

public class Chapter1207 {

	//��ת�ַ���
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
