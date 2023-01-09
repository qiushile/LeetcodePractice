package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Solution0347Test {

    private Solution0347 solution0347UnderTest;

    @Before
    public void setUp() throws Exception {
        solution0347UnderTest = new Solution0347();
    }

    @Test
    public void testTopKFrequent01() {
        assertArrayEquals(new int[]{1,2}, solution0347UnderTest.topKFrequent(new int[]{1,1,1,2,2,3}, 2));
    }

    @Test
    public void testTopKFrequent02() {
        assertArrayEquals(new int[]{1}, solution0347UnderTest.topKFrequent(new int[]{1}, 1));
    }
}
