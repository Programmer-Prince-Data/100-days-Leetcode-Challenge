class Solution {
    private int[] memo; // -1: not visited, 1: true, 0: false

    private boolean fun(int[] nums, int i) {
        if (i >= nums.length - 1) return true;
        if (nums[i] == 0) return false;
        if (memo[i] != -1) return memo[i] == 1;

        int maxJump = nums[i];
        for (int jump = 1; jump <= maxJump; jump++) {
            if (fun(nums, i + jump)) {
                memo[i] = 1;
                return true;
            }
        }
        memo[i] = 0;
        return false;
    }

    public boolean canJump(int[] nums) {
        memo = new int[nums.length];
        java.util.Arrays.fill(memo, -1);
        return fun(nums, 0);
    }
}
