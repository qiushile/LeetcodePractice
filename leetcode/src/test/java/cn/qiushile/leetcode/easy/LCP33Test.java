package cn.qiushile.leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2023/5/21
 */
public class LCP33Test {

    private LCP33 solution = new LCP33();

    @Test
    public void storeWater1() {
        assertEquals(4, solution.storeWater(new int[]{1,3}, new int[]{6,8}));
    }

    @Test
    public void storeWater2() {
        assertEquals(3, solution.storeWater(new int[]{9,0,1}, new int[]{0,2,2}));
    }

    @Test
    public void storeWater09() {
        assertEquals(0, solution.storeWater(new int[]{3,2,5}, new int[]{0,0,0}));
    }

    @Test
    public void storeWater12() {
        assertEquals(13, solution.storeWater(new int[]{2,27,24,75}, new int[]{53,52,28,82}));
    }

    @Test
    public void storeWater31() {
        assertEquals(174, solution.storeWater(
                new int[]{6946,1211,4548,1685,4842,7665,4215,8583,347,2050,6739,9363,2302,3913,8829,1848,7619,5816,7003,2717,4354,5517,6810,3917,9400,7767,7687,66,4736,8092,2960,9985,3026,7557,2442,4417,8319,1933,9530,6214,326,490,4446,8179,4315,6762,3839,3370,9486,5018,5369,539,4826,8359,7663,6714,2621,5871,368,47,50,4574,4918,7023,5749,1937,5341,3557,9993,6702,8461,438,6757,1505,9815,2354,3427,603,7149,8148,9861,2228,2168,7176,4916,3958,5517,3648,2210,242,2132,2649,5840,6060,4556,1978,37,559,2301,2111},
                new int[]{7807,8501,9509,9424,8131,9529,9733,9396,5226,4789,9403,9943,3788,6090,9632,2497,9985,8748,7159,4995,9933,9088,8958,9161,9642,9460,9843,483,7040,8952,6202,9985,6267,8794,3895,5877,9463,4491,9617,9951,2944,3900,5882,8660,6613,8709,9848,3953,9594,9519,8015,7571,7032,8963,8856,6823,9423,8557,6895,8632,9690,5980,6376,8718,9525,8943,7750,9670,9997,8983,9386,1649,8236,2276,9958,3273,9614,4692,8065,8726,9935,7931,6915,9930,5931,5502,6875,7322,3549,5460,6831,3641,9404,8929,7623,2230,4168,8526,5111,3014}));
    }
}
