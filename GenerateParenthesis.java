public class Solution {
    /**
     * the general idea is using recursion to find result.
     */
    List<String> list;
    public List<String> generateParenthesis(int n) {
       list = new ArrayList<String>();
       help("", n, n);
       return list;
    }
    private void help(String s, int l, int r) {
        /**
         * l<r: make sure ( is more than )
         */
        if (l>r || l<0 || r<0)
            return;
        if (l==0 && r==0)
            list.add(s);
        help(s+"(", l-1, r);
        help(s+")", l, r-1);
    }
}
