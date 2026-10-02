class Solution {
    int[][] dp = new int[201][20001];

    private int fun(int[] nums, int i, int tar) {
        if(tar == 0) return 1;
        if(i >= nums.length || tar < 0) return 0;

        if(dp[i][tar] != -1) return dp[i][tar];

        int take = fun(nums, i + 1, tar - nums[i]);
        int not_take = fun(nums, i + 1, tar);

        return dp[i][tar] = take | not_take;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if(sum % 2 != 0) return false;

        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return fun(nums, 0, sum / 2) == 1;
    }
}