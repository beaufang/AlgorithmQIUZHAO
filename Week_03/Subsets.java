package com.beau.leetcode.week3;

import java.util.*;

/**
 * @author BeauFang
 * Date: 2020/7/28
 * 78 https://leetcode-cn.com/problems/subsets/
 */
public class Subsets {

    // 和组合的题类似，只不过这里组合的元素个数没有限制
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length + 1; i++) {
            backtrack(nums, 0, i, new LinkedList<>(), ans);
        }
        return ans;
    }

    private void backtrack(int[] nums, int first, int k, LinkedList<Integer> cur, List<List<Integer>> ans) {
        if (cur.size() == k) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = first; i < nums.length; i++) {
            cur.add(nums[i]);
            backtrack(nums, i + 1, k, cur, ans);
            cur.removeLast();
        }
    }

    // 二进制排序
    // 参考：https://leetcode-cn.com/problems/subsets/solution/zi-ji-by-leetcode/
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        // 生成 bit 位
        for (int i = (int) Math.pow(2, n); i < (int) Math.pow(2, n + 1); i++) {
            String bitmask = Integer.toBinaryString(i).substring(1);
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < bitmask.length(); j++) {
                if (bitmask.charAt(j) == '1') {
                    cur.add(nums[j]);
                }
            }
            ans.add(cur);
        }
        return ans;
    }

}
