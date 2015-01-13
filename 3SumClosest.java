// reference: http://en.wikipedia.org/wiki/3SUM
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        int n = num.length;
        if (n<3)    return -1;
        Arrays.sort(num);
        int result = num[n-1]+num[n-2]+num[n-3];    // edge case max.
        for (int i=0; i<n-2; i++) {
            int l = i+1;
            int r = n-1;
            while (l<r) {
                int tmp = num[i]+num[l]+num[r];
                int dif = target-tmp;
                if (dif==0)
                    return tmp;
                else if (dif>0) // target>tmp
                    l++;
                else 
                    r--;
                    
                if (Math.abs(dif)<Math.abs(result-target))
                    result = tmp;
            }
        }
        return result;
    }
}
