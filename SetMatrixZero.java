/*
    use the matrix itself to store the flags for each row and column if they need to set to 0. 
    So we need 1 row and 1 column, the 1st row and 1st column then can be chosen to store the flag. 
    But we need first check the two if they need to be 0. Then go the other rows and columns.
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean r1 = false;
        boolean c1 = false;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i=0; i<n; i++) {
            if (matrix[0][i]==0) {
                r1 = true;
                break;
            }
        }
        for (int i=0; i<m; i++) {
            if (matrix[i][0]==0) {
                c1 = true;
                break;
            }
        }
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (matrix[i][j]==0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i=1; i<m; i++) {
            if (matrix[i][0]==0)
                clearRow(matrix,i,n);
        }
        for (int i=1; i<n; i++) {
            if (matrix[0][i]==0)
                clearColumn(matrix,i,m);
        }
        if (r1) clearRow(matrix,0,n);
        if (c1) clearColumn(matrix,0,m);
    }
    public void clearRow(int[][] m, int r, int len) {
        for (int i=1; i<len; i++) 
            m[r][i] = 0;
    }
    public void clearColumn(int[][] m, int c, int len) {
        for (int i=1; i<len; i++) 
            m[i][c] = 0;
    }
}
