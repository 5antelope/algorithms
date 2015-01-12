public class Solution {
    public void sortColors(int[] A) {
        int n = A.length;
        int red = -1; // last 0
        int blue = n; // first 2
        int pointer = 0;
        while (pointer < blue) {
            if (A[pointer]==2) 
                swap(A,pointer,--blue);
            else if (A[pointer]==0)
                swap(A,pointer++,++red);  // because 0 is before 1, the iteration-pointer should increase here
            else
                pointer++;
        }
        
    }
    public void swap(int[] A, int i, int j) { // cannot use ^ for switch due to equal case
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
