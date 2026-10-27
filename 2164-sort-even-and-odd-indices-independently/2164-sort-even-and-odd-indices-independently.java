class Solution {
    public int[] sortEvenOdd(int[] nums) {

        int[] ans= new int[nums.length];

        ArrayList<Integer> even= new ArrayList<>();
        ArrayList<Integer> odd= new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(i%2==0) even.add(nums[i]);
            if(i%2!=0) odd.add(nums[i]);
        }

        Collections.sort(even);
        Collections.sort(odd);

        Collections.reverse(odd);

        int e=0,o=0;
        
        for(int i=0;i<nums.length;i++){
            if(i%2==0) ans[i]=even.get(e++);
            if(i%2!=0) ans[i]=odd.get(o++);
        }

        return ans;
    }
}