public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor==0) return Integer.MAX_VALUE;
        if (divisor==1) return dividend;
        int res = 0;
        // take care with Integer.MIN_VALUE's abs value!
        if (dividend == Integer.MIN_VALUE) {
            dividend += Math.abs(divisor);
            if (divisor == -1)
                return Integer.MAX_VALUE;
            res++;
        }
        if(divisor == Integer.MIN_VALUE)    return res;  
        
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int digit = 0;
        while (a>=b) {
            b = b<<1;
            digit++;
        }
        while (digit>=0 && a>0) {
            if (a>=b) {
                res += 1<<digit;
                a = a-b;
            }
            b = b>>1;
            digit--;
        }
        return (dividend^divisor)>>>31==1?-res:res;
    }
}
