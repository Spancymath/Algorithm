package com.zhang.chapter2.section25;

import java.util.Comparator;
import java.util.Date;

/**
 * 实现比较器的交易类型
 * 注：final成员变量必须在声明的时候初始化或者在构造器中初始化
 */
public class Transaction {
    private final String who;
    private final Date when;
    private final double amount;

    public Transaction(String who, Date when, double amount) {
        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    public static class WhoOrder implements Comparator<Transaction> {
        public int compare(Transaction v, Transaction w) {
            return v.who.compareTo(w.who);
        }
    }

    public static class WhenOrder implements Comparator<Transaction> {
        public int compare(Transaction v, Transaction w) {
            return v.when.compareTo(w.when);
        }
    }

    public static class HowMuchOrder implements Comparator<Transaction> {
        public int compare(Transaction v, Transaction w) {
            if (v.amount < w.amount) return -1;
            if (v.amount > w.amount) return 1;
            return 0;
        }
    }
}
