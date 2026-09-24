class Solution {
    int[][][] dp = new int[101][101][201];

    private boolean fun(String s, String t, String u, int i, int j, int k) {

        if (dp[i][j][k] != -1) {
            return dp[i][j][k] == 1;
        }

        if (s.length() + t.length() != u.length()) {
            return false;
        }

        if (i >= s.length()) {
            while (j < t.length() && k < u.length()) {
                if (t.charAt(j) == u.charAt(k)) {
                    j++;
                    k++;
                } else {
                    return false;
                }
            }

            return true;
        }

        if (j >= t.length()) {
            while (i < s.length() && k < u.length()) {
                if (s.charAt(i) == u.charAt(k)) {
                    i++;
                    k++;
                } else {
                    return false;
                }
            }

            return true;
        }

        boolean ans;

        if (s.charAt(i) == u.charAt(k) &&
            t.charAt(j) == u.charAt(k)) {

            ans = fun(s, t, u, i + 1, j, k + 1)
               || fun(s, t, u, i, j + 1, k + 1);

        } 
        else if (s.charAt(i) == u.charAt(k)) {

            ans = fun(s, t, u, i + 1, j, k + 1);

        } 
        else if (t.charAt(j) == u.charAt(k)) {

            ans = fun(s, t, u, i, j + 1, k + 1);

        } 
        else {
            ans = false;
        }

        dp[i][j][k] = ans ? 1 : 0;

        return ans;
    }

    public boolean isInterleave(String s1, String s2, String s3) {

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return fun(s1, s2, s3, 0, 0, 0);
    }
}