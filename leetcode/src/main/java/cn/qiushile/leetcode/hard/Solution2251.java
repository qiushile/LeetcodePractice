package cn.qiushile.leetcode.hard;

import java.util.Arrays;

/**
 * 2251. Number of Flowers in Full Bloom
 * Solved
 * Hard
 * Topics
 * Companies
 * Hint
 * You are given a 0-indexed 2D integer array flowers, where flowers[i] = [starti, endi] means the ith flower will be in full bloom from starti to endi (inclusive). You are also given a 0-indexed integer array people of size n, where people[i] is the time that the ith person will arrive to see the flowers.
 * Return an integer array answer of size n, where answer[i] is the number of flowers that are in full bloom when the ith person arrives.
 * Example 1:
 * Input: flowers = [[1,6],[3,7],[9,12],[4,13]], poeple = [2,3,7,11]
 * Output: [1,2,2,2]
 * Explanation: The figure above shows the times when the flowers are in full bloom and when the people arrive.
 * For each person, we return the number of flowers in full bloom during their arrival.
 * Example 2:
 * Input: flowers = [[1,10],[3,3]], poeple = [3,3,2]
 * Output: [2,2,1]
 * Explanation: The figure above shows the times when the flowers are in full bloom and when the people arrive.
 * For each person, we return the number of flowers in full bloom during their arrival.
 * Constraints:
 * 1 <= flowers.length <= 5 * 104
 * flowers[i].length == 2
 * 1 <= starti <= endi <= 109
 * 1 <= people.length <= 5 * 104
 * 1 <= people[i] <= 109
 * Runtime 1455 ms Beats 5.24% Memory 84.1 MB Beats 5.24%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/9/28
 */
public class Solution2251 {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = people.length;
        int[] indice = new int[n];
        for (int i = 0; i < n; i++) {
            indice[i] = i;
        }
        qsort(people, indice, 0, n - 1);

        int m = flowers.length;
        int[] adds = new int[m];
        int[] rmvs = new int[m];
        for (int i = 0; i < m; i++) {
            adds[i] = flowers[i][0];
            rmvs[i] = flowers[i][1];
        }
        Arrays.sort(adds);
        Arrays.sort(rmvs);

        int time = 0;
        int num = 0;
        int i = 0;
        int j = 0;
        int[] ans = new int[n];
        for (int k = 0; k < n; k++) {
            int t = people[k];
            if (t > time) {
                if (j == m) {
                    num = 0;
                } else {
                    while (j < m && rmvs[j] + 1 <= t) {
                        num--;
                        j++;
                    }
                    while (i < m && adds[i] <= t) {
                        num++;
                        i++;
                    }
                }
                time = t;
            }
            ans[indice[k]] = num;
        }
        return ans;
    }

    private void qsort(int[] vs, int[] idx, int left, int right) {
        if (left < right && left >= 0 && right < vs.length) {
            int k = vs[left];
            int v = idx[left];
            int i = left;
            int j = right;
            while (i < j) {
                while (i < j) {
                    while (i < j && vs[j] >= k) {
                        j--;
                    }
                    if (i < j) {
                        vs[i] = vs[j];
                        idx[i] = idx[j];
                        i++;
                    }
                    while (i < j && vs[i] <= k) {
                        i++;
                    }
                    if (i < j) {
                        vs[j] = vs[i];
                        idx[j] = idx[i];
                        j--;
                    }
                }
            }
            vs[i] = k;
            idx[i] = v;
            qsort(vs, idx, left, i - 1);
            qsort(vs, idx, i + 1, right);
        }
    }
}
