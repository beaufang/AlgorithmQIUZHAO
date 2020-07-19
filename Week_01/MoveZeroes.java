package com.beau.leetcode;

/**
 * @author BeauFang
 * Date: 2020/7/16
 * 283
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        // 使用两个指针，i 指向当前遍历的位置，
        // j 最左侧 0 的位置
        for (int i = 0, j = 0; i < nums.length; i++ ) {
            if (nums[i] != 0) {
                // 不能直接取 0, 因为会发生自生的空交换
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }
}
