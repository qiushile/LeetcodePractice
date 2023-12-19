package cn.qiushile.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 218. The Skyline Problem
 * Solved
 * Hard
 * Topics
 * Companies
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Given the locations and heights of all the buildings, return the skyline formed by these buildings collectively.
 * The geometric information of each building is given in the array buildings where buildings[i] = [lefti, righti, heighti]:
 * lefti is the x coordinate of the left edge of the ith building.
 * righti is the x coordinate of the right edge of the ith building.
 * heighti is the height of the ith building.
 * You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
 * The skyline should be represented as a list of "key points" sorted by their x-coordinate in the form [[x1,y1],[x2,y2],...]. Each key point is the left endpoint of some horizontal segment in the skyline except the last point in the list, which always has a y-coordinate 0 and is used to mark the skyline's termination where the rightmost building ends. Any ground between the leftmost and rightmost buildings should be part of the skyline's contour.
 * Note: There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...,[2 3],[4 5],[7 5],[11 5],[12 7],...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...,[2 3],[4 5],[12 7],...]
 * Example 1:
 * Input: buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
 * Output: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
 * Explanation:
 * Figure A shows the buildings of the input.
 * Figure B shows the skyline formed by those buildings. The red points in figure B represent the key points in the output list.
 * Example 2:
 * Input: buildings = [[0,2,3],[2,5,3]]
 * Output: [[0,3],[5,0]]
 * Constraints:
 * 1 <= buildings.length <= 104
 * 0 <= lefti < righti <= 231 - 1
 * 1 <= heighti <= 231 - 1
 * buildings is sorted by lefti in non-decreasing order.
 * <p>
 * Runtime 10 ms Beats 86.68% of users with Java Memory 45.68 MB Beats 85.30% of users with Java
 *
 * @author qiushile <qiushile@sina.com>
 * @date 2023/12/19
 */
public class Solution0218 {

    public List<List<Integer>> getSkyline(int[][] buildings) {

        LinkedList<int[]> list = new LinkedList<>();
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[2] == b[2] ? a[1] - b[1] : b[2] - a[2]);
        Collections.addAll(q, buildings);
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (list.isEmpty() || list.peekLast()[1] < curr[0]) {
                list.add(curr);
                continue;
            }
            int[] last = list.pollLast();
            if (last[1] == curr[0]) {
                if (last[2] == curr[2]) {
                    last[1] = curr[1];
                    list.add(last);
                } else {
                    list.add(last);
                    list.add(curr);
                }
            } else if (last[2] == curr[2]) {
                if (curr[1] > last[1]) {
                    last[1] = curr[1];
                }
                list.add(last);
            } else if (last[2] > curr[2]) {
                list.add(last);
                if (curr[1] > last[1]) {
                    curr[0] = last[1];
                    q.offer(curr);
                }
            } else {
                int lastEnd = last[1];
                last[1] = curr[0];
                if (last[1] > last[0]) {
                    list.add(last);
                }
                list.add(curr);
                if (lastEnd > curr[1]) {
                    q.offer(new int[]{curr[1], lastEnd, last[2]});
                }
            }
        }

        LinkedList<List<Integer>> ans = new LinkedList<>();
        for (int[] c : list) {
            if (!ans.isEmpty() && ans.peekLast().get(0) == c[0]) {
                ans.pollLast();
            }
            ans.add(new ArrayList<>(Arrays.asList(c[0], c[2])));
            ans.add(new ArrayList<>(Arrays.asList(c[1], 0)));
        }
        return ans;
    }

}
