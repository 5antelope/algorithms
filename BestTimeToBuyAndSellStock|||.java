public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n<2) return 0;
        int[] max1=new int[n+1];
        int[] max2=new int[n+1];
        int minTmp = prices[0];
        for (int i=1; i<=n; i++) {
            minTmp = Math.min(minTmp, prices[i-1]);
            max1[i] = Math.max(max1[i-1],prices[i-1]-minTmp);
        }
        int maxTmp = prices[n-1];
        for (int i=n-1; i>0; i--) {
            maxTmp = Math.max(maxTmp, prices[i - 1]);
            max2[i] = Math.max(max2[i+1], maxTmp-prices[i-1]);
        }
        int max=0;
        for (int i=1; i<=n; i++) {
            max = Math.max(max, max, max1[i]+max2[i]);
        }
        return max;
    }
}
