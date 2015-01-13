public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        int n = num.length;
        if (n<4)    return null;
        Arrays.sort(num);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for (int i=0; i<n-3; i++) {
            if (i>0 && num[i]==num[i-1])  continue;
            for (int j=i+1; j<n-2; j++) {
                if (j>i+1 && num[j]==num[j-1])   continue;
                int l = j+1;
                int r = n-1;
                while (l<r) {
                    int sum = num[i]+num[j]+num[l]+num[r];
                    if (sum>target) r--;
                    else if (sum<target)    l++;
                    else {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[l++]);
                        list.add(num[r--]);
                        lists.add(list);
                        while (l<r && num[l]==num[l-1]) l++;
                        while (l<r && num[r]==num[r+1]) r--;
                    }
                }
            }
        }
        return lists;
    }
}
