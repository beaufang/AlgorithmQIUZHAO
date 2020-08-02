package com.beau.leetcode.week3;

/**
 * @author BeauFang
 * Date: 2020/7/29
 * 33 https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class SearchTnRotatedSortedArray {


    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {

            int mid = left + (right - left + 1) / 2;
            // 如果右区间有序
            if (nums[mid] < nums[right]) {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            } else {
                // 这里故意缩小区间到 [left, mid - 1]，是为了方便统一取中值
                if (nums[left] <= target && target <= nums[mid - 1]) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }


    public static void main(String[] args) {
        SearchTnRotatedSortedArray solution = new SearchTnRotatedSortedArray();
        System.out.println(solution.search(new int[]{1,  3}, 1));
        System.out.println(solution.search(new int[]{4,5,6,7,0,1,2}, 1));
        System.out.println(solution.search(new int[]{4,3,2,1}, 2));
        System.out.println(solution.search(new int[]{3, 1}, 1));
        System.out.println(solution.search(new int[]{3, 1}, 0));
    }
}
