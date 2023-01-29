package cn.qiushile.leetcode.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * 460. LFU Cache
 * Hard
 * 4.6K
 * 283
 * Companies
 * Design and implement a data structure for a Least Frequently Used (LFU) cache.
 * Implement the LFUCache class:
 * LFUCache(int capacity) Initializes the object with the capacity of the data structure.
 * int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
 * void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
 * To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.
 * When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). The use counter for a key in the cache is incremented either a get or put operation is called on it.
 * The functions get and put must each run in O(1) average time complexity.
 * Example 1:
 * Input
 * ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
 * Explanation
 * // cnt(x) = the use counter for key x
 * // cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
 * LFUCache lfu = new LFUCache(2);
 * lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
 * lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
 * lfu.get(1);      // return 1
 *                  // cache=[1,2], cnt(2)=1, cnt(1)=2
 * lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
 *                  // cache=[3,1], cnt(3)=1, cnt(1)=2
 * lfu.get(2);      // return -1 (not found)
 * lfu.get(3);      // return 3
 *                  // cache=[3,1], cnt(3)=2, cnt(1)=2
 * lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
 *                  // cache=[4,3], cnt(4)=1, cnt(3)=2
 * lfu.get(1);      // return -1 (not found)
 * lfu.get(3);      // return 3
 *                  // cache=[3,4], cnt(4)=1, cnt(3)=3
 * lfu.get(4);      // return 4
 *                  // cache=[4,3], cnt(4)=2, cnt(3)=3
 * Constraints:
 * 0 <= capacity <= 104
 * 0 <= key <= 105
 * 0 <= value <= 109
 * At most 2 * 105 calls will be made to get and put.
 * Runtime 63 ms Beats 93.82% Memory 116.2 MB Beats 99.79%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/29
 */
public class Solution0460 {
    public static class LFUCache {

        int[] values = new int[100001];
        int[] freqs = new int[100001];
        int capacity;
        int used = 0;
        int minf = 0;
        Map<Integer, LinkedHashSet<Integer>> frequencies = new HashMap<>();

        public LFUCache(int capacity) {
            this.capacity = capacity;
            Arrays.fill(values, -1);
        }

        public int get(int key) {
            addFrequency(key);
            return values[key];
        }

        private void addFrequency(int key) {
            if (values[key] > -1) {
                int freq = freqs[key];
                frequencies.get(freq).remove(Integer.valueOf(key));
                if (freq == minf && frequencies.get(freq).isEmpty()) {
                    minf++;
                }
                freq++;
                freqs[key] = freq;
                frequencies.computeIfAbsent(freq, n -> new LinkedHashSet<>()).add(key);
            }
        }

        public void put(int key, int value) {
            if (capacity <= 0) {
                return;
            }
            if (values[key] >= 0) {
                values[key] = value;
                addFrequency(key);
                return;
            }
            if (used == capacity) {
                used--;
                Integer rmKey = frequencies.get(minf).iterator().next();
                values[rmKey] = -1;
                freqs[rmKey] = 0;
                frequencies.get(minf).remove(rmKey);
                if (used == 0) {
                    minf = 0;
                }
                while (used > 0 && frequencies.get(minf).isEmpty()) {
                    minf++;
                }
            }
            used++;
            values[key] = value;
            freqs[key] = 1;
            minf = 1;
            frequencies.computeIfAbsent(1, n -> new LinkedHashSet<>()).add(key);
        }
    }
}
