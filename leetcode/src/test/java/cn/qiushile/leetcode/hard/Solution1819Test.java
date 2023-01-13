package cn.qiushile.leetcode.hard;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution1819Test {

    private Solution1819 solution1819UnderTest;

    @Before
    public void setUp() throws Exception {
        solution1819UnderTest = new Solution1819();
    }

    @Test
    public void testCountDifferentSubsequenceGCDs01() {
        assertEquals(5, solution1819UnderTest.countDifferentSubsequenceGCDs(new int[]{6,10,3}));
    }

    @Test
    public void testCountDifferentSubsequenceGCDs02() {
        assertEquals(7, solution1819UnderTest.countDifferentSubsequenceGCDs(new int[]{5,15,40,5,6}));
    }

    @Test
    public void testCountDifferentSubsequenceGCDs09() {
        assertEquals(5, solution1819UnderTest.countDifferentSubsequenceGCDs(new int[]{13,7,4,16,1}));
    }
}
