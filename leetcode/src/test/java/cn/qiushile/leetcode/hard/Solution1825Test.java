package cn.qiushile.leetcode.hard;

import org.junit.Before;
import cn.qiushile.leetcode.hard.Solution1825.MKAverage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution1825Test {

    private Solution1825 solution1825UnderTest;

    @Before
    public void setUp() throws Exception {
        solution1825UnderTest = new Solution1825();
    }
    @Test
    public void test01() {
        MKAverage mk = new MKAverage(3, 1);
        mk.addElement(3);
        mk.addElement(1);
        assertEquals(-1, mk.calculateMKAverage());
        mk.addElement(10);
        assertEquals(3, mk.calculateMKAverage());
        mk.addElement(5);
        mk.addElement(5);
        mk.addElement(5);
        assertEquals(5, mk.calculateMKAverage());
    }
    @Test
    public void test02() {
        MKAverage mk = new MKAverage(3, 1);
        mk.addElement(17612);
        mk.addElement(74607);
        assertEquals(-1, mk.calculateMKAverage());
        mk.addElement(8272);
        mk.addElement(33433);
        assertEquals(33433, mk.calculateMKAverage());
        mk.addElement(15456);
        mk.addElement(64938);
        assertEquals(33433, mk.calculateMKAverage());
        mk.addElement(99741);
    }

    @Test
    public void test002() {
        MKAverage mk = new MKAverage(20, 9);
        mk.addElement(2);
        mk.addElement(1);
        mk.addElement(6);
        mk.addElement(5);
        mk.addElement(8);
        mk.addElement(7);
        mk.addElement(5);
        mk.addElement(7);
        mk.addElement(6);
        mk.addElement(5);
        mk.addElement(4);
        mk.addElement(5);
        mk.addElement(5);
        mk.addElement(8);
        mk.addElement(9);
        mk.addElement(7);
        mk.addElement(6);
        mk.addElement(3);
        mk.addElement(6);
        mk.addElement(9);
        mk.addElement(4);
        mk.addElement(6);
        mk.addElement(6);
        mk.addElement(8);
        mk.addElement(7);
        mk.addElement(6);
        mk.addElement(8);
        mk.addElement(9);
        assertEquals(6, mk.calculateMKAverage());

    }
}
