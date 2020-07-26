package com.beau.leetcode.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author BeauFang
 * Date: 2020/7/25
 * 47 https://leetcode-cn.com/problems/permutations-ii/
 */
public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        // 用于记录元素是否使用过
        boolean[] used = new boolean[nums.length];
        // 对数组进行排序，方便剪枝
        Arrays.sort(nums);
        backtrack(nums, new LinkedList<>(), used, ans);
        return ans;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used, List<List<Integer>> ans) {
        if (track.size() == nums.length) {
            ans.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 如果元素被使用了
            if (used[i]) {
                continue;
            }
            // 如果元素和上一轮决策中的元素相同，且上一轮决策已经使用
            if (i > 0 && nums[i] == nums[i-1] && used[i-1]) {
                continue;
            }
            used[i] = true;
            track.add(nums[i]);
            backtrack(nums, track, used, ans);
            used[i] = false;
            track.removeLast();
        }
    }
}
