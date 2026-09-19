class Solution {
    int[][] dp = new int[2504][2501];
    private int fun(int i, int flag, int[] nums){
        if(i >= nums.length) return 0;
        int m = 0;
        if(dp[i][flag + 1] != -1){
            return dp[i][flag + 1];
        }

        if(flag == -1|| nums[i] > nums[flag]){
            int a = 1 + fun(i + 1, i, nums);
            m  = Math.max(a,m);

        }
        int b = fun(i + 1, flag, nums);
        m  = Math.max(b,m);

        return dp[i][flag + 1] = m;
    }
    public int lengthOfLIS(int[] nums) {
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return fun(0, -1, nums);
    }
}