package com.beau.leetcode.week6;

import java.util.HashMap;
import java.util.Map;

/**
 * @author BeauFang
 * Date: 2020/8/19
 * 387 https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int count = map.getOrDefault(s.charAt(i), 0) + 1;
            map.put(s.charAt(i), count);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
