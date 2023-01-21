package cn.qiushile.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 491. Non-decreasing Subsequences
 * Medium
 * 2K
 * 169
 * Companies
 * Given an integer array nums, return all the different possible non-decreasing subsequences of the given array with at least two elements. You may return the answer in any order.
 * Example 1:
 * Input: nums = [4,6,7,7]
 * Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 * Example 2:
 * Input: nums = [4,4,3,2,1]
 * Output: [[4,4]]
 * Constraints:
 * 1 <= nums.length <= 15
 * -100 <= nums[i] <= 100
 * Accepted
 * 92.7K
 * Submissions
 * 173.7K
 * Acceptance Rate
 * 53.4%
 * Runtime 25 ms Beats 29.10% Memory 50 MB Beats 56.91%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/20
 */
public class Solution0491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        if (nums.length <= 1) {
            return ans.stream().toList();
        }
        List<Integer> currList = new ArrayList<>();
        currList.add(nums[0]);
        ans.add(currList);
        List<List<Integer>> tmp = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            for (List<Integer> list: ans) {
                if (num >= list.get(list.size() - 1)) {
                    currList = new ArrayList<>(list);
                    currList.add(num);
                    tmp.add(currList);
                }
            }
            currList = new ArrayList<>();
            currList.add(num);
            ans.add(currList);
            if (!tmp.isEmpty()) {
                ans.addAll(tmp);
                tmp = new ArrayList<>();
            }
        }
        return ans.stream().filter(l -> l.size() > 1).toList();
    }
}
