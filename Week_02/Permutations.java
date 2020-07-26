package com.beau.leetcode.week2;

import java.util.*;

/**
 * @author BeauFang
 * Date: 2020/7/24
 * 46 https://leetcode-cn.com/problems/permutations/
 */
public class Permutations {


    // 回溯
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, new LinkedList<>(), ans);
        return ans;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track, List<List<Integer>> ans) {
        if (track.size() == nums.length) {
            ans.add(new ArrayList<>(track));
            return;
        }
        for (int num : nums) {
            // 去除重复的元素
            if (track.contains(num)) {
                continue;
            }
            track.add(num);
            backtrack(nums, track, ans);
            track.removeLast();
        }
    }


}
