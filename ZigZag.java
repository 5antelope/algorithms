public class Solution {
    public String convert(String s, int nRows) {
        if (s==null || nRows<1) return null;
        int n=s.length();
        int w = (n%nRows)+(n/nRows)+(n/nRows-1)*(nRows-2);  // Wrong!
        char[][] table = new char[nRows][w];
        int i=0;
        int col=0;
        while (i<n) {
            int j;
            for (j=0;i<n && j<nRows;j++) {
                table[j][col] = s.charAt(i++);
            }
            col++;
            for (int k=1;i<n && k<nRows-2; k++) {
                table[j-k][col++] = s.charAt(i++);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char[] arr : table)
            for (char c:arr) {
                if (c!='\u0000')
                    sb.append(c);
            }
        return sb.toString();
    }
}
