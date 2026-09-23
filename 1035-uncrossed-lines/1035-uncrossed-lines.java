class Solution {
    int[][] dp = new int[501][501];
    private int fun(int[] nums1, int[] nums2, int i, int j){
        if(i >= nums1.length || j >= nums2.length) return 0;
        int res = 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(nums1[i] == nums2[j]){
            int a = 1 + fun(nums1, nums2, i+1, j+1);
            res = Math.max(a, res);
        } else{
            int a = fun(nums1, nums2, i+1, j);
            int b = fun(nums1, nums2, i, j+1);
            res = Math.max(a, Math.max(res, b));
        }
        return dp[i][j]=res;
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        for(int i = 0; i < 501; i++){
            Arrays.fill(dp[i] , -1);
        }
        return fun(nums1, nums2, 0, 0);
    }
}