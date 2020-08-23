package com.beau.leetcode.week6;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author BeauFang
 * Date: 2020/8/18
 * 493 https://leetcode-cn.com/problems/reverse-pairs/
 */
public class ReversePairs {

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;
        int mid = left + (right - left) / 2;
        int count = 0;
        // 重要翻转对的数量为左区间的数量+右区间的数量+左和右区间之间形成的重要翻转对的数量
        count += mergeSort(nums, left, mid);
        count += mergeSort(nums, mid + 1, right);
        // 统计左右区间形成的翻转对数量
        for (int i = left, j = mid + 1; i <= mid; i++) {
            // 模 2.0 防止溢出
            while (j <= right && nums[i] / 2.0 > nums[j]) {
                j++;
            }
            // 重点理解：i 和 [mid + 1, j) 之间的元素都可以形成重要翻转对
            count += j - (mid + 1);
        }
        merge(nums, left, mid, right);

        return count;
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, index = 0;
        while (i <= mid & j <= right) {
            temp[index++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) {
            temp[index++] = nums[i++];
        }
        while (j <= right) {
            temp[index++] = nums[j++];
        }
        System.arraycopy(temp, 0, nums, left, temp.length);
    }

    @Test
    public void test() {
//        int[] arr = {1, 3, 2, 3, 1};
        int[] arr = {2147483647, 2147483647, -2147483647, -2147483647, -2147483647, 2147483647};
        int res = reversePairs(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(res);
    }
}
