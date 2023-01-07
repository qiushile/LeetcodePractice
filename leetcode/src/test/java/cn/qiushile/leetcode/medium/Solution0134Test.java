package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution0134Test {

    private Solution0134 solution0134UnderTest;

    @Before
    public void setUp() throws Exception {
        solution0134UnderTest = new Solution0134();
    }

    @Test
    public void testCanCompleteCircuit01() {
        assertEquals(3, solution0134UnderTest.canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
    }

    @Test
    public void testCanCompleteCircuit02() {
        assertEquals(-1, solution0134UnderTest.canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3}));
    }

    @Test
    public void testCanCompleteCircuit29() {
        assertEquals(0, solution0134UnderTest.canCompleteCircuit(new int[]{3,1,1}, new int[]{1,2,2}));
    }

    @Test
    public void testCanCompleteCircuit32() {
        assertEquals(0, solution0134UnderTest.canCompleteCircuit(new int[]{5}, new int[]{4}));
    }
}
