package cn.qiushile.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LCP 41. 黑白翻转棋
 * 在 n*m 大小的棋盘中，有黑白两种棋子，黑棋记作字母 "X", 白棋记作字母 "O"，空余位置记作 "."。当落下的棋子与其他相同颜色的棋子在行、列或对角线完全包围（中间不存在空白位置）另一种颜色的棋子，则可以翻转这些棋子的颜色。
 * 「力扣挑战赛」黑白翻转棋项目中，将提供给选手一个未形成可翻转棋子的棋盘残局，其状态记作 chessboard。若下一步可放置一枚黑棋，请问选手最多能翻转多少枚白棋。
 * 注意：
 * 若翻转白棋成黑棋后，棋盘上仍存在可以翻转的白棋，将可以 继续 翻转白棋
 * 输入数据保证初始棋盘状态无可以翻转的棋子且存在空余位置
 * 示例 1：
 * 输入：chessboard = ["....X.","....X.","XOOO..","......","......"]
 * 输出：3
 * 解释：
 * 可以选择下在 [2,4] 处，能够翻转白方三枚棋子。
 * 示例 2：
 * 输入：chessboard = [".X.",".O.","XO."]
 * 输出：2
 * 解释：
 * 可以选择下在 [2,2] 处，能够翻转白方两枚棋子。
 * 2126c1d21b1b9a9924c639d449cc6e65.gif
 * 示例 3：
 * 输入：chessboard = [".......",".......",".......","X......",".O.....","..O....","....OOX"]
 * 输出：4
 * 解释：
 * 可以选择下在 [6,3] 处，能够翻转白方四枚棋子。
 * 803f2f04098b6174397d6c696f54d709.gif
 * 提示：
 * 1 <= chessboard.length, chessboard[i].length <= 8
 * chessboard[i] 仅包含 "."、"O" 和 "X"
 * Failed at 153/154
 * @author qiushile <qiushile@sina.com>
 * @date 2023/6/21
 */
public class LCP41 {
    public int flipChess(String[] chessboard) {
        int n = chessboard.length;
        int m = chessboard[0].length();
        char[][] cs = new char[n][m];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            cs[i] = chessboard[i].toCharArray();
            for (int j = 0; j < m; j++) {
                if (cs[i][j] == 'O') {
                    q.offer(new int[]{i, j});
                }
            }
        }
        int ans = 0;
        int[] dx = new int[]{0, 1, 1, 1};
        int[] dy = new int[]{1, 0, 1, -1};
        int k = q.size();
        int remain = k;
        while (!q.isEmpty()) {
            k--;
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            if (cs[x][y] == 'O') {
                for (int i = 0; i < 4; i++) {
                    int lx = x;
                    int ly = y;
                    int rx = x;
                    int ry = y;
                    while (lx >= 0 && ly >= 0 && lx < n && ly < m && cs[lx][ly] == 'O') {
                        lx += dx[i];
                        ly += dy[i];
                    }
                    while (rx >= 0 && ry >= 0 && rx < n && ry < m && cs[rx][ry] == 'O') {
                        rx -= dx[i];
                        ry -= dy[i];
                    }
                    if (lx >= 0 && ly >= 0 && lx < n && ly < m && rx >= 0 && ry >= 0 && rx < n && ry < m) {
                        if (cs[lx][ly] == 'X' || cs[rx][ry] == 'X') {
                            cs[lx][ly] = cs[rx][ry] = 'X';
                            while (lx != rx || ly != ry) {
                                if (cs[lx][ly] == 'O') {
                                    cs[lx][ly] = 'X';
                                    ans++;
                                }
                                lx -= dx[i];
                                ly -= dy[i];
                            }
                            break;
                        }
                    }
                }
            }
            if (cs[x][y] == 'O') {
                q.offer(curr);
            }
            if (k == 0) {
                k = q.size();
                if (k == remain) {
                    break;
                }
                remain = k;
            }
        }
        return ans;
    }
}
