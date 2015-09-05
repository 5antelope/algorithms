// use similar idea with binary search
public int mySqrt(int x) {
  int ans = 0;
  
  int l = 1, r = x;
  
  while (l<=r) {
      int mid = l + (r-l)/2;
      if (mid<=x/mid) {
          l = mid+1;
          ans = mid;
      }
      else
          r = mid-1;
  }
  
  return ans;
}
