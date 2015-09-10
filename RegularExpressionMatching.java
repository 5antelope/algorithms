public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        
        boolean dp[][] = new boolean[m+1][n+1];
        
        dp[0][0] = true;
        
        // i: i chars in s; 
        // j: j chars in p
        for (int i=1; i<=n; i++)
            dp[0][i] = i-2>=0 && p.charAt(i-1)=='*' && dp[0][i-2];
        
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                // current is not *
                if (p.charAt(j-1) != '*')
                    dp[i][j] = dp[i-1][j-1] && equal(s, p, i-1, j-1);
                
                // current is *    
                else {
                    // p[j-2]: char before *
                    dp[i][j] = j-2>=0 && dp[i][j-2]   // ignore element in pattern
                        // *: multiple elements
                        // dp[i-1][j]: element at p[j-1] matches s[i-2] already.
                        // check if p[j-1] matches s[i-1] alse
                        || dp[i-1][j] && equal(s, p, i-1, j-2)   // incomming s = element
                        // dp[i][j-1]: s[i-1] matches p[j-2]
                        // take only one element (actually no need for equal(s, p, i-1, j-2) judge)
                        || dp[i][j-1] && equal(s, p, i-1, j-2);  // take only one element
                }
            }
        }
        
        return dp[m][n];
    }
    
    private boolean equal(String a, String b, int x, int y) {
        return b.charAt(y)=='.' || a.charAt(x) == b.charAt(y);
    }
}
