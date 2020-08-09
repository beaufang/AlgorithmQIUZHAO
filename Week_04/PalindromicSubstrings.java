package com.beau.leetcode.week4;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author BeauFang
 * Date: 2020/8/5
 * 674 https://leetcode-cn.com/problems/palindromic-substrings/
 */
public class PalindromicSubstrings {

    public  int countSubstrings(String s) {
        if (s == null) {
            return -1;
        }
        int len = s.length();
        if (len == 1) {
            return 1;
        }
        // 第 i->j 之间的字符串是否为回文串
        boolean[][] dp = new boolean[len][len];
        int ans = 0;
        // 注意填表顺序
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                // case1: 只有一个字符肯定为回文
                // case2: i 和 j 相等，去掉 i 和 j 依然回文，s(i,j) 肯定回文
                // case3: i 和 j 相等，只有两个字符，肯定回文
                // 注意括号
                if (i == j || s.charAt(i) == s.charAt(j) && (dp[i+1][j-1] || j - i == 1)) {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }
        return ans;
    }

    public int countSubstrings2(String s) {
        if (s == null) {
            return -1;
        }
        int len = s.length();
        if (len == 1) {
            return 1;
        }
        // 索引 i->j 之间的字符串是否为回文串
        boolean[][] dp = new boolean[len][len];

        int ans = 0;
        // base case
        // 对角线表示只有一个字符，肯定是回文(可以省略，因为没用上)
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            ans++;
        }
        // 注意填表顺序
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    // 只有三个字符
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    @Test
    public void test() {
        TestCase.assertEquals(3, countSubstrings("aa"));
        TestCase.assertEquals(6, countSubstrings("aaa"));
    }
}
