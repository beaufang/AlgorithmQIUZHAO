package com.beau.leetcode.week6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author BeauFang
 * Date: 2020/8/21
 * 438 https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 */
public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        for (char c : p.toCharArray()) {
            int count = need.getOrDefault(c, 0) + 1;
            need.put(c, count);
        }
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0, valid = 0;
        Map<Character, Integer> window = new HashMap<>();
        while (j < s.length()) {
            char c = s.charAt(j);
            j++;
            if (need.containsKey(c)) {
                int count = window.getOrDefault(c, 0) + 1;
                window.put(c, count);
                if (count == need.get(c)) {
                    valid++;
                }
            }
            if (valid == need.size()) {
                ans.add(i);
            }
            while (j - i >= p.length()) {
                char d = s.charAt(i);
                if (need.containsKey(d)) {
                    int count = window.get(d);
                    if (count == need.get(d)) {
                        valid--;
                    }
                    window.put(d, count - 1);
                }
                i++;
            }
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("baa", "aa"));
        System.out.println(findAnagrams("cbac", "abc"));
        System.out.println(findAnagrams("aabaa", "aa"));
    }

}
