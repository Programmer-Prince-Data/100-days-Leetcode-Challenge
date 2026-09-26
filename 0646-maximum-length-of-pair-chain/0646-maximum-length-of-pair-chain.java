class Solution {
    int[][] dp = new int[1005][1005];
    private int fun(int prev, int[][] pairs,int i){
        if(i >= pairs.length) return 0;
        if(dp[prev + 1][i] != -1) return dp[prev +1][i];

        int res = 0;
        if(prev == -1 || pairs[i][0] > pairs[prev][1]){
            int a = 1 + fun(i, pairs, i + 1);
            res = Math.max(a, res);
        }
        int b = fun(prev, pairs, i + 1);
        res = Math.max(b, res);

        return dp[prev + 1][i] = res;
    }
    public int findLongestChain(int[][] pairs) {
        for(int i = 0; i < 1001; i++){
            Arrays.fill(dp[i], -1);
        }
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        return fun(-1, pairs, 0);
    }
}