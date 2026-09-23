class Solution {
    int[][] dp = new int[501][501];
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
    public int minDistance(String word1, String word2) {
        for(int i = 0; i < 501; i++){
            Arrays.fill(dp[i] , -1);
        }
        return word1.length() + word2.length() - (2 * fun(0, 0, word1, word2));
    }
}