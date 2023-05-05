package cn.qiushile.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 336. Palindrome Pairs
 * Hard
 * 4.2K
 * 432
 * Companies
 * You are given a 0-indexed array of unique strings words.
 * A palindrome pair is a pair of integers (i, j) such that:
 * 0 <= i, j < words.length,
 * i != j, and
 * words[i] + words[j] (the concatenation of the two strings) is a
 * palindrome
 * Return an array of all the palindrome pairs of words.
 * Example 1:
 * Input: words = ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]]
 * Explanation: The palindromes are ["abcddcba","dcbaabcd","slls","llssssll"]
 * Example 2:
 * Input: words = ["bat","tab","cat"]
 * Output: [[0,1],[1,0]]
 * Explanation: The palindromes are ["battab","tabbat"]
 * Example 3:
 * Input: words = ["a",""]
 * Output: [[0,1],[1,0]]
 * Explanation: The palindromes are ["a","a"]
 * Constraints:
 * 1 <= words.length <= 5000
 * 0 <= words[i].length <= 300
 * words[i] consists of lowercase English letters.
 * Runtime 298 ms Beats 78.97% Memory 51.4 MB Beats 86.21%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/5/4
 */
public class Solution0336 {

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = words.length;
        if (n < 2) {
            return ans;
        }

        Map<String, Integer> map = new HashMap<>();
        Set<Integer> lens = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            map.put(words[i], i);
            lens.add(words[i].length());
        }
        for (int i = 0; i < n; i++) {
            String w = words[i];
            int len = w.length();
            String re = new StringBuilder(w).reverse().toString();
            if (map.containsKey(re) && !map.get(re).equals(i)) {
                ans.add(List.of(i, map.get(re)));
            }
            for (Integer k : lens) {
                if (k.equals(len)) {
                    break;
                }
                String part = re.substring(0, k);
                if (map.containsKey(part) && !map.get(part).equals(i) && isPalindrome(re, k, len - 1)) {
                    ans.add(List.of(map.get(part), i));
                }
                part = re.substring(len - k);
                if (map.containsKey(part) && !map.get(part).equals(i) && isPalindrome(re, 0, len - 1 - k)) {
                    ans.add(List.of(i, map.get(part)));
                }
            }
        }
        return ans;
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
