public class Solution {
    public int firstMissingPositive(int[] A) {
        int n = A.length;
        int i = 0;
        while (i < n) {
            if (A[i] != (i+1) &&        // put i at A[i-1]
              A[i] >= 1 && A[i] <= n    // 1<= i <= n
              && A[A[i]-1] != A[i])     // if 2 num. are same: skip. otherwise dead-loop
            {
                int j = A[i]-1;
                A[i]^=A[j];
                A[j]^=A[i];
                A[i]^=A[j];
            }
            else
                i++;
        }
        for (i = 0; i < n ; i++) {
            if (A[i] != (i+1))
                return i+1;
        }
        return n+1;
    }
}
