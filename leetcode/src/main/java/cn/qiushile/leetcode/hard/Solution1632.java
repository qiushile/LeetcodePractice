package cn.qiushile.leetcode.hard;

/**
 * 1632. Rank Transform of a Matrix
 * Hard
 * 741
 * 50
 * Companies
 * Given an m x n matrix, return a new matrix answer where answer[row][col] is the rank of matrix[row][col].
 * The rank is an integer that represents how large an element is compared to other elements. It is calculated using the following rules:
 * The rank is an integer starting from 1.
 * If two elements p and q are in the same row or column, then:
 * If p < q then rank(p) < rank(q)
 * If p == q then rank(p) == rank(q)
 * If p > q then rank(p) > rank(q)
 * The rank should be as small as possible.
 * The test cases are generated so that answer is unique under the given rules.
 * Example 1:
 * Input: matrix = [[1,2],[3,4]]
 * Output: [[1,2],[2,3]]
 * Explanation:
 * The rank of matrix[0][0] is 1 because it is the smallest integer in its row and column.
 * The rank of matrix[0][1] is 2 because matrix[0][1] > matrix[0][0] and matrix[0][0] is rank 1.
 * The rank of matrix[1][0] is 2 because matrix[1][0] > matrix[0][0] and matrix[0][0] is rank 1.
 * The rank of matrix[1][1] is 3 because matrix[1][1] > matrix[0][1], matrix[1][1] > matrix[1][0], and both matrix[0][1] and matrix[1][0] are rank 2.
 * Example 2:
 * Input: matrix = [[7,7],[7,7]]
 * Output: [[1,1],[1,1]]
 * Example 3:
 * Input: matrix = [[20,-21,14],[-19,4,19],[22,-47,24],[-19,4,19]]
 * Output: [[4,2,3],[1,3,4],[5,1,6],[1,3,4]]
 * Constraints:
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 500
 * -109 <= matrix[row][col] <= 109
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/25
 */
public class Solution1632 {
    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] ms = new int[m * n];
        int[] order = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ms[i * n + j] = matrix[i][j];
                order[i * n + j] = i * n + j;
            }
        }
        quickSort(ms, order, 0, ms.length - 1);

        int[][] ans = new int[m][n];
        int[] rows = new int[m];
        int[] cols = new int[n];
        int last = -1;
        int rank = 0;
        for (int i = 0; i < order.length; i++) {
            int index = order[i];
            int value = ms[i];
            int row = index / n;
            int col = index % n;
            rank = Math.max(rank, rows[row]);
            rank = Math.max(rank, cols[col]);
            if (i == order.length - 1 || value != ms[i + 1]) {
                rank++;
                if (last > -1) {
                    for (int j = last; j <= i; j++) {
                        index = order[j];
                        row = index / n;
                        col = index % n;
                        ans[row][col] = rank;
                        rows[row] = rank;
                        cols[col] = rank;
                    }
                } else {
                    ans[row][col] = rank;
                    rows[row] = rank;
                    cols[col] = rank;
                }
                last = -1;
                rank = 0;
            } else if (last == -1) {
                last = i;
            }
        }
        return ans;
    }

    private static void quickSort(int[] keys, int[] indices, int start, int end) {
        if (start >= 0 && start < keys.length && end >= 0 && end < keys.length && start < end) {
            int i = start;
            int j = end;
            int k = keys[i];
            int v = indices[i];
            while (i != j) {
                while (i < j && keys[j] >= k) {
                    j--;
                }
                if (i < j) {
                    keys[i] = keys[j];
                    indices[i] = indices[j];
                    i++;
                }
                while (i < j && keys[i] <= k) {
                    i++;
                }
                if (i < j) {
                    keys[j] = keys[i];
                    indices[j] = indices[i];
                    j--;
                }
            }
            keys[i] = k;
            indices[i] = v;
            quickSort(keys, indices, start, j - 1);
            quickSort(keys, indices, i + 1, end);
        }
    }
}
