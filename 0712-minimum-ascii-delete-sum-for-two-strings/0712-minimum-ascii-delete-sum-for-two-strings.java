class Solution {
    int[][] dp = new int[1001][1001];
    private int fun(String s, String t, int i, int j){
        if(dp[i][j] != -1) return dp[i][j];

        if(i == s.length()){
            int sum  = 0;
            for(int k = j; k < t.length(); k++){
                sum+=t.charAt(k);
            }
            return sum;
        }
        if(j == t.length()){
            int sum  = 0;
            for(int k = i; k < s.length(); k++){
                sum+=s.charAt(k);
            }
            return sum;
        }

        if(s.charAt(i) == t.charAt(j)){
            return fun(s, t, i +1, j +1);
        }
        int c1 = s.charAt(i) + fun(s, t, i + 1, j);
        int c2 = t.charAt(j) + fun(s, t, i, j + 1);
    
        return dp[i][j] = Math.min(c2,c1);

    }
    public int minimumDeleteSum(String s1, String s2) {
        for(int i = 0; i < 1001; i++){
            Arrays.fill(dp[i], -1);
        }
        return fun(s1, s2, 0, 0);
    }
}