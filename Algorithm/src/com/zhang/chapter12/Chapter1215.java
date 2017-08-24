package com.zhang.chapter12;

public class Chapter1215 {
	
	public static int[] readInts(String name) {
		
		String[] words = name.split("\\s+");
		int[] ints = new int[words.length];
		for(int i = 0; i < words.length; i++) {
			ints[i] = Integer.parseInt(words[i]);
		}
		return ints;
	}
}
