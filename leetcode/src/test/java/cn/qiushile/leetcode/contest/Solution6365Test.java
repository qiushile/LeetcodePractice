package cn.qiushile.leetcode.contest;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2023/4/2
 */
public class Solution6365Test {

    Solution6365 solution = new Solution6365();

    @Test
    public void testMinReverseOperations() {
        Assert.assertArrayEquals(new int[]{0,1,2,3,4}, solution.minReverseOperations(5, 0, new int[0], 2));
    }

    @Test
    public void testMinReverseOperations689() {
    }
}
