class Solution {
    int[][] dp = new int[201][201];
    private int fun(int[][] grid, int i, int j){
        if(i >= grid.length || j >= grid[0].length) return 100000;
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }

        if(dp[i][j] != -1) return dp[i][j];

        int a = grid[i][j] + fun(grid, i + 1, j);
        int b = grid[i][j] + fun(grid, i , j + 1);

        return dp[i][j] = Math.min(a, b);
    }
    public int minPathSum(int[][] grid) {
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return fun(grid, 0, 0);
    }
}