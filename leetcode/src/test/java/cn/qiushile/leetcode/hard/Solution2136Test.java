package cn.qiushile.leetcode.hard;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution2136Test {

    private Solution2136 solution2136UnderTest;

    @Before
    public void setUp() {
        solution2136UnderTest = new Solution2136();
    }

    @Test
    public void testEarliestFullBloom001() {
        assertEquals(9, solution2136UnderTest.earliestFullBloom(new int[]{1,4,3}, new int[]{2,3,1}));
    }

    @Test
    public void testEarliestFullBloom002() {
        assertEquals(9, solution2136UnderTest.earliestFullBloom(new int[]{1,2,3,2}, new int[]{2,1,2,1}));
    }

    @Test
    public void testEarliestFullBloom003() {
        assertEquals(2, solution2136UnderTest.earliestFullBloom(new int[]{1}, new int[]{1}));
    }

    @Test
    public void testEarliestFullBloom021() {
        assertEquals(227, solution2136UnderTest.earliestFullBloom(
                new int[]{3, 11,29,4, 4, 26,26,12,13,10,30,19,27,2,10},
                new int[]{10,13,22,17,18,15,21,11,24,14,18,23,1, 30,6}));
    }

    @Test
    public void testEarliestFullBloom176() {
        assertEquals(348, solution2136UnderTest.earliestFullBloom(
                new int[]{27,5,24,17,27,4, 23,16,6, 26,13,17,21,3,9, 10,28,26,4, 10,28,2},
                new int[]{26,9,14,17,6, 14,23,24,11,6, 27,14,13,1,15,5, 12,15,23,27,28,12}));
    }

    @Test
    public void testEarliestFullBloom177() {
        assertEquals(481461, solution2136UnderTest.earliestFullBloom(
                new int[]{1164,2292,8263,3504,6860,2661,5,7,8671,2377,6426,5372,5917,6242,8282,8,2,6554,3,7374,7723,
                        3295,7309,6744,4,2018,8614,3898,5,7,1,3316,7589,3019,2173,8252,9,6242,4151,5097,6,8,5,6200,5,
                        4263,2,8675,5706,2425,3717,6798,6,5,1,8697,7792,5,2451,1,1029,5,9,9,5945,7,1502,8433,6720,8368,
                        4355,2564,2,8016,10,5990,4275,4433,3640,8020,5787,10,5922,8901,8687,2374,1,4,10,4186,2605,2020,
                        6585,4657,4419,2239,3319,6503,2,3096,4111,7,7915,1640,9,1404,4,6,10,2291,3190,3,5075,1,5183,8,
                        3973,4,8,2767,2016,7,8,4284,8,1795,1657,4,2,2991,2752,4607,3663,4,5,6779,1794,5,4498,4353,9,7,
                        3811,2887,8029,3,6974,7894,1581,10,10,4284,7,3468},
                new int[]{8701,6788,5718,3003,5677,7567,1,7,3848,2498,4812,7192,7797,6956,1906,8,2,6265,4,2269,3513,
                        3894,6322,6058,4,4709,1829,2126,10,3,2,7665,7619,5674,1821,5191,3,1548,7864,8475,4,1,7,2636,5,
                        8573,8,5674,6549,8594,7681,4537,6,10,6,2140,5562,7,8913,6,3411,1,3,5,1449,4,1887,4117,6544,1586,
                        6281,5472,5,8346,7,7098,1082,6387,8352,2807,7837,7,3684,7045,1647,1642,7,9,4,1198,5876,8941,
                        7359,6094,3849,5330,6491,8788,4,5889,3054,4,2977,2991,3,3078,3,7,2,5877,6873,4,5504,4,3931,5,
                        3357,1,6,3863,1352,2,5,8948,10,5519,5185,2,9,3025,3428,1546,2202,7,6,3965,4673,7,7182,6983,6,1,
                        1818,4598,8725,4,3892,8785,3164,5,1,5648,5,1718}));
    }
}
