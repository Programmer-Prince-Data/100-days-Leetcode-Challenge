class Solution {
    public int countConsistent(int[] nums) {
        int n = nums.length;
        int start = 0;
        for(int i = 0; i < n; i++){
            int min = nums[i];
            int and = nums[i];
            for(int j = i; j < n; j++){
                and&=nums[j];
                min = Math.min(min, nums[j]);
                if(and == min) start++;
            }
                
        }
        return start;
    }
}