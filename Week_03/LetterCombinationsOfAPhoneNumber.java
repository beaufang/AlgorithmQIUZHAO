package com.beau.leetcode.week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author BeauFang
 * Date: 2020/7/28
 * 17 https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        dfs(digits, 0, new StringBuilder(), ans, map);
        return ans;
    }

    private void dfs(String digits, int level, StringBuilder cur, List<String> ans, Map<Character, String> map) {
        // 如果遍历到最后一层
        if (level == digits.length()) {
            ans.add(cur.toString());
            return;
        }
        String str = map.get(digits.charAt(level));
        for (char c : str.toCharArray()) {
            dfs(digits, level + 1, cur.append(c), ans, map);
            cur.setLength(cur.length() - 1);
        }
    }
}
