public class Solution {
    List<List<Integer>> lists;
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        lists = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        combination(num, 0, new ArrayList<Integer>(), target);
        return lists;
    }
    public void combination(int[] num, int cp, List<Integer> list, int target) {
        if (target == 0) {
            // if (!lists.contains(list)) // take extra O(n);
            lists.add(list);
            return;
        }
        else if (target<0){
            return;
        }
        else {
            int pre = -1; // all positive nums
            for (int i=cp; i<num.length; i++) {
                if (num[i]!=pre) {
                    List<Integer> tmp = new ArrayList<Integer>(list);
                    tmp.add(num[i]);
                    combination(num,i+1,tmp,target-num[i]);
                    pre = num[i];   // make sure same num. does not appear again at SAME position
                }
            }
        }
    }
}
