public class Solution {
    public int numTrees(int n) {
        if (n==0 || n==1)    return 1;
        int[] p = new int[n+1];
        p[0] = 1; p[1] = 1;
        for (int i=2; i<=n; i++) {
            for (int j=0; j<i; j++) {
                p[i] += p[j]*p[i-1-j];
            }
        }
        return p[n];
    }
}
