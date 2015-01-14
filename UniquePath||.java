public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] table = new int[m][n];
        // base case
        if (obstacleGrid[0][0]==1)  
            return 0;
        else
            table[0][0] = 1;
        // init. table
        for(int i=1; i<m; i++) {
            if (obstacleGrid[i][0]==1)
                table[i][0] = 0;
            else
                table[i][0] = table[i-1][0];  // no need to judge individually, just set as previous if possible
        }
        for(int j=1; j<n; j++) {
            if (obstacleGrid[0][j]==1)
                table[0][j] = 0;
            else
                table[0][j] = table[0][j-1];
        }
        // DP interation
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                if (obstacleGrid[i][j]==1)
                    table[i][j] = 0;
                else
                    table[i][j] = table[i-1][j]+table[i][j-1];
            }
        }
        return table[m-1][n-1];
    }
}
