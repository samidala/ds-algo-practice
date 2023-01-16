package dsa.algorithms.dp;

public class MinSumPath {

    public static void main(String[] args) {

        int[][] grid = {
                { 8, 1, 6},
                { 4 ,4 ,16},
                {2, 7, 20},
                {20, 7, 20}
        };
        minSumPath(grid);
    }

    public static int minSumPath(int[][] grid) {
        // Write your code here.
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        return minSumPath(grid,n-1,m-1,dp);

    }
    private static int minSumPath(int[][] grid, int n, int m,
                                  int[][] dp){

        if(m == 0 && n == 0){
            return grid[0][0];
        }


        if(m < 0 || n < 0)
            return Integer.MAX_VALUE;

        return grid[n][m] +
                Math.min(minSumPath(grid,n-1,m,dp),
                        minSumPath(grid,n,m-1,dp));

    }
}
