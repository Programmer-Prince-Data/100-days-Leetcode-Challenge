class Solution {
    int[][] dp = new int[102][102];

    private long fun(int i, int j, int m, int n) {
        if(i >= m || j >= n)
            return 0;

        if(i == m - 1 && j == n - 1)
            return 1;

        if(dp[i][j] != -1)
            return dp[i][j];

        long c1 = fun(i + 1, j, m, n);
        long c2 = fun(i, j + 1, m, n);

        dp[i][j] = (int)(c1 + c2);

        return dp[i][j];
    }

    public int uniquePaths(int m, int n) {
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return (int)fun(0, 0, m, n);
    }
}