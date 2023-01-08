package cn.qiushile.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 149. Max Points on a Line
 * Hard
 * 2.7K
 * 351
 * Companies
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.
 * Example 1:
 * Input: points = [[1,1],[2,2],[3,3]]
 * Output: 3
 * Example 2:
 * Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 * Constraints:
 * 1 <= points.length <= 300
 * points[i].length == 2
 * -104 <= xi, yi <= 104
 * All the points are unique.
 * Accepted
 * 294.3K
 * Submissions
 * 1.3M
 * Acceptance Rate
 * 23.4%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/8
 */
public class Solution0149 {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }
        int max = 2;
        Map<String, Set<String>> counts = new HashMap<>();

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int x1 = points[j][0];
                int y1 = points[j][1];
                int x2 = points[i][0];
                int y2 = points[i][1];
                int a = y1 - y2;
                int b = x2 - x1;
                if (a < 0) {
                    a = -a;
                    b = -b;
                }
                int gcd = gcd(a, b < 0? -b: b);
                if (gcd > 1) {
                    a /= gcd;
                    b /= gcd;
                }
                int c = - a * x1 - b * y1;
                if (a == 0) {
                    c = c / b;
                    b = 1;
                }
                if (b == 0) {
                    c = c / a;
                    a = 1;
                }
                String k = "" + a + "," + b + "," + c;
                if (counts.containsKey(k)) {
                    Set<String> v = counts.get(k);
                    v.add("" + x1 + "," + y1);
                    v.add("" + x2 + "," + y2);
                    if (v.size() > max) {
                        max = v.size();
                    }
                } else {
                    Set<String> v = new HashSet<>();
                    v.add("" + x1 + "," + y1);
                    v.add("" + x2 + "," + y2);
                    counts.put(k, v);
                }
            }
        }

        return max;
    }

    public int gcd(int a, int b) {
        if (a < b) {
            return gcd(b, a);
        }
        if (b == 0) {
            return 0;
        }
        int c = a % b;
        while (c != 0) {
            a = b;
            b = c;
            c = a % b;
        }
        return b;
    }
}
