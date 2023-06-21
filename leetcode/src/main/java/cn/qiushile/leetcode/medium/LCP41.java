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
 * 时间 3 ms 击败 91.23% 内存 40.2 MB 击败 75%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/6/21
 */
public class LCP41 {
    int[] dx = new int[]{0, 0, 1, -1, 1, 1, -1, -1};
    int[] dy = new int[]{1, -1, 0, 0, 1, -1, 1, -1};

    private int[] judge(char[][] cs, int x, int y, int dx, int dy) {
        int xx = x + dx;
        int yy = y + dy;
        int len = 0;
        while (xx >= 0 && xx < cs.length && yy >= 0 && yy < cs[0].length) {
            if (cs[xx][yy] == 'X') {
                return new int[]{xx, yy, len};
            } else if (cs[xx][yy] == '.') {
                break;
            }
            xx += dx;
            yy += dy;
            len++;
        }
        return new int[]{xx, yy, 0};
    }

    public int flipChess(String[] chessboard) {
        int n = chessboard.length;
        int m = chessboard[0].length();
        char[][] cs = new char[n][m];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (chessboard[i].charAt(j) == '.') {
                    for (int k = 0; k < 8; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x >= 0 && x < n && y >= 0 && y < m && chessboard[x].charAt(y) == 'O') {
                            q.offer(new int[]{i, j});
                            break;
                        }
                    }
                }
            }
        }
        int ans = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < n; i++) {
                cs[i] = chessboard[i].toCharArray();
            }
            cs[cur[0]][cur[1]] = 'X';
            Queue<int[]> qq = new LinkedList<>();
            qq.offer(cur);
            int res = 0;
            while (!qq.isEmpty()) {
                int[] curr = qq.poll();
                int x = curr[0];
                int y = curr[1];
                for (int i = 0; i < 8; i++) {
                    int[] js = judge(cs, x, y, dx[i], dy[i]);
                    if (js[2] > 0) {
                        int len = js[2];
                        res += len;
                        int xx = x + dx[i];
                        int yy = y + dy[i];
                        while (cs[xx][yy] == 'O') {
                            qq.offer(new int[]{xx, yy});
                            cs[xx][yy] = 'X';
                            xx += dx[i];
                            yy += dy[i];
                        }
                    }
                }
            }
            ans = Math.max(ans, res);
        }
        return ans;
    }
}
