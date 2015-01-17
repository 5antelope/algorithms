/*
    DP
    to check (i,j) is palidrome or not :
        (i,j) = (i+1,j-1) && s[i]==s[j]
*/
public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n<2)    return s;
        char[] str = s.toCharArray();
        int sp = 0, maxLen = 0;
        boolean[][] table = new boolean[n][n];
        // init. states
        for (int i=0; i<n; i++) { table[i][i] = true; maxLen = 1; sp = i;}
        for (int i=0; i<n-1; i++) {
            if (str[i]==str[i+1]) { table[i][i+1] = true; maxLen = 2; sp = i;}
        }
            
        for (int len=3; len<=n; len++) {
            for (int i=0; i+len-1<n; i++) {   // (i,i+len-1)
                if (str[i]==str[i+len-1] && table[i+1][i+len-2]) {
                    table[i][i+len-1] = true;  maxLen = len; sp = i;
                }
            }
        }
        return s.substring(sp,sp+maxLen);
    }
}
