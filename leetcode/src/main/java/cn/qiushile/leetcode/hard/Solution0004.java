package cn.qiushile.leetcode.hard;

/**
 * 4. Median of Two Sorted Arrays
 * Hard
 * 21.6K
 * 2.4K
 * Companies
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 * Example 1:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * Constraints:
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/15
 */
public class Solution0004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        boolean isOdd = n % 2 == 1;
        int skip = n / 2 - (isOdd? 0: 1);
        if (n1 == 0 && n2 == 0) {
            return 0.0;
        } else if (n2 == 0) {
            return isOdd? nums1[n1 / 2] : 0.5 * (nums1[n1 / 2 - 1] + nums1[n1 / 2]);
        } else if (n1 == 0) {
            return isOdd? nums2[n2 / 2] : 0.5 * (nums2[n2 / 2 - 1] + nums2[n2 / 2]);
        }
        int p1 = -1;
        int p2 = -1;
        int l1 = (n1 - 1) / 2;
        int l2 = (n2 - 1) / 2;
        if (nums1[l1] < nums2[l2]) {
            p1 = l1;
        } else {
            p2 = l2;
        }
        int move = skip;
        while (move > 1 && p1 + p2 + 2 < skip) {
            move = (skip - p1 - p2 - 2);
            l1 = p1 + move / 2;
            l2 = p2 + move / 2;
            if (l1 >= n1) {
                l1 = n1 - 1;
            }
            if (l2 >= n2) {
                l2 = n2 - 1;
            }
            if (nums1[l1] < nums2[l2]) {
                p1 = l1;
            } else {
                p2 = l2;
            }
        }
        while (p1 + p2 + 2 < skip) {
            if (p1 == n1 - 1) {
                p2++;
            } else if (p2 == n2 - 1) {
                p1++;
            } else if (nums1[p1 + 1] < nums2[p2 + 1]) {
                p1++;
            } else {
                p2++;
            }
        }
        if (p1 == n1 - 1) {
            return isOdd? nums2[p2 + 1] : 0.5 * (nums2[p2 + 1] + nums2[p2 + 2]);
        }
        if (p2 == n2 - 1) {
            return isOdd? nums1[p1 + 1] : 0.5 * (nums1[p1 + 1] + nums1[p1 + 2]);
        }
        return isOdd? Math.min(nums1[p1 + 1], nums2[p2 + 1]): 0.5 * (nums1[p1 + 1] + nums2[p2 + 1]);
    }
}
