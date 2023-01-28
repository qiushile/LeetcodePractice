package cn.qiushile.leetcode.hard;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * 352. Data Stream as Disjoint Intervals
 * Hard
 * 1.3K
 * 288
 * Companies
 * Given a data stream input of non-negative integers a1, a2, ..., an, summarize the numbers seen so far as a list of disjoint intervals.
 * Implement the SummaryRanges class:
 * SummaryRanges() Initializes the object with an empty stream.
 * void addNum(int value) Adds the integer value to the stream.
 * int[][] getIntervals() Returns a summary of the integers in the stream currently as a list of disjoint intervals [starti, endi]. The answer should be sorted by starti.
 * Example 1:
 * Input
 * ["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
 * [[], [1], [], [3], [], [7], [], [2], [], [6], []]
 * Output
 * [null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]], null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]
 * Explanation
 * SummaryRanges summaryRanges = new SummaryRanges();
 * summaryRanges.addNum(1);      // arr = [1]
 * summaryRanges.getIntervals(); // return [[1, 1]]
 * summaryRanges.addNum(3);      // arr = [1, 3]
 * summaryRanges.getIntervals(); // return [[1, 1], [3, 3]]
 * summaryRanges.addNum(7);      // arr = [1, 3, 7]
 * summaryRanges.getIntervals(); // return [[1, 1], [3, 3], [7, 7]]
 * summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
 * summaryRanges.getIntervals(); // return [[1, 3], [7, 7]]
 * summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
 * summaryRanges.getIntervals(); // return [[1, 3], [6, 7]]
 * Constraints:
 * 0 <= value <= 104
 * At most 3 * 104 calls will be made to addNum and getIntervals.
 * Follow up: What if there are lots of merges and the number of disjoint intervals is small compared to the size of the data stream?
 * Runtime 123 ms Beats 31.9% Memory 77.2 MB Beats 5.88%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/28
 */
public class Solution0352 {


    public static class SummaryRanges {

        private int[] links = new int[10001];
        private Map<Integer, Integer> beginEnd = new TreeMap<>();
        private Map<Integer, Integer> endBegin = new TreeMap<>();

        public SummaryRanges() {
            Arrays.fill(links, -1);

        }

        public void addNum(int value) {
            if (links[value] != -1) {
                return;
            }
            boolean isStart = value == 0 || links[value - 1] == -1;
            boolean isEnd = value == 10000 || links[value + 1] == -1;
            if (isStart && isEnd) {
                links[value] = value;
                beginEnd.put(value, value);
                endBegin.put(value, value);
            } else if (isStart) {
                int rightEnd = beginEnd.get(value + 1);
                links[value] = value;
                links[rightEnd] = value;
                endBegin.put(rightEnd, value);
                beginEnd.put(value, rightEnd);
                beginEnd.remove(value + 1);
            } else if (isEnd) {
                int leftStart = endBegin.get(value - 1);
                links[value] = leftStart;
                beginEnd.put(leftStart, value);
                endBegin.put(value, leftStart);
                endBegin.remove(value - 1);
            } else {
                int leftStart = endBegin.get(value - 1);
                int rightEnd = beginEnd.get(value + 1);
                links[rightEnd] = leftStart;
                links[value] = leftStart;
                links[value + 1] = leftStart;
                beginEnd.remove(value + 1);
                endBegin.remove(value - 1);
                beginEnd.put(leftStart, rightEnd);
                endBegin.put(rightEnd, leftStart);
            }
        }

        public int[][] getIntervals() {
            return beginEnd.entrySet().stream().map(e -> new int[]{e.getKey(), e.getValue()}).toArray(s -> new int[beginEnd.size()][2]);
        }
    }
}
