import java.util.Arrays;

public class Knapsack {
    public static int knapSack(int W, int[] wt, int[] val) {
        int n = val.length;
        int[][] dpTable = new int[W+1][n+1];
        boolean[][] sol = new boolean[W+1][n+1];
        // # of for-loop = # of constrains (2)
        for (int i=1; i<=n; i++) { // items
            // by default, the dpTable[x][0] = 0
            for (int w=1; w<=W; w++) {  // weight
                if (w>=wt[i-1]) {
                    dpTable[w][i] = Math.max(dpTable[w][i - 1], dpTable[w - wt[i - 1]][i - 1] + val[i - 1]);
                    sol[w][i] = (dpTable[w][i - 1] < dpTable[w - wt[i - 1]][i - 1] + val[i - 1]);
                }
                else
                    dpTable[w][i] = dpTable[w][i-1];
            }
        }
        // reconstruct path
        boolean[] path = new boolean[n+1];
        for (int i=n, w=W; i>0; i--) {
            if (sol[w][i]) {
                path[i] = true;
                w = w-wt[i-1];
            }
            else
                path[i] = false;
        }
        System.out.println("the path: "+ Arrays.toString(path));
        return dpTable[W][n];
    }
    public static void main(String[] args) {
        int val[] = {3,2,4,4};
        int wt[] = {4,3,2,3};
        int  W = 6;
        System.out.println(knapSack(W, wt, val));
    }
}
