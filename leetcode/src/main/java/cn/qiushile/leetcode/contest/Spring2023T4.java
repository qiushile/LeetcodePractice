package cn.qiushile.leetcode.contest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 4. 生物进化录
 * 通过的用户数32
 * 尝试过的用户数46
 * 用户总通过次数32
 * 用户总提交次数59
 * 题目难度Hard
 * 在永恒之森中，存在着一本生物进化录，以 一个树形结构 记载了所有生物的演化过程。经过观察并整理了各节点间的关系，parents[i] 表示编号 i 节点的父节点编号(根节点的父节点为 -1)。
 * 为了探索和记录其中的演化规律，队伍中的炼金术师提出了一种方法，可以以字符串的形式将其复刻下来，规则如下：
 * 初始只有一个根节点，表示演化的起点，依次记录 01 字符串中的字符，
 * 如果记录 0，则在当前节点下添加一个子节点，并将指针指向新添加的子节点；
 * 如果记录 1，则将指针回退到当前节点的父节点处。
 * 现在需要应用上述的记录方法，复刻下它的演化过程。请返回能够复刻演化过程的字符串中， 字典序最小 的 01 字符串。
 * 注意：
 * 节点指针最终可以停在任何节点上，不一定要回到根节点。
 * 示例 1：
 * 输入：parents = [-1,0,0,2]
 * 输出："00110"
 * 解释：树结构如下图所示，共存在 2 种记录方案：
 * 第 1 种方案为：0(记录编号 1 的节点) -> 1(回退至节点 0) -> 0(记录编号 2 的节点) -> 0((记录编号 3 的节点))
 * 第 2 种方案为：0(记录编号 2 的节点) -> 0(记录编号 3 的节点) -> 1(回退至节点 2) -> 1(回退至节点 0) -> 0(记录编号 1 的节点)
 * 返回字典序更小的 "00110"
 * image.png进化 (3).gif
 * 示例 2：
 * 输入：parents = [-1,0,0,1,2,2]
 * 输出："00101100"
 * 提示：
 * 1 <= parents.length <= 10^4
 * -1 <= parents[i] < i (即父节点编号小于子节点)
 * @author qiushile <qiushile@sina.com>
 * @date 2023/5/7
 */
public class Spring2023T4 {
    public String evolutionaryRecord(int[] ps) {
        int n = ps.length;
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            if (ps[i] >= 0) {
                cnt[ps[i]]++;
            }
        }
        List<String>[] paths = new ArrayList[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (cnt[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            Integer curr = q.poll();
            int p = ps[curr];
            StringBuilder sb = new StringBuilder();
            if (p != -1) {
                sb.append("0");
            }
            if (paths[curr] != null && paths[curr].size() > 0) {
                Collections.sort(paths[curr], (a, b) -> (a + b).compareTo(b + 1));
                for (String path : paths[curr]) {
                    sb.append(path);
                }
            }
            if (p != -1) {
                sb.append("1");
                if (paths[p] == null) {
                    paths[p] = new ArrayList<>();
                }
                paths[p].add(sb.toString());
                cnt[p]--;
                if (cnt[p] == 0) {
                    q.offer(p);
                }
            } else {
                return sb.toString().substring(0, sb.lastIndexOf("0") + 1);
            }
        }
        return null;
    }
}
