public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        int n = num.length;
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        for (int i=0; i<n-2; i++) {
            int l=i+1;
            int r=n-1;
            while (l<r) {
                int sum = num[i]+num[l]+num[r];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[l++]);
                    list.add(num[r--]);
                    if (!lists.contains(list))
                        lists.add(list);
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
