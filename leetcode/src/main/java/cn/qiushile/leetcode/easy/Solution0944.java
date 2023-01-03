package cn.qiushile.leetcode.easy;

/**
 * 944. Delete Columns to Make Sorted
 * Easy
 * 470
 * 2.1K
 * Companies
 * You are given an array of n strings strs, all of the same length.
 * The strings can be arranged such that there is one on each line, making a grid. For example, strs = ["abc", "bce", "cae"] can be arranged as:
 * abc
 * bce
 * cae
 * You want to delete the columns that are not sorted lexicographically. In the above example (0-indexed), columns 0 ('a', 'b', 'c') and 2 ('c', 'e', 'e') are sorted while column 1 ('b', 'c', 'a') is not, so you would delete column 1.
 * Return the number of columns that you will delete.
 * Example 1:
 * Input: strs = ["cba","daf","ghi"]
 * Output: 1
 * Explanation: The grid looks as follows:
 *   cba
 *   daf
 *   ghi
 * Columns 0 and 2 are sorted, but column 1 is not, so you only need to delete 1 column.
 * Example 2:
 * Input: strs = ["a","b"]
 * Output: 0
 * Explanation: The grid looks as follows:
 *   a
 *   b
 * Column 0 is the only column and is sorted, so you will not delete any columns.
 * Example 3:
 * Input: strs = ["zyx","wvu","tsr"]
 * Output: 3
 * Explanation: The grid looks as follows:
 *   zyx
 *   wvu
 *   tsr
 * All 3 columns are not sorted, so you will delete all 3.
 * Constraints:
 * n == strs.length
 * 1 <= n <= 100
 * 1 <= strs[i].length <= 1000
 * strs[i] consists of lowercase English letters.
 * Runtime 9 ms Beats 84.49% Memory 50.9 MB Beats 6.52%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/3
 */
public class Solution0944 {
    public int minDeletionSize(String[] strs) {
        char[][] chars = new char[strs.length][];
        for (int i = 0; i < strs.length; i++) {
            chars[i] = strs[i].toCharArray();
        }
        int ans = 0;
        for (int i = 0; i < chars[0].length; i++) {
            for (int j = 1; j < chars.length; j++) {
                if (chars[j][i] < chars[j - 1][i]) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
