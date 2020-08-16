package com.beau.leetcode.week5;

import java.util.*;

/**
 * @author BeauFang
 * Date: 2020/8/13
 * 433 https://leetcode-cn.com/problems/minimum-genetic-mutation/
 */
public class MinimumGeneticMutation {

    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(end)) {
            return -1;
        }
        int step = 0;
        char[] genes = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                char[] chs = queue.poll().toCharArray();
                for (int j = 0; j < chs.length; j++) {
                    char old = chs[j];
                    for (char c : genes) {
                        if (c == old) {
                            continue;
                        }
                        chs[j] = c;
                        String newString = new String(chs);
                        if (!visited.contains(newString) && bankSet.contains(newString)) {
                            queue.offer(newString);
                            visited.add(newString);
                            if (newString.equals(end)) {
                                return step + 1;
                            }
                        }
                    }
                    chs[j] = old;
                }
            }
            step++;
        }
        return -1;
    }
}
