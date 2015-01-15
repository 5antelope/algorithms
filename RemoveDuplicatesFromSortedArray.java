public class Solution {
    // O(n^2), exceed time limit :(
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
    
    // better solution O(n)!!!!!!!!
    public int removeDuplicates(int[] A) {
        int k=0;
        if (A.length<1) return 0;
        for (int i=0; i<A.length; i++) {
            if (i==0 || A[i]!=A[i-1])
                A[k++] = A[i];
        }
        return k;
    }
}
