package cn.qiushile.leetcode.hard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import cn.qiushile.leetcode.hard.Solution0460.LFUCache;

public class Solution0460Test {

    private Solution0460 solution0460UnderTest;

    @Before
    public void setUp() throws Exception {
        solution0460UnderTest = new Solution0460();
    }

    @Test
    public void test01() {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        Assert.assertEquals(1, cache.get(1));
        cache.put(3, 3);
        Assert.assertEquals(-1, cache.get(2));
        Assert.assertEquals(3, cache.get(3));
        cache.put(4, 4);
        Assert.assertEquals(3, cache.get(3));
        Assert.assertEquals(4, cache.get(4));
    }

    @Test
    public void test02() {
        LFUCache cache = new LFUCache(2);
        cache.put(3, 1);
        cache.put(2, 1);
        cache.put(2, 2);
        cache.put(4, 4);
        Assert.assertEquals(2, cache.get(2));
    }

    @Test
    public void test08() {
        LFUCache cache = new LFUCache(1);
        cache.put(2, 1);
        Assert.assertEquals(1, cache.get(2));
        cache.put(3, 2);
        Assert.assertEquals(-1, cache.get(2));
        Assert.assertEquals(2, cache.get(3));
    }

    @Test
    public void test17() {
        LFUCache cache = new LFUCache(2);
        Assert.assertEquals(-1, cache.get(2));
        cache.put(2, 6);
        Assert.assertEquals(-1, cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        Assert.assertEquals(2, cache.get(1));
        Assert.assertEquals(6, cache.get(2));
    }
}
