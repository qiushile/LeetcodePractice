package cn.qiushile.leetcode.hard;

/**
 * 1092. Shortest Common Supersequence
 * Hard
 * 3.7K
 * 56
 * Companies
 * Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. If there are multiple valid strings, return any of them.
 * A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.
 * Example 1:
 * Input: str1 = "abac", str2 = "cab"
 * Output: "cabac"
 * Explanation:
 * str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
 * str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
 * The answer provided is the shortest such string that satisfies these properties.
 * Example 2:
 * Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
 * Output: "aaaaaaaa"
 * Constraints:
 * 1 <= str1.length, str2.length <= 1000
 * str1 and str2 consist of lowercase English letters.
 * WA
 * @author qiushile <qiushile@sina.com>
 * @date 2023/3/28
 */
public class Solution1092 {
    public String shortestCommonSupersequence(String str1, String str2) {
        String s1 = str1.length() >= str2.length()? str1: str2;
        String s2 = str1.length() >= str2.length()? str2: str1;
        if (s1.startsWith(s2) || s1.endsWith(s2)) {
            return s1;
        }
        int n1 = s1.length();
        int n2 = s2.length();
        boolean flag;
        for (int i = 1; i < n2 - 1; i++) {
            flag = true;
            int ni = n2 - i;
            for (int i1 = 0, i2 = i; i2 <= (ni + 1) / 2; i1++, i2++) {
                if (s1.charAt(i1) != s2.charAt(i2) ||
                        s1.charAt(ni - i1 - 1) != s2.charAt(n2 - i2)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return s2.substring(0, i) + s1;
            }
            flag = true;
            for (int i1 = n2 - n1 + i, i2 = 0; i2 <= (ni + 1) / 2; i1++, i2++) {
                if (s1.charAt(i1) != s2.charAt(i2) ||
                        s1.charAt(ni - i2 - 1) != s2.charAt(n2 - i2 - i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return s1 + s2.substring(i);
            }
        }
        return s1 + s2;
    }
}
