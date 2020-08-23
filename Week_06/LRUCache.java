package com.beau.leetcode.week6;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author BeauFang
 * Date: 2020/8/17
 * 146 https://leetcode-cn.com/problems/lru-cache/
 */
public class LRUCache extends LinkedHashMap<Integer, Integer>{
    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
