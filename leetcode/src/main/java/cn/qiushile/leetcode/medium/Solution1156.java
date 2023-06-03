package cn.qiushile.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 1156. Swap For Longest Repeated Character Substring
 * Medium
 * 903
 * 81
 * Companies
 * You are given a string text. You can swap two of the characters in the text.
 * Return the length of the longest substring with repeated characters.
 * Example 1:
 * Input: text = "ababa"
 * Output: 3
 * Explanation: We can swap the first 'b' with the last 'a', or the last 'b' with the first 'a'. Then, the longest repeated character substring is "aaa" with length 3.
 * Example 2:
 * Input: text = "aaabaaa"
 * Output: 6
 * Explanation: Swap 'b' with the last 'a' (or the first 'a'), and we get longest repeated character substring "aaaaaa" with length 6.
 * Example 3:
 * Input: text = "aaaaa"
 * Output: 5
 * Explanation: No need to swap, longest repeated character substring is "aaaaa" with length is 5.
 * Constraints:
 * 1 <= text.length <= 2 * 104
 * text consist of lowercase English characters only.
 * Runtime 17 ms Beats 16.30% Memory 42.2 MB Beats 63.4%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/6/3
 */
public class Solution1156 {
    public int maxRepOpt1(String text) {
        int[] cs = new int[26];
        List<Integer> num = new ArrayList<>();
        List<Integer> cnt = new ArrayList<>();
        int n = 0;
        int last = text.charAt(0) - 'a';
        num.add(last);
        cs[last] = 1;
        cnt.add(1);
        int ans = 1;
        for (int i = 1; i < text.length(); i++) {
            int c = text.charAt(i) - 'a';
            if (c == last) {
                cnt.set(n, cnt.get(n) + 1);
                ans = Math.max(ans, cnt.get(n) + (cs[c] > 1? 1 : 0));
            } else {
                n++;
                num.add(c);
                cnt.add(1);
                cs[c]++;
                last = c;
            }
        }
        ans = Math.max(ans, cnt.get(0) + (cs[num.get(0)] > 1? 1: 0));
        n++;
        for (int i = 1; i < n - 1; i++) {
            if (cnt.get(i).equals(1) && num.get(i - 1).equals(num.get(i + 1))) {
                int k = num.get(i - 1);
                ans = Math.max(ans, cnt.get(i - 1) + cnt.get(i + 1) + (cs[k] > 2? 1: 0));
            }
            ans = Math.max(ans, cnt.get(i) + (cs[num.get(i)] > 1? 1: 0));
        }
        return ans;
    }
}
