package cn.qiushile.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

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
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/20
 */
public class Solution0491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length <= 1) {
            return ans;
        }
        List<Integer> curr = new ArrayList<>();
        curr.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[i - 1]) {
                curr.add(nums[i]);
            } else {
                ans.addAll(computeAll(curr));
                curr = new ArrayList<>();
                curr.add(nums[i]);
            }
        }
        ans.addAll(computeAll(curr));
        return ans;
    }

    private List<List<Integer>> computeAll(List<Integer> list) {
        int n = list.size();
        if (n <= 1) {
            return Collections.emptyList();
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        int start = 0;
        int index = 0;
        while (index <= n) {
            if (index == n || !list.get(index).equals(list.get(start))) {
                int times = index - start;
                List<Integer> suffix = new ArrayList<>(times);
                List<List<Integer>> tmp = new ArrayList<>();
                while (times > 0) {
                    suffix.add(list.get(start));
                    tmp.addAll(ans.stream().map(l -> Stream.concat(l.stream(), suffix.stream()).toList()).toList());
                    times--;
                }
                ans.addAll(tmp);
                if (index == n) {
                    break;
                }
                start = index;
            }
            index++;
        }
        return ans.stream().filter(l -> l.size() > 1).toList();
    }
}
