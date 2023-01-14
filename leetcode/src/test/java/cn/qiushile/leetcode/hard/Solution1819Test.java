package cn.qiushile.leetcode.hard;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution1819Test {

    private Solution1819 solution1819UnderTest;

    @Before
    public void setUp() throws Exception {
        solution1819UnderTest = new Solution1819();
    }

    @Test
    public void testCountDifferentSubsequenceGCDs01() {
        assertEquals(5, solution1819UnderTest.countDifferentSubsequenceGCDs(new int[]{6,10,3}));
    }

    @Test
    public void testCountDifferentSubsequenceGCDs02() {
        assertEquals(7, solution1819UnderTest.countDifferentSubsequenceGCDs(new int[]{5,15,40,5,6}));
    }

    @Test
    public void testCountDifferentSubsequenceGCDs09() {
        assertEquals(5, solution1819UnderTest.countDifferentSubsequenceGCDs(new int[]{13,7,4,16,1}));
    }

    @Test
    public void testCountDifferentSubsequenceGCDs12() {
        assertEquals(923, solution1819UnderTest.countDifferentSubsequenceGCDs(new int[]{5852,6671,170275,141929,2414,99931,179958,56781,110656,190278,7613,138315,58116,114790,129975,144929,61102,90624,60521,177432,57353,199478,120483,75965,5634,109100,145872,168374,26215,48735,164982,189698,77697,31691,194812,87215,189133,186435,131282,110653,133096,175717,49768,79527,74491,154031,130905,132458,103116,154404,9051,125889,63633,194965,105982,108610,174259,45353,96240,143865,184298,176813,193519,98227,22667,115072,174001,133281,28294,42913,136561,103090,97131,128371,192091,7753,123030,11400,80880,184388,161169,155500,151566,103180,169649,44657,44196,131659,59491,3225,52303,141458,143744,60864,106026,134683,90132,151466,92609,120359,70590,172810,143654,159632,191208,1497,100582,194119,134349,33882,135969,147157,53867,111698,14713,126118,95614,149422,145333,52387,132310,108371,127121,93531,108639,90723,416,141159,141587,163445,160551,86806,120101,157249,7334,60190,166559,46455,144378,153213,47392,24013,144449,66924,8509,176453,18469,21820,4376,118751,3817,197695,198073,73715,65421,70423,28702,163789,48395,90289,76097,18224,43902,41845,66904,138250,44079,172139,71543,169923,186540,77200,119198,184190,84411,130153,124197,29935,6196,81791,101334,90006,110342,49294,67744,28512,66443,191406,133724,54812,158768,113156,5458,59081,4684,104154,38395,9261,188439,42003,116830,184709,132726,177780,111848,142791,57829,165354,182204,135424,118187,58510,137337,170003,8048,103521,176922,150955,84213,172969,165400,111752,15411,193319,78278,32948,55610,12437,80318,18541,20040,81360,78088,194994,41474,109098,148096,66155,34182,2224,146989,9940,154819,57041,149496,120810,44963,184556,163306,133399,9811,99083,52536,90946,25959,53940,150309,176726,113496,155035,50888,129067,27375,174577,102253,77614,132149,131020,4509,85288,160466,105468,73755,4743,41148,52653,85916,147677,35427,88892,112523,55845,69871,176805,25273,99414,143558,90139,180122,140072,127009,139598,61510,17124,190177,10591,22199,34870,44485,43661,141089,55829,70258,198998,87094,157342,132616,66924,96498,88828,89204,29862,76341,61654,158331,187462,128135,35481,152033,144487,27336,84077,10260,106588,19188,99676,38622,32773,89365,30066,161268,153986,99101,20094,149627,144252,58646,148365,21429,69921,95655,77478,147967,140063,29968,120002,72662,28241,11994,77526,3246,160872,175745,3814,24035,108406,30174,10492,49263,62819,153825,110367,42473,30293,118203,43879,178492,63287,41667,195037,26958,114060,99164,142325,77077,144235,66430,186545,125046,82434,26249,54425,170932,83209,10387,7147,2755,77477,190444,156388,83952,117925,102569,82125,104479,16506,16828,83192,157666,119501,29193,65553,56412,161955,142322,180405,122925,173496,93278,67918,48031,141978,54484,80563,52224,64588,94494,21331,73607,23440,197470,117415,23722,170921,150565,168681,88837,59619,102362,80422,10762,85785,48972,83031,151784,79380,64448,87644,26463,142666,160273,151778,156229,24129,64251,57713,5341,63901,105323,18961,70272,144496,18591,191148,19695,5640,166562,2600,76238,196800,94160,129306,122903,40418,26460,131447,86008,20214,133503,174391,45415,47073,39208,37104,83830,80118,28018,185946,134836,157783,76937,33109,54196,37141,142998,189433,8326,82856,163455,176213,144953,195608,180774,53854,46703,78362,113414,140901,41392,12730,187387,175055,64828,66215,16886,178803,117099,112767,143988,65594,141919,115186,141050,118833,2849}));
    }
}
