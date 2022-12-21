package cn.qiushile.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 886. Possible Bipartition
 * We want to split a group of n people (labeled from 1 to n) into two groups of any size. Each person may dislike some other people, and they should not go into the same group.
 * Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai does not like the person labeled bi, return true if it is possible to split everyone into two groups in this way.
 * Example 1:
 * Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
 * Output: true
 * Explanation: group1 [1,4] and group2 [2,3].
 * Example 2:
 * Input: n = 3, dislikes = [[1,2],[1,3],[2,3]]
 * Output: false
 * Example 3:
 * Input: n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * Output: false
 * Constraints:
 * 1 <= n <= 2000
 * 0 <= dislikes.length <= 104
 * dislikes[i].length == 2
 * 1 <= dislikes[i][j] <= n
 * ai < bi
 * All the pairs of dislikes are unique.
 * @author qiushile <qiushile@sina.com>
 * @date 2022/12/21
 */
public class Solution0886 {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        if (n < 3) {
            return true;
        }

        Person[] people = new Person[n + 1];
        for (int i = 0; i < dislikes.length; i++) {
            int p1 = dislikes[i][0];
            int p2 = dislikes[i][1];
            if (people[p1] == null) {
                people[p1] = new Person(p1, p2);
            } else {
                people[p1].addRelation(p2);
            }
            if (people[p2] == null) {
                people[p2] = new Person(p2, p1);
            } else {
                people[p2].addRelation(p1);
            }
        }
        LinkedList<Person> solePersons = new LinkedList<Person>();
        // find solo-like persons
        for (int i = 1; i < n + 1; i++) {
            if (null != people[i] && people[i].relatedPersons.size() <= 1) {
                solePersons.add(people[i]);
            }
        }
        // clean
        while (!solePersons.isEmpty()) {
            Person person = solePersons.poll();
            if (!person.relatedPersons.isEmpty()) {
                Integer anotherPersonIndex = person.relatedPersons.remove(0);
                Person anotherPerson = people[anotherPersonIndex];
                anotherPerson.removeRelation(new Integer(person.val));
                if (anotherPerson.relatedPersons.size() == 1) {
                    solePersons.add(anotherPerson);
                }
            }
            people[person.val] = null;
        }

        // people who already visited
        int[] linked = new int[n+1];
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for (int i = 1; i < n + 1; i++) {
            if (!dfs(people, linkedList, linked, 0, i, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(Person[] people, LinkedList<Integer> linkedList, int[] linked, int linkedAmout, int curr, int start) {
        if (curr > people.length || null == people[curr]) {
            return true;
        }
        Person person = people[curr];
        if (linked[curr] == 1) {
            return (linkedAmout - linkedList.indexOf(new Integer(curr))) % 2 != 1;
        }
        linked[curr] = 1;
        linkedAmout++;
        linkedList.add(curr);
        List<Integer> relatedPersons = person.relatedPersons;
        for (Integer relatedPerson : relatedPersons) {
            if (relatedPerson.equals(linkedList.getLast()) && relatedPerson < start) {
                continue;
            }
            if(!dfs(people, linkedList, linked, linkedAmout, relatedPerson, start)) {
                return false;
            }
        }
        /**
         * this place cause Exception
         * java.util.ConcurrentModificationException
         * 	at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:907)
         * 	at java.util.ArrayList$Itr.next(ArrayList.java:857)
         * 	at cn.qiushile.leetcode.Solution0886.dfs(Solution0886.java:99)
         * 	at cn.qiushile.leetcode.Solution0886.dfs(Solution0886.java:103)
         * 	at cn.qiushile.leetcode.Solution0886.dfs(Solution0886.java:103)
         */
        //if (relatedPersons.size() <= 2) {
        //    for (Integer relatedPerson : relatedPersons) {
        //        people[relatedPerson].relatedPersons.remove(new Integer(curr));
        //    }
        //    people[curr] = null;
        //}
        linked[curr] = 0;
        linkedList.removeLast();
        //linkedAmout--;
        return true;
    }


    /**
     * Definition for a node.
     */
    public static class Person {
        int val;
        List<Integer> relatedPersons;
        private Person() {}
        public Person(int val) {
            this.val = val;
            this.relatedPersons = new ArrayList<Integer>();
        }
        public Person(int val, Integer relatedNum) {
            this(val);
            this.relatedPersons.add(relatedNum);
        }

        public void addRelation(Integer relatedNum) {
            this.relatedPersons.add(relatedNum);
        }

        public void removeRelation(Integer relatedNum) {
            this.relatedPersons.remove(relatedNum);
        }
    }
}
