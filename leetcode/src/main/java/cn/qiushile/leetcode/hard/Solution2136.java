package cn.qiushile.leetcode.hard;

import java.util.Random;

/**
 * 2136. Earliest Possible Day of Full Bloom
 * You have n flower seeds. Every seed must be planted first before it can begin to grow, then bloom. Planting a seed takes time and so does the growth of a seed. You are given two 0-indexed integer arrays plantTime and growTime, of length n each:
 * plantTime[i] is the number of full days it takes you to plant the ith seed. Every day, you can work on planting exactly one seed. You do not have to work on planting the same seed on consecutive days, but the planting of a seed is not complete until you have worked plantTime[i] days on planting it in total.
 * growTime[i] is the number of full days it takes the ith seed to grow after being completely planted. After the last day of its growth, the flower blooms and stays bloomed forever.
 * From the beginning of day 0, you can plant the seeds in any order.
 * Return the earliest possible day where all seeds are blooming.
 * Example 1:
 * Input: plantTime = [1,4,3], growTime = [2,3,1]
 * Output: 9
 * Explanation: The grayed out pots represent planting days, colored pots represent growing days, and the flower represents the day it blooms.
 * One optimal way is:
 * On day 0, plant the 0th seed. The seed grows for 2 full days and blooms on day 3.
 * On days 1, 2, 3, and 4, plant the 1st seed. The seed grows for 3 full days and blooms on day 8.
 * On days 5, 6, and 7, plant the 2nd seed. The seed grows for 1 full day and blooms on day 9.
 * Thus, on day 9, all the seeds are blooming.
 * Example 2:
 * Input: plantTime = [1,2,3,2], growTime = [2,1,2,1]
 * Output: 9
 * Explanation: The grayed out pots represent planting days, colored pots represent growing days, and the flower represents the day it blooms.
 * One optimal way is:
 * On day 1, plant the 0th seed. The seed grows for 2 full days and blooms on day 4.
 * On days 0 and 3, plant the 1st seed. The seed grows for 1 full day and blooms on day 5.
 * On days 2, 4, and 5, plant the 2nd seed. The seed grows for 2 full days and blooms on day 8.
 * On days 6 and 7, plant the 3rd seed. The seed grows for 1 full day and blooms on day 9.
 * Thus, on day 9, all the seeds are blooming.
 * Example 3:
 * Input: plantTime = [1], growTime = [1]
 * Output: 2
 * Explanation: On day 0, plant the 0th seed. The seed grows for 1 full day and blooms on day 2.
 * Thus, on day 2, all the seeds are blooming.
 * Constraints:
 * n == plantTime.length == growTime.length
 * 1 <= n <= 105
 * 1 <= plantTime[i], growTime[i] <= 104
 *
 * Runtime 480 ms Beats 5.5% Memory 55 MB Beats 88.50%
 *
 * @author qiushile <qiushile@sina.com>
 * @date 2022/12/21
 */
public class Solution2136 {

    public int earliestFullBloom(int[] plantTime, int[] growTime) {

        // sort by growTime
        quickSort(plantTime, growTime, 0, growTime.length - 1);
        int len = plantTime.length;

        // sort by plantTime
        int sortPoint;
        int tmp;
        for (int i = 1; i < len - 1; i++) {
            if (growTime[i] > growTime[i - 1]) {
                continue;
            }
            sortPoint = i;
            while (sortPoint > 0 && growTime[sortPoint] == growTime[sortPoint - 1] && plantTime[sortPoint] < growTime[sortPoint - 1]) {
                tmp = plantTime[sortPoint];
                plantTime[sortPoint] = plantTime[sortPoint - 1];
                plantTime[sortPoint - 1] = tmp;
                sortPoint--;
            }
        }

        // calculate
        int sumTime = plantTime[0] + growTime[0];
        for (int i = 1; i < len; i++) {
            int pt = plantTime[i];
            int gt = growTime[i];

            if (gt >= sumTime) {
                sumTime = gt + pt;
            } else {
                sumTime += pt;
            }
        }
        return sumTime;
    }

    private final Random random = new Random();

    private void quickSort(int[] plantTime, int[] growTime, int low, int high) {
        if (low < 0 || high <= low) {
            return;
        }
        if (high - low > 5) {
            // select a random pivot
            int randomIndex = low + random.nextInt(high - low);
            int tmp = plantTime[randomIndex];
            plantTime[randomIndex] = plantTime[low];
            plantTime[low] = tmp;
            tmp = growTime[randomIndex];
            growTime[randomIndex] = growTime[low];
            growTime[low] = tmp;
        }
        int pivot = growTime[low];
        int pivotPlant = plantTime[low];
        int left = low;
        int right = high;
        while (left < right) {
            while (left < right && growTime[right] > pivot) {
                right--;
            }
            if (left < right) {
                plantTime[left] = plantTime[right];
                growTime[left] = growTime[right];
                left++;
            }
            while (left < right && growTime[left] < pivot) {
                left++;
            }
            if (left < right) {
                plantTime[right] = plantTime[left];
                growTime[right] = growTime[left];
                right--;
            }
        }
        growTime[left] = pivot;
        plantTime[left] = pivotPlant;
        quickSort(plantTime, growTime, low, left - 1);
        quickSort(plantTime, growTime, left + 1, high);
    }
}
