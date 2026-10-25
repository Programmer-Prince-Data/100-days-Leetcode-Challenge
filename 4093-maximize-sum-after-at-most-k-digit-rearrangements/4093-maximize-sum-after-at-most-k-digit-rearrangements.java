class Solution {
    public long maximizeSum(int[] nums, int k) {
        int n = nums.length;
        long sum = 0;
        long[] gains = new long[n];
        for(int i = 0; i < n; i++){
            sum += nums[i];
            gains[i] = newNumber(nums[i]) - nums[i];
        }
        Arrays.sort(gains);
        for(int i = n - 1; i >= Math.max(0, n - k); i--) sum += gains[i];
        return sum;
    }
    private long newNumber(int n) {
        int[] cnt = new int[10];
        while(n > 0){
            cnt[n % 10]++;
            n /= 10;
        }
        int res = 0;
        for(int d = 9; d >= 0; d--){
            while(cnt[d]-- > 0) {
                res = res * 10 + d;
            }
        }
        return res;
    }
}