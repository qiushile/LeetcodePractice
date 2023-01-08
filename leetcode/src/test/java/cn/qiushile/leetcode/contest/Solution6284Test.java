package cn.qiushile.leetcode.contest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Solution6284Test {

    private Solution6284 solution6284UnderTest;

    @Before
    public void setUp() throws Exception {
        solution6284UnderTest = new Solution6284();
    }

    @Test
    public void testIsItPossible01() {
        assertFalse(solution6284UnderTest.isItPossible("ac", "b"));
    }

    @Test
    public void testIsItPossible02() {
        assertTrue(solution6284UnderTest.isItPossible("abcc", "aab"));
    }

    @Test
    public void testIsItPossible03() {
        assertTrue(solution6284UnderTest.isItPossible("abcde", "fghij"));
    }

}
