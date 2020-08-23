package com.beau.leetcode.week6;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author BeauFang
 * Date: 2020/8/17
 * 1122 https://leetcode-cn.com/problems/relative-sort-array/
 */
public class RelativeSortArray {

    // 直接使用计数排序
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // arr1.length, arr2.length <= 1000
        int[] counter = new int[1001];
        // 0 <= arr1[i], arr2[i] <= 1000
        for (int a : arr1) {
            counter[a]++;
        }
        int index = 0;
        // 将 arr2 中包含的元素优先放入 arr1
        for (int a : arr2) {
            while (counter[a] > 0) {
                arr1[index++] = a;
                counter[a]--;
            }
        }
        // 将剩余的元素拷贝到 arr1
        for (int i = 0; i < counter.length; i++) {
            while (counter[i] > 0) {
                arr1[index++] = i;
                counter[i]--;
            }
        }
        return arr1;
    }

    /**
     * 分为三种情况：
     * 1. 两个元素都出现在了 arr2 中，直接比较索引
     * 2. 只有一个元素出现在了 arr2 中，可以认为出现在 arr2 中的元素更新
     * 3. 如果两个元素都没有出现在 arr2 中，直接比较其实际大小
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        // 建立值到索引的映射
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        List<Integer> res = Arrays.stream(arr1).boxed().sorted((o1, o2) -> {
            if (map.containsKey(o1) || map.containsKey(o2)) {
                // arr1.length, arr2.length <= 1000
                return map.getOrDefault(o1, 1000) - map.getOrDefault(o2, 1000);
            } else {
                return o1 - o2;
            }
        }).collect(Collectors.toList());
        return res.stream().mapToInt(i -> i).toArray();
    }


}
