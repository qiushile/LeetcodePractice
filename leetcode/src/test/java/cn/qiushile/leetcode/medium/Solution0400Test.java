package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution0400Test {

    private Solution0400 solution0400UnderTest;

    @Before
    public void setUp() throws Exception {
        solution0400UnderTest = new Solution0400();
    }

    @Test
    public void testFindNthDigit10() {
        assertEquals(1, solution0400UnderTest.findNthDigit(10));
    }

    @Test
    public void testFindNthDigit133() {
        assertEquals(1, solution0400UnderTest.findNthDigit(133));
    }
    @Test
    public void testFindNthDigit44444() {
        assertEquals(0, solution0400UnderTest.findNthDigit(44444));
    }
    @Test
    public void testFindNthDigit1000000000() {
        assertEquals(1, solution0400UnderTest.findNthDigit(1000000000));
    }
}
