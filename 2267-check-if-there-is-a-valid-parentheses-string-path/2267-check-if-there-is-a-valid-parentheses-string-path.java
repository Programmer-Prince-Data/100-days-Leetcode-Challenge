class Solution {

    int[][][] dp = new int[101][101][101];

    private int fun(int i, int j, char[][] grid, int bal) {

        int n = grid.length;
        int m = grid[0].length;
        int tt = n + m - 1;

        if (i >= n || j >= m || bal < 0 || bal > tt / 2) {
            return 0;
        }

        if (grid[i][j] == '(') {
            bal++;
        } else {
            bal--;
        }

        if (bal < 0) {
            return 0;
        }

        if (i == n - 1 && j == m - 1) {
            return bal == 0 ? 1 : 0;
        }

        if (dp[i][j][bal] != -1) {
            return dp[i][j][bal];
        }

        int c1 = fun(i + 1, j, grid, bal);
        int c2 = fun(i, j + 1, grid, bal);

        return dp[i][j][bal] = c1 | c2;
    }

    public boolean hasValidPath(char[][] grid) {

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                java.util.Arrays.fill(dp[i][j], -1);
            }
        }

        return fun(0, 0, grid, 0) == 1;
    }
}