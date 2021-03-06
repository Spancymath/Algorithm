package com.zhang.chapter1.section12;

public class Rational {

	private static final Rational ZERO = new Rational(0, 1);
	
	private long num;
	private long den;
	
	public Rational(long numerator, long denominator) {
		if (denominator == 0) {
			throw new ArithmeticException("Denominator is zero");
		}
		
		long g = gcd(numerator, denominator);
		num = numerator / g;
		den = denominator / g;
		
		if (den < 0) {
			den = -den;
			num = -num;
		}
	}
	
	
	public long numerator() {
		return num;
	}
	
	public long denominator() {
		return den;
	}
	
	public double toDouble() {
		return (double) num / den;
	}
	
	public String toString() {
		if (den == 1) {
			return num + "";
		} else {
			return num + "/" + den;
		}
	}
	
	public int compareTo(Rational that) {
		long lhs = this.num * that.den;
		long rhs = this.den * that.num;
		if (lhs < rhs) {
			return -1;
		} else if (lhs > rhs) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public boolean equals(Object other) {
		if (other == null) return false;
		if (other.getClass() != this.getClass()) return false;
		Rational that = (Rational) other;
		return this.compareTo(that) == 0;
	}
	
	private static long gcd(long m, long n) {
		if (m < 0) m = -m;
		if (n < 0) n = -n;
		if (0 == n) {
			return m;
		} else {
			return gcd(n, m % n);
		}
	}
	
	public Rational times(Rational that) {
		Rational c = new Rational(this.num, that.den);
		Rational d = new Rational(that.num, this.den);
		return new Rational(c.num * d.num, c.den * d.den);
	}
	
	public Rational plus(Rational that) {
		if (this.compareTo(ZERO) == 0) return that;
		if (that.compareTo(ZERO) == 0) return this;
		
		long f = gcd(this.num, that.num);
		long g = gcd(this.den, that.den);
		
		Rational s = new Rational((this.num / f) * (that.den / g)
				+ (that.num / f) * (this.den / g), this.den * (that.den / g));
		s.num *= f;
		return s;
	}
	
	//ȡ���ĸ���
	public Rational negate() {
		return new Rational(-num, den);
	}
	
	public Rational abs() {
		if (num >= 0) {
			return this;
		} else {
			return negate();
		}
	}
	
	public Rational minus(Rational that) {
		return this.plus(that.negate());
	}
	
	//����
	public Rational reciprocal() {
		return new Rational(den, num);
	}
	
	public Rational dividedBy(Rational that) {
		return this.times(that.reciprocal());
	}
}
