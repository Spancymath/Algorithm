package com.zhang.chapter12;

import edu.princeton.cs.algs4.StdIn;

public class SmarDate {
	private static final int[] DAYS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    private static final String[] WEEKS = {"Friday", "Saturday", "Sunday", "Monday", "Tuesday",
    		"Wednesday", "Thursday"};	
	private final int month;
	private final int day;
	private final int year;
	
	public SmarDate(int month, int day, int year) {
		if (!isValid(month, day, year)) throw new IllegalArgumentException("无效的日期");
		this.month = month;
		this.day = day;
		this.year = year;
	}
	
	public int month() {
		return month;
	}
	
	public int day() {
		return day;
	}
	
	public int year() {
		return year;
	}
	
	public String dayOfWeek() {
		int sum = sumDays(month, day, year);
		int week = sum % 7;
		return WEEKS[week];
	}
	
	//得到这是从2000年开始的第几天
	private static int sumDays(int m, int d, int y) {
		int sum = 0;
		for (int i = 2000; i < y; i++) {
			if (isLeapYear(i)) {
				sum += 366;
			} else {
				sum += 365;
			}
		}
		for (int i = 1; i < m; i++) {
			if (i == 2 && isLeapYear(y)){
				sum += 29;
			} else {
				sum += DAYS[i];
			}
		}
		sum += d;
		return sum;
	}
	
	//日期是否有效
	private static boolean isValid(int m, int d, int y) {
		if (m < 1 || m > 12) return false;
		if (d < 1 || d > 31) return false;
		if (y < 2000) return false;
		if (m == 2 && d== 29 && !isLeapYear(y)) return false;
		return true;
	}
	
	//判断是不是闰年
	private static boolean isLeapYear(int y) {
		if (y % 400 == 0) return true;
		if (y % 100 != 0 && y % 4 == 0) return true;
		return false;
	}
	
	public String toString() {
		return month() + "/" + day() + "/" + year();
	}
	
	public boolean equals(Object x) {
		if (this == x) return true;
		if (x == null) return false;
		if (this.getClass() != x.getClass()) return false;
		SmarDate that = (SmarDate)x;
		if (this.day != that.day) return false;
		if (this.month != that.month) return false;
		if (this.year != that.year) return false;
		return true;
	}
	
	public static void main(String Args[]) {
		while (true) {
			int y = StdIn.readInt();
			int m = StdIn.readInt();
			int d = StdIn.readInt();
			SmarDate date = new SmarDate(m, d, y);
			System.out.println(date.dayOfWeek());
		}
	}
}
