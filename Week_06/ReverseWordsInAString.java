package com.beau.leetcode.week6;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author BeauFang
 * Date: 2020/8/19
 * 151 https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */
public class ReverseWordsInAString {

    public String reverseWords(String s) {
        List<String> list = Arrays.asList(s.trim().split("\\s+"));
        Collections.reverse(list);
        return String.join(" ", list);
    }

    @Test
    public void test() {
        System.out.println(reverseWords("the sky is   blue"));
    }
}
