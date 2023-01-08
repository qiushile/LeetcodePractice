package cn.qiushile.leetcode.contest;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 6284. Make Number of Distinct Characters Equal
 * User Accepted:2016
 * User Tried:5458
 * Total Accepted:2061
 * Total Submissions:14448
 * Difficulty:Medium
 * You are given two 0-indexed strings word1 and word2.
 * A move consists of choosing two indices i and j such that 0 <= i < word1.length and 0 <= j < word2.length and swapping word1[i] with word2[j].
 * Return true if it is possible to get the number of distinct characters in word1 and word2 to be equal with exactly one move. Return false otherwise.
 * Example 1:
 * Input: word1 = "ac", word2 = "b"
 * Output: false
 * Explanation: Any pair of swaps would yield two distinct characters in the first string, and one in the second string.
 * Example 2:
 * Input: word1 = "abcc", word2 = "aab"
 * Output: true
 * Explanation: We swap index 2 of the first string with index 0 of the second string. The resulting strings are word1 = "abac" and word2 = "cab", which both have 3 distinct characters.
 * Example 3:
 * Input: word1 = "abcde", word2 = "fghij"
 * Output: true
 * Explanation: Both resulting strings will have 5 distinct characters, regardless of which indices we swap.
 * Constraints:
 * 1 <= word1.length, word2.length <= 105
 * word1 and word2 consist of only lowercase English letters.
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/8
 */
public class Solution6284 {
    public boolean isItPossible(String word1, String word2) {
        Set<Character> first1 = new HashSet<>();
        Set<Character> first2 = new HashSet<>();
        Set<Character> sec1 = new HashSet<>();
        Set<Character> sec2 = new HashSet<>();
        char[] ch1 = word1.toCharArray();
        char[] ch2 = word2.toCharArray();
        for (int i = 0; i < ch1.length; i++) {
            if (first1.contains(ch1[i])) {
                if (!sec1.contains(ch1[i])) {
                    sec1.add(ch1[i]);
                } else {
                    first1.add(ch1[i]);
                }
            }
        }
        for (int i = 0; i < ch2.length; i++) {
            if (first2.contains(ch2[i])) {
                if (!sec2.contains(ch2[i])) {
                    sec2.add(ch2[i]);
                } else {
                    first2.add(ch2[i]);
                }
            }
        }
        if (first1.size() == first2.size()) {
            if ((sec1.isEmpty() && sec2.isEmpty()) || (!sec1.isEmpty() && !sec2.isEmpty())) {
                return true;
            } else {
                // have no element in common
                if (Collections.disjoint(first1, first2)) {
                    if (sec1.size() == first1.size() || sec2.size() == first2.size()) {
                        return false;
                    }
                }
                return true;
            }
        } else {
            if (first1.size() - first2.size() == 1) {
                if (sec1.isEmpty() && sec2.isEmpty()) {
                    return false;
                } else if (Collections.disjoint(first1, first2)) {
                    if (sec1.isEmpty() && sec2.isEmpty()) {
                        return false;
                    } else if (first1.size() > sec1.size() || (!sec1.isEmpty() && !sec2.isEmpty())) {
                        return true;
                    }
                } else {
                }
            } else if (first2.size() - first1.size() == 1) {

            }
            return false;
        }
    }
}
