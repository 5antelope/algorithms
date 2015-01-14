public class Solution {
    List<List<Integer>> lists;
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        int n = num.length;
        if (n<1) return null;
        lists = new ArrayList<List<Integer>>();
        lists.add(new LinkedList<Integer>());
        for (int len=1; len<=n; len++) {
            subsets(num,0,0,new LinkedList<Integer>(),len);
        }
        return lists;
    }
    public void subsets(int[] num, int deep, int cp, LinkedList<Integer> list, int len) {
        if (deep==len) {
            lists.add(list);
            return;
        }
        
        Integer pre = null;
        for (int i=0; cp+i<num.length; i++) {
            if (pre!=null && num[cp+i]==pre)
                continue;
            LinkedList<Integer> tmp = new LinkedList<Integer>(list);
            tmp.add(num[cp+i]);
            subsets(num,deep+1,cp+i+1,tmp,len);
            // a common way to deal with duplicate in array for DFS: same spot cannot have same val. at dif pos
            pre = num[cp+i];    
        }
    }
}
