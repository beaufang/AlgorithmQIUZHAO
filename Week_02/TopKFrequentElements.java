package com.beau.leetcode.week2;

import java.util.*;

/**
 * @author BeauFang
 * Date: 2020/7/22
 * 347 https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElements {


    // 大顶堆
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // 统计每个元素的个数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((n1, n2) -> map.get(n2) - map.get(n1));
        priorityQueue.addAll(map.keySet());
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = priorityQueue.poll();
        }
        return ans;
    }

    // 小顶堆
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // 统计每个元素的个数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(map::get));
        map.keySet().forEach(key -> {
            priorityQueue.add(key);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        });
        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = priorityQueue.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        TopKFrequentElements solution = new TopKFrequentElements();
        int[] ints = solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println(Arrays.toString(ints));
    }
}
