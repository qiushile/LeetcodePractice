package cn.qiushile.leetcode.hard;

import java.util.Map;
import java.util.TreeMap;

/**
 * 2276. Count Integers in Intervals
 * Solved
 * Hard
 * Topics
 * Companies
 * Hint
 * Given an empty set of intervals, implement a data structure that can:
 * Add an interval to the set of intervals.
 * Count the number of integers that are present in at least one interval.
 * Implement the CountIntervals class:
 * CountIntervals() Initializes the object with an empty set of intervals.
 * void add(int left, int right) Adds the interval [left, right] to the set of intervals.
 * int count() Returns the number of integers that are present in at least one interval.
 * Note that an interval [left, right] denotes all the integers x where left <= x <= right.
 * Example 1:
 * Input
 * ["CountIntervals", "add", "add", "count", "add", "count"]
 * [[], [2, 3], [7, 10], [], [5, 8], []]
 * Output
 * [null, null, null, 6, null, 8]
 * Explanation
 * CountIntervals countIntervals = new CountIntervals(); // initialize the object with an empty set of intervals.
 * countIntervals.add(2, 3);  // add [2, 3] to the set of intervals.
 * countIntervals.add(7, 10); // add [7, 10] to the set of intervals.
 * countIntervals.count();    // return 6
 *                            // the integers 2 and 3 are present in the interval [2, 3].
 *                            // the integers 7, 8, 9, and 10 are present in the interval [7, 10].
 * countIntervals.add(5, 8);  // add [5, 8] to the set of intervals.
 * countIntervals.count();    // return 8
 *                            // the integers 2 and 3 are present in the interval [2, 3].
 *                            // the integers 5 and 6 are present in the interval [5, 8].
 *                            // the integers 7 and 8 are present in the intervals [5, 8] and [7, 10].
 *                            // the integers 9 and 10 are present in the interval [7, 10].
 * Constraints:
 * 1 <= left <= right <= 109
 * At most 105 calls in total will be made to add and count.
 * At least one call will be made to count.
 * Runtime 61 ms Beats 96.64% of users with Java Memory 93.63 MB Beats 36.98% of users with Java
 * @author qiushile <qiushile@sina.com>
 * @date 2023/12/16
 */
public class Solution2276 {

    public static class CountIntervals {

        private TreeMap<Integer, Integer> map = new TreeMap<>();
        private int cnt = 0;

        public CountIntervals() {}

        public void add(int left, int right) {
            int minus = 0;
            Map.Entry<Integer, Integer> e = map.floorEntry(left);
            if (e != null && e.getValue() >= left) {
                if (e.getValue() >= right) {
                    return;
                }
                minus += e.getValue() - e.getKey() + 1;
                left = e.getKey();
                map.remove(e.getKey());
            }
            Integer k = left;
            while ((e = map.higherEntry(k)) != null) {
                if (e.getKey() <= right + 1) {
                    minus += e.getValue() - e.getKey() + 1;
                    k = e.getValue();
                    map.remove(e.getKey());
                    if (k >= right) {
                        right = k;
                        break;
                    }
                } else {
                    break;
                }
            }
            map.put(left, right);
            cnt += right - left + 1 - minus;
        }

        public int count() {
            return cnt;
        }
    }

}
