package cn.qiushile.leetcode.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 6314. Count Number of Possible Root Nodes
 * User Accepted:241
 * User Tried:462
 * Total Accepted:248
 * Total Submissions:647
 * Difficulty:Hard
 * Alice has an undirected tree with n nodes labeled from 0 to n - 1. The tree is represented as a 2D integer array edges of length n - 1 where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.
 * Alice wants Bob to find the root of the tree. She allows Bob to make several guesses about her tree. In one guess, he does the following:
 * Chooses two distinct integers u and v such that there exists an edge [u, v] in the tree.
 * He tells Alice that u is the parent of v in the tree.
 * Bob's guesses are represented by a 2D integer array guesses where guesses[j] = [uj, vj] indicates Bob guessed uj to be the parent of vj.
 * Alice being lazy, does not reply to each of Bob's guesses, but just says that at least k of his guesses are true.
 * Given the 2D integer arrays edges, guesses and the integer k, return the number of possible nodes that can be the root of Alice's tree. If there is no such tree, return 0.
 * Example 1:
 * Input: edges = [[0,1],[1,2],[1,3],[4,2]], guesses = [[1,3],[0,1],[1,0],[2,4]], k = 3
 * Output: 3
 * Explanation:
 * Root = 0, correct guesses = [1,3], [0,1], [2,4]
 * Root = 1, correct guesses = [1,3], [1,0], [2,4]
 * Root = 2, correct guesses = [1,3], [1,0], [2,4]
 * Root = 3, correct guesses = [1,0], [2,4]
 * Root = 4, correct guesses = [1,3], [1,0]
 * Considering 0, 1, or 2 as root node leads to 3 correct guesses.
 * Example 2:
 * Input: edges = [[0,1],[1,2],[2,3],[3,4]], guesses = [[1,0],[3,4],[2,1],[3,2]], k = 1
 * Output: 5
 * Explanation:
 * Root = 0, correct guesses = [3,4]
 * Root = 1, correct guesses = [1,0], [3,4]
 * Root = 2, correct guesses = [1,0], [2,1], [3,4]
 * Root = 3, correct guesses = [1,0], [2,1], [3,2], [3,4]
 * Root = 4, correct guesses = [1,0], [2,1], [3,2]
 * Considering any node as root will give at least 1 correct guess.
 * Constraints:
 * edges.length == n - 1
 * 2 <= n <= 105
 * 1 <= guesses.length <= 105
 * 0 <= ai, bi, uj, vj <= n - 1
 * ai != bi
 * uj != vj
 * edges represents a valid tree.
 * guesses[j] is an edge of the tree.
 * guesses is unique.
 * 0 <= k <= guesses.length
 * 37 / 51 test cases passed.
 * Status: Time Limit Exceeded
 * @author qiushile <qiushile@sina.com>
 * @date 2023/3/4
 */
public class Solution6314 {
    public int rootCount(int[][] edges, int[][] guesses, int k) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);
        }
        int gn = guesses.length;
        int ans = 0;
        List<Integer> roots = map.keySet().stream().toList();
        for (Integer root : roots) {
            int[] p = new int[10001];
            Arrays.fill(p, -1);
            p[root] = root;
            Queue<Integer> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                Integer node = q.poll();
                for (Integer child : map.get(node)) {
                    if (p[child] == -1) {
                        p[child] = node;
                        q.offer(child);
                    }
                }
            }
            int cnt = 0;
            for (int i = 0; i < guesses.length; i++) {
                int u = guesses[i][0];
                if (u != root) {
                    int v = guesses[i][1];
                    Set<Integer> visited = new HashSet<>();
                    visited.add(v);
                    while (p[v] != u) {
                        if (p[v] == -1 || visited.contains(p[v]) || p[v] == root) {
                            cnt++;
                            break;
                        }
                        v = p[v];
                        visited.add(v);
                    }
                }
                if (cnt > gn - k) {
                    break;
                }
                if (i + 1 - cnt >= k) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
