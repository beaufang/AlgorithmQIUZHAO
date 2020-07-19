package com.beau.leetcode;

import java.util.Arrays;

/**
 * @author BeauFang
 * Date: 2020/7/16
 * 189
 */
public class RotateArray {

    // 暴力法
    public void rotate1(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int tmp = nums[nums.length - 1];
            // 挪动数组
            System.arraycopy(nums, 0, nums, 1, nums.length - 1);
//            for (int j = nums.length - 2; j >= 0; j-- ) {
//                nums[j + 1] = nums[j];
//            }
            nums[0] = tmp;
        }
    }

    // 取模法
    // 把整个数组想象成一个环，实际上是顺时针寻转了 k 个刻度
    public void rotate2(int[] nums, int k) {
        int[] tmpNums = Arrays.copyOfRange(nums, 0, nums.length);
        for (int i = 0; i < nums.length; i++) {
            nums[(i + k)% nums.length] = tmpNums[i];
        }
    }

    // 在取模法中，之所以要使用一个数组，是因为元素的位置是按照顺序调整的，不方便保存数组中被覆盖位置的值
    // 优化的思路是，下一个元素的位置调整从被覆盖的位置开始
    // 但是需要注意: 当 n % k = 0 时，会回到起点
    public static void rotate3(int[] nums, int k) {
        int count = 0, len = nums.length;
        // 处理 k > nums.length 的情况
        k = k % len;
        if (k == 0) {
            return; // k = 0, 相当于没有旋转
        }
        for (int start = 0; count < len; start ++ ) {
            int current = start;
            int pre = nums[start];
            do {
                int next = (current + k) % len;
                int tmp = nums[next];
                nums[next] = pre;
                current = next;
                pre = tmp;
                count++;
            } while (current != start);
        }
    }
}
