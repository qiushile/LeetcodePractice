package cn.qiushile.leetcode.medium;

/**
 * 1574. Shortest Subarray to be Removed to Make Array Sorted
 * Medium
 * 1.4K
 * 48
 * Companies
 * Given an integer array arr, remove a subarray (can be empty) from arr such that the remaining elements in arr are non-decreasing.
 * Return the length of the shortest subarray to remove.
 * A subarray is a contiguous subsequence of the array.
 * Example 1:
 * Input: arr = [1,2,3,10,4,2,3,5]
 * Output: 3
 * Explanation: The shortest subarray we can remove is [10,4,2] of length 3. The remaining elements after that will be [1,2,3,3,5] which are sorted.
 * Another correct solution is to remove the subarray [3,10,4].
 * Example 2:
 * Input: arr = [5,4,3,2,1]
 * Output: 4
 * Explanation: Since the array is strictly decreasing, we can only keep a single element. Therefore we need to remove a subarray of length 4, either [5,4,3,2] or [4,3,2,1].
 * Example 3:
 * Input: arr = [1,2,3]
 * Output: 0
 * Explanation: The array is already non-decreasing. We do not need to remove any elements.
 * Constraints:
 * 1 <= arr.length <= 105
 * 0 <= arr[i] <= 109
 * Runtime 2 ms Beats 60.56% Memory 60.2 MB Beats 16.90%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/3/25
 */
public class Solution1574 {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return 0;
        }
        int left = 0;
        int right = n - 1;
        while (left < n - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }
        if (right == 0) {
            return 0;
        }
        if (arr[0] > arr[n - 1]) {
            return n - Math.max(left + 1, n - right);
        }
        if (arr[left] <= arr[right]) {
            return right - left - 1;
        }
        int i = -1;
        int j = right;
        while (i < left && arr[i + 1] <= arr[right]) {
            i++;
        }
        int ans = Math.max(left + 1, Math.max(n - right, i + 1 + n - right));
        while (i < left && j < n) {
            i++;
            while (j < n && arr[j] < arr[i]) {
                j++;
            }
            if (j < n) {
                ans = Math.max(ans, i + 1 + n - j);
            }
        }
        return n - ans;
    }
}
