public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // presume ascii encoding.
        int max = 0;
        int i=0, j=0;
        // use array to simulate hash table, ascii code (int) as key
        boolean[] hash = new boolean[256];
        while (i<s.length() && j<s.length()) {
            if (hash[s.charAt(j)]==false) 
                { hash[s.charAt(j)] = true; j++;}
            else {
                max = Math.max(max, j-i);
                hash[s.charAt(i)] = false;
                i++;
            }
        }
        // don't forget this comparison!
        max = Math.max(max, j-i);
        return max;
    }
}
