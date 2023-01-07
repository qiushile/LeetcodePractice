package cn.qiushile.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 36. Valid Sudoku
 * Medium
 * 7.7K
 * 859
 * Companies
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * Example 1:
 * Input: board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: true
 * Example 2:
 * Input: board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * Constraints:
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit 1-9 or '.'.
 * Failed:
 *      Wrong Answer at 471 / 507
 * Accepted:
 *      Runtime 3 ms Beats 82.75% Memory 42.2 MB Beats 89.91%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/7
 */
public class Solution0036 {
    public boolean isValidSudoku(char[][] board) {
        // each row
        List<Set<Integer>> list1 = new ArrayList<>(9);
        // each column
        List<Set<Integer>> list2 = new ArrayList<>(9);
        // each 3 * 3
        List<Set<Integer>> list3 = new ArrayList<>(9);
        for (int i = 0; i < 9; i++) {
            list1.add(new HashSet<Integer>(9));
            list2.add(new HashSet<Integer>(9));
            list3.add(new HashSet<Integer>(9));
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    int k = i / 3 * 3 + j / 3;
                    if (list1.get(i).contains(num) || list2.get(j).contains(num) || list3.get(k).contains(num)) {
                        return false;
                    }
                    list1.get(i).add(num);
                    list2.get(j).add(num);
                    list3.get(k).add(num);
                }
            }
        }
        return true;
    }
}
