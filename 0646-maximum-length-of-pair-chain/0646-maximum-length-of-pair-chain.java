class Solution {
    int[] dp = new int[1005];

    private int fun(int[][] pairs, int i) {
        if (i >= pairs.length) return 0;

        if (dp[i] != -1) return dp[i];

        int id = pairs.length;

        // for (int j = i + 1; j < pairs.length; j++) {
        //     if (pairs[j][0] > pairs[i][1]) {
        //         id = j;
        //         break;
        //     }
        // }

        int l = i + 1;
        int h = pairs.length - 1;
        while(l <= h){
            int mid=(l+h)/2;
            if(pairs[mid][0]>pairs[i][1]){
                id=mid;
                h=mid-1;
            }else{
                l=mid+1;
            }
        }

        int take = 1 + fun(pairs, id);
        int not_take = fun(pairs, i + 1);

        return dp[i] = Math.max(take, not_take);
    }

    public int findLongestChain(int[][] pairs) {
        Arrays.fill(dp, -1);

        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        return fun(pairs, 0);
    }
}