public class Solution {
    List<List<Integer>> lists;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        lists = new ArrayList<List<Integer>>();
        combination(candidates, new ArrayList<Integer>(), target, 0);
        return lists;
    }
    public void combination(int[] num, List<Integer> list, int target, int cp) {
        if (target==0) {
            lists.add(list);
            return;
        }
        else if (target<0) {
            return;
        }
        else {
            while (cp<num.length) { // for-loop until current number fails, backward
                List<Integer> tmp = new ArrayList<Integer>(list);
                tmp.add(num[cp]);
                combination(num,tmp,target-num[cp],cp);
                cp++;
            }
        }
    }
}
