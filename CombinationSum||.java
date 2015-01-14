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
            if (!lists.contains(list))
                lists.add(list);
            return;
        }
        else if (target<0){
            return;
        }
        else {
            for (int i=cp; i<num.length; i++) {
                List<Integer> tmp = new ArrayList<Integer>(list);
                tmp.add(num[i]);
                combination(num,i+1,tmp,target-num[i]);
            }
        }
    }
}
