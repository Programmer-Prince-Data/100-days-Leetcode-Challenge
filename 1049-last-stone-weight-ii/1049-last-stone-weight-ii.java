class Solution {
    int[][] dp;

    int fun(int[] stones, int i, int target) {
        if (target == 0) return 1;
        if (i == stones.length) return 0;

        if (dp[i][target] != -1) return dp[i][target];

        int notTake = fun(stones, i + 1, target);

        int take = 0;
        if (stones[i] <= target) {
            take = fun(stones, i + 1, target - stones[i]);
        }

        return dp[i][target] = Math.max(take, notTake);
    }

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        int target = sum / 2;
        dp = new int[stones.length][target + 1];

        for (int i = 0; i < stones.length; i++) {
            java.util.Arrays.fill(dp[i], -1);
        }

        for (int s = target; s >= 0; s--) {
            if (fun(stones, 0, s) == 1) {
                return sum - 2 * s;
            }
        }

        return sum;
    }
}