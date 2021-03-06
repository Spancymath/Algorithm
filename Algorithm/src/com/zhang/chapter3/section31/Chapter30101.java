package com.zhang.chapter3.section31;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 输入成绩档次和分数，算平均分数
 */
public class Chapter30101 {
    /**
     * 存储档次和分数的对象
     */
    public class Score {
        private String mark;
        private float num;

        public Score(String mark, float num) {
            this.mark = mark;
            this.num = num;
        }

        public String getMark() {
            return mark;
        }

        public void setMark(String mark) {
            this.mark = mark;
        }

        public float getNum() {
            return num;
        }

        public void setNum(float num) {
            this.num = num;
        }
    }
    public static void main(String args[]) {
        Chapter30101 chapter30101 = new Chapter30101();
        String flag = "";
        Score[] scores = new Score[20];
        int i = 0;
        StdOut.println("请输入你要做的操作：1添加成绩  2查询平均成绩");
        do {
            flag = StdIn.readString();
            if ("1".equals(flag)) {
                StdOut.println("依次输入档次和分数，中间以逗号隔开");
                String ss = StdIn.readString();
                String letters = ss.split(",")[0].replace(" ", "");
                float num = Float.parseFloat(ss.split(",")[1].replace(" ",""));
                scores[i++] = chapter30101.new Score(letters, num);
            } else if("2".equals(flag)) {
                StdOut.println("输入字母成绩");
                String letters = StdIn.readString();
                float sum = 0;
                i = 0;
                for (Score score : scores) {
                    if (score != null && score.mark.equals(letters.replace(" ", ""))) {
                        sum += score.num;
                        i++;
                    }
                }
                StdOut.println(letters + "的平均成绩是： " + sum/i);
            } else {
                StdOut.println("输入错误请重新输入");
                continue;
            }
            StdOut.println("请输入你要做的操作：1添加成绩  2查询平均成绩");
        }while (!StdIn.isEmpty());
    }
}
