package cn.qiushile.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 1234. Replace the Substring for Balanced String
 * Medium
 * 970
 * 184
 * Companies
 * You are given a string s of length n containing only four kinds of characters: 'Q', 'W', 'E', and 'R'.
 * A string is said to be balanced if each of its characters appears n / 4 times where n is the length of the string.
 * Return the minimum length of the substring that can be replaced with any other string of the same length to make s balanced. If s is already balanced, return 0.
 * Example 1:
 * Input: s = "QWER"
 * Output: 0
 * Explanation: s is already balanced.
 * Example 2:
 * Input: s = "QQWE"
 * Output: 1
 * Explanation: We need to replace a 'Q' to 'R', so that "RQWE" (or "QRWE") is balanced.
 * Example 3:
 * Input: s = "QQQW"
 * Output: 2
 * Explanation: We can replace the first "QQ" to "ER".
 * Constraints:
 * n == s.length
 * 4 <= n <= 105
 * n is a multiple of 4.
 * s contains only 'Q', 'W', 'E', and 'R'.
 * Runtime 14 ms Beats 48.48% Memory 44 MB Beats 15.15%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/2/13
 */
public class Solution1234 {
    public int balancedString(String s) {
        int ns = s.length();
        Integer[] freq = new Integer[]{0,0,0,0};
        int[] sa = new int[ns];
        Map<Character, Integer> map = new HashMap<>();
        map.put('Q', 0);
        map.put('W', 1);
        map.put('E', 2);
        map.put('R', 3);
        for (int i = 0; i < ns; i++) {
            Integer curr = map.get(s.charAt(i));
            freq[curr]++;
            sa[i] = curr;
        }
        int n = ns / 4;
        int diff = 0;
        for (int i = 0; i < 4; i++) {
            if (freq[i] > n) {
                freq[i] -= n;
                diff++;
            } else {
                freq[i] = null;
            }
        }
        if (diff == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < ns; i++) {
            if (freq[sa[i]] != null) {
                freq[sa[i]]--;
                if (freq[sa[i]] == 0) {
                    diff--;
                    if (diff == 0) {
                        right = i;
                        break;
                    }
                }
            }
        }
        for (left = 0; left < right; left++) {
            if (freq[sa[left]] != null) {
                if (freq[sa[left]] == 0) {
                    break;
                }
                freq[sa[left]]++;
            }
        }
        int min = right - left + 1;
        for (right = right + 1; right < ns; right++) {
            if (freq[sa[right]] != null) {
                freq[sa[right]]--;
                if (freq[sa[right]] == 0) {
                    diff--;
                }
            }
            if (freq[sa[left]] != null && freq[sa[left]] >= 0) {
                if (freq[sa[left]] == 0) {
                    diff++;
                }
                freq[sa[left]]++;
                left++;
                continue;
            }
            while (diff == 0) {
                if (freq[sa[left]] == null) {
                    left++;
                } else {
                    if (freq[sa[left]] == 0) {
                        min = Math.min(min, right - left + 1);
                        break;
                    } else {
                        freq[sa[left]]++;
                        left++;
                    }
                }
            }
        }
        return min;
    }
}
