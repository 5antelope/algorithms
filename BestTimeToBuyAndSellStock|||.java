public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max=0;
        int[][] A = new int[n+1][n+1];
        for (int i=1; i<=n; i++) {
            for (int j=i+1; j<=n; j++) {
                if (j<n) {
                    int diff = prices[j-1]-prices[j];
                    A[i][j] = Math.max(A[i][j-1], A[i][j-1]+diff);
                }
                else 
                    A[i][j] = A[i][j-1];
            }
        }
        for (int i=1; i<=n; i++) {
            max = Math.max(max, A[i][n]);
        }
        return max;
    }
}
