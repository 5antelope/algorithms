public class Solution {
    public int[] searchRange(int[] A, int target) {
        int n = A.length;
        int k = binarySearch(A,target);
        if (k==-1) {
            int[] res = {-1,-1};
            return res;
        }
        else {
            return warpUp(A,k);
        }
    }
    public int binarySearch(int[] A, int key) {
        int l=0; int r=A.length-1;
        while(l<r) {
          int m = (l+r)/2;
          if (A[m]==key)
            return m;
          else if (key<A[m])
            r = m-1;
          else 
            l = m+1;
        }
        return -1;
    }
    public int[] warpUp (int[] A, int i) {
        int l = i;
        while (l-1>=0) {
            if (A[l-1]==A[l])
                l--;
            else break;
        }
        int r = i;
        while (r+1<A.length){
            if (A[r+1]==A[r])
                r++;
            else break;
        }
        int[] res = {l,r};
        return res;
    }
}
