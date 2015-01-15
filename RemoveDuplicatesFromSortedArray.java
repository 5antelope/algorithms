public class Solution {
    public int removeDuplicates(int[] A) {
        int n = A.length;
        if (n<1) return 0;
        int tmp = A[0];
        int i = 1;
        while(i<n) {
            if(A[i]==tmp) {
                for (int j=i; j<n-1; j++) {
                    A[j]=A[j+1];
                }
                n--;
            }
            else 
                tmp = A[i++];
        }
        return n;
    }
}
