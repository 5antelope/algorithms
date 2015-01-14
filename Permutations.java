public class Solution {
    List<List<Integer>> lists;
    public List<List<Integer>> permute(int[] num) {
        int n = num.length;
        lists = new ArrayList<List<Integer>>();
        permutation(num,0);
        return lists;
    }
    public void permutation(int[] num, int l) {
        int n = num.length;
        if (l==n) {
            List<Integer> list = new ArrayList<Integer>();
            for (int i:num)
                list.add(i);
            lists.add(list);
            return;
        }
        else {
            /*
                backtrace idea... swap for permutation (included itself)
                gerneral backtrace:
                    - flag / modify sth.
                    - recursive call
                    - unflag/ undo sth.
            */
            for (int i=l; i<n; i++) {
                int tmp = num[l];
                num[l] = num[i];
                num[i] = tmp;
                
                permutation(num, l+1);
                // restore.., going back
                tmp = num[i];
                num[i] = num[l];
                num[l] = tmp;
            }
        }
    }
}
