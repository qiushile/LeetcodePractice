package cn.qiushile.leetcode.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 3203. Find Minimum Diameter After Merging Two Trees
 * Solved
 * Hard
 * Topics
 * Companies
 * Hint
 * There exist two undirected trees with n and m nodes, numbered from 0 to n - 1 and from 0 to m - 1, respectively. You are given two 2D integer arrays edges1 and edges2 of lengths n - 1 and m - 1, respectively, where edges1[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the first tree and edges2[i] = [ui, vi] indicates that there is an edge between nodes ui and vi in the second tree.
 * You must connect one node from the first tree with another node from the second tree with an edge.
 * Return the minimum possible diameter of the resulting tree.
 * The diameter of a tree is the length of the longest path between any two nodes in the tree.
 * Example 1:
 * Input: edges1 = [[0,1],[0,2],[0,3]], edges2 = [[0,1]]
 * Output: 3
 * Explanation:
 * We can obtain a tree of diameter 3 by connecting node 0 from the first tree with any node from the second tree.
 * Example 2:
 * Input: edges1 = [[0,1],[0,2],[0,3],[2,4],[2,5],[3,6],[2,7]], edges2 = [[0,1],[0,2],[0,3],[2,4],[2,5],[3,6],[2,7]]
 * Output: 5
 * Explanation:
 * We can obtain a tree of diameter 5 by connecting node 0 from the first tree with node 0 from the second tree.
 * Constraints:
 * 1 <= n, m <= 105
 * edges1.length == n - 1
 * edges2.length == m - 1
 * edges1[i].length == edges2[i].length == 2
 * edges1[i] = [ai, bi]
 * 0 <= ai, bi < n
 * edges2[i] = [ui, vi]
 * 0 <= ui, vi < m
 * The input is generated such that edges1 and edges2 represent valid trees.
 *
 * Runtime 80 ms Beats 98.44% Memory 108.87 MB Beats 89.84%
 *
 * @author qiushile <qiushile@sina.com>
 * @date 2024/12/25
 */
public class Solution3203 {

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int[] l1 = level(edges1);
        int[] l2 = level(edges2);
        return Math.max(l1[0] + l2[0] + 1, Math.max(l1[1], l2[1]));
    }

    private int[] level(int[][] edges) {
        int n = edges.length + 1;
        if (n <= 2) {
            return new int[]{n - 1, n - 1};
        }
        List<Integer>[] links = new List[n];
        for (int i = 0; i < n; i++) {
            links[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            links[e[0]].add(e[1]);
            links[e[1]].add(e[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (links[i].size() == 1) {
                q.offer(i);
            }
        }
        int step = 0, m = q.size();
        while (m-- > 0) {
            Integer c = q.poll();
            if (!links[c].isEmpty()) {
                Integer next = links[c].get(0);
                links[next].remove(c);
                if (links[next].size() == 1) {
                    q.offer(next);
                }
            }
            n--;
            if (m == 0) {
                m = q.size();
                if (m > 0) {
                    step++;
                }
                if (m == n) {
                    return m > 1? new int[]{step + 1, step * 2 + 1}: new int[]{step, step + step};
                }
            }
        }
        return new int[]{step, step + step};
    }
}
