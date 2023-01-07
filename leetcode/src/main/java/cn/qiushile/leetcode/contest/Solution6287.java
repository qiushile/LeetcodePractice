package cn.qiushile.leetcode.contest;

/**
 * 6287. Categorize Box According to Criteria
 * User Accepted:0
 * User Tried:16
 * Total Accepted:0
 * Total Submissions:16
 * Difficulty:Easy
 * Given four integers length, width, height, and mass, representing the dimensions and mass of a box, respectively, return a string representing the category of the box.
 * The box is "Bulky" if:
 * Any of the dimensions of the box is greater or equal to 104.
 * Or, the volume of the box is greater or equal to 109.
 * If the mass of the box is greater or equal to 100, it is "Heavy".
 * If the box is both "Bulky" and "Heavy", then its category is "Both".
 * If the box is neither "Bulky" nor "Heavy", then its category is "Neither".
 * If the box is "Bulky" but not "Heavy", then its category is "Bulky".
 * If the box is "Heavy" but not "Bulky", then its category is "Heavy".
 * Note that the volume of the box is the product of its length, width and height.
 * Example 1:
 * Input: length = 1000, width = 35, height = 700, mass = 300
 * Output: "Heavy"
 * Explanation:
 * None of the dimensions of the box is greater or equal to 104.
 * Its volume = 24500000 <= 109. So it cannot be categorized as "Bulky".
 * However mass >= 100, so the box is "Heavy".
 * Since the box is not "Bulky" but "Heavy", we return "Heavy".
 * Example 2:
 * Input: length = 200, width = 50, height = 800, mass = 50
 * Output: "Neither"
 * Explanation:
 * None of the dimensions of the box is greater or equal to 104.
 * Its volume = 8 * 106 <= 109. So it cannot be categorized as "Bulky".
 * Its mass is also less than 100, so it cannot be categorized as "Heavy" either.
 * Since its neither of the two above categories, we return "Neither".
 * Constraints:
 * 1 <= length, width, height <= 105
 * 1 <= mass <= 103
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/7
 */
public class Solution6287 {
    public String categorizeBox(int length, int width, int height, int mass) {
        boolean bulky = length >= 10000 || width >= 10000 || height >= 10000 ||
                1L * length * width * height >= 1000000000L;
        boolean heavy = mass >= 100;
        if (bulky && heavy) {
            return "Both";
        } else if (bulky) {
            return "Bulky";
        } else if (heavy) {
            return "Heavy";
        } else {
            return "Neither";
        }
    }
}
