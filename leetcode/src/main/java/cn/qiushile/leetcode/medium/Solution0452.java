package cn.qiushile.leetcode.medium;

/**
 * 452. Minimum Number of Arrows to Burst Balloons
 * Medium
 * 4.8K
 * 131
 * Companies
 * There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.
 * Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis. A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.
 * Given the array points, return the minimum number of arrows that must be shot to burst all balloons.
 * Example 1:
 * Input: points = [[10,16],[2,8],[1,6],[7,12]]
 * Output: 2
 * Explanation: The balloons can be burst by 2 arrows:
 * - Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
 * - Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
 * Example 2:
 * Input: points = [[1,2],[3,4],[5,6],[7,8]]
 * Output: 4
 * Explanation: One arrow needs to be shot for each balloon for a total of 4 arrows.
 * Example 3:
 * Input: points = [[1,2],[2,3],[3,4],[4,5]]
 * Output: 2
 * Explanation: The balloons can be burst by 2 arrows:
 * - Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
 * - Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].
 * Constraints:
 * 1 <= points.length <= 105
 * points[i].length == 2
 * -231 <= xstart < xend <= 231 - 1
 * Runtime 153 ms Beats 13.16% Memory 99 MB Beats 28.56%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/5
 */
public class Solution0452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 1) {
            return 1;
        }

        quickSort(points, 0, points.length - 1);
        int ans = 1;
        int pin = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > pin) {
                ans++;
                pin = points[i][1];
            }
        }
        return ans;
    }

    private static void quickSort(int[][] points, int begin, int end) {
        if (begin >= 0 && begin < points.length && end >= 0 && end < points.length && begin < end) {
            int i = begin, j = end;
            int[] vot = points[i];
            while (i != j) {
                while (i < j && points[j][1] >= vot[1]) {
                    j--;
                }
                if(i < j) {
                    points[i] = points[j];
                    i++;
                }
                while(i < j && points[i][1] <= vot[1]) {
                    i++;
                }
                if(i < j) {
                    points[j]= points[i];
                    j--;
                }
            }
            points[i] = vot;
            quickSort(points, begin, j-1);
            quickSort(points, i+1, end);
        }
    }

}
