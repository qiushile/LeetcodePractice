package cn.qiushile.leetcode.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 140. Word Break II
 * Solved
 * Hard
 * Topics
 * Companies
 * Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 * Example 1:
 * Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * Output: ["cats and dog","cat sand dog"]
 * Example 2:
 * Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
 * Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: []
 * Constraints:
 * 1 <= s.length <= 20
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 10
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 * Input is generated in a way that the length of the answer doesn't exceed 105.
 *
 * Runtime 3 ms Beats 56.38% of users with Java Memory 41.69 MB Beats 54.99% of users with Java
 * @author qiushile <qiushile@sina.com>
 * @date 2024/5/26
 */
public class Solution0140 {

    class Trie {
        boolean isWord = false;
        Trie[] next = new Trie[26];
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        List<String>[] list = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        list[0].add("");
        Trie trie = new Trie();
        for (String word : wordDict) {
            Trie t = trie;
            for (int i = 0; i < word.length(); i++) {
                int k = word.charAt(i) - 'a';
                if (t.next[k] == null) {
                    t.next[k] = new Trie();
                }
                t = t.next[k];
            }
            t.isWord = true;
        }
        int[] cs = s.chars().map(c -> (int) (c - 'a')).toArray();
        for (int i = 0; i < n; i++) {
            if (list[i].isEmpty()) {
                continue;
            }
            Trie t = trie;
            for (int j = i; j < n; j++) {
                if (t.next[cs[j]] == null) {
                    break;
                }
                t = t.next[cs[j]];
                if (t.isWord) {
                    String toAppend = " " + s.substring(i, j + 1);
                    for (String str : list[i]) {
                        list[j + 1].add(str + toAppend);
                    }
                }
            }
        }
        return list[n].stream().map(x -> x.substring(1)).collect(Collectors.toList());
    }
}
