package com.beau.leetcode;


/**
 * @author BeauFang
 * Date: 2020/7/16
 * 88
 */
public class MergeSortedArray {

    // 双指针尾部遍历
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[p1] < nums2[p2] ? nums2[p2--] : nums1[p1--];
        }
        // 把 num2 中未处理完的数据拷贝过去
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

}
