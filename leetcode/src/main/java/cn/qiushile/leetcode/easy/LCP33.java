package cn.qiushile.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * LCP 33. 蓄水
 * 给定 N 个无限容量且初始均空的水缸，每个水缸配有一个水桶用来打水，第 i 个水缸配备的水桶容量记作 bucket[i]。小扣有以下两种操作：
 * 升级水桶：选择任意一个水桶，使其容量增加为 bucket[i]+1
 * 蓄水：将全部水桶接满水，倒入各自对应的水缸
 * 每个水缸对应最低蓄水量记作 vat[i]，返回小扣至少需要多少次操作可以完成所有水缸蓄水要求。
 * 注意：实际蓄水量 达到或超过 最低蓄水量，即完成蓄水要求。
 * 示例 1：
 * 输入：bucket = [1,3], vat = [6,8]
 * 输出：4
 * 解释：
 * 第 1 次操作升级 bucket[0]；
 * 第 2 ~ 4 次操作均选择蓄水，即可完成蓄水要求。
 * vat1.gif
 * 示例 2：
 * 输入：bucket = [9,0,1], vat = [0,2,2]
 * 输出：3
 * 解释：
 * 第 1 次操作均选择升级 bucket[1]
 * 第 2~3 次操作选择蓄水，即可完成蓄水要求。
 * 提示：
 * 1 <= bucket.length == vat.length <= 100
 * 0 <= bucket[i], vat[i] <= 10^4
 * 执行用时：13 ms, 在所有 Java 提交中击败了48.77%的用户
 * 内存消耗：39.1 MB, 在所有 Java 提交中击败了64.81%的用户
 * @author qiushile <qiushile@sina.com>
 * @date 2023/5/21
 */
public class LCP33 {
    public int storeWater(int[] bucket, int[] vat) {
        int n = bucket.length;
        Set<Integer> filled = new HashSet<>(n);
        int base = 0;
        for (int i = 0; i < n; i++) {
            if (vat[i] > 0) {
                if (bucket[i] == 0) {
                    bucket[i]++;
                    base++;
                }
            } else {
                filled.add(i);
            }
        }
        if (n == filled.size()) {
            return 0;
        }
        int left = 0;
        int right = n - 1;
        int ans = Integer.MAX_VALUE;
        int parts = 1;
        while (left <= right) {
            int sum = parts;
            for (int i = left; i <= right; i++) {
                if (filled.contains(i)) {
                    continue;
                }
                if (bucket[i] * parts >= vat[i]) {
                    filled.add(i);
                    continue;
                }
                int re = vat[i] / parts;
                if (re * parts < vat[i]) {
                    re++;
                }
                sum += re - bucket[i];
            }
            ans = Math.min(ans, sum);
            while (left <= right && filled.contains(left)) {
                left++;
            }
            while (left <= right && filled.contains(right)) {
                right--;
            }
            parts++;
        }
        return base + ans;
    }
}
