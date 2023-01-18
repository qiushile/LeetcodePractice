package cn.qiushile.leetcode.hard;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.TreeMap;

/**
 * 1825. Finding MK Average
 * Hard
 * 307
 * 95
 * Companies
 * You are given two integers, m and k, and a stream of integers. You are tasked to implement a data structure that calculates the MKAverage for the stream.
 * The MKAverage can be calculated using these steps:
 * If the number of the elements in the stream is less than m you should consider the MKAverage to be -1. Otherwise, copy the last m elements of the stream to a separate container.
 * Remove the smallest k elements and the largest k elements from the container.
 * Calculate the average value for the rest of the elements rounded down to the nearest integer.
 * Implement the MKAverage class:
 * MKAverage(int m, int k) Initializes the MKAverage object with an empty stream and the two integers m and k.
 * void addElement(int num) Inserts a new element num into the stream.
 * int calculateMKAverage() Calculates and returns the MKAverage for the current stream rounded down to the nearest integer.
 * Example 1:
 * Input
 * ["MKAverage", "addElement", "addElement", "calculateMKAverage", "addElement", "calculateMKAverage", "addElement", "addElement", "addElement", "calculateMKAverage"]
 * [[3, 1], [3], [1], [], [10], [], [5], [5], [5], []]
 * Output
 * [null, null, null, -1, null, 3, null, null, null, 5]
 * Explanation
 * MKAverage obj = new MKAverage(3, 1);
 * obj.addElement(3);        // current elements are [3]
 * obj.addElement(1);        // current elements are [3,1]
 * obj.calculateMKAverage(); // return -1, because m = 3 and only 2 elements exist.
 * obj.addElement(10);       // current elements are [3,1,10]
 * obj.calculateMKAverage(); // The last 3 elements are [3,1,10].
 *                           // After removing smallest and largest 1 element the container will be [3].
 *                           // The average of [3] equals 3/1 = 3, return 3
 * obj.addElement(5);        // current elements are [3,1,10,5]
 * obj.addElement(5);        // current elements are [3,1,10,5,5]
 * obj.addElement(5);        // current elements are [3,1,10,5,5,5]
 * obj.calculateMKAverage(); // The last 3 elements are [5,5,5].
 *                           // After removing smallest and largest 1 element the container will be [5].
 *                           // The average of [5] equals 5/1 = 5, return 5
 * Constraints:
 * 3 <= m <= 105
 * 1 <= k*2 < m
 * 1 <= num <= 105
 * At most 105 calls will be made to addElement and calculateMKAverage.
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/18
 */
public class Solution1825 {
    public static class MKAverage {

        private int m;
        private int k;
        private int size = 0;
        private long sum = 0L;

        private Queue<Integer> q = new ArrayDeque<>(m);
        private TreeMap<Integer, Integer> left = new TreeMap<>();
        private TreeMap<Integer, Integer> middle = new TreeMap<>();
        private TreeMap<Integer, Integer> right = new TreeMap<>();

        public MKAverage(int m, int k) {
            this.m = m;
            this.k = k;
        }

        private void removeOne(TreeMap<Integer, Integer> map, int num) {
            Integer rmCount = map.get(num);
            if (rmCount.equals(1)) {
                map.remove(num);
            } else {
                map.put(num, rmCount - 1);
            }
        }

        private void edgeFix(TreeMap<Integer, Integer> prev, TreeMap<Integer, Integer> next) {
            if (next.firstKey() < prev.lastKey()) {
                Integer nextKey = next.firstKey();
                Integer nextCount = next.get(nextKey);
                Integer prevKey = prev.lastKey();
                Integer prevCount = prev.get(prevKey);
                if (prevCount.equals(1)) {
                    prev.remove(prevKey);
                } else {
                    prev.put(prevKey, prevCount - 1);
                }
                prev.put(nextKey, prev.getOrDefault(nextKey, 0) + 1);
                if (nextCount.equals(1)) {
                    next.remove(nextKey);
                } else {
                    next.put(nextKey, nextCount - 1);
                }
                next.put(prevKey, next.getOrDefault(prevKey, 0) + 1);
                if (prev == middle) {
                    sum = sum - prevKey + nextKey;
                }
                if (next == middle) {
                    sum = sum - nextKey + prevKey;
                }
            }
        }

        public void addElement(int num) {
            q.offer(num);
            // all full
            if (size == m) {
                Integer rm = q.poll();
                // remove and add the same value, no need to change
                if (rm.equals(num)) {
                    return;
                }
                // the position of the value removed
                boolean removeLeft = false;
                boolean removeRight = false;
                if (rm >= middle.firstKey() && rm <= middle.lastKey()) {
                    removeOne(middle, rm);
                    sum = sum - rm;
                } else if (rm <= left.lastKey()) {
                    removeLeft = true;
                    removeOne(left, rm);
                } else if (rm >= right.firstKey()) {
                    removeRight = true;
                    removeOne(right, rm);
                }
                // insert new value into middle first
                middle.put(num, middle.getOrDefault(num, 0) + 1);
                sum = sum + num;
                // update values
                if (removeLeft) {
                    Integer moveKey = middle.firstKey();
                    removeOne(middle, moveKey);
                    sum = sum - moveKey;
                    left.put(moveKey, left.getOrDefault(moveKey, 0) + 1);
                    edgeFix(middle, right);
                } else if (removeRight) {
                    Integer moveKey = middle.lastKey();
                    removeOne(middle, moveKey);
                    sum = sum - moveKey;
                    right.put(moveKey, right.getOrDefault(moveKey, 0) + 1);
                    edgeFix(left, middle);
                }
                return;
            }
            // if not full
            // left not full
            if (size < k) {
                left.put(num, left.getOrDefault(num, 0) + 1);
            } else {
                // left is full
                Integer maxLeft = left.lastKey();
                // num is in left
                if (num < maxLeft) {
                    left.put(num, left.getOrDefault(num, 0) + 1);
                    Integer maxLeftCount = left.get(maxLeft);
                    if (maxLeftCount.equals(1)) {
                        left.remove(maxLeft);
                    } else {
                        left.put(maxLeft, maxLeftCount - 1);
                    }
                    num = maxLeft;
                }
                // right not full
                if (size < k + k) {
                    right.put(num, right.getOrDefault(num, 0) + 1);
                } else {
                    // num is in right
                    Integer minRight = right.firstKey();
                    if (num > minRight) {
                        right.put(num, right.getOrDefault(num, 0) + 1);
                        Integer minRightCount = right.get(minRight);
                        if (minRightCount.equals(1)) {
                            right.remove(minRight);
                        } else {
                            right.put(minRight, minRightCount - 1);
                        }
                        num = minRight;
                    }
                    // middle is not full
                    middle.put(num, middle.getOrDefault(num, 0) + 1);
                    sum += num;
                }
            }
            size++;
        }

        public int calculateMKAverage() {
            if (size < m) {
                return -1;
            }
            return (int) (sum / (size - k - k));
        }
    }
}
