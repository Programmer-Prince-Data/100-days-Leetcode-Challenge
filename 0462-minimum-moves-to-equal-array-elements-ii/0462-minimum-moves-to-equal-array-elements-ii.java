class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        int x = n/2;
        int mid = nums[x];

        for(int i = 0; i < n; i++){
            ans += Math.abs(mid - nums[i]);
        }
        return ans;
    }
}