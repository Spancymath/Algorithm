package com.zhang.test;

import java.util.Arrays;

public class Test {

    public Character maxCharrcter(String string) {
        int maxNum = 0;
        char maxChar = ' ';
        for (int i = 0; i < string.length(); i++) {
            if (!isLetter(string.charAt(i))) continue;
            int count = 0;
            for (int j = 0; j < string.length(); j++) {
                if (equal(string.charAt(i), string.charAt(j))) count++;
            }
            if (count > maxNum) {
                maxNum = count;
                maxChar = string.charAt(i);
            }
        }
        if (maxNum == 0) return null;
        return maxChar;
    }

    public boolean equal(char c1, char c2) {
        return Character.toLowerCase(c1) == Character.toLowerCase(c2);
    }

    public boolean isLetter(char c) {
        char temp = Character.toLowerCase(c);
        int asc = temp - 'a';
        return temp >=0 && temp < 26;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
