class Solution {
    int[] dp = new int[370];
    private int fun(int i, int[] days, int[] costs){
        if(i >= days.length){
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int id1 = i;
        while (id1 < days.length && days[id1] < days[i] + 7) { 
            id1++; 
        }

        int id2 = i; 
        while (id2 < days.length && days[id2] < days[i] + 30) { 
            id2++; 
        }

        int c1 = costs[0] + fun(i+1, days, costs);
        int c2 = costs[1] + fun(id1, days, costs); 
        int c3 = costs[2] + fun(id2, days, costs);

        return dp[i] = Math.min(Math.min(c1, c2), c3);   
    }
    public int mincostTickets(int[] days, int[] costs) {
        Arrays.fill(dp, -1);

        return fun(0, days, costs);
    }
}