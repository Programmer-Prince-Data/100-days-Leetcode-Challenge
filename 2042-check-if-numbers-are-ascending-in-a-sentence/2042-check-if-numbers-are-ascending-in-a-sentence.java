class Solution {
    public boolean areNumbersAscending(String s) {

        int num = -1;
        int dig = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                dig = dig * 10 + (ch - '0');
            } else if (dig != 0) {
                if (dig <= num) return false;
                num = dig;
                dig = 0;
            }
        }

        if (dig != 0 && dig <= num) return false;

        return true;
    }
}