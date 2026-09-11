import java.util.*;

class Solution {

    private int fun(int pos, int[] digits, HashMap<Integer, Integer> map) {

        // We have chosen all 3 digits
        if (pos == 3) {
            return 1;
        }

        int ans = 0;

        for (int digit = 0; digit <= 9; digit++) {

            // Digit is not available
            if (!map.containsKey(digit) || map.get(digit) == 0) {
                continue;
            }

            // First digit cannot be 0
            if (pos == 0 && digit == 0) {
                continue;
            }

            // Last digit must be even
            if (pos == 2 && digit % 2 != 0) {
                continue;
            }

            // Use this digit
            map.put(digit, map.get(digit) - 1);

            ans += fun(pos + 1, digits, map);

            // Backtrack
            map.put(digit, map.get(digit) + 1);
        }

        return ans;
    }

    public int totalNumbers(int[] digits) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int digit : digits) {
            map.put(digit, map.getOrDefault(digit, 0) + 1);
        }

        return fun(0, digits, map);
    }
}