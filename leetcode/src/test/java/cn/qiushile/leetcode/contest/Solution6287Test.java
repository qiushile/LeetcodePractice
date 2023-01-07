package cn.qiushile.leetcode.contest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution6287Test {

    private Solution6287 solution6287UnderTest;

    @Before
    public void setUp() throws Exception {
        solution6287UnderTest = new Solution6287();
    }

    @Test
    public void testCategorizeBox01() {
        assertEquals("Heavy", solution6287UnderTest.categorizeBox(1000, 35, 700, 300));
    }

    @Test
    public void testCategorizeBox02() {
        assertEquals("Neither", solution6287UnderTest.categorizeBox(200, 50, 800, 50));
    }
    @Test
    public void testCategorizeBoxError() {
        assertEquals("Both", solution6287UnderTest.categorizeBox(2909, 3968, 3272, 727));
    }
}
