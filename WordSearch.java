public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] flag = new boolean[m][n];   // flag is needed as the same ele. cannot be used twice
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (search(board, word,flag, i, j, 0))
                    return true;
            }
        }
        return false;
    }
    public boolean search(char[][] board, String word, boolean[][] flag, int i, int j, int cp) {
        int m = board.length;
        int n = board[0].length;
        if (cp == word.length())
            return true;
        if (i<0 || j<0 || i>=m || j>=n)
            return false;
        if (flag[i][j] == true)
            return false;
        if (board[i][j]!=word.charAt(cp))
            return false;
        // typical DFS frame!
        flag[i][j] = true;
        if (search(board, word, flag, i-1, j, cp+1))
            return true;
        if (search(board, word, flag, i+1, j, cp+1))
            return true;
        if (search(board, word, flag, i, j+1, cp+1))
            return true;
        if (search(board, word, flag, i, j-1, cp+1))
            return true;
        flag[i][j] = false;
        return false;
    }
}
