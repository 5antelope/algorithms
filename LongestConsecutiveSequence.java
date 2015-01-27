public class Solution {
    public int longestConsecutive(int[] num) {
        int n = num.length;
        if (n<2)    return n;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i:num)
            set.add(i);
        int res = 0;
        while (!set.isEmpty()) {
            int max = 1;
            int tmp = set.iterator().next();
            int cur = tmp;
            /**
             *  remove cur because it should not also exist in other's list
             */
            set.remove(tmp);
            while (set.contains(++cur)) {set.remove(cur);max++;}
            cur = tmp;
            while (set.contains(--cur)) {set.remove(cur);max++;}
            res = Math.max(res, max);
        }
        return res;
    }
}
