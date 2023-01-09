package cn.qiushile.leetcode.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution0752Test {

    private Solution0752 solution0752UnderTest;

    @Before
    public void setUp() throws Exception {
        solution0752UnderTest = new Solution0752();
    }

    @Test
    public void testOpenLock01() {
        assertEquals(6, solution0752UnderTest.openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202"));
    }

    @Test
    public void testOpenLock02() {
        assertEquals(1, solution0752UnderTest.openLock(new String[]{"8888"}, "0009"));
    }

    @Test
    public void testOpenLock03() {
        assertEquals(-1, solution0752UnderTest.openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"));
    }
}
