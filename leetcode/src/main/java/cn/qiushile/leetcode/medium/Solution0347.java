package cn.qiushile.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 347. Top K Frequent Elements
 * Medium
 * 12.3K
 * 455
 * Companies
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 * Constraints:
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 * <p>
 * <p>
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * Runtime 11 ms Beats 82.89% Memory 44.8 MB Beats 87.77%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/9
 */
public class Solution0347 {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == 0 || nums.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());

        int[] ans = new int[k < list.size() ? k : list.size()];
        for (int i = 0; i < k && i < list.size(); i++) {
            ans[i] = list.get(i).getKey();
        }
        return ans;
    }
}
