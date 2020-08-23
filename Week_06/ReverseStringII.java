package com.beau.leetcode.week6;

/**
 * @author BeauFang
 * Date: 2020/8/19
 * 541 https://leetcode-cn.com/problems/reverse-string-ii/
 */
public class ReverseStringII {


    public String reverseStr(String s, int k) {
        char[] chs = s.toCharArray();
        for (int start = 0; start < chs.length; start += 2*k) {
            int i = start, j = Math.min(start + k - 1, chs.length - 1);
            while (i < j) {
                char temp = chs[i];
                chs[i++] = chs[j];
                chs[j--] = temp;
            }
        }
        return new String(chs);
    }
}
