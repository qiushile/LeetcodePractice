package cn.qiushile.leetcode.contest;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2023/5/7
 */
public class Spring2023T4Test {

    private Spring2023T4 solution = new Spring2023T4();

    @Test
    public void evolutionaryRecord1() {
        assertEquals("00110", solution.evolutionaryRecord(new int[]{-1,0,0,2}));
    }

    @Test
    public void evolutionaryRecord2() {
        assertEquals("00101100", solution.evolutionaryRecord(new int[]{-1,0,0,1,2,2}));
    }
}
