package cn.qiushile.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2024/4/17
 */
public class Solutioin0928Test {

    Solutioin0928 solutioin = new Solutioin0928();

    @Test
    public void minMalwareSpread() {
        assertEquals(3, solutioin.minMalwareSpread(new int[][]{{1,0,0,0,0,0,0,0,1},{0,1,0,1,0,0,0,0,0},{0,0,1,1,0,1,0,0,0},{0,1,1,1,1,0,1,0,0},{0,0,0,1,1,1,0,0,0},{0,0,1,0,1,1,0,0,0},{0,0,0,1,0,0,1,1,0},{0,0,0,0,0,0,1,1,1},{1,0,0,0,0,0,0,1,1}}, new int[]{3,7}));
    }
}
