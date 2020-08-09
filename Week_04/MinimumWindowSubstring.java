package com.beau.leetcode.week4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author BeauFang
 * Date: 2020/8/9
 * 76 https://leetcode-cn.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        Map<Character, Integer> needed = new HashMap<>();
        for (char c : t.toCharArray()) {
            int count = needed.getOrDefault(c, 0) + 1;
            needed.put(c, count);
        }
        Map<Character, Integer> window = new HashMap<>();
        int valid = 0; // 窗口内达到 needed 中字符数量的个数
        int left = 0, right = 0;
        int start = 0, len = Integer.MAX_VALUE; // 用于记录子串
        // 更新窗口内数据
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (needed.containsKey(c)) {
                int count = window.getOrDefault(c, 0) + 1;
                window.put(c, count);
                if (window.get(c).equals(needed.get(c))) {
                    valid++;
                }
            }
            // 判断窗口是否需要收缩
            while (valid == needed.size()) {
                // 更新覆盖子串为更小的长度
                if (right - left< len) {
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                left++;
                if (needed.containsKey(d)) {
                    int count = window.get(d) - 1;
                    window.put(d, count);
                    if (count < needed.get(d)) {
                        valid--;
                    }
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
