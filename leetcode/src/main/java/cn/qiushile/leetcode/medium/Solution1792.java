package cn.qiushile.leetcode.medium;

import java.util.PriorityQueue;

/**
 * 1792. Maximum Average Pass Ratio
 * Medium
 * 626
 * 68
 * Companies
 * There is a school that has classes of students and each class will be having a final exam. You are given a 2D integer array classes, where classes[i] = [passi, totali]. You know beforehand that in the ith class, there are totali total students, but only passi number of students will pass the exam.
 * You are also given an integer extraStudents. There are another extraStudents brilliant students that are guaranteed to pass the exam of any class they are assigned to. You want to assign each of the extraStudents students to a class in a way that maximizes the average pass ratio across all the classes.
 * The pass ratio of a class is equal to the number of students of the class that will pass the exam divided by the total number of students of the class. The average pass ratio is the sum of pass ratios of all the classes divided by the number of the classes.
 * Return the maximum possible average pass ratio after assigning the extraStudents students. Answers within 10-5 of the actual answer will be accepted.
 * Example 1:
 * Input: classes = [[1,2],[3,5],[2,2]], extraStudents = 2
 * Output: 0.78333
 * Explanation: You can assign the two extra students to the first class. The average pass ratio will be equal to (3/4 + 3/5 + 2/2) / 3 = 0.78333.
 * Example 2:
 * Input: classes = [[2,4],[3,9],[4,5],[2,10]], extraStudents = 4
 * Output: 0.53485
 * Constraints:
 * 1 <= classes.length <= 105
 * classes[i].length == 2
 * 1 <= passi <= totali <= 105
 * 1 <= extraStudents <= 105
 * Runtime 522 ms Beats 86.90% Memory 100.7 MB Beats 47.62%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/2/19
 */
public class Solution1792 {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            long v1 = (long) (a[1] + 1) * a[1] * (b[1] - b[0]);
            long v2 = (long) (b[1] + 1) * b[1] * (a[1] - a[0]);
            if (v1 == v2) {
                return 0;
            }
            return v1 > v2? 1: -1;
        });
        for (int[] c : classes) {
            q.offer(c);
        }
        for (int i = 0; i < extraStudents; i++) {
            int[] c = q.poll();
            q.offer(new int[]{c[0] + 1, c[1] + 1});
        }
        double rate = 0.0;
        while (!q.isEmpty()) {
            int[] c = q.poll();
            rate += 1.0 * c[0] / c[1];
        }
        rate /= classes.length;
        return rate;
    }
}
