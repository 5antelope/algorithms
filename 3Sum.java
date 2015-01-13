public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        int n = num.length;
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        for (int i=0; i<n-2; i++) {
            if (i>0 && num[i]==num[i-1])    continue;   // avoid duplicate
            int l=i+1;
            int r=n-1;
            while (l<r) {
                int sum = num[i]+num[l]+num[r];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[l++]);
                    list.add(num[r--]);
                    // cost extra O(n), make O(n^3) in all... bad!
                    //if (!lists.contains(list))
                    //    lists.add(list);
                    while (l>r && num[l]==num[l-1]) l++;
                    while (l>r && num[r]==num[r+1]) r--;
                }
                else if (sum>0)
                    r--;
                else
                    l++;
            }
        }
        return lists;
    }
} 
