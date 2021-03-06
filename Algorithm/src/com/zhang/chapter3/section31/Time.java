package com.zhang.chapter3.section31;

public class Time implements Comparable<Time> {
    @Override
    public int compareTo(Time o) {
        int a = this.hour * 60 * 24 + this.minute * 60 + this.second;
        int b = o.hour * 60 * 24 + o.minute * 60 + this.second;
        if (a > b) return 1;
        else if (a == b) return 0;
        else return -1;
    }

    private int hour;
    private int minute;
    private int second;

    public Time(String time) {
        String[] ints = time.split(":");
        hour = Integer.getInteger(ints[0]);
        minute = Integer.getInteger(ints[1]);
        second = Integer.getInteger(ints[2]);
    }

    public String toString() {
        return "" + hour + minute + second;
    }
}
