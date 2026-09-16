class Solution {
    int[][] dp = new int[1001][1001];
    private int fun(int i, int j, String s){
        if(i > j) return 0;
        if(i == j) return 1;

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int res = 0;

        if(s.charAt(i) == s.charAt(j)){
            int a = 2 + fun(i + 1, j - 1, s);
            res = Math.max(a,res);
        } else{
            int a  = fun(i + 1, j, s);
            int b  = fun(i, j - 1, s);
            res = Math.max(res, Math.max(a,b)); 
        }
        return dp[i][j] = res;
    }
    public int longestPalindromeSubseq(String s) {
        for(int i = 0; i < 1001; i++){
            Arrays.fill(dp[i], -1);
        }
        return fun(0, s.length() - 1, s);
    }
}