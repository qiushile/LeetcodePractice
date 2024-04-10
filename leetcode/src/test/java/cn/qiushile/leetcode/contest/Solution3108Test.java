package cn.qiushile.leetcode.contest;

import cn.qiushile.leetcode.hard.Solution3108;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2024/4/7
 */
public class Solution3108Test {

    Solution3108 solution = new Solution3108();

    @Test
    public void minimumCost1() {
        assertArrayEquals(new int[]{0, 0, 0}, solution.minimumCost(10,
                new int[][]{{9,7,9},{8,3,7},{7,0,11},{6,3,8},{6,1,3},{7,3,0},{2,3,9},{8,9,12}},
                new int[][]{{0,6},{1,0},{2,9}}));
    }
}
