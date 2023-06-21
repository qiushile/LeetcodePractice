package cn.qiushile.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2023/6/21
 */
public class LCP41Test {

    private LCP41 solution = new LCP41();

    @Test
    public void flipChess1() {
        assertEquals(3, solution.flipChess(new String[]{"....X.","....X.","XOOO..","......","......"}));
    }

    @Test
    public void flipChess2() {
        assertEquals(2, solution.flipChess(new String[]{".X.",".O.","XO."}));
    }

    @Test
    public void flipChess3() {
        assertEquals(4, solution.flipChess(new String[]{".......",".......",".......","X......",".O.....","..O....","....OOX"}));
    }

    @Test
    public void flipChess153() {
        assertEquals(10, solution.flipChess(new String[]{".O.....",".O.....","XOO.OOX",".OO.OO.",".XO.OX.","..X.X.."}));
    }
}
