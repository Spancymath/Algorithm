package com.zhang.chapter1.section12;

public class Transaction {
	private final String who;
	private final Date when;
	private final double amount;
	
	public Transaction(String who, Date when, double amount) {
		if (Double.isNaN(amount) || Double.isInfinite(amount)) {
			throw new IllegalArgumentException("Amount can't be Nan or infinite");
		}
		this.who = who;
		this.when = when;
		this.amount = amount;
	}
	
	public Transaction(String transaction) {
		String[] a = transaction.split("\\s+");
		who = a[0];
		when = new Date(a[1]);
		amount = Double.parseDouble(a[2]);
		if (Double.isNaN(amount) || Double.isInfinite(amount)) {
			throw new IllegalArgumentException("Amount can't be Nan or infinite");
		}
	}
	public String getWho() {
		return who;
	}
	public Date getWhen() {
		return when;
	}
	public double getAmount() {
		return amount;
	}
	
	public String toString() {
		return String.format("%-10s %10s %8.2f", who, when, amount);
	}
	
	public int compareTo(Transaction that) {
		return Double.compare(this.amount, that.amount);
	}
	
	public boolean equals(Object other) {
		if (other == this) return true;
		if (other == null) return false;
		if (other.getClass() != this.getClass()) return false;
		Transaction that = (Transaction)other;
		return (this.amount == that.amount && this.who == that.who
				&& this.when ==that.when);
	}
}
