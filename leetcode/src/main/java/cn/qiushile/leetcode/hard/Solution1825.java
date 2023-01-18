package cn.qiushile.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

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
        // max heap
        private List<Integer> left;
        // max heap
        private List<Integer> middle;
        // min heap
        private List<Integer> right;

        public MKAverage(int m, int k) {
            this.m = m;
            this.k = k;
            this.left = new ArrayList<>(k + 1);
            this.middle = new ArrayList<>();
            this.right = new ArrayList<>(k + 1);
            this.left.add(0);
            this.middle.add(0);
            this.right.add(0);
        }

        private int removeTop(List<Integer> heap, boolean isMinHeap) {
            int top = heap.get(1);
            heap.set(1, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);
            if (heap.size() == 1) {
                return top;
            }
            int index = 1;
            int num = heap.get(1);
            while (index < heap.size() / 2) {
                int leftValue = heap.get(index * 2);
                int rightValue = heap.size() <= (index + 1) * 2? heap.get(index * 2 + 1): -1;
                boolean stop = isMinHeap? leftValue > num && (rightValue > num || rightValue == -1):
                        leftValue < num && (rightValue < num || rightValue == -1);
                if (stop) {
                    break;
                }
                boolean moveLeft = rightValue == -1 || (isMinHeap? leftValue < rightValue: leftValue > rightValue);
                if (moveLeft) {
                    heap.set(index * 2, num);
                    heap.set(index, leftValue);
                    index = index * 2;
                } else {
                    heap.set(index * 2 + 1, num);
                    heap.set(index, rightValue);
                    index = index * 2 + 1;
                }
            }
            return top;
        }

        private void addValue(List<Integer> heap, boolean isMinHeap, int num) {
            int index = heap.size();
            heap.add(num);
            while (index >= 1) {
                Integer parent = heap.get(index / 2);
                if (index > 1 && ((isMinHeap && num < parent) || (!isMinHeap && num > parent))) {
                    heap.set(index / 2, num);
                    heap.set(index, parent);
                } else {
                    break;
                }
                index = parent;
            }
        }

        public void addElement(int num) {
            if (size < k) {
                addValue(left, false, num);
            } else {
                Integer maxLeft = left.get(1);
                if (num < maxLeft) {
                    removeTop(left, false);
                    addValue(left, false, num);
                    num = maxLeft;
                }
                if (size < k + k) {
                    addValue(right, true, num);
                } else {
                    Integer rightMin = right.get(1);
                    if (num > rightMin) {
                        removeTop(right, true);
                        addValue(right, true, num);
                        num = rightMin;
                    }
                    addValue(middle, false, num);
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
