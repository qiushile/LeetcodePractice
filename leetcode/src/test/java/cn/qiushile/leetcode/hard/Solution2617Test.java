package cn.qiushile.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2024/3/22
 */
public class Solution2617Test {

    private Solution2617 solution = new Solution2617();

    @Test
    public void minimumVisitedCells1() {
        assertEquals(4, solution.minimumVisitedCells(new int[][]{{3,4,2,1},{4,2,3,1},{2,1,0,0},{2,4,0,0}}));
    }
    @Test
    public void minimumVisitedCells2() {
        assertEquals(3, solution.minimumVisitedCells(new int[][]{{3,4,2,1},{4,2,1,1},{2,1,1,0},{3,4,1,0}}));
    }
    @Test
    public void minimumVisitedCells3() {
        assertEquals(-1, solution.minimumVisitedCells(new int[][]{{2,1,0},{1,0,0}}));
    }
}
