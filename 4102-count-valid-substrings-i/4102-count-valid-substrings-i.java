class Solution {
    public long countValidSubstrings(String s) {
        int n = s.length();
        long ans = 0;
        int last = -1;
        for(int i = 0; i < n; i++){
            if(i >= 2 && s.charAt(i - 2) == 'a' && s.charAt(i - 1) == 'b' && s.charAt(i) == 'c') {
                last = i - 2;
            }
            ans += i - last;
        }
        return ans;
    }
}