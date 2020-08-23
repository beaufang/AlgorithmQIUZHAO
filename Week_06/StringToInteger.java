package com.beau.leetcode.week6;

import org.junit.Test;

/**
 * @author BeauFang
 * Date: 2020/8/21
 * 8 https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
public class StringToInteger {

    public int myAtoi(String str) {
        int len = str.length();
        int i = 0, sign = 1, res = 0;
        char[] chs = str.toCharArray();
        while (i < len && chs[i] == ' ') {
            i++;
        }
        if (i == len) {
            return 0;
        }
        char firstChar = chs[i];
        if (firstChar == '-') {
            sign = -1;
            i++;
        } else if (firstChar == '+') {
            i++;
        }
        while (i < len) {
            int n = chs[i] - '0';
            if (n < 0 || n > 9) {
                break;
            }
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && sign * n > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && sign * n < Integer.MIN_VALUE % 10)) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + sign * n;
            i++;
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("      -42"));
        System.out.println(myAtoi("2147483646"));
        System.out.println(myAtoi("-2147483648"));
        System.out.println(myAtoi("-2147483649"));
        System.out.println(myAtoi("991283472332"));
    }
}
