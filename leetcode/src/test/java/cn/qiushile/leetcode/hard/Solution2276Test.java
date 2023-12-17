package cn.qiushile.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2023/12/16
 */
public class Solution2276Test {

    @Test
    public void test01() {
        Solution2276.CountIntervals countIntervals = new Solution2276.CountIntervals();
        countIntervals.add(2, 3);
        countIntervals.add(7, 10);
        assertEquals(6, countIntervals.count());
        countIntervals.add(5, 8);
        assertEquals(8, countIntervals.count());
    }

    @Test
    public void test014() {
        Solution2276.CountIntervals countIntervals = new Solution2276.CountIntervals();
        assertEquals(0, countIntervals.count());
        countIntervals.add(8, 43);
        countIntervals.add(13, 16);
        countIntervals.add(26, 33);
        countIntervals.add(28, 36);
        countIntervals.add(29, 37);
        assertEquals(36, countIntervals.count());
        countIntervals.add(34, 46);
        countIntervals.add(10, 23);
    }

    @Test
    public void test023() {
        Solution2276.CountIntervals countIntervals = new Solution2276.CountIntervals();
        assertEquals(0, countIntervals.count());
        countIntervals.add(10, 27); // 18
        countIntervals.add(46, 50); // 18 + 15 = 23
        countIntervals.add(15, 35); // 21 +15 = 36
        countIntervals.add(12, 32);
        countIntervals.add(7, 15);
        countIntervals.add(49, 49);
        assertEquals(34, countIntervals.count());
    }

}
