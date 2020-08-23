package com.beau.leetcode.week6;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author BeauFang
 * Date: 2020/8/20
 * 680 https://leetcode-cn.com/problems/valid-palindrome-ii/
 */
public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        int len = s.length();
        if (len < 2) return true;
        int i = 0, j = len - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j) ) {
               return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int i ,int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    @Test
    public void test() {
        TestCase.assertTrue(validPalindrome("aba"));
        TestCase.assertTrue(validPalindrome("abca"));
        TestCase.assertTrue(validPalindrome("abbca"));
        TestCase.assertFalse(validPalindrome("abeca"));
    }
}
