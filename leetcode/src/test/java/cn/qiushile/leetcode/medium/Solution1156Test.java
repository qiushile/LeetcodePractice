package cn.qiushile.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2023/6/3
 */
public class Solution1156Test {

    private Solution1156 solution = new Solution1156();

    @Test
    public void maxRepOpt11() {
        assertEquals(3, solution.maxRepOpt1("ababa"));
    }

    @Test
    public void maxRepOpt12() {
        assertEquals(6, solution.maxRepOpt1("aaabaaa"));
    }

    @Test
    public void maxRepOpt13() {
        assertEquals(5, solution.maxRepOpt1("aaaaa"));
    }

    @Test
    public void maxRepOpt149() {
        assertEquals(4, solution.maxRepOpt1("aaabbaaa"));
    }
}
