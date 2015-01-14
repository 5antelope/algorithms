public class Solution {
    boolean b = false;
    public boolean canJump(int[] A) {
        int n = A.length;
        if (n<1)    return b;
        jump(A,n-1,0);
        return b;
    }
    public void jump(int[] A, int t, int cp) {
        if (cp==t) {
            b = true;
            return;
        }
        else {
            int i = cp;
            for (int stp=1; i<A.length-1 && stp<=A[i]; stp++) {
                i += stp;
                jump(A,t,i);
            }
        }
    }
}
