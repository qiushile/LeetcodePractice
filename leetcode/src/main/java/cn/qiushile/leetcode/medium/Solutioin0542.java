package cn.qiushile.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 542. 01 Matrix
 * Medium 6.3K 308
 * Companies
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 * The distance between two adjacent cells is 1.
 * Example 1:
 * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 * Example 2:
 * Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
 * Output: [[0,0,0],[0,1,0],[1,2,1]]
 * Constraints:
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * mat[i][j] is either 0 or 1.
 * There is at least one 0 in mat.
 * Accepted 343.7K Submissions 774.3K Acceptance Rate 44.4%
 * Runtime 11 ms Beats 88.57% Memory 45.1 MB Beats 82.12%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/10
 */
public class Solutioin0542 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] move = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        Queue<Integer> curr = new LinkedList<>();
        Queue<Integer> next = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[j][i] == 1) {
                    if ((j > 0 && mat[j - 1][i] == 0) || (i > 0 && mat[j][i - 1] == 0)) {
                        curr.add(j * n + i);
                        continue;
                    } else {
                        mat[j][i] = -1;
                    }
                } else if (mat[j][i] == 0) {
                    if (j > 0 && mat[j - 1][i] == -1) {
                        mat[j - 1][i] = 1;
                        curr.add((j - 1) * n + i);
                    }
                    if (i > 0 && mat[j][i - 1] == -1) {
                        mat[j][i - 1] = 1;
                        curr.add(j * n + i - 1);
                    }
                }
            }
        }
        int distance = 2;
        while (!curr.isEmpty()) {
            int xy = curr.poll();
            int y = xy / n;
            int x = xy % n;
            for (int i = 0; i < move.length; i++) {
                int ny = y + move[i][0];
                int nx = x + move[i][1];
                if (ny >= 0 && ny < m && nx >= 0 && nx < n && mat[ny][nx] == -1) {
                    mat[ny][nx] = distance;
                    next.add(ny * n + nx);
                }
            }
            if (curr.isEmpty()) {
                curr = next;
                next = new LinkedList<>();
                distance++;
            }
        }
        return mat;
    }
}
