package com.beau.leetcode;

import java.util.HashMap;
import java.util.Map;


/**
 * @author BeauFang
 * Date: 2020/7/16
 * 1
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int goal = target - nums[i];
            if (map.containsKey(goal)) {
                return new int[]{i, map.get(goal)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no such solution");
    }
}
