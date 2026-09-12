class Solution {
    int[][] dp = new int[505][505];
    private int fun(int p, int i, int[] arr, int k, int m){
        if(i >= arr.length){
            return 0;
        }
        if (dp[p][i] != -1) {
            return dp[p][i];
        }
        int ans = 0;

        m  = Math.max(m, arr[i]);
        int len = i - p+1;
        if(len == k){
            int partition = (m * len) + fun(i+1, i+1, arr, k, 0);
            ans = Math.max(partition, ans);
        } else {
            int not_partition = fun(p, i+1, arr, k, m);
            int partition = (m * len) +fun(i+1, i+1, arr, k, 0);
            ans = Math.max(partition, ans);
            ans = Math.max(not_partition, ans);
        }
        
        return  dp[p][i] = ans;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
       
        return fun(0,0,arr,k,0);
    }
}