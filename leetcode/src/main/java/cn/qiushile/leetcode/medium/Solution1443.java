package cn.qiushile.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 1443. Minimum Time to Collect All Apples in a Tree
 * Medium
 * 1.2K
 * 100
 * Companies
 * Given an undirected tree consisting of n vertices numbered from 0 to n-1, which has some apples in their vertices. You spend 1 second to walk over one edge of the tree. Return the minimum time in seconds you have to spend to collect all apples in the tree, starting at vertex 0 and coming back to this vertex.
 * The edges of the undirected tree are given in the array edges, where edges[i] = [ai, bi] means that exists an edge connecting the vertices ai and bi. Additionally, there is a boolean array hasApple, where hasApple[i] = true means that vertex i has an apple; otherwise, it does not have any apple.
 * Example 1:
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,true,true,false]
 * Output: 8
 * Explanation: The figure above represents the given tree where red vertices have an apple. One optimal path to collect all apples is shown by the green arrows.
 * Example 2:
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,false,true,false]
 * Output: 6
 * Explanation: The figure above represents the given tree where red vertices have an apple. One optimal path to collect all apples is shown by the green arrows.
 * Example 3:
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,false,false,false,false,false]
 * Output: 0
 * Constraints:
 * 1 <= n <= 105
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai < bi <= n - 1
 * fromi < toi
 * hasApple.length == n
 * Accepted 33.8K Submissions 60.1K Acceptance Rate 56.3%
 * Runtime 40 ms Beats 82.94% Memory 85.3 MB Beats 70%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/11
 */
public class Solution1443 {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Set<Integer> ans = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> exists = new HashSet<>();
        exists.add(0);
        for (int i = 0; i < hasApple.size(); i++) {
            if (hasApple.get(i)) {
                ans.add(i);
                queue.add(i);
            }
        }
        if (ans.isEmpty()) {
            return 0;
        }
        Map<Integer, Integer> father = new HashMap<>();
        for (int[] edge : edges) {
            int up = edge[0];
            int down = edge[1];
            if (exists.contains(edge[1]) && !exists.contains(edge[0])) {
                up = edge[1];
                down = edge[0];
            }
            if (ans.contains(down)) {
                ans.add(up);
                queue.add(up);
            } else {
                father.put(down, up);
            }
            exists.add(down);
            exists.add(up);
        }
        while (!queue.isEmpty()) {
            Integer next = queue.poll();
            while (father.containsKey(next)) {
                next = father.remove(next);
                if (!ans.contains(next)) {
                    ans.add(next);
                    queue.add(next);
                }
            }
        }
        return (ans.size() - 1) * 2;
    }
}
