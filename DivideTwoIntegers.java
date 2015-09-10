public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor==0)
            return Integer.MAX_VALUE;
        if (divisor==1)
            return dividend;
        if (divisor==-1)
            return dividend==Integer.MIN_VALUE?Integer.MAX_VALUE:-dividend;
        
        long x = Math.abs((long)dividend);
        long y = Math.abs((long)divisor);
        
        int ans = 0;
        
        if (x<y)
            return ans;
        
        while (x>=y) {
            long d = y;
            int tmp = 1;
            
            while ((d<<1)<x) {
                d <<= 1;
                tmp <<= 1;
            }
            
            ans += tmp;
            x -= d;
        }
        
        if ((dividend>>>31 ^ divisor>>>31)==1)
            return -ans;
        else
            return ans;
    }
}
