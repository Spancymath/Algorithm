package com.zhang.chapter31;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class TestBinarySearch {

    //打印菜单
    public static void printMenu() {
        StdOut.println("请输入相应的功能对应的序号：\n" +
                "0: menu\n" +
                "1: max\n" +
                "2: min\n" +
                "3: floor\n" +
                "4: ceiling\n" +
                "5: select\n" +
                "6: rank\n" +
                "7: deleteMin\n" +
                "8: deleteMax\n" +
                "9: keys\n" +
                "10: exit");
    }


    public static void main(String args[]) {
        BinarySearchST<String, Integer> st = new BinarySearchST<>();
        StdOut.println("请输入字典，以exit;结束");
        while (true) {
            String word = StdIn.readString();
            if (word.equals("exit;")) break;
            if (st.contains(word)) st.put(word, st.get(word) + 1);
            else st.put(word, 1);
        }

        String w;
        printMenu();
        while (true) {
            int option = StdIn.readInt();
            switch (option) {
                case 0: {
                    printMenu();
                    break;
                }
                case 1: {
                    StdOut.println(st.maxKey() + ": " + st.get(st.maxKey()));
                    break;
                }
                case 2: {
                    StdOut.println(st.minKey() + ": " + st.get(st.minKey()));
                    break;
                }
                case 3: {
                    StdOut.println("输入要查找的键：");
                    w = StdIn.readString();
                    StdOut.println(st.floor(w));
                    break;
                }
                case 4: {
                    StdOut.println("输入要查找的键：");
                    w = StdIn.readString();
                    StdOut.println(st.ceiling(w));
                    break;
                }
                case 5: {
                    StdOut.println("输入要查找的键的排名：");
                    int k = StdIn.readInt();
                    StdOut.println(st.select(k));
                    break;
                }
                case 6: {
                    StdOut.println("输入要查找的键：");
                    w = StdIn.readString();
                    StdOut.println(st.rank(w));
                    break;
                }
                case 7: {
                    st.deleteMin();
                    break;
                }
                case 8: {
                    st.deleteMax();
                    break;
                }
                case 9: {
                    Queue<String> queue = st.keys();
                    while (!queue.isEmpty()) {
                        StdOut.println(queue.dequeue());
                    }
                    break;
                }
                case 10: {
                    System.exit(0);
                    break;
                }
                default: break;
            }
        }

    }
}
