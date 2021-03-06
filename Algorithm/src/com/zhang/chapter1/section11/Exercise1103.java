package com.zhang.chapter1.section11;

import edu.princeton.cs.algs4.StdIn;

public class Exercise1103 {

	public static void main(String[] args) {
		while(StdIn.hasNextChar()) {
			int a = StdIn.readInt();
			int b = StdIn.readInt();
			int c = StdIn.readInt();
			
			if (a==b && a==c) {
				System.out.println("true");
			} else {
				System.out.println("false");
			}
		}
	}

}
