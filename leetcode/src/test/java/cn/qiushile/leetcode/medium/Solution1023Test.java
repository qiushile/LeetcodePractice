package cn.qiushile.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2023/4/14
 */
public class Solution1023Test {

    Solution1023 solution = new Solution1023();

    @Test
    public void camelMatch03() {
        assertArrayEquals(new Boolean[]{false,true,false,false,false},
                solution.camelMatch(new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"}, "FoBaT")
                        .stream().toArray());
    }

    @Test
    public void camelMatch32() {
        assertArrayEquals(new Boolean[]{true,true,true,true,true,true,true},
                solution.camelMatch(new String[]{"kqshppmjgjfB","mkqsthpypmgB","kqshppmtgttB","lklqsphppmgB","kqesshppwmgB","kqshpzlcpmgB","kqsyhppmhfgB"}, "kqshppmgB")
                        .stream().toArray());
    }
}
