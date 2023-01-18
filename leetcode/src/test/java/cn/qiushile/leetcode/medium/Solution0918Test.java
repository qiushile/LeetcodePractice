package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution0918Test {

    private Solution0918 solution0918UnderTest;

    @Before
    public void setUp() throws Exception {
        solution0918UnderTest = new Solution0918();
    }

    @Test
    public void testMaxSubarraySumCircular01() {
        assertEquals(3, solution0918UnderTest.maxSubarraySumCircular(new int[]{1,-2,3,-2}));
    }

    @Test
    public void testMaxSubarraySumCircular02() {
        assertEquals(10, solution0918UnderTest.maxSubarraySumCircular(new int[]{5,-3,5}));
    }

    @Test
    public void testMaxSubarraySumCircular03() {
        assertEquals(-2, solution0918UnderTest.maxSubarraySumCircular(new int[]{-3,-2,-3}));
    }

    @Test
    public void testMaxSubarraySumCircular108() {
        assertEquals(-2, solution0918UnderTest.maxSubarraySumCircular(new int[]{-2}));
    }

    @Test
    public void testMaxSubarraySumCircular109() {
        assertEquals(15, solution0918UnderTest.maxSubarraySumCircular(new int[]{3,1,3,2,6}));
    }
}
