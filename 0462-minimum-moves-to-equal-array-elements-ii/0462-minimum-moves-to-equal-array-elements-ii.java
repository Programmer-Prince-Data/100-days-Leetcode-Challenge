class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        int mid = n/2;
        for(int i = 0; i < n; i++){
            ans += Math.abs(nums[mid] - nums[i]);
        }
        return ans;
    }
}