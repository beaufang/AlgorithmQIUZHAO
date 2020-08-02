package com.beau.leetcode.week3;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author BeauFang
 * Date: 2020/7/31
 * 153 https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinimumInRotatedSortedArray {


/*    // 3 , 2 ,1 这种情况，不能通过
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // 确保 mid - 1 >= 0
            int mid = left + (right - left + 1) / 2;
            // 旋转点在右区间
            if (nums[left] < nums[mid]) {
                left = mid;
            } else {
                right = mid - 1;
                System.out.println(right);
            }
        }
        // 把整个数组考虑成一个环形
        return nums[(right + 1) % nums.length];
    }*/


    // 二分搜索旋转点
    public int findMin2(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int left = 0, right = len - 1;
        // 如果未发生旋转
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        // 查找寻转点
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 如果 mid 不是旋转点，则 mid 附件一定满足升序的条件
            // mid 附近发生逆序，因此，mid 就是旋转点
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            // 旋转点靠右
            if (nums[0] < nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // 递归二分搜索
    public int findMin(int[] nums) {
        return findMinHelper(nums, 0, nums.length - 1);
    }

    private int findMinHelper(int[] nums, int from, int to) {
        // 如果只有一个元素
        if (to - from <= 0) {
            return nums[from];
        }
        // 如果超过数组的范围
        if (from >= nums.length || to < 0) {
            return Integer.MAX_VALUE;
        }
        // 如果在该区间单调递增
        if (nums[from] < nums[to]) {
            return nums[from];
        }
        int mid = from + (to - from) / 2;
        int minLeft = findMinHelper(nums, from, mid - 1);
        int minRight = findMinHelper(nums, mid + 1, to);
        return Math.min(Math.min(minLeft, minRight), nums[mid]);
    }

    @Test
    public void test() {
        TestCase.assertEquals(1, findMin(new int[]{3, 4, 5, 1, 2}));
        TestCase.assertEquals(1, findMin(new int[]{4, 5, 1, 2, 3}));
        TestCase.assertEquals(3, findMin(new int[]{3, 4, 5}));
        TestCase.assertEquals(3, findMin(new int[]{4, 3}));
        TestCase.assertEquals(1, findMin(new int[]{2, 3, 4, 5, 1}));
        TestCase.assertEquals(1, findMin(new int[]{1, 2, 3}));
        TestCase.assertEquals(1, findMin(new int[]{3, 1, 2}));
        TestCase.assertEquals(1, findMin(new int[]{3, 2, 1}));
    }
}
