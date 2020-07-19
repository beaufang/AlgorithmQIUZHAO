package com.beau.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author BeauFang
 * Date: 2020/7/16
 * 350
 */
public class IntersectionsOfTwoArray2 {


    // hashMap 法
    public int[] intersect(int[] nums1, int[] nums2) {
        // 为了节省空间，选取小的数组存储
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> memo = new HashMap<>();
        for (int n : nums1) {
            int count = memo.getOrDefault(n, 0) + 1;
            memo.put(n, count);
        }
        int[] res = new int[nums1.length];
        int index = 0;
        for (int n : nums2) {
            int count = memo.getOrDefault(n, 0);
            if (count > 0) {
                res[index++] = n;
                count--;
                // 及时释放空间
                if (count > 0) {
                    memo.put(n, count);
                } else {
                    memo.remove(n);
                }
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }

    // 排序之后，双指针法
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, index = 0;
        int[] intersections = new int[Math.min(nums1.length, nums2.length)];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            }else if (nums1[i] > nums2[j]) {
                j++;
            }else {
                intersections[index++] = nums1[i++];
                j++;
            }
        }
        return Arrays.copyOfRange(intersections, 0, index);
    }

}
