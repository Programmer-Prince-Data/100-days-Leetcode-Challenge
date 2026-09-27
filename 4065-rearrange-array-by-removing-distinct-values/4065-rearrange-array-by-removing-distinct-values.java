class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num:nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> values = new ArrayList<>(map.keySet());
        Collections.sort(values);

        int idx = 0;
        while(idx < nums.length){
            for(int value : values){
                if(map.get(value) > 0){
                    ans[idx++] = value;
                    map.put(value, map.get(value) - 1);
                }
            }
        }

        return ans;
    }
}