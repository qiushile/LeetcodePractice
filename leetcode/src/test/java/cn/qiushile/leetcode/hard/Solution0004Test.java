package cn.qiushile.leetcode.hard;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution0004Test {

    private Solution0004 solution0004UnderTest;

    @Before
    public void setUp() throws Exception {
        solution0004UnderTest = new Solution0004();
    }

    @Test
    public void testFindMedianSortedArrays0() {
        assertEquals(5.0, solution0004UnderTest.findMedianSortedArrays(new int[]{1,3,4,5,6,11,13,45}, new int[]{2,3,4,5,6,11}), 0.0001);
    }

    @Test
    public void testFindMedianSortedArrays00() {
        assertEquals(5.0, solution0004UnderTest.findMedianSortedArrays(new int[]{1,3,4,5,6,11,13,45,88}, new int[]{2,3,4,5,6,11}), 0.0001);
    }

    @Test
    public void testFindMedianSortedArrays000() {
        assertEquals(5.5, solution0004UnderTest.findMedianSortedArrays(new int[]{1,3,4,5,6,11,13,45,88}, new int[]{2,3,4,5,6,11,22}), 0.0001);
    }

    @Test
    public void testFindMedianSortedArrays0000() {
        assertEquals(5.0, solution0004UnderTest.findMedianSortedArrays(new int[]{1,3,4,5,6,13,45,88}, new int[]{2,3,4,5,6,11,22}), 0.0001);
    }

    @Test
    public void testFindMedianSortedArrays01() {
        assertEquals(2.0, solution0004UnderTest.findMedianSortedArrays(new int[]{1,3}, new int[]{2}), 0.0001);
    }

    @Test
    public void testFindMedianSortedArrays02() {
        assertEquals(2.5, solution0004UnderTest.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}), 0.0001);
    }
}
