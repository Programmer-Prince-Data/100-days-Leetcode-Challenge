import java.util.*;

class Solution {
    int[][] dp = new int[102][102];

    private long fun(int i, int j, int[][] grid) {

        // Out of bounds
        if(i >= grid.length || j >= grid[0].length)
            return 0;

        // Start or end is blocked
        if(grid[0][0] == 1 || 
           grid[grid.length - 1][grid[0].length - 1] == 1)
            return 0;

        // Current cell is an obstacle
        if(grid[i][j] == 1)
            return 0;

        // Reached destination
        if(i == grid.length - 1 && j == grid[0].length - 1)
            return 1;

        // Already calculated
        if(dp[i][j] != -1)
            return dp[i][j];

        long c1 = fun(i + 1, j, grid);
        long c2 = fun(i, j + 1, grid);

        dp[i][j] = (int)(c1 + c2);

        return dp[i][j];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return (int)fun(0, 0, obstacleGrid);
    }
}