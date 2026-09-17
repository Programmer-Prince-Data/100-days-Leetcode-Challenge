class Solution {
    int[] dp;

    private int cs(int curr, int n) {
        if (curr == n) return 1;
        if (curr > n) return 0;

        if (dp[curr] != -1) {
            return dp[curr];
        }

        dp[curr] = cs(curr + 1, n) + cs(curr + 2, n);

        return dp[curr];
    }

    public int climbStairs(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return cs(0, n);
    }
}