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
    public void flipChess153() {
        assertEquals(12, solution.flipChess(new String[]{".O.....",".O.....","XOO.OOX",".OO.OO.",".XO.OX.","..X.X.."}));
    }
}
