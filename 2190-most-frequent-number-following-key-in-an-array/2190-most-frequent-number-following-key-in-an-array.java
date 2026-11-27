class Solution {
    public int mostFrequent(int[] nums, int key) {

        int count=0;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            int temp=0;
            for(int j=0;j<=nums.length-2;j++){
                if(nums[j]==key && nums[j+1]==nums[i]) temp++;
            }
            if(temp>count){
                count=temp;
                ans=nums[i];
            }
        }
        return ans;
    }
}