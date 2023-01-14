package cn.qiushile.leetcode.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * 1819. Number of Different Subsequences GCDs
 * Hard
 * 330
 * 35
 * Companies
 * You are given an array nums that consists of positive integers.
 * The GCD of a sequence of numbers is defined as the greatest integer that divides all the numbers in the sequence evenly.
 * For example, the GCD of the sequence [4,6,16] is 2.
 * A subsequence of an array is a sequence that can be formed by removing some elements (possibly none) of the array.
 * For example, [2,5,10] is a subsequence of [1,2,1,2,4,1,5,10].
 * Return the number of different GCDs among all non-empty subsequences of nums.
 * Example 1:
 * Input: nums = [6,10,3]
 * Output: 5
 * Explanation: The figure shows all the non-empty subsequences and their GCDs.
 * The different GCDs are 6, 10, 3, 2, and 1.
 * Example 2:
 * Input: nums = [5,15,40,5,6]
 * Output: 7
 * Constraints:
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 2 * 105
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/14
 */
public class Solution1819 {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 1;
        }
        Set<Integer> ans = new HashSet<>();
        int max = nums[0];
        for (int i = 0; i < n; i++) {
            ans.add(nums[i]);
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        int result = ans.size();
        for (int i = max / 2; i >= 1; i--) {
            if (!ans.contains(i)) {
                int last = -1;
                for (int j = 2; j <= max / i && last != 1; j++) {
                    if (ans.contains(i * j)) {
                        last = last < 0 ? j: gcd(j, last);
                    }
                }
                if (last == 1) {
                    result++;
                }
            }
        }
        return result;
    }

    private int gcd(int a, int b) {
        if (a == b) {
            return a;
        }
        while (b != 0) {
            a %= b;
            if (a == 0) {
                return b;
            }
            b %= a;
            if (b == 0) {
                return a;
            }
        }
        return a;
    }
}
