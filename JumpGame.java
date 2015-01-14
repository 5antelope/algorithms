public class Solution {
    public class Solution {
        public boolean canJump(int[] A) {
            int n = A.length;
            if (n<1)    return false;
            int p1 = 0;
            int p2 = 0;
            while (p1<=p2 &&    // in case 0 in array cause dead-loop
                p2<n)           // cannot take equal for input's len = 1
            {
                p2 = Math.max(p2, p1+A[p1++]);
                if (p2 >= n-1) return true;
            }
            return false;
        }
    }
}
