class Solution {

    private boolean isPowerOf5(int num) {
        if (num <= 0) return false;

        while (num % 5 == 0) {
            num /= 5;
        }

        return num == 1;
    }

    private int fun(int p, int i, String s) {

        if (i >= s.length()) {
            return p;
        }

        if (s.charAt(i) == '0') {
            return Integer.MAX_VALUE;
        }

        int ans = Integer.MAX_VALUE;
        int num = 0;

        for (int j = i; j < s.length(); j++) {

            num = num * 2 + (s.charAt(j) - '0');

            if (isPowerOf5(num)) {
                int temp = fun(p + 1, j + 1, s);

                if (temp != Integer.MAX_VALUE) {
                    ans = Math.min(ans, temp);
                }
            }
        }

        return ans;
    }

    public int minimumBeautifulSubstrings(String s) {

        int ans = fun(0, 0, s);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}