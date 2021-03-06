package com.zhang.chapter1.section12;

public class Date {
	private final int month;
	private final int day;
	private final int year;
	
	public Date(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
	}
	
	public Date(String date) {
		String[] fields = date.split("/");
		month = Integer.parseInt(fields[0]);
		day = Integer.parseInt(fields[1]);
		year = Integer.parseInt(fields[2]);
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
	
	public String toString() {
		return month() + "/" + day() + "/" + year();
	}
	
	public boolean equals(Object x) {
		if (this == x) return true;
		if (x == null) return false;
		if (this.getClass() != x.getClass()) return false;
		Date that = (Date)x;
		if (this.day != that.day) return false;
		if (this.month != that.month) return false;
		if (this.year != that.year) return false;
		return true;
	}
}
