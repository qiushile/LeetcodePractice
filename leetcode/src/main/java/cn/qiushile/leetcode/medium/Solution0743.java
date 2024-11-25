package cn.qiushile.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 743. Network Delay Time
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
 * We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
 * Example 1:
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * Output: 2
 * Example 2:
 * Input: times = [[1,2,1]], n = 2, k = 1
 * Output: 1
 * Example 3:
 * Input: times = [[1,2,1]], n = 2, k = 2
 * Output: -1
 * Constraints:
 * 1 <= k <= n <= 100
 * 1 <= times.length <= 6000
 * times[i].length == 3
 * 1 <= ui, vi <= n
 * ui != vi
 * 0 <= wi <= 100
 * All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
 *
 * Runtime 8 ms Beats 94.38% Memory 48.89 MB Beats 30.09%
 *
 * @author qiushile <qiushile@sina.com>
 * @date 2024/11/25
 */
public class Solution0743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] reach = new int[n + 1];
        Arrays.fill(reach, Integer.MAX_VALUE);
        reach[k] = 0;
        List<int[]>[] links = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            links[i] = new ArrayList<>();
        }
        for (int[] t : times) {
            links[t[0]].add(new int[]{t[1], t[2]});
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q.offer(new int[]{k, 0});
        while (!q.isEmpty()) {
            int[] c = q.poll();
            if (c[1] > reach[c[0]]) {
                continue;
            }
            for (int[] link : links[c[0]]) {
                if (c[1] + link[1] < reach[link[0]]) {
                    reach[link[0]] = c[1] + link[1];
                    q.offer(new int[]{link[0], reach[link[0]]});
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, reach[i]);
        }
        return max == Integer.MAX_VALUE? -1: max;
    }
}
