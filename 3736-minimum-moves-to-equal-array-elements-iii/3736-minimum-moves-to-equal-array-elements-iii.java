class Solution {
    public int minMoves(int[] nums) {
        int min = nums[0];
        for (int num : nums) {
            min = Math.max(min, num);
        }
        
        int ans = 0;
        for (int num : nums) {
            ans += Math.abs(num - min);
        }
        
        return ans;
    }
}
