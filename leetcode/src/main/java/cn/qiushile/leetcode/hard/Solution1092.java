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
 * Runtime 14 ms Beats 86.66% Memory 46 MB Beats 68.8%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/3/28
 */
public class Solution1092 {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][m] = n - i;
        }
        for (int i = m - 1; i >= 0; i--) {
            dp[n][i] = m - i;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (str1.charAt(i) == str2.charAt(j)) {
                sb.append(str1.charAt(i));
                i++;
                j++;
            } else if (dp[i][j] == dp[i + 1][j] + 1) {
                sb.append(str1.charAt(i));
                i++;
            } else {
                sb.append(str2.charAt(j));
                j++;
            }
        }
        if (i < n) {
            sb.append(str1.substring(i));
        } else if (j < m) {
            sb.append(str2.substring(j));
        }
        return sb.toString();
    }
}
