package cn.qiushile.leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author qiushile <qiushile@sina.com>
 * @date 2022/12/19
 */
public class Solution1971 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        if (n < 0 || source < 0 || destination < 0 || source >= n || destination >= n) {
            return false;
        }

        if (source == destination) {
            return true;
        }

        n++;
        source++;
        destination++;

        int[] links = new int[n];
        int tmp;
        for (int[] edge : edges) {
            int left = edge[0] + 1;
            int right = edge[1] + 1;
            if (links[right] == left) {
                continue;
            }
            if (left > right) {
                tmp = left;
                left = right;
                right = tmp;
            }
            if (links[left] == 0 && links[right] == 0) {
                links[right] = left;
                continue;
            }
            if (links[right] == 0) {
                links[right] = links[left];
                continue;
            }
            if (links[left] == 0) {
                int secondRight = links[right];
                while (secondRight > left) {
                    right = secondRight;
                    secondRight = links[right];
                }
                if (secondRight == left) {
                    continue;
                }
                links[left] = secondRight;
                links[right] = left;
                continue;
            }
            merge(links, left, right);
        }

        return find(links, source, destination);
    }

    private boolean find(int[] links, int left, int right) {
        if (left == 0 || right == 0) {
            return false;
        }
        if (left == right) {
            return true;
        }
        if (left > right) {
            return find(links, right, left);
        }
        int secondRight = links[right];
        while (secondRight > left) {
            right = secondRight;
            secondRight = links[right];
        }
        if (left == secondRight) {
            return true;
        } else {
            return find(links, secondRight, left);
        }
    }

    private void merge(int[] links, int left, int right) {
        if (left == right) {
            return;
        }
        if (left > right) {
            merge(links, right, left);
        }
        int secondRight = links[right];
        while (secondRight > left) {
            right = secondRight;
            secondRight = links[right];
        }
        if (secondRight == left) {
            return;
        }
        if (secondRight == 0) {
            links[right] = left;
            return;
        }
        int secondLeft = links[left];
        if (secondLeft == secondRight) {
            links[right] = left;
            return;
        } else {
            links[right] = left;
            merge(links, secondRight, left);
            return;
        }
    }

    // failed at 22
    public boolean oldValidPath(int n, int[][] edges, int source, int destination) {

        if (n < 0 || source < 0 || destination < 0 || source >= n || destination >= n) {
            return false;
        }

        if (source == destination) {
            return true;
        }

        List<Set<Integer>> setList = new ArrayList<>();
        for (int[] edge : edges) {
            int left = edge[0];
            int right = edge[1];
            if (left == right) {
                continue;
            }
            int leftPosition = -1;
            int rightPosition = -1;
            for (int i = 0; i < setList.size() && (leftPosition < 0 || rightPosition < 0); i++) {
                Set<Integer> link = setList.get(i);
                if (link.contains(left)) {
                    leftPosition = i;
                }
                if (link.contains(right)) {
                    rightPosition = i;
                }
            }
            if (leftPosition < 0 && rightPosition < 0) {
                Set<Integer> link = new HashSet<>();
                link.add(left);
                link.add(right);
                setList.add(link);
                continue;
            }
            if (leftPosition == rightPosition) {
                continue;
            }
            if (leftPosition >= 0 && rightPosition < 0) {
                setList.get(leftPosition).add(right);
                continue;
            }
            if (leftPosition < 0 && rightPosition >= 0) {
                setList.get(rightPosition).add(left);
                continue;
            }
            if (leftPosition > rightPosition) {
                int temp = leftPosition;
                leftPosition = rightPosition;
                rightPosition = temp;
            }
            setList.get(leftPosition).addAll(setList.get(rightPosition));
            setList.remove(rightPosition);
        }

        for (Set<Integer> link : setList) {
            boolean begin = link.contains(source);
            boolean end = link.contains(destination);
            if (begin && end) {
                return true;
            }
            if (begin || end) {
                return false;
            }
        }

        throw new IllegalStateException("Unable to run here!!");
    }
}
