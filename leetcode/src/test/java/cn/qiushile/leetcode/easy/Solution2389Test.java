package cn.qiushile.leetcode.easy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Solution2389Test {

    private Solution2389 solution2389UnderTest;

    @Before
    public void setUp() {
        solution2389UnderTest = new Solution2389();
    }

    @Test
    public void testAnswerQueries01() {
        assertArrayEquals(new int[]{2,3,4}, solution2389UnderTest.answerQueries(new int[]{4,5,2,1}, new int[]{3,10,21}));
    }

    @Test
    public void testAnswerQueries02() {
        assertArrayEquals(new int[]{0}, solution2389UnderTest.answerQueries(new int[]{2,3,4,5}, new int[]{1}));
    }

    @Test
    public void testAnswerQueries15() {
        assertArrayEquals(new int[]{2,2,1,1,2,3,3}, solution2389UnderTest.answerQueries(new int[]{736411,184882,914641,37925,214915}, new int[]{331244,273144,118983,118252,305688,718089,665450}));
    }
}
