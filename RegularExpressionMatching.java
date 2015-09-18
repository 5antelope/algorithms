public class Solution {
    public boolean isMatch(String s, String p) {
        int strLen = s.length();
        int ptnLen = p.length();
        
        boolean[][] dp = new boolean[strLen+1][ptnLen+1];
        
        // dp[i][j]: match with s (len=i) && p (len=j)
        dp[0][0] = true;
        
        // handle case where s len=0
        for (int i=1; i<=ptnLen; i++)
            dp[0][i] = 
                // check from 2nd char    
                    i>=2 
                // char at cur position is *
                && p.charAt(i-1)=='*'
                // previous string is a match
                && dp[0][i-2] == true;
        
        for (int i=1; i<=strLen; i++) {
            for (int j=1; j<=ptnLen; j++) {
                // s len = i;
                // p len = j;
                
                if (p.charAt(j-1)!='*')
                    dp[i][j] = dp[i-1][j-1] && match(s,p,i-1,j-1);
                
                else {
                    // '*' can have one of three cases:
                    // 1. match 0 of prev char
                    // 2. match one and only prev char
                    // 3. match more than one prev char
                    dp[i][j] = 
                            j>=2 && dp[i][j-2]
                        || dp[i][j-1]
                            // case where '*' match more than one prev char
                            // dp[i-1][j]: s with len=i-1 also match util cur pattern
                            // s[i-1]==p[j-2]: cur char in s matches char in p before '*'
                        || dp[i-1][j] && match(s,p,i-1,j-2);
                }
            }
        }
        
        return dp[strLen][ptnLen];
    }
    
    private boolean match(String a, String b, int x, int y) {
        char m = a.charAt(x);
        char n = b.charAt(y);
        if (m==n || n=='.')
            return true;
        return false;
    }
