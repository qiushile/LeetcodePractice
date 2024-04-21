package cn.qiushile.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. Combination Sum
 * Solved
 * Medium
 * Topics
 * Companies
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
 * frequency
 *  of at least one of the chosen numbers is different.
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * Example 2:
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * Example 3:
 * Input: candidates = [2], target = 1
 * Output: []
 * Constraints:
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * All elements of candidates are distinct.
 * 1 <= target <= 40
 *
 * Runtime 3 ms Beats 33.88% of users with Java Memory 44.53 MB Beats 45.64% of users with Java
 * @author qiushile <qiushile@sina.com>
 * @date 2024/4/20
 */
public class Solution0039 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        if (target < candidates[0]) {
            return ans;
        }
        List<List<Integer>> comb = comb(candidates, target, candidates.length - 1);
        return comb == null? new ArrayList<>(0): comb;
    }

    private List<List<Integer>> comb(int[] cs, int target, int end) {
        List<List<Integer>> ans = new ArrayList<>();
        if (target == 0) {
            ans.add(new ArrayList<>());
            return ans;
        } else if (end < 0 || (end == 0 && target < cs[0])) {
            return null;
        }
        if (cs[end] <= target) {
            List<List<Integer>> ret = comb(cs, target - cs[end], end);
            if (ret != null) {
                for (List<Integer> r : ret) {
                    r.add(cs[end]);
                }
                ans.addAll(ret);
            }
        }
        if (end > 0 && target >= cs[0]) {
            List<List<Integer>> ret = comb(cs, target, end - 1);
            if (ret != null) {
                ans.addAll(ret);
            }
        }
        return ans.isEmpty()? null: ans;
    }
}
