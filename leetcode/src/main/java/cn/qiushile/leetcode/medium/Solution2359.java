package cn.qiushile.leetcode.medium;

import java.util.Arrays;

/**
 * 2359. Find Closest Node to Given Two Nodes
 * Medium
 * 968
 * 239
 * Companies
 * You are given a directed graph of n nodes numbered from 0 to n - 1, where each node has at most one outgoing edge.
 * The graph is represented with a given 0-indexed array edges of size n, indicating that there is a directed edge from node i to node edges[i]. If there is no outgoing edge from i, then edges[i] == -1.
 * You are also given two integers node1 and node2.
 * Return the index of the node that can be reached from both node1 and node2, such that the maximum between the distance from node1 to that node, and from node2 to that node is minimized. If there are multiple answers, return the node with the smallest index, and if no possible answer exists, return -1.
 * Note that edges may contain cycles.
 * Example 1:
 * Input: edges = [2,2,3,-1], node1 = 0, node2 = 1
 * Output: 2
 * Explanation: The distance from node 0 to node 2 is 1, and the distance from node 1 to node 2 is 1.
 * The maximum of those two distances is 1. It can be proven that we cannot get a node with a smaller maximum distance than 1, so we return node 2.
 * Example 2:
 * Input: edges = [1,2,-1], node1 = 0, node2 = 2
 * Output: 2
 * Explanation: The distance from node 0 to node 2 is 2, and the distance from node 2 to itself is 0.
 * The maximum of those two distances is 2. It can be proven that we cannot get a node with a smaller maximum distance than 2, so we return node 2.
 * Constraints:
 * n == edges.length
 * 2 <= n <= 105
 * -1 <= edges[i] < n
 * edges[i] != i
 * 0 <= node1, node2 < n
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/25
 */
public class Solution2359 {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        if (node1 == node2) {
            return node1;
        }
        int n = edges.length;
        int[] link1 = new int[n];
        int[] link2 = new int[n];
        Arrays.fill(link1, -1);
        Arrays.fill(link2, -1);
        int cnt = 0;
        link1[node1] = 0;
        while (edges[node1] != -1) {
            cnt++;
            node1 = edges[node1];
            if (link1[node1] > -1) {
                break;
            }
            link1[node1] = cnt;
        }
        cnt = 0;
        link2[node2] = 0;
        while (edges[node2] != -1) {
            cnt++;
            node2 = edges[node2];
            if (link2[node2] > -1) {
                break;
            }
            link2[node2] = cnt;
        }
        int ans = n;
        int node = -1;
        for (int i = 0; i < n; i++) {
            if (link1[i] >= 0 && link2[i] >= 0) {
                int max = Math.max(link1[i], link2[i]);
                if (max < ans) {
                    node = i;
                    ans = max;
                }
            }
        }
        return node;
    }
}
