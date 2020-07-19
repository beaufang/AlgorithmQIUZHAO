package com.beau.leetcode;

import java.util.*;

/**
 * @author BeauFang
 * Date: 2020/7/17
 * 49 https://leetcode-cn.com/problems/group-anagrams/
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            // 计算字符串内每个字母的个数
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            // 拼接成 1#2# 形式
            StringBuilder sb = new StringBuilder();
            for (int c : count) {
                sb.append(c).append("#");
            }
            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key ,new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
