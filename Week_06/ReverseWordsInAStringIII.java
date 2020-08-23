package com.beau.leetcode.week6;

import org.junit.Test;

/**
 * @author BeauFang
 * Date: 2020/8/20
 * 557 https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 */
public class ReverseWordsInAStringIII {

    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(new StringBuilder(word).reverse()).append(" ");
        }
        return sb.toString().trim();
    }

    @Test
    public void test() {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}
