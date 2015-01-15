public class Solution {
    public int maxProduct(int[] A) {
        int n=A.length;
        if (n<1)    return 0;
        int max_prod = A[0];
        int min_prod = A[0];
        int max = A[0];
        for (int i=1; i<n; i++) {
            int a = max_prod;
            int b = min_prod;
            max_prod = Math.max(Math.max(a*A[i],b*A[i]),A[i]);  // max of subarray including cur. pos.!
            min_prod = Math.min(Math.min(a*A[i],b*A[i]),A[i]);
            max = Math.max(max,max_prod);   // global max. 
        }
        return max;
    }
}
