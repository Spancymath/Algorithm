package com.zhang.chapter5.section53;

import java.math.BigInteger;
import java.util.Random;

/**
 * Rabin-Karp指纹字符串查找算法
 */
public class RabinKarp {
    private String pat;//模式字符串
    private long patHash;//模式字符串的散列值
    private int M;//模式字符串的长度
    private long Q;//一个很大素数
    private int R = 256;//字母表的大小
    private long RM;//R^(M-1) % Q

    public RabinKarp(String pat) {
        this.pat = pat;
        this.M = pat.length();
        Q = longRandomPrime();
        RM = 1;
        for (int i = 1; i <= M-1; i++) {
            RM = (R * RM) % Q;
        }
        patHash = hash(pat, M);
    }

    public boolean check(int i) {
        return true;//蒙特卡洛算法

        //拉斯维加斯算法
        /*for (int j = 0; j < M; j++) {
            if (pat.charAt(j) != txt.charAt(j)) return false;
        }
        return true;*/
    }

    private long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }

    private long hash(String key, int M) {
        //计算key[0..M-1]散列值
        long h = 0;
        for (int j = 0; j < M; j++) {
            h = (R * h + key.charAt(j)) % Q;
        }
        return h;
    }

    private int search(String txt) {
        int N = txt.length();
        long txtHash = hash(txt, M);
        if (patHash == txtHash && check(0)) return 0;
        for (int i = M; i < N; i++) {
            txtHash = (txtHash + Q - RM * txt.charAt(i - M) % Q) % Q;
            txtHash = (txtHash * R + txt.charAt(i)) % Q;
            if (patHash == txtHash) {
                if (check(i - M + 1)) return i - M + 1;//找到匹配
            }
        }
        return N;//未找到匹配
    }
}
