package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution1574Test {

    private Solution1574 solution1574UnderTest;

    @Before
    public void setUp() throws Exception {
        solution1574UnderTest = new Solution1574();
    }

    @Test
    public void testFindLengthOfShortestSubarray01() {
        assertEquals(3, solution1574UnderTest.findLengthOfShortestSubarray(new int[]{1,2,3,10,4,2,3,5}));
    }

    @Test
    public void testFindLengthOfShortestSubarray02() {
        assertEquals(4, solution1574UnderTest.findLengthOfShortestSubarray(new int[]{5,4,3,2,1}));
    }

    @Test
    public void testFindLengthOfShortestSubarray03() {
        assertEquals(0, solution1574UnderTest.findLengthOfShortestSubarray(new int[]{1,2,3}));
    }

    @Test
    public void testFindLengthOfShortestSubarray72() {
        assertEquals(3, solution1574UnderTest.findLengthOfShortestSubarray(new int[]{2,2,2,1,1,1}));
    }

    @Test
    public void testFindLengthOfShortestSubarray77() {
        assertEquals(8, solution1574UnderTest.findLengthOfShortestSubarray(new int[]{13,0,14,7,18,18,18,16,8,15,20}));
    }

    @Test
    public void testFindLengthOfShortestSubarray94() {
        assertEquals(8, solution1574UnderTest.findLengthOfShortestSubarray(new int[]{6,3,10,11,15,20,13,3,18,12}));
    }

    @Test
    public void testFindLengthOfShortestSubarray109() {
        assertEquals(7, solution1574UnderTest.findLengthOfShortestSubarray(new int[]{10,13,17,21,15,15,9,17,22,22,13}));
    }
}
