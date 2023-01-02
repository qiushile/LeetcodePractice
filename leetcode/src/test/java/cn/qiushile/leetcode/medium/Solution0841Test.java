package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Solution0841Test {

    private Solution0841 solution0841UnderTest;

    @Before
    public void setUp() {
        solution0841UnderTest = new Solution0841();
    }

    @Test
    public void testCanVisitAllRooms1() {
        assertTrue(solution0841UnderTest.canVisitAllRooms(Arrays.asList(Arrays.asList(1),Arrays.asList(2),Arrays.asList(3), new ArrayList<Integer>(0))));
    }

    @Test
    public void testCanVisitAllRooms2() {
        assertFalse(solution0841UnderTest.canVisitAllRooms(Arrays.asList(Arrays.asList(1,3),Arrays.asList(3, 0, 1),Arrays.asList(2), new ArrayList<Integer>(0))));
    }
}
