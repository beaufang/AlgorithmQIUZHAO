package com.beau.leetcode.week3;

import java.util.*;

/**
 * @author BeauFang
 * Date: 2020/7/28
 * 127 https://leetcode-cn.com/problems/word-ladder/
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 将 wordList 转换成 hashSet 方便判断
        Set<String> set = new HashSet<>(wordList);
        set.remove(beginWord);
        // 广度优先搜索
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        visited.add(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int l = 0; l < level; l++) {
                String str = queue.poll();
                // 对 str 的每个字符做 a-z 的变换，查找单词列表是否存在
                char[] chars = str.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char originalChar = chars[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (j == originalChar) {
                            continue;
                        }
                        chars[i] = j;
                        String newString = new String(chars);
                        if (set.contains(newString)) {
                            if (newString.equals(endWord)) {
                                return step + 1;
                            }
                            if (!visited.contains(newString)) {
                                queue.add(newString);
                                visited.add(newString);
                            }
                        }
                        // 恢复
                        chars[i] = originalChar;
                    }
                }
            }
            step++;
        }
        return 0;
    }

    // 双向 bfs
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        int step = 1;
        Set<String> visited = new HashSet<>();
        Set<String> startQueue = new HashSet<>();
        Set<String> endQueue = new HashSet<>();
        startQueue.add(beginWord);
        endQueue.add(endWord);
        while (!startQueue.isEmpty() && !endQueue.isEmpty()) {
            // 总是从较小的队列来遍历
            if (startQueue.size() > endQueue.size()) {
                Set<String> tmp = startQueue;
                startQueue = endQueue;
                endQueue = tmp;
            }
            Set<String> nextLevel = new HashSet<>();
            for (String word : startQueue) {
                char[] chs = word.toCharArray();
                for (int j = 0; j < chs.length; j++) {
                    char old = chs[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) {
                            continue;
                        }
                        chs[j] = c;
                        String newWord = new String(chs);
                        if (wordSet.contains(newWord)) {
                            if (endQueue.contains(newWord)) {
                                return step + 1;
                            }
                            if (!visited.contains(newWord)) {
                                nextLevel.add(newWord);
                            }
                            visited.add(newWord);

                        }
                    }
                    chs[j] = old;
                }
            }
            startQueue = nextLevel;
            step++;
        }
        return 0;
    }
}
