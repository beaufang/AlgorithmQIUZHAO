package com.beau.leetcode.week4;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author BeauFang
 * Date: 2020/8/3
 * 91 https://leetcode-cn.com/problems/decode-ways/
 */
public class DecodeWays {

    /**
     * 这个问题本质上和上楼梯是一类问题，要看 s[i] 有多少中解法，
     * 实际上是 s[i - 1] + s[i - 2] 的解法， 不同的地方是多了限制条件
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        // dp[i] 表示以 i 结尾的字符串有多少中解法
        int[] dp = new int[len];
        char[] chs = s.toCharArray();
        if (chs[0] == '0') {
            return 0;
        }
        dp[0] = 1;
        for (int i = 1; i < chs.length; i++) {
            if (chs[i] != '0') {
                dp[i] += dp[i - 1];
            }
            int num = 10 * (chs[i - 1] - '0') + chs[i] - '0';
            if (num >= 10 && num <= 26) {
                if ( i == 1) {
                    dp[i]++;
                } else {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[len - 1];
    }

    @Test
    public void test() {
        TestCase.assertEquals(1, numDecodings("2"));
        TestCase.assertEquals(2, numDecodings("12"));
        TestCase.assertEquals(3, numDecodings("226"));
        TestCase.assertEquals(2, numDecodings("227"));
        TestCase.assertEquals(1, numDecodings("101"));
        TestCase.assertEquals(1, numDecodings("10"));
    }
}
