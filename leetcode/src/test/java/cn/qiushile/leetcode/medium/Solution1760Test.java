package cn.qiushile.leetcode.medium;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2024/12/7
 */
public class Solution1760Test {

    Solution1760 solution = new Solution1760();

    @Test
    public void minimumSize2() {
        assertEquals(2, solution.minimumSize(new int[]{2,4,8,2}, 4));
    }
}
