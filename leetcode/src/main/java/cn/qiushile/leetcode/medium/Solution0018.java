package cn.qiushile.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum
 * Solved
 * Medium
 * Topics
 * Companies
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 * Example 1:
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * Example 2:
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 * Constraints:
 * 1 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 *
 * Runtime 4 ms Beats 95.70% of users with Java Memory 44.08 MB Beats 48.33% of users with Java
 * @author qiushile <qiushile@sina.com>
 * @date 2024/4/19
 */
public class Solution0018 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        if (n < 4 || nums[0] * 2L + nums[1] * 2L > target) {
            return new ArrayList<>(0);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n - 3; i++) {
            if (0L + nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            } else if ((i > 0 && nums[i] == nums[i - 1]) || 0L + nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) {
                continue;
            }
            for (int j = i + 1; j < n - 2; j++) {
                if (0L + nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                } else if ((j > i + 1 && nums[j] == nums[j - 1]) || 0L + nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target) {
                    continue;
                }
                for (int k = j + 1; k < n - 1; k++) {
                    if (0L + nums[i] + nums[j] + nums[k] + nums[k + 1] > target) {
                        break;
                    } else if ((k > j + 1 && nums[k] == nums[k - 1]) || 0L + nums[i] + nums[j] + nums[k] + nums[n - 1] < target) {
                        continue;
                    }
                    int t = target - nums[i] - nums[j] - nums[k];
                    int l = k + 1;
                    int r = n - 1;
                    while (l < r) {
                        int mid = l + (r - l) / 2;
                        if (nums[mid] < t) {
                            l = mid + 1;
                        } else if (nums[mid] > t) {
                            r = mid - 1;
                        } else {
                            l = mid;
                            r = mid;
                        }
                    }
                    if (l == r && nums[l] == t) {
                        ans.add(List.of(nums[i], nums[j], nums[k], nums[l]));
                    }
                }
            }
        }
        return ans;
    }
}
