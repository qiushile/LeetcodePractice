
package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution1664Test {

    private Solution1664 solution1664UnderTest;

    @Before
    public void setUp() throws Exception {
        solution1664UnderTest = new Solution1664();
    }

    @Test
    public void testWaysToMakeFair001() {
        assertEquals(1, solution1664UnderTest.waysToMakeFair(new int[]{2,1,6,4}));
    }

    @Test
    public void testWaysToMakeFair007() {
        assertEquals(5, solution1664UnderTest.waysToMakeFair(new int[]{1,1,1,1,1}));
    }
}
