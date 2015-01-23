/*
  http://en.wikipedia.org/wiki/Permutation

  1. Find the largest index k such that a[k] < a[k + 1]. If no such index exists, the permutation is the last permutation.
  2. Find the largest index l greater than k such that a[k] < a[l].
  3. Swap the value of a[k] with that of a[l].
  4. Reverse the sequence from a[k + 1] up to and including the final element a[n].
  --- at which point a[k] < a[k + 1] does not exist, indicating that this is the last permutation.
 */

public class Solution {
    public void nextPermutation(int[] num) {
        int n = num.length;
        if (n==1)   return;
        int p;
        // find 1st. 'decreased' number at p
        for (p=n-2; p>=0; p--) {
            if (num[p]<num[p+1]) break;
        }
        // last permutation
        if (p+1==0)   {Arrays.sort(num); return;}
        // swap p and fist larger numer from tail
        for (int i=n-1; i>p; i--) {
            if (num[i]>num[p])  { swap(num,p,i); break;}
        }
        // reverse from p+1 ~ n-1
        for (int i=0; i<(n-p)/2; i++) {
            int tmp = num[p+1+i];
            num[p+1+i] = num[n-i-1];
            num[n-i-1] = tmp;
        }
    }
    public void swap (int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}
