package cn.qiushile.leetcode.medium;

/**
 * 57. Insert Interval
 * Medium
 * 7K
 * 487
 * Companies
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 * Return intervals after the insertion.
 * Example 1:
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * Constraints:
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 105
 * intervals is sorted by starti in ascending order.
 * newInterval.length == 2
 * 0 <= start <= end <= 105
 * Runtime 1 ms Beats 99.26% Memory 44.4 MB Beats 92.90%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/16
 */
public class Solution0057 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{newInterval};
        }
        if (newInterval == null || newInterval.length == 0) {
            return intervals;
        }
        int n = intervals.length;
        if (newInterval[1] < intervals[0][0]) {
            int[][] ans = new int[n + 1][2];
            ans[0] = newInterval;
            System.arraycopy(intervals, 0, ans, 1, n);
            return ans;
        }
        if (newInterval[0] > intervals[n - 1][1]) {
            int[][] ans = new int[n + 1][2];
            System.arraycopy(intervals, 0, ans, 0, n);
            ans[n] = newInterval;
            return ans;
        }

        int start = 0;
        int end = n;
        while (start < end) {
            int mid = (start + end) / 2;
            if (Math.max(intervals[mid][0], newInterval[0]) <= Math.min(intervals[mid][1], newInterval[1])) {
                start = mid;
                end = mid;
                break;
            } else if (newInterval[0] > intervals[mid][0]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        while (start > 0 && newInterval[0] <= intervals[start - 1][1]) {
            start--;
        }
        while (end < n - 1 && newInterval[1] >= intervals[end + 1][0]) {
            end++;
        }
        if (start == end && start < n && start >= 0) {
            if (newInterval[0] >= intervals[start][0] && newInterval[1] <= intervals[start][1]) {
                return intervals;
            }
        }
        boolean isInsert = false;
        if (start > 0 && newInterval[0] > intervals[start - 1][1] && newInterval[1] < intervals[start ][0]) {
            isInsert = true;
        }
        if (newInterval[0] > intervals[start][1] && newInterval[1] < intervals[start + 1][0]) {
            start++;
            isInsert = true;
        }
        if (isInsert) {
            int[][] ans = new int[n + 1][2];
            System.arraycopy(intervals, 0, ans, 0, start);
            ans[start] = newInterval;
            System.arraycopy(intervals, start, ans, start + 1, n - start);
            return ans;
        }

        int[][] ans = new int[n + start - end +
                ((start == n || start == -1)? 1: 0)][2];
        if (start >= 0) {
            System.arraycopy(intervals, 0, ans, 0, start);
        }
        if (start == n) {
            ans[n] = newInterval;
        } else {
            if (start == -1) {
                ans[0] = newInterval;
                start = 0;
            } else {
                ans[start] = new int[2];
                ans[start][0] = Math.min(intervals[start][0], newInterval[0]);
                ans[start][1] = Math.max(intervals[end][1], newInterval[1]);
            }
            if (end < n - 1) {
                System.arraycopy(intervals, end + 1, ans, start + 1, n - end - 1);
            }
        }
        return ans;
    }
}
