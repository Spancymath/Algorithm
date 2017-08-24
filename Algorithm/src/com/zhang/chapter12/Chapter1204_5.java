package com.zhang.chapter12;

public class Chapter1204_5 {

	public static void main(String[] args) {
		
		//1.2.4
		String string1 = "hello";
		String string2 = string1;
		string1 = "world";
		System.out.println(string1);
		System.out.println(string2);
		
		//1.2.5
		String s = "Hello World";
		String s1 = s.toUpperCase();
		s1 = s1.substring(6, 11);
		System.out.println(s);
		System.out.println(s1);
		
		//1.2.6
		String a = "ACTGACG";
		String b = "TGACGACb";
		
		String aa = a.concat(a);
		if (a.length() == b.length() && (aa.indexOf(b)) >= 0) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

}
