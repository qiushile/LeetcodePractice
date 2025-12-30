package cn.qiushile.leetcode.medium;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2025/12/30
 */
public class Solution0840Test {

    private Solution0840 solution = new Solution0840();

    @Test
    public void numMagicSquaresInside1() {
        assertEquals(1, solution.numMagicSquaresInside(new int[][]{{4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}}));
    }

    @Test
    public void numMagicSquaresInside050() {
        assertEquals(0, solution.numMagicSquaresInside(new int[][]{{8,7,9,2,4,7},{3,2,7,5,10,3},{8,4,0,8,1,8},{1,6,5,7,9,1},{6,4,9,2,3,5},{7,0,6,1,8,6}}));
    }
    @Test
    public void numMagicSquaresInside100() {
        assertEquals(0, solution.numMagicSquaresInside(new int[][]{{3,8,1},{4,5,6},{9,2,7}}));
    }
}
