package cn.qiushile.leetcode.hard;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution1012Test {

    private Solution1012 solution1012UnderTest;

    @Before
    public void setUp() throws Exception {
        solution1012UnderTest = new Solution1012();
    }

    @Test
    public void testNumDupDigitsAtMostN01() {
        assertEquals(1, solution1012UnderTest.numDupDigitsAtMostN(20));
    }

    @Test
    public void testNumDupDigitsAtMostN02() {
        assertEquals(10, solution1012UnderTest.numDupDigitsAtMostN(100));
    }

    @Test
    public void testNumDupDigitsAtMostN03() {
        assertEquals(262, solution1012UnderTest.numDupDigitsAtMostN(1000));
    }

    @Test
    public void testNumDupDigitsAtMostN04() {
        assertEquals(1, solution1012UnderTest.numDupDigitsAtMostN(11));
    }

    @Test
    public void testNumDupDigitsAtMostN05() {
        assertEquals(0, solution1012UnderTest.numDupDigitsAtMostN(1));
    }

    @Test
    public void testNumDupDigitsAtMostN39() {
        assertEquals(1, solution1012UnderTest.numDupDigitsAtMostN(21));
    }
}
