package com.beau.leetcode.week3;

import org.junit.Test;

import java.util.*;

/**
 * @author BeauFang
 * Date: 2020/7/31
 * 126 https://leetcode-cn.com/problems/word-ladder-ii/
 */
public class WordLadderII {

    /**
     * 1. 通过 bfs 构建图
     * 2. 通过 dfs 输出路径
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // 方便判断单词是否在列表中
        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> ans = new ArrayList<>();
        if (!wordSet.contains(endWord)) {
            return ans;
        }
        // 通过 bfs 构建图, key 是单词， value 是可以转换到的单词
        Map<String, Set<String>> map = new HashMap<>();
        boolean found = bfs(beginWord, endWord, wordSet, map);
        if (!found) {
            return ans;
        }
        // 通过 dfs 输出路径
        LinkedList<String> path = new LinkedList<>();
        path.add(beginWord);
        dfs(beginWord, endWord, path, ans, map);
        return ans;
    }

    private boolean bfs(String beginWord, String endWord, Set<String> wordSet, Map<String, Set<String>> map) {
        // bfs 要点： visited 集合， queue
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.add(beginWord);
        boolean found = false;
        while (!queue.isEmpty()) {
            // 遍历当前层
            int size = queue.size();
            Set<String> nextLevel = new HashSet<>();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                // 对单词每一位做 a - z 转换
                char[] chs = word.toCharArray();
                for (int j = 0; j < chs.length; j++) {
                    char old = chs[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) {
                            continue;
                        }
                        chs[j] = c;
                        String newWord = new String(chs);

                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            if (newWord.equals(endWord)) {
                                found = true;
                            }
                            // 用于将下一次节点加入时去重
                            if (!nextLevel.contains(newWord)) {
                                queue.offer(newWord);
                                nextLevel.add(newWord);
                            }

                            map.computeIfAbsent(word, key -> new HashSet<>());
                            map.get(word).add(newWord);
                        }
                    }
                    chs[j] = old;
                }
            }
            // 如果找到了，直接跳出，因为后面的层路径肯定比当前找到的路径长
            if (found) {
                break;
            }
            visited.addAll(nextLevel);
        }
        return found;
    }

    private void dfs(String beginWord, String endWord, LinkedList<String> path, List<List<String>> ans, Map<String, Set<String>> map) {
        if (beginWord.equals(endWord)) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 如果找不到 beginWord 的后继
        if (!map.containsKey(beginWord)) {
            return;
        }
        for (String word : map.get(beginWord)) {
            path.add(word);
            dfs(word, endWord, path, ans, map);
            path.removeLast();
        }
    }


    @Test
    public void test() {
        String[] words = {"rex", "ted", "tex", "tad", "tax"};
        List<String> wordList = new ArrayList<>();
        Collections.addAll(wordList, words);
        String beginWord = "red";
        String endWord = "tax";
        List<List<String>> res = findLadders(beginWord, endWord, wordList);
        System.out.println(res);
    }

}
