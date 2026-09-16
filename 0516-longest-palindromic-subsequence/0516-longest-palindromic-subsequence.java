class Solution {
    int[][] dp = new int[1001][1001];
    private int fun(int i, int j, String s, String t){
        if(i >= s.length() || j >= t.length()) return 0;
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int res = 0;
        if(s.charAt(i) == t.charAt(j)){
            int a = 1  + fun(i+1, j+1, s,t);
            res = Math.max(a, res);   
        } else {
            int a = fun(i, j+1, s,t);
            int b = fun(i+1, j, s,t);
            res = Math.max(res,Math.max(a,b));
        }

        return dp[i][j] = res;
    }
    public int longestPalindromeSubseq(String s) {
        String t = new StringBuilder(s).reverse().toString();
        for(int i = 0; i < 1001; i++){
            Arrays.fill(dp[i], -1);
        }
        return fun(0, 0, s, t);
    }
}