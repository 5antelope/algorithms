public class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        if (n==0)   return true;
        s = s.toLowerCase();
        int i=0; 
        int j=n-1;
        while (i<=j) {
            if (!Character.isLetter(s.charAt(i)) && !Character.isDigit(s.charAt(i)))  // use Character class to test alphanumeric
                i++;
            else if (!Character.isLetter(s.charAt(j)) && !Character.isDigit(s.charAt(j)))
                j--;
            else if (s.charAt(i)==s.charAt(j)) {
                i++; j--;
            }
            else 
                return false;
        }
        return true;
    }
}
