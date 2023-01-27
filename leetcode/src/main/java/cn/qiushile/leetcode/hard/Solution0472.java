package cn.qiushile.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 472. Concatenated Words
 * Hard
 * 3K
 * 249
 * Companies
 * Given an array of strings words (without duplicates), return all the concatenated words in the given list of words.
 * A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.
 * Example 1:
 * Input: words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
 * Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
 * "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
 * "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
 * Example 2:
 * Input: words = ["cat","dog","catdog"]
 * Output: ["catdog"]
 * Constraints:
 * 1 <= words.length <= 104
 * 1 <= words[i].length <= 30
 * words[i] consists of only lowercase English letters.
 * All the strings of words are unique.
 * 1 <= sum(words[i].length) <= 105
 * Runtime 86 ms Beats 45.23% Memory 47.6 MB Beats 74.1%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/27
 */
public class Solution0472 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Set<String> ans = new HashSet<>();
        Set<String> wordsSet = new HashSet<>();
        for (String word : words) {
            if (wordsSet.contains(word)) {
                ans.add(word);
            } else {
                boolean[] dp = new boolean[word.length() + 1];
                dp[0] = true;
                for (int i = 1; i <= word.length(); i++) {
                    for (int j = 0; !dp[i] && j < i; j++) {
                        dp[i] = dp[j] && wordsSet.contains(word.substring(j, i));
                    }
                }
                if (dp[word.length()]) {
                    ans.add(word);
                }
                wordsSet.add(word);
            }
        }
        return new ArrayList<>(ans);
    }
}
