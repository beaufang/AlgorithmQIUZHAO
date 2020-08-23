package com.beau.leetcode.week6;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author BeauFang
 * Date: 2020/8/20
 * 205 https://leetcode-cn.com/problems/isomorphic-strings/
 */
public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
    }

    private boolean isIsomorphicHelper(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (map.containsKey(a)) {
                char c = map.get(a);
                if (b != c) return false;
            } else {
                map.put(a, b);
            }
        }
        return true;
    }

    @Test
    public void test() {
        TestCase.assertTrue(isIsomorphic("egg", "add"));
        TestCase.assertTrue(isIsomorphic("paper", "title"));
        TestCase.assertFalse(isIsomorphic("foo", "bar"));
        TestCase.assertFalse(isIsomorphic("ab", "aa"));
        TestCase.assertFalse(isIsomorphic("aba", "baa"));
    }
}
