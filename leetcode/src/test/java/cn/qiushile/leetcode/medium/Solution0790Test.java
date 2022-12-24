package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution0790Test {

    private Solution0790 solution0790UnderTest;

    @Before
    public void setUp() {
        solution0790UnderTest = new Solution0790();
    }

    @Test
    public void testNumTilings00() {
        for (int i = 25; i < 40; i++) {
            System.out.println(i + ": " + solution0790UnderTest.numTilings(i));
        }
        assertEquals(false, solution0790UnderTest.numTilings(28) > 1000000007);
        //assertEquals(true, solution0790UnderTest.numTilings(29) > 1000000007);
    }

    @Test
    public void testNumTilings01() {
        assertEquals(5, solution0790UnderTest.numTilings(3));
    }

    @Test
    public void testNumTilings02() {
        assertEquals(1, solution0790UnderTest.numTilings(1));
    }
}
