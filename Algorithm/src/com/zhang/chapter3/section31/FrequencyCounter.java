package com.zhang.chapter3.section31;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FrequencyCounter {
    public static void main(String[] args) {
        StdOut.println("请输入要统计的单词的最短长度");
        int minlen = StdIn.readInt();
        Chapter30102 chapter30102 = new Chapter30102();
        Chapter30102.ST<String, Integer> st = chapter30102.new ST<>();
        int n = 0;
        String lastWord = "";
        int lastN = 0;
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (word.equals("exit;")) break;
            n++;
            if (word.length() < minlen) continue;
            //正常
            /*if (!st.contains(word)) st.put(word, 1);
            else st.put(word, st.get(word) + 1);*/
            //追踪最后一次put
            lastWord = word;
            lastN = n - 1;
            if (!st.contains(word)) {
                st.put(word, 1);
            }
            else {
                st.put(word, st.get(word) + 1);
            }
        }
        /*//找出出现频率最高的单词
        String max = "";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max)) {
                max = word;
            }
        }
        StdOut.println(max + ": " + st.get(max));
        StdOut.println(lastWord + " beforeWordsNum: " + lastN);*/
        //找出所有出现频率最高的单词
        Queue<String> queue = new Queue<>();
        String max = "";
        queue.enqueue(max);
        st.put(max, 0);
        for (String s : st.keys()) {
            if (st.get(s) >= st.get(max)) {
                if (st.get(s) > st.get(max)) {
                    max = s;
                    while (!queue.isEmpty()) queue.dequeue();
                }
                queue.enqueue(s);
            }
        }

        while (!queue.isEmpty()) {
            StdOut.println(queue.dequeue());
        }

    }
}
