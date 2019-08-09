package com.zhang.chapter51;

/**
 * 字母表
 */
public class Alphabet {

    private char[] chars;
    int R;

    public Alphabet(String s) {
        R = s.length();
        chars = new char[R];
        for (int i = 0; i < R; i++) {
            chars[i] = s.charAt(i);
        }
    }

    public char toChar(int index) {
        return chars[index];
    }

    public int toIndex(char c) {
        for (int i = 0; i < R; i++) {
            if (c == chars[i]) return i;
        }
        return -1;
    }

    public boolean contains(char c) {
        if (toIndex(c) != -1) return true;
        return false;
    }

    public int R() {
        return R;
    }

    public int lgR() {
        return (int)(Math.ceil(Math.log(R)));
    }

    public int[] toIndices(String s) {
        int[] indexs = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            indexs[i] = toIndex(s.charAt(i));
        }
        return indexs;
    }

    public String toChars(int[] indices) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < indices.length; i++) {
            stringBuilder.append(chars[indices[i]]);
        }
        return stringBuilder.toString();
    }
}
