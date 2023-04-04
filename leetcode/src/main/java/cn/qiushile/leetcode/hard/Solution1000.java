package cn.qiushile.leetcode.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 1000. Minimum Cost to Merge Stones
 * Hard
 * 2.1K
 * 97
 * Companies
 * There are n piles of stones arranged in a row. The ith pile has stones[i] stones.
 * A move consists of merging exactly k consecutive piles into one pile, and the cost of this move is equal to the total number of stones in these k piles.
 * Return the minimum cost to merge all piles of stones into one pile. If it is impossible, return -1.
 * Example 1:
 * Input: stones = [3,2,4,1], k = 2
 * Output: 20
 * Explanation: We start with [3, 2, 4, 1].
 * We merge [3, 2] for a cost of 5, and we are left with [5, 4, 1].
 * We merge [4, 1] for a cost of 5, and we are left with [5, 5].
 * We merge [5, 5] for a cost of 10, and we are left with [10].
 * The total cost was 20, and this is the minimum possible.
 * Example 2:
 * Input: stones = [3,2,4,1], k = 3
 * Output: -1
 * Explanation: After any merge operation, there are 2 piles left, and we can't merge anymore.  So the task is impossible.
 * Example 3:
 * Input: stones = [3,5,1,2,6], k = 3
 * Output: 25
 * Explanation: We start with [3, 5, 1, 2, 6].
 * We merge [5, 1, 2] for a cost of 8, and we are left with [3, 8, 6].
 * We merge [3, 8, 6] for a cost of 17, and we are left with [17].
 * The total cost was 25, and this is the minimum possible.
 * Constraints:
 * n == stones.length
 * 1 <= n <= 30
 * 1 <= stones[i] <= 100
 * 2 <= k <= 30
 * failed: Time Limit Exceeded
 * @author qiushile <qiushile@sina.com>
 * @date 2023/4/4
 */
public class Solution1000 {
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if (n == 1) {
            return 0;
        }
        if (((n - 1) % (k - 1)) > 0) {
            return -1;
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(stones);
        Map<String, Integer> map0 = new HashMap<>();
        map0.put(Arrays.toString(stones), 0);
        int steps = (n - 1) / (k - 1);
        for (int step = 0; step < steps; step++) {
            n -= k - 1;
            int size = q.size();
            Map<String, Integer> map1 = new HashMap<>();
            while (size-- > 0) {
                int[] curr = q.poll();
                Integer cost = map0.get(Arrays.toString(curr));
                int sum = 0;
                for (int i = 0; i < k; i++) {
                    sum += curr[i];
                }
                int[] arr = new int[n];
                arr[0] = sum;
                for (int i = 1; i < n; i++) {
                    arr[i] = curr[i + k - 1];
                }
                String k0 = Arrays.toString(arr);
                if (map1.containsKey(k0)) {
                    Integer v = map1.get(k0);
                    if (cost + sum < v) {
                        map1.put(k0, cost + sum);
                    }
                } else {
                    map1.put(k0, cost + sum);
                    q.offer(arr);
                }
                int[] arri;
                for (int i = 1; i < n; i++) {
                    sum += curr[i + k - 1] - curr[i - 1];
                    arri = Arrays.copyOf(arr, n);
                    arri[i - 1] = curr[i - 1];
                    arri[i] = sum;
                    String ki = Arrays.toString(arri);
                    if (map1.containsKey(ki)) {
                        Integer v = map1.get(ki);
                        if (cost + sum < v) {
                            map1.put(ki, cost + sum);
                        }
                    } else {
                        map1.put(ki, cost + sum);
                        q.offer(arri);
                    }
                    arr = arri;
                }
            }
            map0.clear();
            map0 = map1;
        }
        return map0.values().iterator().next();
    }
}
