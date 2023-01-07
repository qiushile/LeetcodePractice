package cn.qiushile.leetcode.contest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution6289Test {

    private Solution6289 solution6289UnderTest;

    @Before
    public void setUp() throws Exception {
        solution6289UnderTest = new Solution6289();
    }

    @Test
    public void testXorBeauty01() {
        assertEquals(5, solution6289UnderTest.xorBeauty(new int[]{1,4}));
    }

    @Test
    public void testXorBeauty02() {
        assertEquals(34, solution6289UnderTest.xorBeauty(new int[]{15,45,20,2,34,35,5,44,32,30}));
    }
}
