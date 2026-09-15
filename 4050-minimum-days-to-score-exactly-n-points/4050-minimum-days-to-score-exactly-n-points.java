class Solution {
    int[][] dp;
    int max = (int)(1e9);

    private int fun(int k, int s, int i) {
        if (k == s) return 0;
        if (k > s) return max;

        if (dp[k][i] != -1)
            return dp[k][i];

        int a = 1 + fun(k + i, s, i + 1);
        int b = 2 + fun(k + 1, s, 2);

        return dp[k][i] = Math.min(a, b);
    }

    public int minDays(int n) {
        dp = new int[n + 1][500];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return fun(0, n, 1);
    }
}