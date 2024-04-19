package cn.qiushile.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2024/4/19
 */
public class Solution0018Test {

    Solution0018 solution = new Solution0018();

    @Test
    public void fourSum1() {
        assertEquals(3, solution.fourSum(new int[]{1,0,-1,0,-2,2}, 0).size());
    }
}
